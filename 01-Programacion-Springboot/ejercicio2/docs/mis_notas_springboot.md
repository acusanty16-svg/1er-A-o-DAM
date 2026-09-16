# 📌 NOTA DE CONTEXTO Y DIRECTRICES TÉCNICAS (CON FUENTES PARA ASISTENTE IA)

## 1. Contexto General del Proyecto y Base de Información

- **Curso:** 1er Año DAM — Programación Spring Boot [1].
- **Proyecto Objetivo:** `ejercicio2` (Sistema de Biblioteca — REST API) [2, 3].
- **Ubicación del Proyecto:** `01-Programacion-Springboot/ejercicio2` [3].
- **Stack Tecnológico:** Java 17/23 (Corretto 23), Spring Boot 4.1.1, Spring Data JPA, Spring Security, JWT (`jjwt` 0.12.6), PostgreSQL 16 (en contenedor Docker, puerto 5433), Lombok, Bean Validation, Maven Wrapper (`mvnw`) e IntelliJ IDEA Community [4-6].
- **Arquitectura de Código:** Estructura organizada en capas dentro del paquete base `Biblioteca.ejercicio2` [3, 5]:
  - **Entidades (`model/`):** `Autor`, `Libro`, `Prestamo`, `Usuario`, `Role` (Enum: `ROLE_USER`, `ROLE_ADMIN`) [3, 5].
  - **Repositorios (`repository/`):** `AutorRepository`, `LibroRepository`, `PrestamosRepository`, `UsuarioRepository` [3, 5].
  - **Servicios (`service/`):** `AutorService`, `LibroService`, `PrestamoService` (gestiona límites y usa `@Transactional`), `JwtService`, `UsuarioService` (BCrypt + registro/autenticación) [3, 5, 7, 8].
  - **Controladores (`controller/`):** `AuthController`, `AutorController`, `LibroController`, `PrestamoController` [3, 5].
  - **Seguridad (`security/`):** `SecurityConfig` (rutas públicas vs. protegidas), `JwtAuthenticationFilter`, `UserDetailServiceImpl` [3, 5, 8].
  - **Configuración (`config/`):** `BibliotecaConfig` (`@ConfigurationProperties` para límites de préstamos) [3, 5, 9].

## 2. Estado de Progreso del Curso

- **Fases completadas (Fase 0 a Fase 5):** Preparación del entorno, fundamentos de Spring Core (IoC/DI/Beans), Capa Web REST (DTOs, validación, `@ControllerAdvice`), Capa de Datos JPA + PostgreSQL (relaciones `@OneToMany`/`@ManyToOne`), Configuración Profesional (profiles `dev`/`prod`, variables de entorno) y Seguridad (Spring Security, BCrypt, JWT, roles) [10-15].
- **Fase actual:** **Fase 6 — Testing Profesional** (Sesiones 16-18) [14-16].

---

## 3. Especificaciones y Tarea Exacta para la Fase 6 (Testing Profesional)

El objetivo central de la **Fase 6** es construir la suite de pruebas completa (Proyecto real #5) para el **Sistema de Biblioteca (`ejercicio2`)** [16, 17]. La IA debe seguir los siguientes pilares técnicos:

### A. Cobertura de Pruebas Requerida [16]

1. **Tests Unitarios de Servicios (JUnit 5 + Mockito):**
   - Aislar la lógica de negocio simulando repositorios con `@Mock` e inyectándolos con `@InjectMocks` [16].
   - Probar `PrestamoService` (verificando el límite configurado de préstamos, excepciones como `LibroNotFoundException` y la atomicidad transaccional) [7, 9, 16].
   - Probar `UsuarioService` (registro, autenticación, gestión de credenciales e interacción con BCrypt) [8, 16].
2. **Test Slices (Pruebas de Capas Específicas):**
   - **Persistencia (`@DataJpaTest`):** Validar consultas personalizadas y comportamiento de repositorios en `UsuarioRepository` (`findByUsername`, `existsByEmail`) y `PrestamosRepository` [8, 16].
   - **Capa Web (`@WebMvcTest` con `MockMvc`):** Validar los controladores `LibroController` y `AuthController` [5, 8, 16].
   - Verificar respuestas HTTP (200 OK, 201 Created, 400 Bad Request, 401 Unauthorized, 404 Not Found), parsing de JSON y aislamiento de filtros de seguridad mediante `@WithMockUser` [8, 16, 18].
3. **Tests de Integración Completa con Testcontainers:**
   - Configurar `@SpringBootTest` junto con `@Testcontainers` y `PostgreSQLContainer` para ejecutar pruebas integrales de extremo a extremo sobre una base de datos PostgreSQL real en Docker [16].
   - Probar la integración completa entre la capa Web, Security (tokens JWT), Servicios y Base de Datos PostgreSQL [5, 8, 16].

### B. Configuración de Dependencias Requerida (`pom.xml`)

- `spring-boot-starter-test` (proporciona JUnit 5, Mockito, AssertJ) [6, 16].
- `spring-security-test` (para autenticación simulada en controladores) [16].
- `testcontainers` y `testcontainers:postgresql` (para contenedor de PostgreSQL en pruebas) [16].

---

## 4. Instrucción Directa para la IA Ejecutora

Analiza la estructura del proyecto en `Biblioteca.ejercicio2` y prepárate para guiarme en la creación de los archivos de prueba estructurados en la ruta `src/test/java/Biblioteca/ejercicio2/`, organizándolos en los paquetes `service`, `repository`, `controller` e `integration` [3, 5, 16]. ¡Recuerda no escribir el código de resolución, debes guiarme paso a paso según tus instrucciones de Mentor!
