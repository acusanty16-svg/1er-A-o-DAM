package Biblioteca.ejercicio2.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
/**
 * DTO de entrada para crear un Libro.
 * Validaciones: título no vacío, precio positivo, autor obligatorio.
 */

public class LibroCreateDTO {

    @NotBlank(message = "El titulo del libro es obligatorio")
    @Size(min = 1, max = 100, message = "El titulo del nombre no puede exceder los 100 caracteres y al menos 1")
    private String titulo;

    @NotNull(message = "El precio es obligatorio")
    @Positive(message = "El precio debe ser mayor a 0")
    private Double precio;

    @NotNull(message = "El autor es obligatorio")
    private UUID autorId;
}
