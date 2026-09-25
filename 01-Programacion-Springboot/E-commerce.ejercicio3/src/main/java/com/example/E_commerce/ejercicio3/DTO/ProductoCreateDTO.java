package com.example.E_commerce.ejercicio3.DTO;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
DTO de entrada para crear un Producto.
Validaciones:
    -Nombre: no puede tener mas de 50 caracteres, ademas no puede estar vacio
    -Descripcion: No puede estar vacio y no debe tener mas de 500 caracteres
    -Precio: Tiene que ser positivo y no puede estar vacio
    -Stock: no puede estar vacio y al menos debe tener uno
 */

public class ProductoCreateDTO {

    @NotBlank(message = "EL nombre es obligatorio")
    @Size(max = 100)
    private String nombre;

    @NotBlank(message = "La descripcion del producto es obligatoria")
    @Size(max = 500)
    private String descripcion;

    @NotNull(message = "El precio es obligatorio")
    @Positive
    private Double precio;

    @NotNull(message = "EL stock es obligatorio")
    @Min(1)
    private Integer stock;
}
