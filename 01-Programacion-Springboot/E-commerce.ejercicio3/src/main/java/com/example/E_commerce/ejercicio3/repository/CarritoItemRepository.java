package com.example.E_commerce.ejercicio3.repository;

import com.example.E_commerce.ejercicio3.model.Carrito;
import com.example.E_commerce.ejercicio3.model.CarritoItem;
import com.example.E_commerce.ejercicio3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/* Repositorio para la entidad Item del carrito
    JPARepository nos da metodos CRUD automaticamente
    Añadimos metodos personalizados para encontrar el item pero al tener una restriccion
    el elemento no se duplicara
*/

@Repository
public interface CarritoItemRepository extends JpaRepository<CarritoItem, UUID> {

    /*Metodo para encontrar item, pero respeta el constraint puesto dentro de la clase modelo
    Que no le permite duplicar productos al carrito
    */
    Optional<CarritoItem> findByCarritoAndProducto(Carrito carrito, Producto producto);
}
