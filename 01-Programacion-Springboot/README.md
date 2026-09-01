# 🚀 Curso de Spring Boot — Desde Cero hasta Profesional

> **Proyecto de aprendizaje** donde construimos APIs REST profesionales paso a paso, siguiendo las mejores prácticas de la industria.

## 📋 Descripción General

Este repositorio contiene el material completo de un curso de **Spring Boot** diseñado para aprender desde los fundamentos hasta la creación de aplicaciones web profesionales. Cada fase incluye teoría explicada con analogías de la vida real, código escrito paso a paso, y proyectos reales que simulan entornos laborales.

### Stack Tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 23 (Corretto) | Lenguaje de programación |
| **Spring Boot** | 4.1.0 | Framework principal |
| **Spring Data JPA** | — | Acceso a datos con JPA |
| **Hibernate** | 7.4.1 | Implementación de JPA |
| **PostgreSQL** | 16 | Base de datos relacional |
| **Docker** | 29.4.2 | Contenedores para PostgreSQL |
| **Lombok** | — | Reducción de código boilerplate |
| **Maven** | Wrapper | Gestión de dependencias |
| **IntelliJ IDEA** | 2025.2.3 Community | IDE de desarrollo |

---

## 🗺️ Estructura del Curso

El curso está dividido en **8 fases** progresivas:

| Fase | Tema | Estado |
|------|------|--------|
| **Fase 0** | Preparación del entorno | ✅ Completada |
| **Fase 1** | Fundamentos de Spring Core | ✅ Completada |
| **Fase 2** | Capa Web / REST API | ✅ Completada |
| **Fase 3** | Capa de Datos: JPA + PostgreSQL | ⏳ Pendiente |
| **Fase 4** | Configuración profesional | ⏳ Pendiente |
| **Fase 5** | Seguridad (Spring Security + JWT) | ⏳ Pendiente |
| **Fase 6** | Testing profesional | ⏳ Pendiente |
| **Fase 7** | Producción y API docs | ⏳ Pendiente |
| **Fase 8** | Proyecto Integrador Final | ⏳ Pendiente |

---

## 📁 Estructura del Proyecto

```
Programacion Springboot/
├── README.md                          ← Este archivo
├── PLAN_DE_ESTUDIOS.md                ← Plan detallado del curso
├── Sesiones/                          ← Contenido teórico por fase
│   ├── Fase1-Fundamentos-Spring-Core.md
│   └── Fase2-Capa-Web-REST-API.md
└── ejercicio1-hola-mundo/            ← Proyecto principal
    └── ejercicio1-hola-mundo/
        ├── docker-compose.yml         ← PostgreSQL en Docker
        ├── pom.xml                    ← Dependencias Maven
        ├── mvnw / mvnw.cmd           ← Maven Wrapper
        ├── data.sql                   ← Datos de prueba (30 productos)
        └── src/main/java/com/example/ejercicio1_hola_mundo/
            ├── Ejercicio1HolaMundoApplication.java
            ├── HolaController.java
            ├── component/
            │   └── ContadorVisitas.java
            ├── controller/
            │   └── ProductoController.java
            ├── dto/
            │   ├── ProductoDTO.java
            │   └── ProductoCreateDTO.java
            ├── exception/
            │   ├── ProductoNotFoundException.java
            │   ├── ErrorResponse.java
            │   └── GlobalExceptionHandler.java
            ├── model/
            │   └── Producto.java
            ├── repository/
            │   └── ProductoRepository.java
            └── service/
                ├── SaludoService.java
                └── ProductoService.java
```

---

## 🛠️ Cómo Ejecutar el Proyecto

### Prerrequisitos

1. **Java 23** (Corretto o OpenJDK) instalado
2. **Docker Desktop** corriendo
3. **IntelliJ IDEA** Community o Ultimate

### Pasos

```bash
# 1. Navegar a la carpeta del proyecto
cd "Programacion Springboot/ejercicio1-hola-mundo/ejercicio1-hola-mundo"

# 2. Levantar PostgreSQL con Docker
docker-compose up -d

# 3. Verificar que PostgreSQL está corriendo
docker-compose ps

# 4. Ejecutar la app con Maven Wrapper
./mvnw spring-boot:run

# 5. Abrir en el navegador
# http://localhost:8080
```

### Endpoints de la API

| Método | URL | Descripción | Código |
|--------|-----|-------------|--------|
| `GET` | `/api/productos` | Listar todos los productos | 200 |
| `GET` | `/api/productos/{id}` | Obtener un producto por ID | 200 / 404 |
| `POST` | `/api/productos` | Crear un producto nuevo | 201 |
| `PUT` | `/api/productos/{id}` | Actualizar un producto | 200 / 404 |
| `DELETE` | `/api/productos/{id}` | Eliminar un producto | 204 / 404 |

### Ejemplos con PowerShell

```powershell
# Listar productos
Invoke-WebRequest -Uri "http://localhost:8080/api/productos" -UseBasicParsing | Select-Object -ExpandProperty Content

# Crear producto
Invoke-WebRequest -Uri "http://localhost:8080/api/productos" -Method POST -Body '{"nombre": "Portatil", "precio": 999.99}' -ContentType "application/json" | Select-Object -ExpandProperty Content

# Obtener producto por ID
Invoke-WebRequest -Uri "http://localhost:8080/api/productos/{id}" -UseBasicParsing | Select-Object -ExpandProperty Content

# Actualizar producto
Invoke-WebRequest -Uri "http://localhost:8080/api/productos/{id}" -Method PUT -Body '{"nombre": "Portatil Gaming", "precio": 1499.99}' -ContentType "application/json" | Select-Object -ExpandProperty Content

# Eliminar producto
Invoke-WebRequest -Uri "http://localhost:8080/api/productos/{id}" -Method DELETE -UseBasicParsing
```

---

## 📚 Conceptos Aprendidos

### Fase 0 — Preparación del entorno
- Estructura de un proyecto Spring Boot
- Maven y Maven Wrapper (`mvnw`)
- Configuración de JDK en IntelliJ
- Ejecución de la primera app en `localhost:8080`

### Fase 1 — Fundamentos de Spring Core
- **IoC Container:** Spring crea y gestiona los objetos por ti
- **Dependency Injection:** Inyección por constructor (nunca por campo)
- **Beans:** `@Component`, `@Service`, `@Repository`, `@Controller`
- **Autoconfiguration:** Spring Boot configura todo automáticamente
- **Starters:** Paquetes de dependencias preconfigurados

### Fase 2 — Capa Web / REST API
- **HTTP:** Métodos (GET, POST, PUT, DELETE) y códigos de estado (200, 201, 400, 404)
- **REST Controllers:** `@RestController`, `@RequestMapping`, `@GetMapping`, `@PostMapping`
- **DTOs:** Separar la entidad de lo que el cliente ve
- **Validación:** `@Valid`, `@NotBlank`, `@Size`, `@NotNull`, `@Positive`
- **Manejo de errores:** `@ControllerAdvice` + `@ExceptionHandler`
- **Spring Data JPA:** `JpaRepository` para acceso a datos
- **Docker:** `docker-compose` para levantar PostgreSQL
- **Lombok:** `@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`
- **UUID:** Identificadores únicos en vez de auto-incremental

---

## 🎓 Metodología de Aprendizaje

1. **Teoría con analogías:** Cada concepto se explica con ejemplos de la vida real
2. **Código paso a paso:** El estudiante escribe el código y el profesor verifica
3. **Proyectos reales:** Cada fase termina con un proyecto que simula un entorno laboral
4. **Diario de sesiones:** Registro detallado de lo aprendido en cada sesión

---

## 📊 Progreso

| Fecha | Fase | Duración | Estado |
|-------|------|----------|--------|
| 20/08/2026 | Fase 0 — Preparación del entorno | ~30 min | ✅ |
| 26/08/2026 | Fase 1 — Fundamentos de Spring Core | ~15 min | ✅ |
| 26/08/2026 | Fase 2 — Capa Web / REST API | ~90 min | ✅ |
| — | Fase 3 — Capa de Datos | — | ⏳ |
| — | Fase 4 — Configuración profesional | — | ⏳ |
| — | Fase 5 — Seguridad | — | ⏳ |
| — | Fase 6 — Testing | — | ⏳ |
| — | Fase 7 — Producción | — | ⏳ |
| — | Fase 8 — Proyecto Final | — | ⏳ |

---

## 🤝 Contribuir

Este es un proyecto de aprendizaje personal. Si quieres seguir el mismo curso, clona el repositorio y ejecuta los pasos de la sección "Cómo Ejecutar el Proyecto".

---

## 📄 Licencia

Proyecto de aprendizaje — uso educativo.

---

> **Última actualización:** 26 de Agosto de 2026