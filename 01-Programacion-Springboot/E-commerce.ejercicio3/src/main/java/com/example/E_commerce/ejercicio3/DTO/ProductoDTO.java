package com.example.E_commerce.ejercicio3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 DTO de respuesta para la entidad Producto.
 Envía solo la información necesaria al cliente.
 */

public class ProductoDTO {
    private UUID id;
    private String nombre;
    private String descripcion;
    private Double precio;
    private Integer stock;
    private boolean activo;
}
