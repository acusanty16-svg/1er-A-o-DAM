package com.example.E_commerce.ejercicio3.exception;

/*
Excepción que se lanza cuando el stock es insuficiente.
 */

public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String message) {
        super(message);
    }
}
