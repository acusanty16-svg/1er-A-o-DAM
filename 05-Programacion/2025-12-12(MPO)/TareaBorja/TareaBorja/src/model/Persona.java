package model;

import jdk.jfr.DataAmount;
import lombok.Data;

@Data
public class Persona {
    private String nombre;
    private String apellido;
    private String dni;
    private String correo;
    private int telefono;

    public Persona(){
    this.nombre= "Nombre temporal";
    this.apellido="Apellido temporal";
    this.dni="000000";
    this.correo="ejemplo@correo.com";
    }
}
