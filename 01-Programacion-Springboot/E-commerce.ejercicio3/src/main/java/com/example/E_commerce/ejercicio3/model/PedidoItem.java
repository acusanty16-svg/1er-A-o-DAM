package com.example.E_commerce.ejercicio3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Entidad Items de pedidos
@Entity
@Table(name = "pedidos_items")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PedidoItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Muchos items estan relacionadas con un solo pedido
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    //Muchos items estan realcionados con un solo producto
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private Producto producto;

    @Column(nullable = false)
    private String nombreProducto;

    @Column(nullable = false)
    private Double precioUnitario;

    @Column(nullable = false)
    private Integer cantidad;
}
