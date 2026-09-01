package com.example.ejercicio1_hola_mundo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO de creación: lo que el cliente envía para crear un producto nuevo.
 * No tiene ID porque lo genera la base de datos automáticamente.
 * Las validaciones aseguran que los datos sean correctos antes de llegar al servicio.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCreateDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(min = 2, max = 100, message = "El nombre debe tener entre 2 y 100 caracteres")
    private String nombre;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;
}
