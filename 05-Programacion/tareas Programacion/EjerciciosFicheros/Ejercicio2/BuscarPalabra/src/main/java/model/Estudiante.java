package model;

public class Estudiante extends Persona{

    private double calificacion;
    private String dni;
    @Override
    void saludar() {
        System.out.println("Hola soy estudiante y saludo");
    }

    public Estudiante(){}
    public Estudiante(String nombre, int edad, String dni) {
        super(nombre, edad);
        this.dni = dni;
        this.calificacion = -1;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        String calificacionFormateada = String.format("%.2f", calificacion);
        return "Estudiante{" +
                "nombre='" + getNombre() + '\'' +
                ", edad=" + getEdad() +
                ", dni='" + dni + '\'' +
                ", calificacion= "+calificacionFormateada+
                '}';
    }
}
