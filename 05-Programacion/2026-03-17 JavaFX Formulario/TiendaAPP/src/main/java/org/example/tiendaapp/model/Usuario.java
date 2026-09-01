package org.example.tiendaapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {
    private String nombre, apellido, direccion, correo, password;
    private int edad;
    private String perfil, genero;

    @Override
    public String toString() {
        return nombre+ " "+apellido;
    }
}
