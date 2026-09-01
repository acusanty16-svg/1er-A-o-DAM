package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Trabajador {
    private String nombre,apellido,dni,correo, estado;
    private int id;

    public Trabajador(String nombre, String apellido, String dni, String correo, int id){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.estado = "Activo";
    }

    public Trabajador(int id, String nombre, String apellido, String dni, String correo, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.correo = correo;
        this.estado = estado;
    }

    public String toString(){
        return id + "," + nombre + "," + apellido + "," + dni + "," + correo + "," + estado;
    }
}
