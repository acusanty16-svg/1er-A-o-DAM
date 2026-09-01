package Biblioteca.ejercicio2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * DTO de respuesta para la entidad Libro.
 * Incluye el nombre del autor (no todo el objeto Autor).
 */

public class LibroDTO {
    private UUID id;
    private String titulo;
    private Double precio;
    private boolean prestado;
    private UUID autorId;
    private String autorNombre;
}
