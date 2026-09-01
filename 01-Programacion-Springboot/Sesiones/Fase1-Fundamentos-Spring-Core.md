# Fase 1 — Fundamentos de Spring Core

**Sesiones 2-3** | Duración estimada: 45-60 minutos

---

## 🎯 Objetivo de esta fase

Entender cómo funciona Spring por dentro: el contenedor IoC, la inyección de dependencias, los beans y los estereotipos. Todo con ejemplos reales y código que escribiremos juntos.

---

## 1. IoC Container (Contenedor de Inversión de Control)

### ¿Qué es?

Imagina que tienes una fábrica. En vez de que tú crees manualmente cada pieza (objetos), **la fábrica las crea por ti y te las entrega cuando las necesitas**. Eso es el IoC Container de Spring.

**En palabras técnicas:** El IoC Container es el corazón de Spring. Se encarga de:
1. **Crear** los objetos (llamados "beans")
2. **Inyectar** las dependencias que necesitan
3. **Gestionar** el ciclo de vida completo de cada bean

### Ejemplo sin Spring (lo que haríamos a mano):

```java
// Tú creas todo manualmente
ServicioEmail servicioEmail = new ServicioEmail();
ServicioUsuario servicioUsuario = new ServicioUsuario(servicioEmail);
ControladorUsuario controlador = new ControladorUsuario(servicioUsuario);
```

**Problema:** Si cambias `ServicioEmail` por otra implementación, tienes que modificar todas las clases donde la usas.

### Ejemplo con Spring (el contenedor lo hace por ti):

```java
// Spring crea los objetos y los conecta automáticamente
@Autowired
private ServicioUsuario servicioUsuario;
```

**Ventaja:** Spring decide qué implementación usar. Si cambias algo, solo modifies una configuración.

### Analogía de la vida real 🏠

Piensa en un restaurante:
- **Sin IoC:** Tú cocinas, lavas platos, sirves, cobras... (haces todo)
- **Con IoC:** Hay un cocinero (crea platos), un mesero (sirve), un cajero (cobra). Cada uno hace su trabajo y el gerente (IoC Container) coordina todo.

---

## 2. Dependency Injection (Inyección de Dependencias)

### ¿Qué problema resuelve?

Imagina esta situación:

```java
public class PedidoService {
    // ❌ MAL: Creas la dependencia tú mismo
    private BaseDatosRepository repository = new BaseDatosRepository();
}
```

**Problemas:**
- **Acoplamiento fuerte:** `PedidoService` depende directamente de `BaseDatosRepository`
- **Difícil de testear:** ¿Cómo pruebas sin una base de datos real?
- **Difícil de cambiar:** Si cambias a MongoDB, tienes que modificar `PedidoService`

### La solución: Inyección por Constructor (Constructor Injection)

```java
// ✅ BIEN: La dependencia viene de fuera
public class PedidoService {
    private final BaseDatosRepository repository;
    
    // Spring llama a este constructor y te pasa lo que necesitas
    public PedidoService(BaseDatosRepository repository) {
        this.repository = repository;
    }
}
```

**¿Por qué constructor injection?**
1. **Inmutabilidad:** El `final` garantiza que no cambia después de creado
2. **Testing:** Puedes pasar un mock fácilmente: `new PedidoService(mockRepository)`
3. **Claridad:** Se ve exactamente qué necesita la clase para funcionar

### Analogía 📦

Piensa en una caja de herramientas:
- **Sin DI:** Tú buscas cada herramienta (taladro, martillo, destornillador) y las juntas
- **Con DI:** Alguien te da una caja con todas las herramientas que necesitas para ese trabajo

---

## 3. Beans y Estereotipos

### ¿Qué es un Bean?

Un **bean** es simplemente un objeto que Spring crea y gestiona. Cuando anotas una clase con `@Service`, `@Component`, etc., estás diciendo: "Hola Spring, crea instancias de esta clase y cuídalas".

### Los 4 estereotipos principales

| Anotación | Para qué se usa | Ejemplo |
|-----------|-----------------|---------|
| `@Component` | Componente genérico (no específica capa) | `ContadorVisitas`, `Utilidades` |
| `@Service` | Lógica de negocio | `PedidoService`, `UsuarioService` |
| `@Repository` | Acceso a datos (bases de datos) | `PedidoRepository`, `UsuarioRepository` |
| `@Controller` / `@RestController` | Capa web (endpoints REST) | `PedidoController`, `UsuarioController` |

### Ejemplos reales

```java
// @Service - Lógica de negocio
@Service
public class PedidoService {
    private final PedidoRepository repository;
    
    public PedidoService(PedidoRepository repository) {
        this.repository = repository;
    }
    
    public Pedido crearPedido(PedidoDTO dto) {
        // Aquí va la lógica: validar, calcular, guardar...
        return repository.save(pedido);
    }
}

// @Repository - Acceso a datos
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByEstado(String estado);
}

// @RestController - Endpoints web
@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {
    private final PedidoService pedidoService;
    
    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }
    
    @GetMapping("/{id}")
    public PedidoDTO obtenerPedido(@PathVariable Long id) {
        return pedidoService.obtenerPorId(id);
    }
}
```

### ¿Por qué importa la distinción?

A nivel técnico funcionan igual, pero **en proyectos reales** ayuda a:
- **Organizar el código:** Sabes rápido dónde está cada cosa
- **Legibilidad:** Otros desarrolladores entienden la arquitectura
- **Futuro:** Spring podría añadir comportamientos específicos por estereotipo

---

## 4. Autoconfiguration (Configuración Automática)

### ¿Qué es?

La **autoconfiguración** es la magia de Spring Boot. Cuando añades una dependencia al `pom.xml`, Spring Boot **configura automáticamente** todo lo necesario para que funcione.

### Ejemplo real

Cuando añades `spring-boot-starter-web`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

Spring Boot automáticamente:
1. ✅ Detecta que quieres hacer una app web
2. ✅ Configura Tomcat (servidor web) en el puerto 8080
3. ✅ Configura Spring MVC para manejar peticiones HTTP
4. ✅ Configura un `ObjectMapper` para JSON
5. ✅ Configura manejadores de errores

**Tú no configuras nada.** Solo añades la dependencia y funciona.

### ¿Cómo funciona por dentro?

Spring Boot analiza las clases que tienes en el classpath (todas las dependencias) y decide qué configurar:

```
¿Tienes spring-boot-starter-web?
    → SÍ: Configura Tomcat + Spring MVC
    
¿Tienes spring-boot-starter-data-jpa?
    → SÍ: Configura DataSource + EntityManager + Repositorios

¿Tienes spring-boot-starter-security?
    → SÍ: Configura seguridad básica (login por defecto)
```

### Analogía 🚗

Piensa en un coche con park assist:
- **Sin autoconfig:** Tú tienes que estacionar manualmente (configurar servidor, puerto, etc.)
- **Con autoconfig:** El coche estaciona solo (solo dices "quiero web" y Spring Boot hace el resto)

---

## 5. Spring Boot Starters

### ¿Qué son?

Los **starters** son paquetes de dependencias que traen todo lo necesario para un propósito específico. Son como "kits" preconfigurados.

### Starter más usados

| Starter | Para qué sirve | Qué incluye |
|---------|----------------|-------------|
| `spring-boot-starter-web` | APIs REST / Web | Tomcat, Spring MVC, Jackson (JSON) |
| `spring-boot-starter-data-jpa` | Base de datos JPA | Hibernate, Spring Data JPA, HikariCP |
| `spring-boot-starter-security` | Seguridad | Spring Security, BCrypt |
| `spring-boot-starter-test` | Testing | JUnit 5, Mockito, AssertJ |
| `spring-boot-starter-validation` | Validación | Bean Validation, Hibernate Validator |

### Ejemplo en tu proyecto

Tu `pom.xml` actual tiene:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-webmvc</artifactId>
</dependency>
```

Esto trae:
- ✅ Tomcat (servidor web embebido)
- ✅ Spring MVC (para manejar peticiones HTTP)
- ✅ Jackson (para convertir Java a JSON y viceversa)
- ✅ Logback (para logging)

**En una sola línea, tienes todo lo necesario para una API web.**

### ¿Por qué no usar dependencias individuales?

Sin starters tendrías que añadir:

```xml
<!-- Sin starter: ~10 dependencias manuales -->
<dependency>spring-web</dependency>
<dependency>spring-webmvc</dependency>
<dependency>spring-core</dependency>
<dependency>spring-beans</dependency>
<dependency>jackson-databind</dependency>
<dependency>jackson-core</dependency>
<dependency>tomcat-embed-core</dependency>
<dependency>tomcat-embed-el</dependency>
<!-- ... y más -->
```

Con starter: **1 dependencia** y todo funciona.

---

## 6. Resumen visual

```
┌─────────────────────────────────────────────────────────────┐
│                    SPRING BOOT APP                          │
├─────────────────────────────────────────────────────────────┤
│                                                             │
│  ┌─────────────┐    ┌─────────────┐    ┌─────────────┐     │
│  │ @Controller │───▶│  @Service   │───▶│ @Repository │     │
│  │  (Web/API)  │    │ (Negocio)   │    │   (Datos)   │     │
│  └─────────────┘    └─────────────┘    └─────────────┘     │
│         │                  │                  │             │
│         └──────────────────┼──────────────────┘             │
│                            │                                │
│                   ┌────────▼────────┐                       │
│                   │  IoC Container  │                       │
│                   │   (Spring Core) │                       │
│                   └─────────────────┘                       │
│                            │                                │
│                   ┌────────▼────────┐                       │
│                   │   Autoconfig    │                       │
│                   │  (Starters)     │                       │
│                   └─────────────────┘                       │
│                                                             │
└─────────────────────────────────────────────────────────────┘
```

---

## 7. Puntos clave para recordar

| Concepto | Regla de oro |
|----------|--------------|
| **IoC Container** | Spring crea y gestiona los objetos por ti |
| **Constructor Injection** | Siempre inyectar por constructor, nunca por campo |
| **`final`** | Las dependencias deben ser `private final` |
| **Estereotipos** | Usar `@Service` para negocio, `@Repository` para datos |
| **Autoconfiguration** | No configures lo que Spring Boot configura automáticamente |
| **Starters** | Usa starters en vez de dependencias individuales |

---

## 8. Errores comunes

### ❌ No hacer esto:

```java
// MAL: Inyección por campo (no es inmutable, difícil de testear)
@Service
public class MiServicio {
    @Autowired
    private MiRepositorio repositorio;
}

// MAL: Crear instancias manualmente
@Service
public class MiServicio {
    private MiRepositorio repositorio = new MiRepositorio(); // ¡NO!
}
```

### ✅ Hacer esto:

```java
// BIEN: Inyección por constructor (inmutable, testeable)
@Service
public class MiServicio {
    private final MiRepositorio repositorio;
    
    public MiServicio(MiRepositorio repositorio) {
        this.repositorio = repositorio;
    }
}

// BIEN: Con Lombok (si lo usas)
@Service
@RequiredArgsConstructor
public class MiServicio {
    private final MiRepositorio repositorio;
}
```

---

## 9. Ejercicio práctico (Tarea)

### Objetivo:
Crear un servicio y un componente para practicar lo aprendido.

### Paso 1: Crear `SaludoService.java`

```java
package com.example.ejercicio1_hola_mundo.service;

import org.springframework.stereotype.Service;

@Service
public class SaludoService {
    
    public String generarSaludo(String nombre) {
        if (nombre == null || nombre.isBlank()) {
            return "¡Hola, Mundo!";
        }
        return "¡Hola, " + nombre + "! Bienvenido a Spring Boot";
    }
}
```

### Paso 2: Crear `ContadorVisitas.java`

```java
package com.example.ejercicio1_hola_mundo.component;

import org.springframework.stereotype.Component;

@Component
public class ContadorVisitas {
    private int visitas = 0;
    
    public int incrementar() {
        return ++visitas;
    }
    
    public int getVisitas() {
        return visitas;
    }
}
```

### Paso 3: Modificar `HolaController.java`

```java
package com.example.ejercicio1_hola_mundo;

import com.example.ejercicio1_hola_mundo.service.SaludoService;
import com.example.ejercicio1_hola_mundo.component.ContadorVisitas;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HolaController {
    
    private final SaludoService saludoService;
    private final ContadorVisitas contadorVisitas;
    
    // Constructor injection - Spring inyecta automáticamente
    public HolaController(SaludoService saludoService, ContadorVisitas contadorVisitas) {
        this.saludoService = saludoService;
        this.contadorVisitas = contadorVisitas;
    }
    
    @GetMapping("/")
    public String hola() {
        int totalVisitas = contadorVisitas.incrementar();
        return saludoService.generarSaludo(null) + " | Visitas: " + totalVisitas;
    }
    
    @GetMapping("/saludo")
    public String saludo(@RequestParam String nombre) {
        int totalVisitas = contadorVisitas.incrementar();
        return saludoService.generarSaludo(nombre) + " | Visitas: " + totalVisitas;
    }
}
```

### Resultado esperado:
- `GET /` → `¡Hola, Mundo! Bienvenido a Spring Boot | Visitas: 1`
- `GET /saludo?nombre=Carlos` → `¡Hola, Carlos! Bienvenido a Spring Boot | Visitas: 2`

---

## 10. Siguiente paso

En la **Fase 2** aprenderemos:
- HTTP: métodos, códigos de estado, APIs REST
- `@RestController` a fondo
- DTOs: por qué no exponer entidades directamente
- Validación con Bean Validation
- Manejo de errores con `@ControllerAdvice`

---

*Documento de teoría — Fase 1 del curso de Spring Boot*
