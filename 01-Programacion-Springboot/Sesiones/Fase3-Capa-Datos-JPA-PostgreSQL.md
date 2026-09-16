# Fase 3 — Capa de Datos: JPA + PostgreSQL

**Sesiones 7-10** | Duración estimada: 60-90 minutos

---

## Objetivo de esta fase

Aprender a conectar Spring Boot a una base de datos real con JPA y PostgreSQL, crear entidades con relaciones, repositorios, servicios transaccionales y DTOs para transferencia de datos.

---

# PARTE A: DOCKER Y POSTGRESQL

## 1. Docker Compose para PostgreSQL

### Por qué Docker?

En vez de instalar PostgreSQL directamente en tu máquina, usamos Docker para crear un **contenedor** aislado. Ventajas:

- No contaminas tu sistema operativo
- Puedes crear/destruir entornos fácilmente
- Cada proyecto puede tener su propia base de datos

### docker-compose.yml del ejercicio2

```yaml
services:
  postgres:
    image: postgres:16
    container_name: biblioteca_postgres
    environment:
      POSTGRES_DB: biblioteca_db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5433:5432"
    volumes:
      - biblioteca_data:/var/lib/postgresql/data

volumes:
  biblioteca_data:
```

### Explicación clave

| Elemento | Por qué |
|----------|---------|
| `POSTGRES_DB: biblioteca_db` | Crea la base de datos automáticamente al iniciar |
| `ports: "5433:5432"` | Mapea el puerto 5433 de tu máquina al 5432 del contenedor (evita conflicto con ejercicio1) |
| `volumes: biblioteca_data` | Guarda los datos persistentes para que no se borren al detener el contenedor |

### Comandos esenciales

```bash
# Levantar PostgreSQL en segundo plano
docker-compose up -d

# Verificar que está corriendo
docker-compose ps

# Ver logs
docker-compose logs postgres

# Detener (los datos se mantienen por el volume)
docker-compose down
```

---

# PARTE B: ENTIDADES JPA CON RELACIONES

## 2. Entidad Autor (Uno a Muchos)

### Modelo del dominio

Un **autor** puede tener **muchos libros**. Esta es una relación `@OneToMany`.

```java
@Entity
@Table(name = "autores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros = new ArrayList<>();
}
```

### Anotaciones explicadas

| Anotación | Qué hace |
|-----------|----------|
| `@Entity` | Marca esta clase como una tabla en la base de datos |
| `@Table(name = "autores")` | Nombre de la tabla en PostgreSQL |
| `@Id` | Campo que es la llave primaria |
| `@GeneratedValue(strategy = GenerationType.UUID)` | Genera un UUID automáticamente |
| `@OneToMany(mappedBy = "autor")` | Un autor tiene muchos libros. `mappedBy` indica quién tiene la llave foránea |
| `cascade = CascadeType.ALL` | Si borras un autor, se borran sus libros |
| `fetch = FetchType.EAGER` | Carga los libros junto con el autor (porque un autor tiene pocos libros) |

### Fetch Types: LAZY vs EAGER

| Tipo | Comportamiento | Cuándo usarlo |
|------|----------------|---------------|
| `LAZY` | Solo carga los libros cuando accedes a `autor.getLibros()` | Cuando la colección es grande |
| `EAGER` | Carga los libros junto con el autor en la misma consulta | Cuando la colección es pequeña y siempre la necesitas |

**En nuestro caso:** Un autor tiene pocos libros (2-3), así que `EAGER` es apropiado.

---

## 3. Entidad Libro (Muchos a Uno)

### Modelo del dominio

Muchos **libros** pertenecen a **un autor**. Relación `@ManyToOne`.

```java
@Entity
@Table(name = "libros")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = false)
    private Double precio;

    @Column(nullable = false)
    private boolean prestado = false;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;
}
```

### Anotaciones clave

| Anotación | Qué hace |
|-----------|----------|
| `@ManyToOne` | Muchos libros pueden tener un mismo autor |
| `@JoinColumn(name = "autor_id")` | Columna en la tabla `libros` que referencia al autor |

---

## 4. Entidad Préstamo

```java
@Entity
@Table(name = "prestamos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Prestamo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String usuario;

    @Column(nullable = false)
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;

    @ManyToOne
    @JoinColumn(name = "libro_id")
    private Libro libro;
}
```

---

## 5. Diagrama de Relaciones

```
┌──────────────┐       ┌──────────────┐       ┌──────────────┐
│   AUTORES    │       │    LIBROS    │       │  PRESTAMOS   │
├──────────────┤       ├──────────────┤       ├──────────────┤
│ id (UUID)    │──┐    │ id (UUID)    │──┐    │ id (UUID)    │
│ nombre       │  └───>│ titulo       │  └───>│ usuario      │
└──────────────┘       │ precio       │       │ fechaPrestamo│
    @OneToMany         │ prestado     │       │ fechaDevoluc.│
                       │ autor_id (FK)│       │ libro_id (FK)│
                       └──────────────┘       └──────────────┘
                            @ManyToOne             @ManyToOne
```

---

# PARTE C: REPOSITORIOS

## 6. Spring Data JPA

### ¿Qué es?

Spring Data JPA te da **métodos CRUD automáticos** solo por extender `JpaRepository`. No necesitas escribir SQL para operaciones básicas.

```java
@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}

@Repository
public interface LibroRepository extends JpaRepository<Libro, UUID> {
}

@Repository
public interface PrestamosRepository extends JpaRepository<Prestamo, UUID> {
}
```

### Métodos que obtienes gratis

| Método | Qué hace |
|--------|----------|
| `findAll()` | Lista todos los registros |
| `findById(UUID id)` | Busca por ID (retorna `Optional`) |
| `save(entity)` | Guarda o actualiza |
| `deleteById(UUID id)` | Elimina por ID |
| `count()` | Cuenta registros |
| `existsById(UUID id)` | Verifica si existe |

### Métodos personalizados (naming convention)

```java
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {
    Optional<Usuario> findByUsername(String username);  // Spring genera el SQL
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
```

**Regla:** Si nombras el método correctamente (`findBy` + campo), Spring genera la consulta automáticamente.

---

# PARTE D: DTOs

## 7. ¿Por qué no exponer entidades directamente?

**Problema:** Si devuelves la entidad `Autor` directamente, el cliente recibe:
```json
{
    "id": "...",
    "nombre": "García Márquez",
    "libros": [...]  // Datos internos que el cliente no necesita
}
```

**Solución:** Usas un DTO que solo expone lo necesario:

```java
public class AutorDTO {
    private UUID id;
    private String nombre;
}
```

### DTOs de creación vs respuesta

| Tipo | Propósito | Ejemplo |
|------|-----------|---------|
| **Create DTO** | Lo que el cliente envía al crear | `AutorCreateDTO` (solo `nombre`) |
| **Response DTO** | Lo que el cliente recibe | `AutorDTO` (id + nombre) |

---

# PARTE E: SERVICIOS Y TRANSACCIONES

## 8. Lógica de Negocio

Los servicios encapsulan toda la lógica de negocio:

```java
@Service
public class AutorService {
    private final AutorRepository autorRepository;

    // Constructor injection (siempre final)
    public AutorService(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    public List<AutorDTO> findAll() {
        return autorRepository.findAll().stream()
                .map(this::toDTO)
                .toList();
    }

    public AutorDTO create(AutorCreateDTO dto) {
        Autor autor = new Autor();
        autor.setNombre(dto.getNombre());
        return toDTO(autorRepository.save(autor));
    }
}
```

## 9. Transacciones con @Transactional

Las operaciones que deben ejecutarse **juntas** (si una falla, todo se deshace) llevan `@Transactional`:

```java
@Transactional
public PrestamosDTO create(PrestamoCreateDTO dto) {
    // Paso 1: Buscar libro
    Libro libro = libroRepository.findById(dto.getLibroId())
            .orElseThrow(() -> new LibroNotFoundException(dto.getLibroId()));

    // Paso 2: Verificar que no esté prestado
    if (libro.isPrestado()) {
        throw new RuntimeException("El libro ya está prestado");
    }

    // Paso 3: Marcar como prestado
    libro.setPrestado(true);
    libroRepository.save(libro);

    // Paso 4: Crear el préstamo
    Prestamo prestamo = new Prestamo();
    prestamo.setLibro(libro);
    prestamo.setUsuario(dto.getUsuario());
    prestamo.setFechaPrestamo(LocalDateTime.now());

    return toDTO(prestamosRepository.save(prestamo));
    // Si algo falla en CUALQUIER paso, TODO se deshace
}
```

**Por qué importa:** Sin `@Transactional`, si falla el paso 4, el paso 3 ya se habría guardado (el libro marcado como prestado pero sin préstamo registrado).

---

# PARTE F: CONTROLADORES

## 10. Endpoints REST

```java
@RestController
@RequestMapping("/api/autores")
public class AutorController {
    private final AutorService autorService;

    public AutorController(AutorService autorService) {
        this.autorService = autorService;
    }

    @GetMapping
    public ResponseEntity<List<AutorDTO>> findAll() {
        return ResponseEntity.ok(autorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AutorDTO> findById(@PathVariable UUID id) {
        return ResponseEntity.ok(autorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AutorDTO> create(@Valid @RequestBody AutorCreateDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(autorService.create(dto));
    }
}
```

---

## 11. Endpoints de la API

| Método | URL | Descripción | Status |
|--------|-----|-------------|--------|
| `GET` | `/api/autores` | Listar autores | 200 |
| `GET` | `/api/autores/{id}` | Obtener autor | 200 / 404 |
| `POST` | `/api/autores` | Crear autor | 201 |
| `GET` | `/api/libros` | Listar libros | 200 |
| `GET` | `/api/libros/{id}` | Obtener libro | 200 / 404 |
| `POST` | `/api/libros` | Crear libro | 201 |
| `GET` | `/api/prestamos` | Listar préstamos | 200 |
| `POST` | `/api/prestamos` | Crear préstamo | 201 |
| `PUT` | `/api/prestamos/{id}/devolver` | Devolver libro | 204 |

---

## 12. Datos de prueba (data.sql)

```sql
-- Autores
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Gabriel García Márquez');
INSERT INTO autores (id, nombre) VALUES (gen_random_uuid(), 'Mario Vargas Llosa');
-- ...

-- Libros
INSERT INTO libros (id, titulo, precio, prestado, autor_id)
VALUES (gen_random_uuid(), 'Cien Años de Soledad', 19.99, false,
        (SELECT id FROM autores WHERE nombre = 'Gabriel García Márquez'));
```

**Nota:** `gen_random_uuid()` genera UUIDs automáticamente en PostgreSQL.

---

## 13. Resumen de la Fase 3

| Concepto | Qué aprendimos |
|----------|----------------|
| Docker Compose | Levantar PostgreSQL en contenedor aislado |
| Entidades JPA | Mapear clases Java a tablas de la BD |
| Relaciones | `@OneToMany`, `@ManyToOne` con `@JoinColumn` |
| Fetch Types | `LAZY` vs `EAGER` y cuándo usar cada uno |
| Repositorios | `JpaRepository` para CRUD automático |
| DTOs | Separar entidades de lo que el cliente ve |
| Transacciones | `@Transactional` para operaciones atómicas |
| UUIDs | Identificadores únicos en vez de auto-incremental |
| Excepciones | `NotFoundException` personalizadas por entidad |

---

*Documento de teoría — Fase 3 del curso de Spring Boot*
