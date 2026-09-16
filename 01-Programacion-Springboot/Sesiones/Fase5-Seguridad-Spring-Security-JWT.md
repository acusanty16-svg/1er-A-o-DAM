# Fase 5 — Seguridad: Spring Security + JWT

**Sesiones 13-15** | Duración estimada: 60-90 minutos

---

## Objetivo de esta fase

Implementar autenticación y autorización en la API de la biblioteca usando Spring Security con JWT (JSON Web Tokens), incluyendo registro de usuarios, login, y endpoints protegidos por roles.

---

# PARTE A: CONCEPTOS DE SEGURIDAD

## 1. Autenticación vs Autorización

| Concepto | Pregunta que resuelve | Ejemplo |
|----------|----------------------|---------|
| **Autenticación** | ¿Quién eres? | Login con username + password |
| **Autorización** | ¿Qué puedes hacer? | Solo el admin puede crear autores |

## 2. ¿Qué es JWT?

JWT (JSON Web Token) es un **token** que el servidor genera después del login y el cliente envía en cada petición para autenticarse.

### Flujo de JWT

```
1. Login
   Cliente → POST /api/auth/login {username, password}
   Servidor → Verifica credenciales → Genera JWT → Devuelve token

2. Petición autenticada
   Cliente → GET /api/prestamos + Header: Authorization: Bearer <token>
   Servidor → Valida el token → Permite el acceso
```

### Estructura de un JWT

```
eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhZG1pbiJ9.firma
│          Header          │      Payload     │  Firma
```

- **Header:** Algoritmo de firma (HS256)
- **Payload:** Datos del usuario (username, roles, expiración)
- **Firma:** Garantiza que el token no fue modificado

---

# PARTE B: DEPENDENCIAS

## 3. Dependencias en pom.xml

```xml
<!-- Spring Security -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>

<!-- JWT -->
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-api</artifactId>
    <version>0.12.6</version>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-impl</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>io.jsonwebtoken</groupId>
    <artifactId>jjwt-jackson</artifactId>
    <version>0.12.6</version>
    <scope>runtime</scope>
</dependency>
```

---

# PARTE C: ENTIDADES DE SEGURIDAD

## 4. Enum de Roles

```java
public enum Role {
    ROLE_USER,    // Usuario normal: puede ver, crear préstamos
    ROLE_ADMIN    // Administrador: puede crear autores, libros, etc.
}
```

**¿Por qué enum?** Los roles son valores fijos. Un enum evita errores de tipeo y es más seguro que Strings.

## 5. Entidad Usuario

```java
@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(nullable = false)
    private String password;  // Nunca se guarda en texto plano

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
```

### Detalles importantes

| Campo | Restricción | Por qué |
|-------|-------------|---------|
| `username` | `unique = true` | No pueden existir dos usuarios con el mismo nombre |
| `password` | Sin `length` | Los hashes BCrypt son largos (~60 caracteres) |
| `role` | `@Enumerated(STRING)` | Guarda el nombre del enum como String, no como número |

---

# PARTE D: SERVICIO DE SEGURIDAD

## 6. JwtService — Generación y Validación de Tokens

```java
@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    // Decodifica la clave secreta
    private SecretKey getSigningKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    // Genera un token JWT para un usuario
    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + jwtExpiration))
                .signWith(getSigningKey())
                .compact();
    }

    // Extrae el username del token
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    // Verifica si el token es válido
    public boolean isTokenValid(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return extractedUsername.equals(username) && !isTokenExpired(token);
    }
}
```

### Configuración del JWT

```yaml
# application-dev.yml
jwt:
  secret: "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970"
  expiration: 86400000    # 24 horas en milisegundos
```

---

## 7. UserDetailServiceImpl — Carga de usuarios

Spring Security necesita un servicio que le dé información del usuario cuando alguien hace login:

```java
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(usuario.getRole().name()));

        return new User(usuario.getUsername(), usuario.getPassword(), authorities);
    }
}
```

**¿Qué hace?** Cuando alguien intenta hacer login, Spring Security llama a este método para:
1. Buscar el usuario en la BD
2. Devolver sus credenciales y roles

---

# PARTE E: FILTRO JWT

## 8. JwtAuthenticationFilter

Este filtro se ejecuta **antes de cada petición** para verificar si el token es válido:

```java
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtService jwtService;
    private final UsuarioRepository usuarioRepository;

    public JwtAuthenticationFilter(JwtService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        // Paso 1: Obtener el header Authorization
        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response);  // No hay token, continuar
            return;
        }

        // Paso 2: Extraer el token
        final String jwt = authHeader.substring(7);

        // Paso 3: Extraer el username del token
        final String userEmail = jwtService.extractUsername(jwt);

        // Paso 4: Si hay username y no hay autenticación previa
        if (userEmail != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            Usuario usuario = usuarioRepository.findByUsername(userEmail).orElse(null);

            // Paso 5: Validar el token
            if (usuario != null && jwtService.isTokenValid(jwt, usuario.getUsername())) {
                UsernamePasswordAuthenticationToken authToken =
                    new UsernamePasswordAuthenticationToken(
                        usuario,
                        null,
                        List.of(new SimpleGrantedAuthority(usuario.getRole().name()))
                    );
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }

        filterChain.doFilter(request, response);
    }
}
```

### Flujo del filtro

```
Petición HTTP
    │
    ▼
¿Tiene header "Authorization: Bearer xxx"?
    │
    ├── NO → Continuar sin autenticación
    │
    └── SÍ → Extraer token
              │
              ▼
         ¿El token es válido?
              │
              ├── NO → Error 401 Unauthorized
              │
              └── SÍ → Buscar usuario en BD
                        │
                        ▼
                   ¿El usuario existe?
                        │
                        ├── NO → Error 401
                        │
                        └── SÍ → Establecer autenticación en SecurityContext
                                  │
                                  ▼
                             Continuar con la petición
```

---

# PARTE F: CONFIGURACIÓN DE SEGURIDAD

## 9. SecurityConfig

```java
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())              // API REST no necesita CSRF
            .cors(cors -> cors.configurationSource(...)) // Configurar CORS
            .formLogin(form -> form.disable())          // API REST no usa formularios
            .httpBasic(htt -> htt.disable())            // Usamos JWT, no Basic Auth
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/auth/**").permitAll()    // Login y registro: público
                .requestMatchers("/api/libros/**").permitAll()  // Libros: público
                .requestMatchers("/api/autores/**").permitAll() // Autores: público
                .anyRequest().authenticated()                   // Todo lo demás: autenticado
            )
            .sessionManagement(session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // Sin sesiones
            )
            .exceptionHandling(exception -> exception
                .authenticationEntryPoint(...)    // Error 401
                .accessDeniedHandler(...)         // Error 403
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
```

### Decisiones clave

| Decisión | Por qué |
|----------|---------|
| `csrf.disable()` | Las APIs REST son stateless, no necesitan CSRF |
| `formLogin.disable()` | Usamos JWT, no formularios de login |
| `SessionCreationPolicy.STATELESS` | El token se valida en cada petición, no hay sesión en servidor |
| `permitAll()` en `/api/auth/**` | Login y registro deben ser accesibles sin token |
| `BCryptPasswordEncoder` | Algoritmo de hashing estándar para contraseñas |

---

# PARTE G: ENDPOINTS DE AUTENTICACIÓN

## 10. AuthController

```java
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UsuarioService usuarioService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthController(UsuarioService usuarioService, JwtService jwtService,
                          AuthenticationManager authenticationManager) {
        this.usuarioService = usuarioService;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    // Registro
    @PostMapping("/register")
    public ResponseEntity<UsuarioDTO> register(@Valid @RequestBody UsuarioCreateDTO dto) {
        return ResponseEntity.ok(usuarioService.register(dto));
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid @RequestBody LoginDTO dto) {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new CredencialesInvalidasException("Credenciales inválidas");
        }

        String token = jwtService.generateToken(dto.getUsername());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
```

## 11. UsuarioService — Registro con BCrypt

```java
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UsuarioDTO register(UsuarioCreateDTO dto) {
        // Verificar duplicados
        if (usuarioRepository.existsByUsername(dto.getUsername())) {
            throw new UsuarioDuplicadoException("El nombre de usuario ya existe");
        }
        if (usuarioRepository.existsByEmail(dto.getEmail())) {
            throw new UsuarioDuplicadoException("El email ya está registrado");
        }

        // Crear usuario con contraseña cifrada
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));  // BCrypt
        usuario.setEmail(dto.getEmail());
        usuario.setRole(Role.ROLE_USER);  // Por defecto, usuario normal

        Usuario saved = usuarioRepository.save(usuario);
        return toDTO(saved);
    }
}
```

### ¿Por qué BCrypt?

| Algoritmo | Seguridad |
|-----------|-----------|
| MD5 | ❌ Obsoleto, vulnerable |
| SHA-256 | ⚠️ Sin sal, vulnerable a rainbow tables |
| **BCrypt** | ✅ Incluye sal, lento a propósito (resistente a fuerza bruta) |

---

# PARTE H: FLUJO COMPLETO

## 12. Flujo de Login

```
1. POST /api/auth/login
   Body: {"username": "admin", "password": "password123"}

2. AuthenticationManager.authenticate()
   → UserDetailServiceImpl.loadUserByUsername("admin")
   → Busca usuario en BD
   → BCrypt verifica la contraseña

3. Si es válido:
   → JwtService.generateToken("admin")
   → Devuelve: {"token": "eyJhbGci..."} (200 OK)

4. Si no es válido:
   → CredencialesInvalidasException
   → Devuelve: {"message": "Credenciales inválidas"} (401)
```

## 13. Flujo de Petición Autenticada

```
1. GET /api/prestamos
   Header: Authorization: Bearer eyJhbGci...

2. JwtAuthenticationFilter.doFilterInternal()
   → Extrae el token del header
   → Extrae el username del token
   → Valida el token con JwtService
   → Establece la autenticación en SecurityContext

3. SecurityFilterChain
   → Verifica que el endpoint requiere autenticación
   → El usuario ya está autenticado → Permite el acceso

4. PrestamoController.findAll()
   → Retorna la lista de préstamos (200 OK)
```

---

# PARTE I: EXCEPCIONES DE SEGURIDAD

## 14. Excepciones personalizadas

```java
// Credenciales incorrectas
public class CredencialesInvalidasException extends RuntimeException {
    public CredencialesInvalidasException(String message) {
        super(message);
    }
}

// Usuario duplicado
public class UsuarioDuplicadoException extends RuntimeException {
    public UsuarioDuplicadoException(String message) {
        super(message);
    }
}
```

## 15. Manejo en GlobalExceptionHandler

```java
@ExceptionHandler(CredencialesInvalidasException.class)
public ResponseEntity<ErrorResponse> handleCredencialesInvalidas(
        CredencialesInvalidasException ex, HttpServletRequest request) {
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
        .body(crearErrorResponse(401, "Unauthorized", ex.getMessage(), request.getRequestURI()));
}

@ExceptionHandler(UsuarioDuplicadoException.class)
public ResponseEntity<ErrorResponse> handleUsuarioDuplicado(
        UsuarioDuplicadoException ex, HttpServletRequest request) {
    return ResponseEntity.badRequest()
        .body(crearErrorResponse(400, "Bad Request", ex.getMessage(), request.getRequestURI()));
}
```

---

# PARTE J: ENDPOINTS FINALES

## 16. Endpoints de la API con seguridad

| Método | URL | Descripción | Acceso |
|--------|-----|-------------|--------|
| `POST` | `/api/auth/register` | Registrar usuario nuevo | **Público** |
| `POST` | `/api/auth/login` | Login y obtener token | **Público** |
| `GET` | `/api/autores` | Listar autores | **Público** |
| `GET` | `/api/autores/{id}` | Obtener autor | **Público** |
| `POST` | `/api/autores` | Crear autor | **Admin** |
| `GET` | `/api/libros` | Listar libros | **Público** |
| `GET` | `/api/libros/{id}` | Obtener libro | **Público** |
| `POST` | `/api/libros` | Crear libro | **Público** |
| `GET` | `/api/prestamos` | Listar préstamos | **Autenticado** |
| `POST` | `/api/prestamos` | Crear préstamo | **Autenticado** |
| `PUT` | `/api/prestamos/{id}/devolver` | Devolver libro | **Autenticado** |

---

## 17. Datos de prueba

```sql
-- Usuarios de prueba (contraseña: "password123")
INSERT INTO usuarios (id, username, password, email, role)
VALUES (gen_random_uuid(), 'admin', '$2a$10$...', 'admin@biblioteca.com', 'ROLE_ADMIN');

INSERT INTO usuarios (id, username, password, email, role)
VALUES (gen_random_uuid(), 'usuario', '$2a$10$...', 'usuario@biblioteca.com', 'ROLE_USER');
```

**Nota:** El hash `$2a$10$...` es `password123` cifrado con BCrypt.

---

## 18. Resumen de la Fase 5

| Concepto | Qué aprendimos |
|----------|----------------|
| Spring Security | Framework de seguridad de Spring |
| JWT | Tokens stateless para autenticación |
| BCrypt | Hashing seguro de contraseñas |
| Roles | `ROLE_USER` y `ROLE_ADMIN` con Enum |
| Filtros JWT | `JwtAuthenticationFilter` para validar tokens en cada petición |
| SecurityConfig | Configurar endpoints públicos vs protegidos |
| AuthenticationManager | Gestión centralizada de autenticación |
| UserDetailsService | Carga de usuarios para Spring Security |
| DTOs de seguridad | `LoginDTO`, `UsuarioCreateDTO`, `LoginResponseDTO` |
| Excepciones | `CredencialesInvalidasException`, `UsuarioDuplicadoException` |
| Estado sin sesiones | `STATELESS` — el token se valida en cada petición |

---

*Documento de teoría — Fase 5 del curso de Spring Boot*
