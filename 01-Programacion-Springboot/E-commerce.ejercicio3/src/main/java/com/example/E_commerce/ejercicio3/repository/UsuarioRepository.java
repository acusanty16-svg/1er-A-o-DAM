package com.example.E_commerce.ejercicio3.repository;

import com.example.E_commerce.ejercicio3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/* Repositorio para la entidad Usuario
    JPARepository nos da metodos CRUD automaticamente
    Añadimos metodos personalizados para buscar username y email
*/

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

    //Metodo para buscar username
    Optional<Usuario> findByUsername(String username);

    //Metodo para verificar si existe el usuario
    boolean existsByUsername(String username);

    //Metodo que verfica si ya existe un email
    boolean existsByEmail(String email);
}
