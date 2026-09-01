package model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class Contacto {
    private int id;
    private String nombre, apellido, dni;
    private int telefono;

    public Contacto() {
    }

    public Contacto(String nombre, int telefono, String dni, String apellido) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
        this.apellido = apellido;
    }
    public void mostrarDatos(){
        System.out.println("Mostrando los datos del contacto: "+nombre);
        System.out.println("id = " + id);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
        System.out.println("telefono = " + telefono);

    }
}
