package com.example.ejercicio1_hola_mundo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO de respuesta: lo que el cliente recibe de la API.
 * Incluye el ID porque el cliente lo necesita para referenciar
 * el producto en futuras peticiones (comprar, editar, borrar).
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private UUID id;
    private String nombre;
    private Double precio;
}
