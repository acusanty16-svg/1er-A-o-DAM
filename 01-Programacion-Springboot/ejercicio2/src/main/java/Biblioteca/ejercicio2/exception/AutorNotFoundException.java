package Biblioteca.ejercicio2.exception;

import java.util.UUID;
/**
 * Excepción que se lanza cuando no se encuentra un autor.
 */
public class AutorNotFoundException extends RuntimeException {
    public AutorNotFoundException(UUID id) {
        super("Autor no encontrado con ID: "+id);
    }
}
