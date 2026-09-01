package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repositorio para la entidad Autor.
 * JpaRepository nos da métodos CRUD automáticamente.
 *
 * Extiende de JpaRepository<Autor, UUID>:
 * - Autor: la entidad que gestiona
 * - UUID: el tipo de ID de la entidad
 */
@Repository
public interface AutorRepository extends JpaRepository<Autor, UUID> {
}
