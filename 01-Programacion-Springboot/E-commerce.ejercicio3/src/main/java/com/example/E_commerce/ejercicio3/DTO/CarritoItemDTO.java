package com.example.E_commerce.ejercicio3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
 DTO de respuesta para la entidad Item del carrito.
 Envía solo la información necesaria al cliente.
 */

public class CarritoItemDTO {
    private UUID id;
    private UUID productoId;
    private String nombreProducto;
    private Double precio;
    private Integer cantidad;
    private Double subtotal;
}
