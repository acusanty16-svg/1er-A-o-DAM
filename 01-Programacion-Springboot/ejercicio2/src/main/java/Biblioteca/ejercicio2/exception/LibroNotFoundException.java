package Biblioteca.ejercicio2.exception;

import java.util.UUID;
/**
 * Excepción que se lanza cuando no se encuentra un libro.
 */
public class LibroNotFoundException extends RuntimeException {
    public LibroNotFoundException(UUID id) {
        super("Libro no encontrado con ID: "+id);
    }
}
