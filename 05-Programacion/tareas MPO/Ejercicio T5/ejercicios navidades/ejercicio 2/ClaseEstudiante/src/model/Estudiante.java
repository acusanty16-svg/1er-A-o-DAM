package model;

public class Estudiante {
    private String nombre;
    private int edad;
    private double notaMatematicas;
    private double notaProgramacion;
    private double notaIngles;

    public Estudiante(){}

    public Estudiante(String nombre, int edad, double notaMatematicas, double notaProgramacion, double notaIngles) {
        this.nombre = nombre;
        this.edad = edad;
        this.notaMatematicas = notaMatematicas;
        this.notaProgramacion = notaProgramacion;
        this.notaIngles = notaIngles;
    }
    public double calcularPromedio(){
        double suma = this.notaIngles + this.notaMatematicas + this.notaProgramacion;
        return suma/3;
    }
    public boolean estaAprobado (){
        double promedio =calcularPromedio();
        if (promedio>=5 && promedio<=10){
            System.out.println("El estudiante está aprobado");
            return true;
        }else if (promedio<5){
            System.out.println("El estudiante está suspenso");
        }else {
            System.out.println("Dato invalido");
        }
        return false;
    }
    public String obtenerCalificacion(){
        double promedio = calcularPromedio();
        if (promedio < 0 || promedio > 10) {
            return "Rango inválido";
        }
        else if (promedio >= 9) {
            return "Sobresaliente";
        } else if (promedio >= 7) {
            return "Notable";
        } else if (promedio >= 6) {
            return "Bien";
        } else if (promedio >= 5) {
            return "Suficiente";
        } else {
            return "Suspenso";
        }
    }
    public void mostrarInforme(){
        System.out.println("nombre = " + nombre);
        System.out.println("edad = " + edad);
        estaAprobado();
        System.out.printf("Su promedio es: %.2f%n",calcularPromedio());
        System.out.println("Calificacion: "+obtenerCalificacion());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getNotaMatematicas() {
        return notaMatematicas;
    }

    public void setNotaMatematicas(double notaMatematicas) {
        this.notaMatematicas = notaMatematicas;
    }

    public double getNotaProgramacion() {
        return notaProgramacion;
    }

    public void setNotaProgramacion(double notaProgramacion) {
        this.notaProgramacion = notaProgramacion;
    }

    public double getNotaIngles() {
        return notaIngles;
    }

    public void setNotaIngles(double notaIngles) {
        this.notaIngles = notaIngles;
    }
}
