package com.example.E_commerce.ejercicio3.exception;

/*
Excepción que se lanza cuando el carrito esta vacio.
 */

public class CarritoVacioException extends RuntimeException {
    public CarritoVacioException() {
        super("El carrito esta vacio, agrega productos antes de comprar");
    }
}
