package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repositorio para la entidad Libro.
 * JpaRepository nos da métodos CRUD automáticamente.
 *
 * Extiende de JpaRepository<Libro, UUID>:
 * - Libro: la entidad que gestiona
 * - UUID: el tipo de ID de la entidad
 */
@Repository
public interface LibroRepository extends JpaRepository<Libro, UUID> {
}
