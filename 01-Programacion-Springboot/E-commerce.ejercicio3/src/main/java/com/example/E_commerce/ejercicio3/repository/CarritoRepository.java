package com.example.E_commerce.ejercicio3.repository;

import com.example.E_commerce.ejercicio3.model.Carrito;
import com.example.E_commerce.ejercicio3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/* Repositorio para la entidad Carrito
    JPARepository nos da metodos CRUD automaticamente
    Añadimos metodos personalizados para buscar usuario,
    y para encontrar el carrito del usuario con su id
*/

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, UUID> {

    //Metodo para buscar usuario
    Optional<Carrito> findByUsuario(Usuario usuario);

    //Metodo para buscar carrito con id de usuario
    Optional<Carrito> findByUsuario_Id(UUID id_usuario);
}
