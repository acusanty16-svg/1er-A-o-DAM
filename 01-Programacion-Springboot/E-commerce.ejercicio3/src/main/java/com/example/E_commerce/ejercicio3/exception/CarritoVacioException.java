package com.example.E_commerce.ejercicio3.exception;

public class CarritoVacioException extends RuntimeException {
    public CarritoVacioException(String message) {
        super("El carrito esta vacio, agrega productos antes de comprar");
    }
}
