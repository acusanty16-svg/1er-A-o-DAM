# 📚 Sistema de Biblioteca — REST API

Proyecto de gestión de biblioteca desarrollado con Spring Boot, JPA y PostgreSQL.

## 🎯 Objetivo del proyecto

Aprender a construir una API REST completa con:
- Entidades JPA con relaciones (`@OneToMany`, `@ManyToOne`)
- Repositorios con Spring Data JPA
- DTOs para transferencia de datos
- Manejo de errores personalizado
- Transacciones con `@Transactional`
- Docker para bases de datos

## 🛠️ Stack tecnológico

| Tecnología | Versión | Propósito |
|------------|---------|-----------|
| Java | 17 | Lenguaje de programación |
| Spring Boot | 4.1.1 | Framework principal |
| Spring Data JPA | - | Acceso a datos |
| PostgreSQL | 16 | Base de datos |
| Docker | - | Contenedores |
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
│   │   │   ├── model/                         # Entidades JPA
│   │   │   │   ├── Autor.java
│   │   │   │   ├── Libro.java
│   │   │   │   └── Prestamo.java
│   │   │   ├── repository/                    # Repositorios
│   │   │   │   ├── AutorRepository.java
│   │   │   │   ├── LibroRepository.java
│   │   │   │   └── PrestamosRepository.java
│   │   │   ├── DTO/                           # Data Transfer Objects
│   │   │   │   ├── AutorDTO.java
│   │   │   │   ├── LibroDTO.java
│   │   │   │   ├── PrestamosDTO.java
│   │   │   │   ├── AutorCreateDTO.java
│   │   │   │   ├── LibroCreateDTO.java
│   │   │   │   └── PrestamoCreateDTO.java
│   │   │   ├── exception/                     # Excepciones personalizadas
│   │   │   │   ├── AutorNotFoundException.java
│   │   │   │   ├── LibroNotFoundException.java
│   │   │   │   └── PrestamoNotFoundException.java
│   │   │   ├── service/                       # Lógica de negocio
│   │   │   │   ├── AutorService.java
│   │   │   │   ├── LibroService.java
│   │   │   │   └── PrestamoService.java
│   │   │   └── controller/                    # Controladores REST
│   │   │       ├── AutorController.java
│   │   │       ├── LibroController.java
│   │   │       └── PrestamoController.java
│   │   └── resources/
│   │       ├── application.yml                # Configuración
│   │       └── data.sql                       # Datos de prueba
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

## 📡 Endpoints de la API

### Autores

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/autores` | Listar todos los autores |
| `GET` | `/api/autores/{id}` | Obtener un autor por ID |
| `POST` | `/api/autores` | Crear un autor nuevo |

### Libros

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/libros` | Listar todos los libros |
| `GET` | `/api/libros/{id}` | Obtener un libro por ID |
| `POST` | `/api/libros` | Crear un libro nuevo |

### Préstamos

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/prestamos` | Listar todos los préstamos |
| `GET` | `/api/prestamos/{id}` | Obtener un préstamo por ID |
| `POST` | `/api/prestamos` | Crear un préstamo (prestar libro) |
| `PUT` | `/api/prestamos/{id}/devolver` | Devolver un libro prestado |

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

---

*Proyecto del curso de Spring Boot — Fase 3*
