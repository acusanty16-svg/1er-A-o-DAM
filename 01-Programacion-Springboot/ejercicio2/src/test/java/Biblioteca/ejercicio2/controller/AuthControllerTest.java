package Biblioteca.ejercicio2.controller;

import Biblioteca.ejercicio2.DTO.LoginDTO;
import Biblioteca.ejercicio2.DTO.UsuarioCreateDTO;
import Biblioteca.ejercicio2.DTO.UsuarioDTO;
import Biblioteca.ejercicio2.exception.UsuarioDuplicadoException;
import Biblioteca.ejercicio2.model.Role;
import Biblioteca.ejercicio2.model.Usuario;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import Biblioteca.ejercicio2.service.JwtService;
import Biblioteca.ejercicio2.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.test.web.servlet.MockMvc;
import tools.jackson.databind.json.JsonMapper;

import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(value = AuthController.class, excludeAutoConfiguration = {
        org.springframework.boot.security.autoconfigure.SecurityAutoConfiguration.class
})
@AutoConfigureMockMvc(addFilters = false)
public class AuthControllerTest {

    @Autowired private MockMvc mockMvc;

    @MockitoBean
    private UsuarioService usuarioService;

    @MockitoBean
    private JwtService jwtService;

    @MockitoBean
    private AuthenticationManager authenticationManager;

    @MockitoBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private final JsonMapper objectMapper = JsonMapper.builder().build();

    @Test
    void register_deberiaRetornarOk() throws Exception {
        UsuarioCreateDTO dto = new UsuarioCreateDTO("santi","pass123","santi@email.com");
        UsuarioDTO usuarioDTO = new UsuarioDTO(UUID.randomUUID(),"santi","santi@email.com",Role.ROLE_USER);

        when(usuarioService.register(dto)).thenReturn(usuarioDTO);

        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.username").value("santi"))
                .andExpect(jsonPath("$.email").value("santi@email.com"))
                .andExpect(jsonPath("$.role").value("ROLE_USER"));
    }

    @Test
    void register_deberiaRetonar400_dtoInvalido() throws Exception{
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}")).andExpect(status().isBadRequest());
    }

    @Test
    void register_deberiaRetornar400_usuarioDuplicado() throws Exception{
        UsuarioCreateDTO dto = new UsuarioCreateDTO("santi","pass123","santi@email.com");

        when(usuarioService.register(dto)).thenThrow(new UsuarioDuplicadoException("El usuario ya existe"));
        mockMvc.perform(post("/api/auth/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void login_deberiaRetornarOk() throws Exception{
        LoginDTO dto = new LoginDTO("santi","pass123");

        when(authenticationManager.authenticate(any())).thenReturn(null);
        when(jwtService.generateToken("santi")).thenReturn("token123");

        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.token").value("token123"));
    }

    @Test
    void login_deberiaRetornar401_credencialesInvalidas() throws Exception{
        LoginDTO dto = new LoginDTO("fantasma","malpass");

        when(authenticationManager.authenticate(any())).thenThrow(new BadCredentialsException("bad"));

        mockMvc.perform(post("/api/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isUnauthorized());
    }

    @Test
    void login_deberiaRetornar400_dtoInvalido() throws Exception{
        mockMvc.perform(post("/api/auth/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{}"))
                .andExpect(status().isBadRequest());
    }
}
