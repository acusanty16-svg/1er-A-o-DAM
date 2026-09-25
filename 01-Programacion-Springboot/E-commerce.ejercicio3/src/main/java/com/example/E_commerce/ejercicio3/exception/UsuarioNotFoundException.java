package com.example.E_commerce.ejercicio3.exception;

/*
Excepción que se lanza cuando no se encuentra un usuario.
 */

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(String username) {
        super("Usuario " + username+" no encontrado");
    }

}
