package com.example.E_commerce.ejercicio3.repository;

import com.example.E_commerce.ejercicio3.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/* Repositorio para la entidad Producto
    JPARepository nos da metodos CRUD automaticamente
    Añadimos metodos personalizados para encontrar productos activos,
    y para listar todos los productos
*/

@Repository
public interface ProductoRepository extends JpaRepository<Producto, UUID> {

    //Metodo que lista productos que estan activos
    List<Producto> findByActivoTrue();

    //Metodo que lista todos los productos con su nombre de forma ascendente
    List<Producto> findAllByOrderByNombreAsc();
}
