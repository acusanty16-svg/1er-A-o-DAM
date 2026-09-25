package com.example.E_commerce.ejercicio3.exception;

/*
Excepción que se lanza cuando no se encuentra un pedido.
 */

import java.util.UUID;

public class PedidoNotFoundException extends RuntimeException {
    public PedidoNotFoundException(UUID id) {
        super("Pedido no encontrado con ID: "+ id);
    }
}
