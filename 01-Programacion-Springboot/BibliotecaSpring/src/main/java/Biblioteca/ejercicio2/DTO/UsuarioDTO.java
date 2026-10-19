package Biblioteca.ejercicio2.DTO;

import Biblioteca.ejercicio2.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

/**
 * DTO de respuesta para la entidad Usuario.
 * No incluye la contraseña por seguridad.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private UUID id;
    private String username;
    private String email;
    private Role role;
}
