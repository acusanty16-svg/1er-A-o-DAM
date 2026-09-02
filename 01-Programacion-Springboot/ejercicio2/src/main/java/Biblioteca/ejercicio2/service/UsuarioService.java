package Biblioteca.ejercicio2.service;

import Biblioteca.ejercicio2.DTO.UsuarioCreateDTO;
import Biblioteca.ejercicio2.DTO.UsuarioDTO;
import Biblioteca.ejercicio2.model.Role;
import Biblioteca.ejercicio2.model.Usuario;
import Biblioteca.ejercicio2.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Servicio para gestionar usuarios.
 * Maneja registro de usuarios con contraseñas cifradas.
 */

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    // Convierte una entidad Usuario a UsuarioDTO
    private UsuarioDTO toDTO(Usuario usuario) {
        return new UsuarioDTO(
                usuario.getId(),
                usuario.getUsername(),
                usuario.getEmail(),
                usuario.getRole()
        );
    }

    //Registra un usuario nuevo con contraseña cifrada
    public UsuarioDTO register(UsuarioCreateDTO dto){
        //Verificar si ya existe el username
        if (usuarioRepository.existsByUsername(dto.getUsername())){
            throw new RuntimeException("El nombre de usuario ya existe");
        }
        //Verificar si ya existe el email
        if (usuarioRepository.existsByEmail(dto.getEmail())){
            throw new RuntimeException("El email ya esta registrado");
        }
        //Crear usuario con contraseña cifrada
        Usuario usuario = new Usuario();
        usuario.setUsername(dto.getUsername());
        usuario.setPassword(passwordEncoder.encode(dto.getPassword()));
        usuario.setEmail(dto.getEmail());
        usuario.setRole(Role.ROLE_USER);
        //Guardar en la base de datos
        Usuario saved = usuarioRepository.save(usuario);
        return toDTO(saved);
    }

    //Busca un usuario por su nombre
    public Optional<Usuario> findByUsername(String username){
        return usuarioRepository.findByUsername(username);
    }
}
