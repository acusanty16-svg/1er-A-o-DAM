package com.example.ejercicio1_hola_mundo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Objeto que se devuelve al cliente cuando ocurre un error.
 * En vez de devolver el stack trace de Java (que es feo y peligroso),
 * devolvemos un JSON limpio con un mensaje entendible.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String mensaje;
}
