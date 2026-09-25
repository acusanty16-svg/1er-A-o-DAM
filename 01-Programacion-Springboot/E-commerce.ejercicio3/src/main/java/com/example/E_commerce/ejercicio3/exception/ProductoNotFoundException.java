package com.example.E_commerce.ejercicio3.exception;

import java.util.UUID;

/*
Excepción que se lanza cuando no se encuentra un producto.
 */

public class ProductoNotFoundException extends RuntimeException{
    public ProductoNotFoundException(UUID id){
        super("Producto no encontrado con ID: " + id);
    }
}
