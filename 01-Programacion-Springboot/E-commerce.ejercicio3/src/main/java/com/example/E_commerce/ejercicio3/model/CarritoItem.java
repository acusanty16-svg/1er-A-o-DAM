package com.example.E_commerce.ejercicio3.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

//Entidad item de carritos
@Entity
//Entidad de items de cada carrito
@Table(name = "carritos_items",
        /*restriccion entre las columnas de carrito y producto
        para que no existan duplicados y si llegase a existir
        entonces saldra la siguiente excepcion: DataIntegrityViolationException
        */
        uniqueConstraints = @UniqueConstraint(columnNames = {"carrito_id", "producto_id"}))
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoItem {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //Muchos items, pero un solo un carrito
    @ManyToOne
    @JoinColumn(name = "carrito_id", nullable = false)
    private Carrito carrito;

    //Cada item puede tener mas de un producto
    @ManyToOne
    @JoinColumn(name = "producto_id",nullable = false)
    private Producto producto;

    @Column(nullable = false)
    private Integer cantidad;

}
