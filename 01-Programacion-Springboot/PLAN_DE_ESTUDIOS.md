# 📚 Plan de Estudios — Spring Boot

Curso completo para dominar Spring Boot desde cero, sin saltarse ningún paso, con escenarios laborales reales donde construimos proyectos juntos.

## 🧑‍🎓 Perfil del estudiante
- **Nivel de Java:** Intermedio (POO, colecciones, lambdas/streams, excepciones)
- **Entorno:** IntelliJ IDEA Community + terminal
- **Base de datos:** PostgreSQL desde el inicio (con Docker)
- **Docker:** Instalado y disponible
- **Ritmo:** Varias sesiones por semana, sin horario fijo

## 🎯 Objetivo del curso
Que el estudiante entienda Spring Boot en su totalidad: cómo funciona por dentro (Spring Core, IoC, DI), cómo se construye una API REST profesional, cómo se conecta a bases de datos reales, cómo se asegura y cómo se testea — siguiendo las mejores prácticas usadas en empresas reales.

## ⚙️ Entorno actual de la máquina
- **Java:** Corretto 23 / Corretto 24 / OpenJDK 26 instalados en `~\.jdks` (se usará Corretto 23)
- **Maven global:** No instalado — se usará el Maven de IntelliJ + Maven Wrapper (`mvnw`)
- **IntelliJ:** IDEA Community 2025.2.3
- **Git:** Sin GitHub — el curso es 100% local
- **Docker:** Instalado pero el daemon requiere arrancar Docker Desktop (se usará en la Fase 3)
- **Proyecto actual:** `ejercicio1-hola-mundo` en `Programacion Springboot\ejercicio1-hola-mundo\ejercicio1-hola-mundo\`

---

## 🗺️ Las 8 Fases del Plan

### Fase 0 — Preparación del entorno (Sesión 1) ✅ COMPLETADA
- [x] Instalar/configurar el JDK correcto en IntelliJ (Corretto 23)
- [x] Entender Maven y el Maven Wrapper (`mvnw`) — el estándar en empresas
- [x] Entender la estructura de un proyecto y el paquete base
- [x] **Proyecto real #0:** Hola Mundo Spring Boot — primera app corriendo en `localhost:8080` (respuesta `200 - Hola Mundo, Spring Boot` verificada)
- [~] **Git/GitHub:** DECIDIDO NO USAR — el curso se trabaja 100% en local, sin repositorio remoto
- [~] **Docker:** POSPUESTO — no se usará hasta la Fase 3 (PostgreSQL)

### Fase 1 — Fundamentos de Spring Core (Sesiones 2-3) ✅ COMPLETADA
- [x] Qué es un IoC Container y el contexto de Spring
- [x] Inyección de Dependencias (DI): qué problema resuelve, constructor injection
- [x] Beans y estereotipos (`@Component`, `@Service`, `@Repository`, `@Controller`)
- [x] Autoconfiguration de Spring Boot: qué nos ahorra
- [x] Spring Boot Starter: qué son las dependencias que IntelliJ añade
- **Proyecto real #0 (continuación):** expandir el Hola Mundo con beans propios

### Fase 2 — Capa Web / REST API (Sesiones 4-6) ✅ COMPLETADA
- [x] HTTP: métodos, códigos de estado, APIs REST
- [x] `@RestController`, rutas, `@PathVariable`, `@RequestParam`, `@RequestBody`
- [x] DTOs: por qué nunca se exponen las entidades directamente
- [x] Validación con Bean Validation (`@Valid`, `@NotNull`, `@Size`)
- [x] Manejo global de errores con `@ControllerAdvice`
- **Proyecto real #1:** API de tienda — catálogo de productos con endpoints bien diseñados ✅

### Fase 3 — Capa de Datos: JPA + PostgreSQL (Sesiones 7-10) ✅ COMPLETADA
- [x] Levantar PostgreSQL con Docker
- [x] Entidades JPA y mapeo de tablas
- [x] Relaciones (`@OneToMany`, `@ManyToOne`)
- [x] Spring Data JPA: `JpaRepository`, consultas derivadas, `@Query`
- [x] Transacciones con `@Transactional`
- **Proyecto real #2:** Sistema de biblioteca — libros, autores y préstamos con relaciones ✅

### Fase 4 — Configuración profesional (Sesiones 11-12)
- [ ] `application.yml`, profiles (`dev`, `prod`), variables de entorno para secretos
- [ ] `@ConfigurationProperties` para configuración tipada
- **Proyecto real #3:** Biblioteca con 2 entornos (local con Docker + producción simulada)

### Fase 5 — Seguridad (Sesiones 13-15)
- [ ] Spring Security: autenticación y autorización
- [ ] Hashing de contraseñas con BCrypt
- [ ] JWT para APIs modernas
- [ ] Roles y permisos
- **Proyecto real #4:** API de usuarios — registro, login y endpoints protegidos por rol

### Fase 6 — Testing profesional (Sesiones 16-18)
- [ ] Tests unitarios con JUnit 5 + Mockito (servicios)
- [ ] Tests de integración con `@SpringBootTest`
- [ ] Test slices (`@WebMvcTest`, `@DataJpaTest`)
- [ ] Testcontainers: tests contra PostgreSQL real en Docker
- [ ] Aplicar tests a los proyectos anteriores
- **Proyecto real #5:** Suite de tests completa de la biblioteca

### Fase 7 — Producción y API docs (Sesiones 19-20)
- [ ] Actuator: health checks y métricas
- [ ] OpenAPI/Swagger para documentar la API
- [ ] Buenas prácticas finales y code review de lo aprendido

### Fase 8 — Proyecto Integrador Final (Sesiones 21-25)
- [ ] **Sistema de e-commerce completo:** productos, carrito, pedidos, usuarios con roles
- [ ] Base de datos real, seguridad JWT, validaciones y tests
- [ ] Estructura de código profesional lista para producción

---

## 🛠️ Proyectos reales que construiremos

| # | Proyecto | Fase | Qué enseña |
|---|----------|------|------------|
| 0 | Hola Mundo Spring Boot | 0-1 | Setup, contexto, beans, DI |
| 1 | API de tienda | 2 | REST, DTOs, validación, errores |
| 2 | Sistema de biblioteca | 3 | JPA, PostgreSQL, relaciones, transacciones |
| 3 | Biblioteca con 2 entornos | 4 | Profiles y configuración externa |
| 4 | API de usuarios con JWT | 5 | Spring Security, BCrypt, roles |
| 5 | Tests de la biblioteca | 6 | Unit tests, integración, Testcontainers |
| 6 | E-commerce completo | 8 | Todo lo aprendido integrado |

---

## 🎓 Metodología de cada sesión
1. **Teoría corta** con ejemplos de la vida real (por qué se hace así en empresas)
2. **Código juntos:** escribimos el proyecto paso a paso, el estudiante hace y el profesor corrige
3. **Tarea al final:** mini-ejercicio para fijar lo aprendido
4. **Revisión** al inicio de la siguiente sesión

---

## ✅ Progreso del curso
*(Marcar con `x` cada casilla al completar cada fase)*

**Fase 0:** [x] Completada (Sesión 1 — 20/08/2026)
**Fase 1:** [x] Completada (Sesión 2 — 26/08/2026)
**Fase 2:** [x] Completada (Sesión 2 — 26/08/2026)
**Fase 3:** [x] Completada (Sesión 3 — 31/08/2026)
**Fase 4:** [ ] Pendiente
**Fase 5:** [ ] Pendiente
**Fase 6:** [ ] Pendiente
**Fase 7:** [ ] Pendiente
**Fase 8:** [ ] Pendiente

---

## 📓 Diario de sesiones

### Sesión 1 — 20/08/2026 · Fase 0 ✅
**Qué hicimos hoy:**
- Descargamos el proyecto desde `start.spring.io` (Maven + Java 23 + dependencia `web`) — se resolvió la duda de "qué dependencias usa IntelliJ": son los starters de Spring Boot
- Descomprimimos el zip y abrimos el proyecto en IntelliJ (Corretto 23)
- Aprendimos la estructura de un proyecto Spring Boot: `pom.xml`, `src/main/java`, `src/main/resources`, `mvnw`
- Creamos `HolaController.java` con `@RestController` y `@GetMapping("/")`
- Ejecutamos la app por primera vez con la ▶ verde: `Tomcat started on port 8080`
- Verificamos en el navegador: `http://localhost:8080` → **"Hola Mundo, Spring Boot"** (código 200)
- Aprendimos qué es `localhost` (mi propia máquina = `127.0.0.1`) y el puerto por defecto `8080` (cambiable con `server.port` en `application.properties`)

**Decisiones tomadas:**
- ❌ Sin GitHub: el curso se trabaja 100% local
- ⏳ Docker se pospone hasta la Fase 3

**Próxima sesión (Fase 1):** Fundamentos de Spring Core — IoC Container, Inyección de Dependencias, beans y estereotipos

### Sesión 2 — 26/08/2026 · Fase 1 + Fase 2 ✅
**Qué hicimos hoy:**
- **Fase 1 (repaso rápido):** El estudiante ya dominaba los conceptos de IoC, DI, beans y estereotipos, así que pasamos directamente a la Fase 2
- **Docker y PostgreSQL:** Creamos `docker-compose.yml`, levantamos PostgreSQL en Docker (puerto 5432), resolvimos conflicto con PostgreSQL local
- **Configuración:** Creamos `application.yml` con conexión a la base de datos, solucionamos problemas de indentación y dependencias
- **Paquetes:** Creamos 6 carpetas: `model`, `repository`, `dto`, `exception`, `controller`, `service`
- **Entidad:** `Producto.java` con UUID, Lombok (`@Data`, `@NoArgsConstructor`, `@AllArgsConstructor`)
- **Repositorio:** `ProductoRepository.java` con `JpaRepository<Producto, UUID>`
- **DTOs:** `ProductoDTO.java` (respuesta) y `ProductoCreateDTO.java` (creación con validaciones `@NotBlank`, `@Size`, `@NotNull`, `@Positive`)
- **Excepciones:** `ProductoNotFoundException.java`, `ErrorResponse.java`, `GlobalExceptionHandler.java` con `@RestControllerAdvice`
- **Servicio:** `ProductoService.java` con lógica de negocio (listar, obtener, crear, actualizar, eliminar)
- **Controlador:** `ProductoController.java` con 5 endpoints REST (`GET`, `POST`, `PUT`, `DELETE`)
- **Seed data:** `data.sql` con 30 productos de prueba
- **Tests:** Probamos todos los endpoints con `Invoke-WebRequest` en PowerShell

**Problemas resueltos:**
- Conflicto de puertos: PostgreSQL local vs Docker (pararamos el servicio local)
- Dependencia faltante: `spring-boot-starter-validation` para las anotaciones de validación
- JSON corrupto: PowerShell escapa mal las comillas con `curl.exe` (usamos `Invoke-WebRequest`)
- `data.sql` no se ejecutaba: falta `spring.sql.init.mode: always` en `application.yml`
- Indentación incorrecta: `sql.init.mode` estaba anidado dentro de `datasource`

**Decisiones tomadas:**
- Usamos UUID en vez de auto-incremental para los IDs
- Usamos Lombok para reducir código boilerplate
- PostgreSQL corre en Docker (puerto 5432)
- Datos de prueba en `data.sql` con 30 productos

**Documentación creada:**
- `README.md` — Documentación profesional del proyecto con stack tecnológico, estructura, instrucciones de ejecución y conceptos aprendidos
- `PLAN_DE_ESTUDIOS.md` — Plan del curso actualizado con Fase 0, 1 y 2 completadas

**Próxima sesión (Fase 3):** Configuración profesional — profiles, `@ConfigurationProperties`, variables de entorno

### Sesión 3 — 31/08/2026 · Fase 3 ✅
**Qué hicimos hoy:**
- **Teoría:** Aprendimos sobre relaciones entre entidades (`@OneToMany`, `@ManyToOne`, `@ManyToMany`), consultas personalizadas con `@Query` (derivadas, JPQL, nativas) y transacciones con `@Transactional`
- **Proyecto nuevo:** Creamos `ejercicio2` — Sistema de biblioteca completa
- **Configuración:** `pom.xml` con dependencias (JPA, PostgreSQL, Lombok, Validation), `application.yml` con conexión a PostgreSQL, `docker-compose.yml` para PostgreSQL en puerto 5433
- **Entidades JPA:** `Autor.java`, `Libro.java`, `Prestamo.java` con relaciones `@OneToMany` y `@ManyToOne`
- **Repositorios:** `AutorRepository.java`, `LibroRepository.java`, `PrestamosRepository.java` con `JpaRepository`
- **DTOs:** 6 DTOs (3 de respuesta + 3 de creación con validaciones)
- **Excepciones:** 3 excepciones personalizadas (`AutorNotFoundException`, `LibroNotFoundException`, `PrestamoNotFoundException`)
- **Servicios:** `AutorService.java`, `LibroService.java`, `PrestamoService.java` (este último con `@Transactional` para préstamos/devoluciones)
- **Controladores:** 3 controladores REST con endpoints completos
- **Seed data:** `data.sql` con 5 autores y 10 libros de prueba
- **Pruebas:** Probamos todos los endpoints con `Invoke-WebRequest` — CRUD completo funcionando

**Problemas resueltos:**
- Error de autenticación PostgreSQL: puerto incorrecto (5432 vs 5433)
- Tabla no existía: `defer-datasource-initialization: true` necesario para ejecutar `data.sql` después de Hibernate
- Columna `autor_id` no existía: corregimos `@JoinColumn` en `Libro.java`
- Error de comillas en PowerShell: usamos `Invoke-WebRequest` en vez de `curl.exe`

**Decisiones tomadas:**
- Puerto 5433 para PostgreSQL (evitar conflicto con ejercicio1)
- `FetchType.EAGER` en `Autor.java` (un autor tiene pocos libros)
- `@Transactional` en `PrestamoService` para operaciones de préstamo/devolución
- `ddl-auto: create-drop` temporalmente para recrear tablas, luego `update`

**Próxima sesión (Fase 4):** Configuración profesional — profiles, `@ConfigurationProperties`, variables de entorno

---

*Documento guía — ir actualizando sesión a sesión para seguir el hilo del curso.*