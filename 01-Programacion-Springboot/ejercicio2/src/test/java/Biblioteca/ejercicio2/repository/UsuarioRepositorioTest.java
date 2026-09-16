package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Role;
import Biblioteca.ejercicio2.model.Usuario;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UsuarioRepositorioTest {
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Test
    void save_deberiaGuardarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setUsername("carlos");
        usuario.setPassword("hashedPassword123");
        usuario.setEmail("carlos@email.com");
        usuario.setRole(Role.ROLE_USER);

        Usuario guardado = usuarioRepository.save(usuario);

        assertNotNull(guardado.getId());
        assertEquals("carlos", guardado.getUsername());
        assertEquals("carlos@email.com",guardado.getEmail());
        assertEquals(Role.ROLE_USER, guardado.getRole());
    }

    @Test
    void findByUsername_deberiaRetornarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setUsername("maria");
        usuario.setPassword("hashedPassword");
        usuario.setEmail("maria@email.com");
        usuario.setRole(Role.ROLE_ADMIN);
        usuarioRepository.save(usuario);

        Optional<Usuario> resultado = usuarioRepository.findByUsername("maria");

        assertTrue(resultado.isPresent());
        assertEquals("maria",resultado.get().getUsername());
        assertEquals(Role.ROLE_ADMIN, resultado.get().getRole());
    }

    @Test
    void findByUsername_deberiaRetornarEmptySiNoExiste(){
        Optional<Usuario> resultado = usuarioRepository.findByUsername("noexiste");

        assertTrue(resultado.isEmpty());
    }

    @Test
    void existsByUsername_deberiaRetornarTrueSiExiste(){
        Usuario usuario = new Usuario();
        usuario.setUsername("pedro");
        usuario.setPassword("hashedPassword");
        usuario.setEmail("pedro@email.com");
        usuario.setRole(Role.ROLE_USER);
        usuarioRepository.save(usuario);

        assertTrue(usuarioRepository.existsByUsername("pedro"));
    }

    @Test
    void existsByUsername_deberiaRetornarFalseSiNoExiste(){
        assertFalse(usuarioRepository.existsByUsername("noexiste"));
    }

    @Test
    void existsByEmail_deberiaRetonarTrueSiExiste(){
        Usuario usuario = new Usuario();
        usuario.setUsername("ana");
        usuario.setPassword("hashedPassword");
        usuario.setEmail("ana@email.com");
        usuario.setRole(Role.ROLE_USER);
        usuarioRepository.save(usuario);

        assertTrue(usuarioRepository.existsByEmail("ana@email.com"));
    }
}
