package Biblioteca.ejercicio2.integration;

import Biblioteca.ejercicio2.DTO.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.resttestclient.TestRestTemplate;
import org.springframework.boot.resttestclient.autoconfigure.AutoConfigureTestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureTestRestTemplate
@ActiveProfiles("testcontainers")
public class BibliotecaIntegrationTest {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void contexto_cargaConPostgres(){
        assertNotNull(jdbcTemplate.getDataSource());
        Integer uno = jdbcTemplate.queryForObject("SELECT 1",Integer.class);
        assertEquals(1,uno);
        System.out.println("PostgreSQL REAL conectado");
    }

    @Test
    void flujo_crearAutorYLibro(){
        ResponseEntity<AutorDTO> autorRes =
                restTemplate.postForEntity("/api/autores", new AutorCreateDTO("Julio Verne"),
                        AutorDTO.class);
        assertEquals(HttpStatus.CREATED, autorRes.getStatusCode());
        UUID autorId = autorRes.getBody().getId();

        ResponseEntity<LibroDTO> libroRes =
                restTemplate.postForEntity("/api/libros", new LibroCreateDTO("Veinte mil leguas"
                ,29.99,autorId), LibroDTO.class);
        assertEquals(HttpStatus.CREATED, libroRes.getStatusCode());
        assertEquals("Veinte mil leguas", libroRes.getBody().getTitulo());
        assertEquals("Julio Verne", libroRes.getBody().getAutorNombre());
    }

    @Test
    void registroLogin_flujoCompleto(){
        ResponseEntity<UsuarioDTO> usuarioRes =
                restTemplate.postForEntity("/api/auth/register", new UsuarioCreateDTO("santi"
                ,"pass123","santi@email.com"), UsuarioDTO.class);
        assertEquals(HttpStatus.OK, usuarioRes.getStatusCode());
        assertEquals("santi", usuarioRes.getBody().getUsername());

        ResponseEntity<LoginResponseDTO> loginRes =
                restTemplate.postForEntity("/api/auth/login", new LoginDTO("santi","pass123")
                , LoginResponseDTO.class);

        assertEquals(HttpStatus.OK, loginRes.getStatusCode());
        assertNotNull(loginRes.getBody().getToken());
        assertFalse(loginRes.getBody().getToken().isBlank());

    }

    @Test
    void prestamo_conToken_Y_Devolucion(){
        ResponseEntity<UsuarioDTO> usuarioRes =
                restTemplate.postForEntity("/api/auth/register", new UsuarioCreateDTO("ana"
                        ,"pass123","ana@email.com"), UsuarioDTO.class);
        assertEquals(HttpStatus.OK, usuarioRes.getStatusCode());
        assertEquals("ana", usuarioRes.getBody().getUsername());

        ResponseEntity<LoginResponseDTO> loginRes =
                restTemplate.postForEntity("/api/auth/login", new LoginDTO("ana","pass123")
                        , LoginResponseDTO.class);

        assertEquals(HttpStatus.OK, loginRes.getStatusCode());
        assertNotNull(loginRes.getBody().getToken());
        assertFalse(loginRes.getBody().getToken().isBlank());

        ResponseEntity<AutorDTO> autorRes =
                restTemplate.postForEntity("/api/autores", new AutorCreateDTO("Isaac Asimov"),
                        AutorDTO.class);
        assertEquals(HttpStatus.CREATED, autorRes.getStatusCode());
        UUID autorId = autorRes.getBody().getId();

        ResponseEntity<LibroDTO> libroRes =
                restTemplate.postForEntity("/api/libros", new LibroCreateDTO("Fundacion"
                        ,29.99,autorId), LibroDTO.class);
        assertEquals(HttpStatus.CREATED, libroRes.getStatusCode());
        assertEquals("Fundacion", libroRes.getBody().getTitulo());
        assertEquals("Isaac Asimov", libroRes.getBody().getAutorNombre());

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(loginRes.getBody().getToken());
        HttpEntity<PrestamoCreateDTO> entity = new HttpEntity<>(new PrestamoCreateDTO
                (libroRes.getBody().getId(), "ana"), headers);

        ResponseEntity<PrestamosDTO> prestamosRes =
                restTemplate.exchange("/api/prestamos",HttpMethod.POST,entity,PrestamosDTO.class);
        assertEquals(HttpStatus.CREATED, prestamosRes.getStatusCode());
        assertEquals("Fundacion", prestamosRes.getBody().getLibroTitulo());

       HttpEntity<Void> putEntity = new HttpEntity<>(headers);
       ResponseEntity<Void> devoluciones =
               restTemplate.exchange("/api/prestamos/" + prestamosRes.getBody().getId()
               + "/devolver",HttpMethod.PUT,putEntity, Void.class);
                assertEquals(HttpStatus.NO_CONTENT, devoluciones.getStatusCode());

    }

    @Test
    void prestamo_sinToken_deberiaRetornar401(){
        ResponseEntity<PrestamosDTO> prestamosRes =
                restTemplate.postForEntity("/api/prestamos", new PrestamoCreateDTO(UUID.randomUUID()
                ,"ana"), PrestamosDTO.class);
        assertEquals(HttpStatus.UNAUTHORIZED, prestamosRes.getStatusCode());
    }
}
