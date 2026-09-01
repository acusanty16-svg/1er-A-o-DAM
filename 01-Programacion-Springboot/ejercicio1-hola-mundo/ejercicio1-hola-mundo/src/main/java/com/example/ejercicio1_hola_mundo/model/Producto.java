package com.example.ejercicio1_hola_mundo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * Entidad que representa la tabla "productos" en la base de datos.
 * Usa UUID como identificador único en vez de un Long auto-incremental.
 * Lombok genera automáticamente getters, setters, toString, equals y hashCode.
 */
@Entity
@Table(name = "productos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false)
    private Double precio;
}
