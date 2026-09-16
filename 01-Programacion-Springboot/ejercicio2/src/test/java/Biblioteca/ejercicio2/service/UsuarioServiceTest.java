package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.UsuarioCreateDTO;
import Biblioteca.ejercicio2.DTO.UsuarioDTO;
import Biblioteca.ejercicio2.exception.UsuarioDuplicadoException;
import Biblioteca.ejercicio2.model.Role;
import Biblioteca.ejercicio2.model.Usuario;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith({MockitoExtension.class})
class UsuarioServiceTest {
    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UsuarioService usuarioService;

    @Test
    void register_deberiaGuardarUsuarioConPasswordHasheado(){
        //ARRANGE
        UsuarioCreateDTO dto = new UsuarioCreateDTO("juan","password123","juan@email.com");

        when(usuarioRepository.existsByUsername("juan")).thenReturn(false);
        when(usuarioRepository.existsByEmail("juan@email.com")).thenReturn(false);
        when(passwordEncoder.encode("password123")).thenReturn("$2a$10$hashedPassword");

        //ArgumentCaptor para capturar el Usuario que se pasa a save()
        ArgumentCaptor<Usuario> usuarioCaptor = ArgumentCaptor.forClass(Usuario.class);
        when(usuarioRepository.save(any(Usuario.class))).thenAnswer(inv -> inv.getArgument(0));

        //ACT
        UsuarioDTO resultado = usuarioService.register(dto);

        //ASSERT
        assertNotNull(resultado);
        assertEquals("juan", resultado.getUsername());
        assertEquals("juan@email.com", resultado.getEmail());
        assertEquals(Role.ROLE_USER, resultado.getRole());

        //VERIFY
        verify(passwordEncoder).encode("password123");

        //VERIFY
        verify(usuarioRepository).save(usuarioCaptor.capture());
        verify(usuarioRepository).existsByUsername("juan");
        verify(usuarioRepository).existsByEmail("juan@email.com");
        Usuario usuarioGuardado = usuarioCaptor.getValue();
        assertEquals("$2a$10$hashedPassword", usuarioGuardado.getPassword());
        assertEquals(Role.ROLE_USER, usuarioGuardado.getRole());
    }

    @Test
    void register_deberiaLanzarExcepcionCuandoUsernameDuplicado(){
        //ARRANGE
        UsuarioCreateDTO dto = new UsuarioCreateDTO("juan","password123","juan@email.com");
        when(usuarioRepository.existsByUsername("juan")).thenReturn(true);

        //ACT+ASSERT
        assertThrows(UsuarioDuplicadoException.class, ()->usuarioService.register(dto));

        //VERIFY
        verify(usuarioRepository, never()).save(any());
        verify(passwordEncoder, never()).encode(anyString());
    }

    @Test
    void register_deberiaLanzarExceptionCuandoEmailDuplicado(){
        //ARRANGE
        UsuarioCreateDTO dto = new UsuarioCreateDTO("juan","password123","juan@email.com");
        when(usuarioRepository.existsByUsername("juan")).thenReturn(false);
        when(usuarioRepository.existsByEmail("juan@email.com")).thenReturn(true);


        //ACT+ASSERT
        assertThrows(UsuarioDuplicadoException.class, ()->usuarioService.register(dto));

        //VERIFY
        verify(usuarioRepository, never()).save(any());
        verify(passwordEncoder, never()).encode(anyString());

    }

    @Test
    void findByUsername_deberiaRetornarUsuarioCuandoExiste(){
        Usuario usuario = new Usuario();
        usuario.setId(java.util.UUID.randomUUID());
        usuario.setUsername("maria");
        usuario.setPassword("hashed");
        usuario.setEmail("maria@email.com");
        usuario.setRole(Role.ROLE_ADMIN);

        when(usuarioRepository.findByUsername("maria")).thenReturn(Optional.of(usuario));

        //ACT
        Optional<Usuario> resultado = usuarioService.findByUsername("maria");

        //ASSERT
        assertTrue(resultado.isPresent());
        assertEquals("maria", resultado.get().getUsername());
        assertEquals(Role.ROLE_ADMIN, resultado.get().getRole());
    }

    @Test
    void findByUsername_deberiaRetornarEmptyCuandoNoExiste(){
        //ARRANGE
        when(usuarioRepository.findByUsername("fantasma")).thenReturn(Optional.empty());

        //ACT
        Optional<Usuario> resultado = usuarioService.findByUsername("fantasma");

        //ASSERT
        assertTrue(resultado.isEmpty());
    }
}
