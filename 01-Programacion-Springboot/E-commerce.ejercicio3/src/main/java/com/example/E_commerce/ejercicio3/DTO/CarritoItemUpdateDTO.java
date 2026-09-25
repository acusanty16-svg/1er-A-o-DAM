package com.example.E_commerce.ejercicio3.DTO;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 DTO de respuesta para hacer PUT con: "/items/{id}"
 */

public class CarritoItemUpdateDTO {

    @NotNull
    @Min(1)
    private Integer cantidad;
}
