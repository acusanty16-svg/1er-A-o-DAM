package Biblioteca.ejercicio2.exception;

import java.util.UUID;
/**
 * Excepción que se lanza cuando no se encuentra un préstamo.
 */
public class PrestamoNotFoundException extends RuntimeException {
    public PrestamoNotFoundException(UUID id) {
        super("Prestamo no encontrado con ID: "+id);
    }
}
