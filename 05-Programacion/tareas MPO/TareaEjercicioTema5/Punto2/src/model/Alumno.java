package model;

public class Alumno {
    private String dni,nombre,apellido;
    private double nota;

    public Alumno() {
    }

    public Alumno(String nombre, String apellido, String dni, double nota) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.nota = nota;
    }

    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("apellido = " + apellido);
        System.out.println("dni = " + dni);
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
       if (nota>=0 && nota<=10){
           this.nota=nota;
       }else {
           System.out.println("Error, la nota no puede superar el 10 o ser inferior a 0");
       }
    }


}
