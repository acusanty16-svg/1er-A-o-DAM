package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.LibroCreateDTO;
import Biblioteca.ejercicio2.DTO.LibroDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.exception.LibroNotFoundException;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import Biblioteca.ejercicio2.service.JwtService;
import Biblioteca.ejercicio2.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = LibroController.class, excludeAutoConfiguration = {
        org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration.class
})
@AutoConfigureMockMvc(addFilters = false)

public class LibroControllerTest {
    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private LibroService libroService;

    @Autowired
    private final JsonMapper objectMapper = JsonMapper.builder().build();

    @Test
    void findAll_deberiaRetornarOk() throws Exception{
        UUID libro1id = UUID.randomUUID();
        UUID libro2id = UUID.randomUUID();

        LibroDTO libro1 = new LibroDTO(libro1id,"El Cuervo",19.99,false,UUID.randomUUID(), "Edgar A. Poe");
        LibroDTO libro2 = new LibroDTO(libro2id,"Rayuela",15.99,false,UUID.randomUUID(), "Cortázar");

    when(libroService.findAll()).thenReturn(List.of(libro1,libro2));

    mockMvc.perform(get("/api/libros"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].autorNombre").value("Edgar A. Poe"))
                .andExpect(jsonPath("$[1].autorNombre").value("Cortázar"));
    }

    @Test
    void findById_deberiaRetornarOk() throws Exception {
        UUID id = UUID.randomUUID();
        LibroDTO libro = new LibroDTO(id,"Rayuela",15.99,false,UUID.randomUUID(),"Cortázar");

        when(libroService.findById(id)).thenReturn(libro);

        mockMvc.perform(get("/api/libros/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.autorNombre").value("Cortázar"))
                .andExpect(jsonPath("$.id").value(id.toString()));
    }

    @Test
    void findById_deberiaRetornar404() throws Exception{
        UUID id = UUID.randomUUID();

        when(libroService.findById(id)).thenThrow(new LibroNotFoundException(id));

        mockMvc.perform(get("/api/libros/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    void create_deberiaRetornar201() throws Exception{
        LibroCreateDTO dto = new LibroCreateDTO("Berenice",19.99,UUID.randomUUID());
        LibroDTO libroCreado = new LibroDTO(UUID.randomUUID(),"Berenice",19.99,false,dto.getAutorId(),"Edgar A. Poe");

        when(libroService.create(dto)).thenReturn(libroCreado);

        mockMvc.perform(post("/api/libros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.titulo").value("Berenice"));
    }

    @Test
    void create_deberiaRetonar400_dtoInvalido() throws Exception{
        String body = "{}";

        mockMvc.perform(post("/api/libros")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isBadRequest());
    }

    @Test
    void create_deberiaRetonar400_precioInvalido() throws Exception{
        String body = "{\"titulo\":\"Test\",\"precio\":-5,\"autorId\":\"" + UUID.randomUUID() + "\"}";

        mockMvc.perform(post("/api/libros")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isBadRequest());

    }
}
