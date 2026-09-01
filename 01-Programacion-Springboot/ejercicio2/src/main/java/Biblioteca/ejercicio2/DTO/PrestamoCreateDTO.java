package Biblioteca.ejercicio2.DTO;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO de entrada para crear un Préstamo.
 * Solo necesita el ID del libro y el nombre del usuario.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PrestamoCreateDTO {

    @NotNull(message = "El ID del libro es obligatorio")
    private UUID libroId;

    @NotNull(message = "El nombre del usuario es obligatorio")
    private String usuario;
}
