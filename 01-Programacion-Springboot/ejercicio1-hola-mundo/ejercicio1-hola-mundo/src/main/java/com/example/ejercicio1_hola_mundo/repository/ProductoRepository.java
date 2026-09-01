package com.example.ejercicio1_hola_mundo.repository;

import com.example.ejercicio1_hola_mundo.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Repositorio para acceder a la tabla "productos".
 * Hereda de JpaRepository que trae métodos listos para usar:
 * findAll(), findById(), save(), deleteById(), count(), existsById(), etc.
 * No hace falta escribir SQL, Spring Data JPA genera las consultas automáticamente.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID> {

}
