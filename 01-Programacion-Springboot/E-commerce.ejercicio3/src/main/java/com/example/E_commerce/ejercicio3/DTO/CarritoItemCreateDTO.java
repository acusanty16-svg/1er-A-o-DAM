package com.example.E_commerce.ejercicio3.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
DTO de entrada para crear un item del carrito.
Validaciones:
    -ProductoId: relacionamos el producto con el item para que exista snapshot
    y todo se relacione entre si y no puede estar vacio
    -Cantidad: Debe tener al menos un elemento, no esta vacio y debe ser positivo
 */

public class CarritoItemCreateDTO {

    @NotNull
    private UUID productoId;

    @NotNull(message = "La cantidad es obligatoria")
    @Positive
    @Min(1)
    private Integer cantidad;
}
