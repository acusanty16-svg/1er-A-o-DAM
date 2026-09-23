package com.example.E_commerce.ejercicio3.repository;

import com.example.E_commerce.ejercicio3.model.Pedido;
import com.example.E_commerce.ejercicio3.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

/* Repositorio para la entidad Pedido
    JPARepository nos da metodos CRUD automaticamente
    Añadimos metodos personalizados para tener todos
    los pedidos escogidos por el cliente en mis favoritos
*/
@Repository
public interface PedidoRepository extends JpaRepository<Pedido, UUID> {

    //Metodo para tener todos los pedidos escogidos por el cliente en mis favoritos
    List<Pedido> findByUsuarioOrderByFechaDesc(Usuario usuario);
}
