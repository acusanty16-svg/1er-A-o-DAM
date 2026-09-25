package com.example.E_commerce.ejercicio3.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

/*
DTO de entrada para crear un Usuario.
Validaciones:
    -Nombre: no puede tener menos de 3 letras y mas de 50, ademas no puede
    ser estar vacio
    -Contraseña: minimo 6
    -Email: no puede estar vacio
 */

public class UsuarioCreateDTO {
    @NotBlank(message = "El nombre de usuario es obligatorio")
    @Size(max = 50, min = 3, message = "El nombre de usuario debe tener entre 3 y 50 caracteres")
    private String username;

    @Size(min = 6, message = "La contraseña debe tener al menos 6 caracteres")
    @NotNull(message = "La contraseña es obligatoria")
    private String password;

    @NotBlank(message = "El email es obligatorio")
    @Email
    private String email;
}
