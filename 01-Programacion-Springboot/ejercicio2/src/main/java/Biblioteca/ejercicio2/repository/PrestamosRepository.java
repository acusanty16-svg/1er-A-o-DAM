package Biblioteca.ejercicio2.repository;

import Biblioteca.ejercicio2.model.Prestamo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
/**
 * Repositorio para la entidad Prestamo.
 * JpaRepository nos da métodos CRUD automáticamente.
 *
 * Extiende de JpaRepository<Prestamo, UUID>:
 * - Prestamo: la entidad que gestiona
 * - UUID: el tipo de ID de la entidad
 */
@Repository
public interface PrestamosRepository extends JpaRepository<Prestamo, UUID> {
}
