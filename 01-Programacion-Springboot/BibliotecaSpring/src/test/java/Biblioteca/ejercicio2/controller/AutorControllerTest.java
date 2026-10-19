package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.AutorCreateDTO;
import Biblioteca.ejercicio2.DTO.AutorDTO;
import Biblioteca.ejercicio2.exception.AutorNotFoundException;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import Biblioteca.ejercicio2.service.AutorService;
import Biblioteca.ejercicio2.service.JwtService;
import tools.jackson.databind.json.JsonMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.UUID;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(value = AutorController.class, excludeAutoConfiguration = {
        org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration.class
})
@AutoConfigureMockMvc(addFilters = false)

public class AutorControllerTest {

    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private AutorService autorService;

    @Autowired
    private final JsonMapper objectMapper = JsonMapper.builder().build();

    @Test
    void findAll_deberiaRetornarOk() throws Exception{
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        AutorDTO autor1 = new AutorDTO(id1, "García Márquez");
        AutorDTO autor2 = new AutorDTO(id2, "Cortázar");

        when(autorService.findAll()).thenReturn(List.of(autor1,autor2));

        mockMvc.perform(get("/api/autores"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                        .andExpect(jsonPath("$[0].nombre").value("García Márquez"))
                        .andExpect(jsonPath("$[1].nombre").value("Cortázar"));

    }

    @Test
    void findById_deberiaRetornarOk() throws Exception{
        UUID id = UUID.randomUUID();
        AutorDTO autor = new AutorDTO(id, "Vargas Llosa");

        when(autorService.findById(id)).thenReturn(autor);

        mockMvc.perform(get("/api/autores/" + id))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nombre").value("Vargas Llosa"))
                .andExpect(jsonPath("$.id").value(id.toString()));
    }

    @Test
    void findById_deberiaRetornar404() throws Exception{
        UUID id = UUID.randomUUID();
        when(autorService.findById(id)).thenThrow(new AutorNotFoundException(id));

        mockMvc.perform(get("/api/autores/" + id))
                .andExpect(status().isNotFound());
    }

    @Test
    void create_deberiaRetornar201() throws Exception{
        AutorCreateDTO dto = new AutorCreateDTO("Pablo Neruda");
        AutorDTO autorCreado = new AutorDTO(UUID.randomUUID(), "Pablo Neruda");

        when(autorService.create(dto)).thenReturn(autorCreado);

        mockMvc.perform(post("/api/autores")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nombre").value("Pablo Neruda"));
    }
}
