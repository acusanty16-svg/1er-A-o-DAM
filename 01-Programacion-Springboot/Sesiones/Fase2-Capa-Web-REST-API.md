# Fase 2 — Capa Web / REST API

**Sesiones 4-6** | Duracion estimada: 90-130 minutos

---

## Objetivo

Aprender a construir APIs REST profesionales con Spring Boot, conectando PostgreSQL y creando endpoints para gestionar productos.

---

# PARTE A: PREPARACION DEL ENTORNO

## 1. Docker y PostgreSQL

### Que es Docker?

Docker crea **contenedores**. Un contenedor es como una maquina virtual ligera que tiene todo lo necesario para ejecutar un programa.

**Analogia:**
- **Sin Docker:** Tienes que instalar PostgreSQL manualmente en tu PC
- **Con Docker:** Docker crea un cajon con PostgreSQL instalado y listo para usar

### Que es PostgreSQL?

PostgreSQL es un **sistema de gestion de bases de datos** (SGBD). Es como un almacen de datos estructurados donde tu aplicacion guarda y consulta informacion.

```
Tu app Spring Boot  -->  PostgreSQL  -->  Datos guardados
   (codigo Java)         (contenedor)      (productos, etc.)
```

---

## 2. docker-compose.yml

### Archivo docker-compose.yml

```yaml
version: '3.8'

services:
  postgres:
    image: postgres:16
    container_name: mi_postgres
    environment:
      POSTGRES_DB: tienda_db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

volumes:
  postgres_data:
```

### Explicacion linea por linea

| Linea | Que hace |
|-------|----------|
| `version: '3.8'` | Version de docker-compose |
| `services:` | Define los contenedores |
| `postgres:` | Nombre del servicio |
| `image: postgres:16` | Imagen de PostgreSQL version 16 |
| `container_name: mi_postgres` | Nombre del contenedor |
| `POSTGRES_DB: tienda_db` | Nombre de la base de datos |
| `POSTGRES_USER: postgres` | Usuario de la base de datos |
| `POSTGRES_PASSWORD: postgres` | Contrasena |
| `ports: "5432:5432"` | Puerto externo: interno |
| `volumes:` | Guardar datos persistentes |

### Comandos Docker

```bash
# Levantar PostgreSQL
docker-compose up -d

# Ver contenedores activos
docker-compose ps

# Detener PostgreSQL
docker-compose down

# Ver logs
docker-compose logs postgres
```

---

# PARTE B: TEORIA WEB

## 3. HTTP y Metodos

### Que es HTTP?

HTTP (HyperText Transfer Protocol) es el **protocolo** que usan las aplicaciones web para comunicarse. Es como un idioma que entienden todos los navegadores y servidores.

### Metodos HTTP

| Metodo | Proposito | Ejemplo | Cuerpo (body) |
|--------|-----------|---------|---------------|
| `GET` | Obtener datos | `GET /api/productos` | No |
| `POST` | Crear recurso | `POST /api/productos` | Si (datos del nuevo producto) |
| `PUT` | Actualizar completo | `PUT /api/productos/1` | Si (todos los campos) |
| `PATCH` | Actualizar parcial | `PATCH /api/productos/1` | Si (solo campos modificados) |
| `DELETE` | Eliminar recurso | `DELETE /api/productos/1` | No |

### Ejemplo visual

```
Cliente (navegador/App)          Servidor (Spring Boot)
        |                                |
        |  GET /api/productos            |
        |------------------------------->|
        |                                |
        |  200 OK + lista de productos   |
        |<-------------------------------|
        |                                |
        |  POST /api/productos           |
        |  Body: {nombre, precio}        |
        |------------------------------->|
        |                                |
        |  201 Created + producto creado |
        |<-------------------------------|
```

---

## 4. Codigo de Estado HTTP

### Que son?

Los codigos de estado son **numeros de 3 digitos** que el servidor devuelve para indicar que paso con la peticion.

### Codigos mas usados

| Codigo | Significado | Cuando usar |
|--------|-------------|-------------|
| `200 OK` | Exito | GET exitoso, PUT exitoso |
| `201 Created` | Recurso creado | POST exitoso |
| `204 No Content` | Sin contenido | DELETE exitoso |
| `400 Bad Request` | Datos invalidos | Validacion fallida |
| `404 Not Found` | No encontrado | Recurso no existe |
| `500 Internal Server Error` | Error del servidor | Error inesperado |

### Ejemplo en codigo Java

```java
@GetMapping("/{id}")
public ResponseEntity<ProductoDTO> obtener(@PathVariable Long id) {
    Producto producto = service.obtenerPorId(id);
    
    if (producto == null) {
        return ResponseEntity.notFound().build();  // 404
    }
    
    return ResponseEntity.ok(dto);  // 200
}

@PostMapping
public ResponseEntity<ProductoDTO> crear(@RequestBody ProductoCreateDTO dto) {
    Producto producto = service.crear(dto);
    return ResponseEntity.status(201).body(producto);  // 201
}
```

---

## 5. DTOs (Data Transfer Objects)

### Que es un DTO?

Un DTO es un objeto que **transporta datos** entre capas de la aplicacion. No tiene logica de negocio, solo campos.

### Por que no exponer entidades directamente?

**Problema: Exponer la entidad**

```java
@Entity
public class Producto {
    private Long id;
    private String nombre;
    private Double precio;
    private Date fechaCreacion;    // El cliente no necesita esto
    private Boolean activo;        // El cliente no deberia cambiar esto
    private String internalCode;   // Informacion sensible
}
```

**Solucion: Usar DTO**

```java
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;         // Solo lo que el cliente necesita
}
```

### Tipos de DTO

| Tipo | Proposito | Ejemplo |
|------|-----------|---------|
| **Response DTO** | Lo que el cliente recibe | `ProductoDTO` |
| **Request DTO** | Lo que el cliente envia | `ProductoCreateDTO` |

---

## 6. Validacion con Bean Validation

### Anotaciones mas comunes

| Anotacion | Que valida | Ejemplo |
|-----------|------------|---------|
| `@NotNull` | No puede ser null | `@NotNull private String nombre;` |
| `@NotBlank` | No puede ser null, vacio o espacios | `@NotBlank private String nombre;` |
| `@Size(min, max)` | Longitud del texto | `@Size(min=2, max=100)` |
| `@Positive` | Debe ser positivo | `@Positive private Double precio;` |
| `@Email` | Debe ser email valido | `@Email private String email;` |

### Ejemplo en DTO

```java
public class ProductoCreateDTO {
    
    @NotNull(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;
    
    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;
    
    // Constructor, getters, setters
}
```

### Uso en el controlador

```java
@PostMapping
public ResponseEntity<ProductoDTO> crear(
        @Valid @RequestBody ProductoCreateDTO dto) {
    // Si la validacion falla, Spring lanza una excepcion automaticamente
    Producto producto = service.crear(dto);
    return ResponseEntity.status(201).body(producto);
}
```

---

## 7. Manejo de Errores con @ControllerAdvice

### Excepcion personalizada

```java
@ResponseStatus(HttpStatus.NOT_FOUND)  // 404
public class ProductoNotFoundException extends RuntimeException {
    
    public ProductoNotFoundException(Long id) {
        super("Producto no encontrado con id: " + id);
    }
}
```

### Manejador global de errores

```java
@ControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(ProductoNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleNotFound(
            ProductoNotFoundException ex) {
        ErrorResponse error = new ErrorResponse(ex.getMessage());
        return ResponseEntity.status(404).body(error);
    }
    
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {
        
        List<String> errores = ex.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(e -> e.getField() + ": " + e.getDefaultMessage())
            .collect(Collectors.toList());
        
        ErrorResponse error = new ErrorResponse("Errores de validacion", errores);
        return ResponseEntity.status(400).body(error);
    }
}
```

### Respuesta de error

```java
public class ErrorResponse {
    private String mensaje;
    private List<String> detalles;
    
    // Constructor, getters, setters
}
```

---

# PARTE C: SPRING DATA JPA

## 8. Entidades JPA

### Que es JPA?

JPA (Java Persistence API) es un estandar Java para **mapear objetos a bases de datos**. Con JPA, una clase Java se convierte en una tabla de la base de datos.

### Ejemplo de entidad

```java
@Entity
@Table(name = "productos")
public class Producto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(nullable = false, length = 100)
    private String nombre;
    
    @Column(nullable = false)
    private Double precio;
    
    public Producto() {}
    
    public Producto(String nombre, Double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }
    
    // Getters y Setters
}
```

### Explicacion de anotaciones

| Anotacion | Que hace |
|-----------|----------|
| `@Entity` | Indica que esta clase es una entidad JPA |
| `@Table(name = "productos")` | Nombre de la tabla en la BD |
| `@Id` | Campo que es la llave primaria |
| `@GeneratedValue` | ID autoincremental |
| `@Column` | Configura la columna en la BD |

---

## 9. Repositorios

### Que es un Repository?

Un Repository es una interfaz que Spring Data JPA convierte automaticamente en una clase que accede a la base de datos.

### Ejemplo de repository

```java
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    // Spring genera automaticamente:
    // - findAll()
    // - findById(Long id)
    // - save(Producto producto)
    // - deleteById(Long id)
    // - count()
    // - existsById(Long id)
    
    // Consultas derivadas (Spring las genera automaticamente)
    List<Producto> findByNombre(String nombre);
    List<Producto> findByPrecioLessThan(Double precio);
    List<Producto> findByNombreContaining(String texto);
}
```

### Metodos automaticos de JpaRepository

| Metodo | Que hace |
|--------|----------|
| `findAll()` | Lista todos |
| `findById(Long id)` | Busca por ID |
| `save(Producto)` | Guarda o actualiza |
| `deleteById(Long id)` | Elimina por ID |
| `count()` | Cuenta registros |
| `existsById(Long id)` | Verifica si existe |

---

## 10. application.yml

### Configuracion de PostgreSQL

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/tienda_db
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
  
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
```

### Explicacion

| Propiedad | Que hace |
|-----------|----------|
| `spring.datasource.url` | URL de conexion a la BD |
| `spring.datasource.username` | Usuario de la BD |
| `spring.datasource.password` | Contrasena de la BD |
| `spring.jpa.hibernate.ddl-auto` | `update` = actualiza tablas automaticamente |
| `spring.jpa.show-sql` | Muestra las consultas SQL en consola |

---

# PARTE D: PRACTICA PASO A PASO

## Estructura final del proyecto

```
ejercicio1_hola_mundo/
├── Ejercicio1HolaMundoApplication.java
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
├── service/
│   ├── SaludoService.java
│   └── ProductoService.java
└── component/
    └── ContadorVisitas.java
```

## Pasos a seguir

1. Crear `docker-compose.yml` y levantar PostgreSQL
2. Crear paquetes: `model`, `repository`, `dto`, `exception`, `controller`
3. Crear `Producto.java` (entidad JPA)
4. Crear `ProductoRepository.java`
5. Crear `ProductoDTO.java` y `ProductoCreateDTO.java`
6. Crear `ProductoService.java`
7. Crear `ProductoNotFoundException.java`
8. Crear `ErrorResponse.java`
9. Crear `GlobalExceptionHandler.java`
10. Crear `ProductoController.java`
11. Configurar `application.yml`
12. Probar la API completa

## Endpoints que crearemos

| Metodo | URL | Descripcion | Codigo |
|--------|-----|-------------|--------|
| `GET` | `/api/productos` | Listar todos | 200 |
| `GET` | `/api/productos/{id}` | Obtener uno | 200 o 404 |
| `POST` | `/api/productos` | Crear nuevo | 201 |
| `PUT` | `/api/productos/{id}` | Actualizar | 200 o 404 |
| `DELETE` | `/api/productos/{id}` | Eliminar | 204 o 404 |

---

*Documento de teoria — Fase 2 del curso de Spring Boot*
