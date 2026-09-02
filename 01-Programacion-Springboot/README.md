# 🚀 Curso de Spring Boot — Desde Cero hasta Profesional

> **Proyecto de aprendizaje** donde construimos APIs REST profesionales paso a paso, siguiendo las mejores prácticas de la industria.

## 📋 Descripción General

Este repositorio contiene el material completo de un curso de **Spring Boot** diseñado para aprender desde los fundamentos hasta la creación de aplicaciones web profesionales. Cada fase incluye teoría explicada con analogías de la vida real, código escrito paso a paso, y proyectos reales que simulan entornos laborales.

### Stack Tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| **Java** | 17 | Lenguaje de programación |
| **Spring Boot** | 4.1.1 | Framework principal |
| **Spring Data JPA** | — | Acceso a datos con JPA |
| **Spring Security** | — | Autenticación y autorización (Fase 5) |
| **Hibernate** | — | Implementación de JPA |
| **PostgreSQL** | 16 | Base de datos relacional |
| **Docker** | — | Contenedores para PostgreSQL |
| **Lombok** | — | Reducción de código boilerplate |
| **JWT (jjwt)** | 0.12.6 | Tokens de autenticación (Fase 5) |
| **Bean Validation** | — | Validación de datos |
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
| **Fase 3** | Capa de Datos: JPA + PostgreSQL | ✅ Completada |
| **Fase 4** | Configuración profesional | ✅ Completada |
| **Fase 5** | Seguridad (Spring Security + JWT) | ⏳ En progreso |
| **Fase 6** | Testing profesional | ⏳ Pendiente |
| **Fase 7** | Producción y API docs | ⏳ Pendiente |
| **Fase 8** | Proyecto Integrador Final | ⏳ Pendiente |

---

## 📁 Estructura del Repositorio

```
01-Programacion-Springboot/
├── README.md                              ← Este archivo
├── PLAN_DE_ESTUDIOS.md                    ← Plan detallado del curso
├── Sesiones/                              ← Contenido teórico por fase
│   ├── Fase1-Fundamentos-Spring-Core.md
│   └── Fase2-Capa-Web-REST-API.md
│
├── ejercicio1-hola-mundo/                 ← Proyecto 1: API de Tienda
│   └── ejercicio1-hola-mundo/
│       ├── docker-compose.yml             ← PostgreSQL en Docker (puerto 5432)
│       ├── pom.xml                        ← Dependencias Maven
│       ├── README.md                      ← Documentación del proyecto
│       └── src/main/java/.../
│           ├── model/Producto.java
│           ├── repository/ProductoRepository.java
│           ├── dto/ProductoDTO.java, ProductoCreateDTO.java
│           ├── exception/GlobalExceptionHandler.java
│           ├── service/ProductoService.java
│           └── controller/ProductoController.java
│
└── ejercicio2/                            ← Proyecto 2: Sistema de Biblioteca
    ├── docker-compose.yml                 ← PostgreSQL en Docker (puerto 5433)
    ├── pom.xml                            ← Dependencias Maven
    ├── README.md                          ← Documentación del proyecto
    └── src/main/java/Biblioteca/ejercicio2/
        ├── config/
        │   └── BibliotecaConfig.java      ← @ConfigurationProperties
        ├── model/
        │   ├── Autor.java                 ← @OneToMany → Libro
        │   ├── Libro.java                 ← @ManyToOne → Autor
        │   ├── Prestamo.java              ← @ManyToOne → Libro
        │   └── Usuario.java               ← Entidad de usuario (Fase 5)
        ├── repository/
        │   ├── AutorRepository.java
        │   ├── LibroRepository.java
        │   ├── PrestamosRepository.java
        │   └── UsuarioRepository.java     ← Repositorio de usuarios
        ├── DTO/
        │   ├── AutorDTO.java, AutorCreateDTO.java
        │   ├── LibroDTO.java, LibroCreateDTO.java
        │   └── PrestamosDTO.java, PrestamoCreateDTO.java
        ├── exception/
        │   ├── AutorNotFoundException.java
        │   ├── LibroNotFoundException.java
        │   └── PrestamoNotFoundException.java
        ├── service/
        │   ├── AutorService.java
        │   ├── LibroService.java
        │   └── PrestamoService.java       ← Usa @Transactional y config
        └── controller/
            ├── AutorController.java
            ├── LibroController.java
            └── PrestamoController.java
```

---

## 🛠️ Cómo Ejecutar los Proyectos

### Prerrequisitos

1. **Java 17+** (Corretto o OpenJDK) instalado
2. **Docker Desktop** corriendo
3. **IntelliJ IDEA** Community o Ultimate

### Proyecto 1: API de Tienda (ejercicio1)

```bash
# 1. Navegar a la carpeta del proyecto
cd "01-Programacion-Springboot/ejercicio1-hola-mundo/ejercicio1-hola-mundo"

# 2. Levantar PostgreSQL con Docker
docker-compose up -d

# 3. Ejecutar la app
./mvnw spring-boot:run

# 4. Abrir en el navegador
# http://localhost:8080
```

### Proyecto 2: Sistema de Biblioteca (ejercicio2)

```bash
# 1. Navegar a la carpeta del proyecto
cd "01-Programacion-Springboot/ejercicio2"

# 2. Levantar PostgreSQL con Docker
docker-compose up -d

# 3. Ejecutar la app (con profile dev)
./mvnw spring-boot:run -Dspring.profiles.active=dev

# 4. Abrir en el navegador
# http://localhost:8081
```

### Endpoints de la API de Tienda

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/productos` | Listar todos los productos |
| `GET` | `/api/productos/{id}` | Obtener un producto por ID |
| `POST` | `/api/productos` | Crear un producto nuevo |
| `PUT` | `/api/productos/{id}` | Actualizar un producto |
| `DELETE` | `/api/productos/{id}` | Eliminar un producto |

### Endpoints de la Biblioteca

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/autores` | Listar todos los autores |
| `POST` | `/api/autores` | Crear un autor nuevo |
| `GET` | `/api/libros` | Listar todos los libros |
| `POST` | `/api/libros` | Crear un libro nuevo |
| `GET` | `/api/prestamos` | Listar todos los préstamos |
| `POST` | `/api/prestamos` | Crear un préstamo (prestar libro) |
| `PUT` | `/api/prestamos/{id}/devolver` | Devolver un libro prestado |

### Ejemplos con PowerShell

```powershell
# Listar autores
Invoke-WebRequest -Uri "http://localhost:8081/api/autores" -Method GET

# Crear autor
Invoke-WebRequest -Uri "http://localhost:8081/api/autores" -Method POST -ContentType "application/json" -Body '{"nombre":"Gabriel Garcia Marquez"}'

# Crear libro
Invoke-WebRequest -Uri "http://localhost:8081/api/libros" -Method POST -ContentType "application/json" -Body '{"titulo":"Cien Anos de Soledad","precio":19.99,"autorId":"ID_DEL_AUTOR"}'

# Prestar libro
Invoke-WebRequest -Uri "http://localhost:8081/api/prestamos" -Method POST -ContentType "application/json" -Body '{"libroId":"ID_DEL_LIBRO","usuario":"Juan Perez"}'

# Devolver libro
Invoke-WebRequest -Uri "http://localhost:8081/api/prestamos/ID_DEL_PRESTAMO/devolver" -Method PUT
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

### Fase 3 — Capa de Datos: JPA + PostgreSQL
- **Relaciones JPA:** `@OneToMany`, `@ManyToOne`
- **Fetch Types:** `LAZY` vs `EAGER`
- **Consultas derivadas:** `findByXxx()` en repositorios
- **Transacciones:** `@Transactional` para operaciones atómicas
- **DTOs de respuesta y entrada:** Separar datos de entrada y salida
- **Excepciones personalizadas:** `NotFoundException` para cada entidad

### Fase 4 — Configuración Profesional
- **Profiles:** `application-dev.yml` y `application-prod.yml`
- **Variables de entorno:** Secretos fuera del código (`${DB_USERNAME}`)
- **@ConfigurationProperties:** Configuración tipada con Java
- **Configuración común:** `application.yml` para valores compartidos

### Fase 5 — Seguridad (en progreso)
- **Spring Security:** Framework de seguridad de Spring
- **BCrypt:** Hashing de contraseñas
- **JWT:** JSON Web Tokens para autenticación
- **Roles y permisos:** `ROLE_USER`, `ROLE_ADMIN`

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
| 31/08/2026 | Fase 3 — Capa de Datos: JPA + PostgreSQL | ~60 min | ✅ |
| 01/09/2026 | Fase 4 — Configuración profesional | ~30 min | ✅ |
| 01/09/2026 | Fase 5 — Seguridad | — | ⏳ |
| — | Fase 6 — Testing | — | ⏳ |
| — | Fase 7 — Producción | — | ⏳ |
| — | Fase 8 — Proyecto Final | — | ⏳ |

---

## 🤝 Contribuir

Este es un proyecto de aprendizaje personal. Si quieres seguir el mismo curso, clona el repositorio y ejecuta los pasos de la sección "Cómo Ejecutar los Proyectos".

---

## 📄 Licencia

Proyecto de aprendizaje — uso educativo.

---

> **Última actualización:** 01 de Septiembre de 2026
