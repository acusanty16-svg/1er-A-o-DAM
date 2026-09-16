# Fase 4 — Configuración Profesional

**Sesiones 11-12** | Duración estimada: 30-45 minutos

---

## Objetivo de esta fase

Aprender a configurar una aplicación Spring Boot de forma profesional: profiles para diferentes entornos, variables de entorno para secretos, y `@ConfigurationProperties` para configuración tipada.

---

# PARTE A: PROFILES

## 1. ¿Qué son los Profiles?

Los **profiles** te permiten tener **diferentes configuraciones** para diferentes entornos (desarrollo, producción, tests) sin cambiar el código.

**Analogía:**
- **Sin profiles:** Tienes que cambiar manualmente la configuración cada vez que pasas de desarrollo a producción
- **Con profiles:** Cada entorno tiene su propio archivo de configuración

### Archivos de profile

```
src/main/resources/
├── application.yml          ← Configuración COMÚN
├── application-dev.yml      ← Configuración de DESARROLLO
└── application-prod.yml     ← Configuración de PRODUCCIÓN
```

---

## 2. application.yml (Común)

```yaml
spring:
  application:
    name: ejercicio2
  profiles:
    active: dev    # Profile activo por defecto
```

**¿Por qué `active: dev`?** Por defecto se usa el profile de desarrollo. En producción se sobrescribe con `--spring.profiles.active=prod` o variable de entorno.

---

## 3. application-dev.yml (Desarrollo)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5433/biblioteca_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: update          # Actualiza tablas automáticamente
    show-sql: true              # Muestra SQL en consola
    defer-datasource-initialization: true
    properties:
      hibernate:
        format_sql: true        # SQL formateado y legible

  sql:
    init:
      mode: never               # No ejecutar data.sql automáticamente

server:
  port: 8081

biblioteca:
  nombre: "Biblioteca Municipal"
  max-prestamos: 5
  version: "1.0"

jwt:
  secret: "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"
  expiration: 86400000
```

### Configuraciones clave de desarrollo

| Propiedad | Valor | Por qué |
|-----------|-------|---------|
| `ddl-auto: update` | Actualiza tablas | Crece el esquema sin perder datos |
| `show-sql: true` | Muestra SQL | Para depurar y aprender |
| `port: 8081` | Puerto distinto | Evita conflicto con ejercicio1 |

---

## 4. application-prod.yml (Producción)

```yaml
spring:
  datasource:
    url: jdbc:postgresql://${DB_HOST:localhost}:${DB_PORT:5432}/${DB_NAME:biblioteca_db}
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
    driver-class-name: org.postgresql.Driver

  jpa:
    hibernate:
      ddl-auto: validate        # Solo VALIDA, no modifica tablas
    show-sql: false             # No muestra SQL (rendimiento)
    properties:
      hibernate:
        format_sql: false

  sql:
    init:
      mode: never

server:
  port: 8080
```

### Configuraciones clave de producción

| Propiedad | Valor | Por qué |
|-----------|-------|---------|
| `ddl-auto: validate` | Solo valida | En producción NUNCA modifies el esquema automáticamente |
| `show-sql: false` | Oculta SQL | Rendimiento y seguridad |
| `port: 8080` | Puerto estándar | El puerto por defecto de producción |
| `${DB_USERNAME}` | Variable de entorno | Secretos fuera del código |

---

# PARTE B: VARIABLES DE ENTORNO

## 5. ¿Por qué fuera del código?

**NUNCA** hardcodees secretos en el código fuente:

```yaml
# ❌ MAL: Contraseña visible en el código
spring:
  datasource:
    username: admin
    password: MiContraseñaSecreta123
```

```yaml
# ✅ BIEN: Variable de entorno
spring:
  datasource:
    username: ${DB_USERNAME:postgres}
    password: ${DB_PASSWORD:postgres}
```

### Sintaxis

`${NOMBRE_VARIABLE:valor_por_defecto}`

- Si existe la variable de entorno `DB_USERNAME`, usa su valor
- Si no existe, usa `postgres` como valor por defecto

### En IntelliJ

Para desarrollo, puedes definir variables de entorno en:
`Run Configuration → Environment variables`

### En producción

En el servidor (Docker, Kubernetes, AWS, etc.) se configuran las variables de entorno reales.

---

# PARTE C: @ConfigurationProperties

## 6. Configuración Tipada

En vez de leer valores sueltos de `application.yml`, puedes agruparlos en una clase Java tipada:

### YAML personalizado

```yaml
biblioteca:
  nombre: "Biblioteca Municipal"
  max-prestamos: 5
  version: "1.0"
```

### Clase de configuración

```java
@Component
@ConfigurationProperties(prefix = "biblioteca")
public class BibliotecaConfig {
    private String nombre = "Mi Biblioteca";
    private int maxPrestamos = 5;
    private String version = "1.0";

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getMaxPrestamos() { return maxPrestamos; }
    public void setMaxPrestamos(int maxPrestamos) { this.maxPrestamos = maxPrestamos; }

    public String getVersion() { return version; }
    public void setVersion(String version) { this.version = version; }
}
```

### Uso en un servicio

```java
@Service
public class PrestamoService {
    private final BibliotecaConfig bibliotecaConfig;

    public PrestamoService(..., BibliotecaConfig bibliotecaConfig) {
        this.bibliotecaConfig = bibliotecaConfig;
    }

    @Transactional
    public PrestamosDTO create(PrestamoCreateDTO dto) {
        long totalPrestamos = prestamosRepository.count();
        if (totalPrestamos >= bibliotecaConfig.getMaxPrestamos()) {
            throw new RuntimeException(
                "Límite de préstamos alcanzado. Máximo: " + bibliotecaConfig.getMaxPrestamos()
            );
        }
        // ...
    }
}
```

### Ventajas

| Ventaja | Ejemplo |
|---------|---------|
| **Tipado** | `maxPrestamos` es `int`, no un `String` que parsear |
| **IDE support** | autocompletado, refactorización |
| **Reutilización** | La misma config se inyecta en cualquier servicio |
| **Validación** | Puedes añadir `@Validated` con restricciones |

---

# PARTE D: RESUMEN

## 7. Arquitectura de configuración

```
application.yml (común)
    │
    ├── application-dev.yml (desarrollo)
    │   ├── Puerto: 8081
    │   ├── ddl-auto: update
    │   ├── show-sql: true
    │   └── Secretos hardcodeados (solo para dev)
    │
    └── application-prod.yml (producción)
        ├── Puerto: 8080
        ├── ddl-auto: validate
        ├── show-sql: false
        └── Secretos: ${VARIABLES_DE_ENTORNO}

BibliotecaConfig.java
    └── Lee "biblioteca.*" de YAML → config tipada en Java
```

## 8. Checklist de buenas prácticas

| Práctica | Estado |
|----------|--------|
| Secretos fuera del código | ✅ |
| Profiles por entorno | ✅ |
| `ddl-auto: update` en dev | ✅ |
| `ddl-auto: validate` en prod | ✅ |
| `show-sql: true` solo en dev | ✅ |
| Configuración tipada con `@ConfigurationProperties` | ✅ |
| Puerto distinto por entorno | ✅ |

---

## 9. Resumen de la Fase 4

| Concepto | Qué aprendimos |
|----------|----------------|
| Profiles | `application-dev.yml` y `application-prod.yml` |
| Variables de entorno | `${DB_USERNAME:default}` para secretos |
| `@ConfigurationProperties` | Configuración tipada en clases Java |
| `ddl-auto` | `update` en dev, `validate` en prod |
| Separación de entornos | Nunca mezclar config de dev y prod |

---

*Documento de teoría — Fase 4 del curso de Spring Boot*
