package com.example.E_commerce.ejercicio3.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 * DTO de respuesta para iniciar sesión con un token especifico.
 */

public class LoginResponseDTO {
    private String token;
}
