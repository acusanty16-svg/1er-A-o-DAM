package Biblioteca.ejercicio2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * DTO de respuesta para la entidad Prestamos.
 * Incluye el id del Prestamo (no todo el objeto Prestamo).
 */
public class PrestamosDTO {
    private UUID id;
    private String usuario;
    private LocalDateTime fechaPrestamo;
    private LocalDateTime fechaDevolucion;
    private UUID idLibro;
    private String libroTitulo;
}
