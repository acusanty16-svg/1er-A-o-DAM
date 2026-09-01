# 🛒 API de Tienda — REST API

Proyecto de gestión de tienda desarrollado con Spring Boot, JPA y PostgreSQL.

## 🎯 Objetivo del proyecto

Aprender a construir una API REST completa con:
- Entidades JPA con UUID
- Repositorios con Spring Data JPA
- DTOs para transferencia de datos
- Manejo de errores con `@ControllerAdvice`
- Validación con Bean Validation
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
ejercicio1-hola-mundo/
├── docker-compose.yml          # PostgreSQL en Docker
├── pom.xml                     # Dependencias Maven
├── src/
│   ├── main/
│   │   ├── java/com/example/ejercicio1_hola_mundo/
│   │   │   ├── Ejercicio1HolaMundoApplication.java    # Clase principal
│   │   │   ├── HolaController.java                    # Controlador Hola Mundo
│   │   │   ├── component/
│   │   │   │   └── ContadorVisitas.java               # Componente contador
│   │   │   ├── model/
│   │   │   │   └── Producto.java                      # Entidad JPA
│   │   │   ├── repository/
│   │   │   │   └── ProductoRepository.java            # Repositorio
│   │   │   ├── dto/
│   │   │   │   ├── ProductoDTO.java                   # DTO de respuesta
│   │   │   │   └── ProductoCreateDTO.java             # DTO de creación
│   │   │   ├── exception/
│   │   │   │   ├── ProductoNotFoundException.java     # Excepción personalizada
│   │   │   │   ├── ErrorResponse.java                 # Respuesta de error
│   │   │   │   └── GlobalExceptionHandler.java        # Manejador global
│   │   │   └── service/
│   │   │       ├── ProductoService.java               # Lógica de negocio
│   │   │       └── SaludoService.java                 # Servicio de saludos
│   │   └── resources/
│   │       ├── application.yml                        # Configuración
│   │       └── data.sql                               # Datos de prueba
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

O desde IntelliJ: ejecutar `Ejercicio1HolaMundoApplication.java`

### 3. Verificar

La aplicación arranca en: `http://localhost:8080`

## 📡 Endpoints de la API

### Hola Mundo

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/` | Mensaje de bienvenida |

### Productos

| Método | URL | Descripción |
|--------|-----|-------------|
| `GET` | `/api/productos` | Listar todos los productos |
| `GET` | `/api/productos/{id}` | Obtener un producto por ID |
| `POST` | `/api/productos` | Crear un producto nuevo |
| `PUT` | `/api/productos/{id}` | Actualizar un producto |
| `DELETE` | `/api/productos/{id}` | Eliminar un producto |

## 📝 Ejemplos de uso

### Listar productos

```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/productos" -Method GET
```

### Crear un producto

```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/productos" -Method POST -ContentType "application/json" -Body '{"nombre":"Portatil Lenovo","precio":899.99}'
```

### Actualizar un producto

```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/productos/ID_DEL_PRODUCTO" -Method PUT -ContentType "application/json" -Body '{"nombre":"Portatil Lenovo Pro","precio":999.99}'
```

### Eliminar un producto

```powershell
Invoke-WebRequest -Uri "http://localhost:8080/api/productos/ID_DEL_PRODUCTO" -Method DELETE
```

## 🗄️ Base de datos

- **Motor:** PostgreSQL 16
- **Puerto:** 5432 (Docker)
- **Nombre:** `tienda_db`
- **Usuario:** `postgres`
- **Contraseña:** `postgres`

### Tablas

| Tabla | Descripción |
|-------|-------------|
| `productos` | Productos de la tienda |

## 📚 Conceptos aprendidos

- [x] Spring Boot: primera aplicación
- [x] Controladores REST con `@RestController`
- [x] Entidades JPA con UUID
- [x] Repositorios con Spring Data JPA
- [x] DTOs para transferencia de datos
- [x] Validación con Bean Validation
- [x] Manejo de errores con `@ControllerAdvice`
- [x] Docker para bases de datos
- [x] Datos de prueba con `data.sql`

---

*Proyecto del curso de Spring Boot — Fase 0, 1 y 2*
