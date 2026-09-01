package Biblioteca.ejercicio2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO de respuesta para la entidad Autor.
 * Envía solo la información necesaria al cliente.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AutorDTO {
    private UUID id;
    private String nombre;
}
