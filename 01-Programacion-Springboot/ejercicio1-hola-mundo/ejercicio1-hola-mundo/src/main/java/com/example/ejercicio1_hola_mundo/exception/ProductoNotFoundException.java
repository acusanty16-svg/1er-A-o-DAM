package com.example.ejercicio1_hola_mundo.exception;

import java.util.UUID;

/**
 * Excepción personalizada que se lanza cuando no se encuentra un producto.
 * Extiende RuntimeException para que no sea obligatorio capturarla.
 * El mensaje incluye el ID del producto buscado para facilitar el debug.
 */
public class ProductoNotFoundException extends RuntimeException {

    public ProductoNotFoundException(UUID id) {
        super("Producto no encontrado con id: " + id);
    }
}
