package com.example.E_commerce.ejercicio3.exception;

/*
Excepción que se lanza cuando no se encuentra un item dentro del carrito.
 */

import java.util.UUID;

public class CarritoItemNotFoundException extends RuntimeException {
    public CarritoItemNotFoundException(UUID id) {
        super("Item no encontrado con ID: "+id);
    }
}
