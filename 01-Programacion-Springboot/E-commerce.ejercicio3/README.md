# 🛒 E-commerce — REST API

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.1.1-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![JWT](https://img.shields.io/badge/JWT-0.12.6-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-4169E1?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Estado](https://img.shields.io/badge/Estado-Fase_8_en_curso-F5A623?style=for-the-badge)

> Proyecto integrador final del curso de Spring Boot: API REST de e-commerce completa con productos, carrito de compras, pedidos, usuarios con roles, JWT, transacciones y testing profesional.

## ✅ Estado del proyecto

**Fase 8 — Proyecto Integrador Final** en curso.

| Fase | Qué aporta | Estado |
|------|-----------|--------|
| **Modelo de dominio** | 6 entidades: Usuario, Producto, Carrito, CarritoItem, Pedido, PedidoItem + enums Role y EstadoPedido | ✅ |
| **Repositorios** | 5 repos JPA con consultas derivadas (findByUsername, findByActivoTrue, findByCarritoAndProducto, etc.) | ✅ |
| **Servicios** | Lógica de negocio: stock transaccional, snapshot de precio, vaciado del carrito | 🔄 En curso |
| **Controladores** | REST endpoints con validación y manejo de errores | 🔜 |
| **Seguridad** | JWT + roles ADMIN/USER + @PreAuthorize | 🔜 |
| **Tests** | Unit, slices y Testcontainers | 🔜 |
| **Docs y producción** | Actuator, Swagger, perfil prod | 🔜 |

## 🎯 Objetivo del proyecto

Integrar todo lo aprendido en el curso en un e-commerce real:

- Entidades JPA con relaciones (`@OneToOne`, `@OneToMany`, `@ManyToOne`)
- Repositorios con Spring Data JPA y consultas derivadas
- DTOs para transferencia de datos
- Manejo de errores personalizado
- Transacciones con `@Transactional` (control de stock)
- Snapshot de datos en pedidos históricos
- Spring Security con JWT para autenticación
- Roles y permisos de usuario (`@PreAuthorize`)
- Docker para bases de datos
- Testing profesional con JUnit 5, Mockito, test slices y Testcontainers
- Actuator y documentación OpenAPI/Swagger
- Perfiles de configuración (dev, prod, test, testcontainers)

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
| Lombok | 1.18.46 | Reducción de código boilerplate |
| Bean Validation | - | Validación de datos |
| SpringDoc OpenAPI | 3.1.1 | Documentación Swagger |
| Spring Boot Actuator | - | Monitoreo y health checks |
| Maven | - | Gestión de dependencias |

## 📁 Estructura del proyecto

```
E-commerce.ejercicio3/
├── pom.xml                          # Dependencias Maven
├── src/
│   ├── main/java/com/example/E_commerce/ejercicio3/
│   │   ├── Application.java
│   │   ├── model/
│   │   │   ├── Role.java            # Enum: ROLE_USER, ROLE_ADMIN
│   │   │   ├── Usuario.java         # Usuarios del sistema
│   │   │   ├── Producto.java        # Productos de la tienda
│   │   │   ├── Carrito.java         # Carrito de compras (1:1 con Usuario)
│   │   │   ├── CarritoItem.java     # Items del carrito (constraint única carrito+producto)
│   │   │   ├── EstadoPedido.java    # Enum: PENDIENTE, PAGADO, CANCELADO
│   │   │   ├── Pedido.java          # Pedidos realizados
│   │   │   └── PedidoItem.java      # Items del pedido (snapshot de precio y nombre)
│   │   └── repository/
│   │       ├── UsuarioRepository.java
│   │       ├── ProductoRepository.java
│   │       ├── CarritoRepository.java
│   │       ├── CarritoItemRepository.java
│   │       └── PedidoRepository.java
│   └── main/resources/
│       └── application.properties
│   └── test/java/.../
│       └── ApplicationTests.java
```

## 🚀 Cómo levantar el proyecto

### Requisitos
- Java 17 o superior
- Docker (para PostgreSQL)

### 1. Levantar la base de datos

```bash
docker run --name ecommerce-db -e POSTGRES_DB=comercio_db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=postgres -p 5434:5432 -d postgres:16
```

### 2. Arrancar la aplicación

```bash
# Modo desarrollo (puerto 8082)
.\mvnw spring-boot:run

# Modo producción (requiere variables de entorno)
.\mvnw spring-boot:run "-Dspring-boot.run.profiles=prod"
```

### 3. Variables de entorno para prod

```bash
$env:JWT_SECRET = "tu-clave-secreta-muy-larga-y-segura-aqui-cambiame"
$env:DB_PORT = "5434"
```

### 4. Acceder a la API

- **API:** http://localhost:8082 (dev)
- **Swagger UI:** http://localhost:8082/swagger-ui.html (solo en dev)
- **Actuator:** http://localhost:8082/actuator/health

## 🗃️ Modelo de datos

| Entidad | Descripción | Relaciones clave |
|---------|-------------|------------------|
| `Usuario` | Usuarios con roles (ADMIN/USER) | 1:1 → Carrito, 1:N → Pedido |
| `Producto` | Productos con nombre, precio, stock | 1:N → CarritoItem, 1:N → PedidoItem |
| `Carrito` | Carrito persistido por usuario | 1:1 ← Usuario, 1:N → CarritoItem |
| `CarritoItem` | Producto en el carrito + cantidad | Constraint única: (carrito, producto) |
| `Pedido` | Pedido con estado y fecha | N:1 → Usuario, 1:N → PedidoItem |
| `PedidoItem` | Snapshot del producto al comprar | Snapshot: nombre + precioUnitario |

## 📝 Licencia

Proyecto educativo — 1er Año DAM
