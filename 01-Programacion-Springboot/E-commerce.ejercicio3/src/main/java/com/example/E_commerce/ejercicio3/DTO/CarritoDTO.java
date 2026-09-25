package com.example.E_commerce.ejercicio3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 DTO de respuesta para la entidad carrito.
 Envía solo la información necesaria al cliente.
 */

public class CarritoDTO {
    private UUID id;
    private List<CarritoItemDTO> items;
    private Double total;
}
