package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositorio para la entidad Usuario.
 * JpaRepository nos da métodos CRUD automáticamente.
 * Añadimos métodos personalizados para buscar por username y email.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    // Busca un usuario por su nombre de usuario
    Optional<Usuario> findByUsername(String username);

    // Verifica si ya existe un usuario con ese nombre
    boolean existsByUsername(String username);

    // Verifica si ya existe un usuario con ese email
    boolean existsByEmail(String email);
}
