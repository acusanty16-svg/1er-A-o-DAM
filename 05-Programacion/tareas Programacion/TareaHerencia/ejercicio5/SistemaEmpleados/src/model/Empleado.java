package model;

public abstract class Empleado {
    private String nombre;
    private double salarioBase;

    public Empleado(){}
    public Empleado(String nombre, double salarioBase) {
        this.nombre = nombre;
        this.salarioBase = salarioBase;
    }
    public void mostrarDatos(){
        System.out.println("nombre = " + nombre);
        System.out.println("salarioBase = " + salarioBase);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }
}
