package Biblioteca.ejercicio2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * DTO de entrada para crear un Autor.
 * Validaciones: nombre no puede estar vacío, máximo 100 caracteres.
 */
public class AutorCreateDTO {
    @NotBlank(message = "El nombre del autor es obligatorio")
    @Size(max = 100, message = "EL nombre no puede tener mas de 100 caracteres")
    private String nombre;
}
