package com.example.E_commerce.ejercicio3.DTO;

import com.example.E_commerce.ejercicio3.model.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor

/*
 DTO de respuesta para la entidad Usuario.
 Envía solo la información necesaria al cliente.
 */

public class UsuarioDTO {
    private UUID id;
    private String username;
    private String email;
    private Role role;
}