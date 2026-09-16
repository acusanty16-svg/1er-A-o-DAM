# 📚 Sistema de Biblioteca — REST API

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-0.12.6-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Estado](https://img.shields.io/badge/Estado-Completado_6%2F8_fases-25A162?style=for-the-badge)

> Proyecto de gestión de biblioteca desarrollado con Spring Boot, JPA, PostgreSQL, Spring Security con JWT y **testing profesional completo**.

## ✅ Estado del proyecto

Completado hasta la **Fase 6 (Testing profesional)**

| Fase | Qué aporta | Estado |
|------|-----------|--------|
| **Fase 3** | Capa de datos: JPA + PostgreSQL + Docker | ✅ |
| **Fase 4** | Configuración profesional (profiles, `@ConfigurationProperties`) | ✅ |
| **Fase 5** | Seguridad: Spring Security + JWT + BCrypt + roles | ✅ |
| **Fase 6** | Testing: unit tests, controllers y tests de integración | ✅ |

## 🎯 Objetivo del proyecto

Aprender a construir una API REST completa con:
- Entidades JPA con relaciones (`@OneToMany`, `@ManyToOne`)
- Repositorios con Spring Data JPA
- DTOs para transferencia de datos
- Manejo de errores personalizado
- Transacciones con `@Transactional`
- Docker para bases de datos
- Spring Security con JWT para autenticación
- Roles y permisos de usuario
- Testing profesional con JUnit 5, Mockito, test slices y Testcontainers

## 🛠️ Stack tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 17 | Lenguaje de programación |
| Spring Boot | 4.1.1 | Framework principal |
| Spring Data JPA | - | Acceso a datos |
| Spring Security | - | Autenticación y autorización |
| JWT (jjwt) | 0.12.6 | Tokens de autenticación |
| PostgreSQL | 16 | Base de datos |
| Docker | - | Contenedores |
| Testcontainers | 2.0.5 | PostgreSQL real para tests de integración |
| JUnit 5 + Mockito | - | Tests unitarios y de controladores |
| Lombok | - | Reducción de código boilerplate |
| Bean Validation | - | Validación de datos |
| Maven | - | Gestión de dependencias |

## 📁 Estructura del proyecto

```
ejercicio2/
├── docker-compose.yml          # PostgreSQL en Docker
├── pom.xml                     # Dependencias Maven
├── src/
│   ├── main/
│   │   ├── java/Biblioteca/ejercicio2/
│   │   │   ├── Ejercicio2Application.java    # Clase principal
│   │   │   ├── config/
│   │   │   │   └── BibliotecaConfig.java     # @ConfigurationProperties
│   │   │   ├── model/                         # Entidades JPA
│   │   │   │   ├── Autor.java
│   │   │   │   ├── Libro.java
│   │   │   │   ├── Prestamo.java
│   │   │   │   ├── Usuario.java              # Entidad de usuario
│   │   │   │   └── Role.java                 # Enum de roles
│   │   │   ├── repository/                    # Repositorios
│   │   │   │   ├── AutorRepository.java
│   │   │   │   ├── LibroRepository.java
│   │   │   │   ├── PrestamosRepository.java
│   │   │   │   └── UsuarioRepository.java
│   │   │   ├── DTO/                           # Data Transfer Objects
│   │   │   │   ├── AutorDTO.java
│   │   │   │   ├── AutorCreateDTO.java
│   │   │   │   ├── LibroDTO.java
│   │   │   │   ├── LibroCreateDTO.java
│   │   │   │   ├── PrestamosDTO.java
│   │   │   │   ├── PrestamoCreateDTO.java
│   │   │   │   ├── LoginDTO.java
│   │   │   │   ├── LoginResponseDTO.java
│   │   │   │   ├── UsuarioCreateDTO.java
│   │   │   │   └── UsuarioDTO.java
│   │   │   ├── exception/                     # Excepciones personalizadas
│   │   │   │   ├── AutorNotFoundException.java
│   │   │   │   ├── LibroNotFoundException.java
│   │   │   │   ├── PrestamoNotFoundException.java
│   │   │   │   ├── CredencialesInvalidasException.java
│   │   │   │   ├── UsuarioDuplicadoException.java
│   │   │   │   ├── ErrorResponse.java
│   │   │   │   └── GlobalExceptionHandler.java
│   │   │   ├── security/                      # Seguridad
│   │   │   │   ├── SecurityConfig.java
│   │   │   │   ├── JwtAuthenticationFilter.java
│   │   │   │   └── UserDetailServiceImpl.java
│   │   │   ├── service/                       # Lógica de negocio
│   │   │   │   ├── AutorService.java
│   │   │   │   ├── LibroService.java
│   │   │   │   ├── PrestamoService.java
│   │   │   │   ├── JwtService.java
│   │   │   │   └── UsuarioService.java
│   │   │   └── controller/                    # Controladores REST
│   │   │       ├── AuthController.java
│   │   │       ├── AutorController.java
│   │   │       ├── LibroController.java
│   │   │       └── PrestamoController.java
│   │   └── resources/
│   │       ├── application.yml                # Configuración común
│   │       ├── application-dev.yml            # Configuración de desarrollo
│   │       ├── application-prod.yml           # Configuración de producción
│   │       └── data.sql                       # Datos de prueba
│   └── test/
│       ├── java/Biblioteca/ejercicio2/        # Tests de la Fase 6
│       │   ├── service/                       # Unit tests con Mockito
│       │   ├── repository/                    # @DataJpaTest con H2
│       │   ├── controller/                    # @WebMvcTest + MockMvc
│       │   └── integration/                   # Testcontainers + PostgreSQL real
│       └── resources/
│           ├── application-test.yml           # Perfil de test (H2)
│           └── application-testcontainers.yml # Perfil con PostgreSQL real
```

## 🚀 Cómo ejecutar

### 1. Levantar PostgreSQL con Docker

```bash
docker-compose up -d
```

### 2. Ejecutar la aplicación

```bash
./mvnw spring-boot:run
```

O desde IntelliJ: ejecutar `Ejercicio2Application.java`

### 3. Verificar

La aplicación arranca en: `http://localhost:8081`

## 🧪 Testing (Fase 6)

Suite completa en verde: **56 tests**, 0 fallos.

### Qué se testea

| Capa | Enfoque | Tecnología |
|------|---------|------------|
| **Servicios** | Lógica de negocio y casos borde (22 tests) | JUnit 5 + Mockito (`@MockitoBean`) |
| **Repositorios** | Consultas contra BD (12 tests) | `@DataJpaTest` con H2 |
| **Controladores** | Estado HTTP y cuerpo JSON (16 tests) | `@WebMvcTest` + MockMvc |
| **Integración** | Flujo completo end-to-end (5 tests) | `@SpringBootTest` + Testcontainers |
| **Contexto** | Arranque de la app (1 test) | `@SpringBootTest` |

### Lo más destacado: Testcontainers

Los tests de integración **no usan una base de datos simulada**: Testcontainers levanta un **PostgreSQL real** en un contenedor Docker desechable. Así se verifican los flujos completos (registro → login → JWT → préstamo → devolución) contra el motor de base de datos de producción.

### Cómo ejecutar los tests

```bash
# Suite completa (arranca PostgreSQL en Docker)
./mvnw test

# Solo los tests de integración
./mvnw test -Dtest=BibliotecaIntegrationTest

# Estrategia de perfiles
# - application-test.yml             → H2 en memoria (tests rápidos)
# - application-testcontainers.yml   → PostgreSQL 16 real (tests de integración)
```

> 💡 **Particularidad de Spring Boot 4:** en Boot 4, `TestRestTemplate` es opt-in. Los tests de integración lo habilitan con `@AutoConfigureTestRestTemplate` y la dependencia `spring-boot-restclient`.

## 📡 Endpoints de la API

### Autenticación

| Método | URL | Descripción | Acceso |
|--------|-----|-------------|--------|
| `POST` | `/api/auth/register` | Registrar usuario nuevo | Público |
| `POST` | `/api/auth/login` | Login y obtener token JWT | Público |

### Autores

| Método | URL | Descripción | Acceso |
|--------|-----|-------------|--------|
| `GET` | `/api/autores` | Listar todos los autores | Público |
| `GET` | `/api/autores/{id}` | Obtener un autor por ID | Público |
| `POST` | `/api/autores` | Crear un autor nuevo | Admin |

### Libros

| Método | URL | Descripción | Acceso |
|--------|-----|-------------|--------|
| `GET` | `/api/libros` | Listar todos los libros | Público |
| `GET` | `/api/libros/{id}` | Obtener un libro por ID | Público |
| `POST` | `/api/libros` | Crear un libro nuevo | Público |

### Préstamos

| Método | URL | Descripción | Acceso |
|--------|-----|-------------|--------|
| `GET` | `/api/prestamos` | Listar todos los préstamos | Autenticado |
| `GET` | `/api/prestamos/{id}` | Obtener un préstamo por ID | Autenticado |
| `POST` | `/api/prestamos` | Crear un préstamo (prestar libro) | Autenticado |
| `PUT` | `/api/prestamos/{id}/devolver` | Devolver un libro prestado | Autenticado |

## 📝 Ejemplos de uso

### Crear un autor

```bash
Invoke-WebRequest -Uri "http://localhost:8081/api/autores" -Method POST -ContentType "application/json" -Body '{"nombre":"Gabriel Garcia Marquez"}'
```

### Crear un libro

```bash
Invoke-WebRequest -Uri "http://localhost:8081/api/libros" -Method POST -ContentType "application/json" -Body '{"titulo":"Cien Anos de Soledad","precio":19.99,"autorId":"ID_DEL_AUTOR"}'
```

### Prestar un libro

```bash
Invoke-WebRequest -Uri "http://localhost:8081/api/prestamos" -Method POST -ContentType "application/json" -Body '{"libroId":"ID_DEL_LIBRO","usuario":"Juan Perez"}'
```

### Devolver un libro

```bash
Invoke-WebRequest -Uri "http://localhost:8081/api/prestamos/ID_DEL_PRESTAMO/devolver" -Method PUT
```

## 🗄️ Base de datos

- **Motor:** PostgreSQL 16
- **Puerto:** 5433 (Docker)
- **Nombre:** `biblioteca_db`
- **Usuario:** `postgres`
- **Contraseña:** `postgres`

### Tablas

| Tabla | Descripción |
|-------|-------------|
| `autores` | Autores de libros |
| `libros` | Libros de la biblioteca |
| `prestamos` | Préstamos de libros a usuarios |

## 📚 Conceptos aprendidos

- [x] Relaciones JPA (`@OneToMany`, `@ManyToOne`)
- [x] Fetch types (`LAZY` vs `EAGER`)
- [x] DTOs para transferencia de datos
- [x] Validación con Bean Validation
- [x] Manejo de errores con excepciones personalizadas
- [x] Transacciones con `@Transactional`
- [x] Docker para bases de datos
- [x] Spring Data JPA
- [x] Profiles (`dev`, `prod`) y configuración por entorno
- [x] Variables de entorno para secretos
- [x] `@ConfigurationProperties` para configuración tipada
- [x] Spring Security y autenticación
- [x] JWT (JSON Web Tokens) para APIs stateless
- [x] BCrypt para hashing de contraseñas
- [x] Roles y permisos (`ROLE_USER`, `ROLE_ADMIN`)
- [x] Filtros JWT para validación de tokens
- [x] Unit tests de servicios con JUnit 5 y Mockito
- [x] Tests de controladores con `@WebMvcTest` y MockMvc
- [x] Tests de repositorios con `@DataJpaTest`
- [x] Tests de integración con Testcontainers y PostgreSQL real
- [x] `TestRestTemplate` opt-in en Spring Boot 4 (`@AutoConfigureTestRestTemplate`)

---

*Proyecto del curso de Spring Boot — Fases 3 a 6 completadas*
