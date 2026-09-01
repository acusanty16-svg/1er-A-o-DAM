package model;

public class Empleado {
    private String nombre, dni;
    private double salarioBase;
    private int horasExtra;

    public Empleado() {
    }

    public Empleado(String nombre, String dni, double salarioBase) {
        this.nombre = nombre;
        this.dni = dni;
        this.salarioBase = salarioBase;
        this.horasExtra = 0;
    }
    public void agregarHorasExtra(int horas){
        if (horas>0){
            this.horasExtra+=horas;
        }else {
            System.out.println("Dato incorrecto...");
        }
    }
    public double calcularSalarioTotal(){
        double salarioTotal=salarioBase+(horasExtra*20);
        return salarioTotal;
    }
    public void aplicarAumento(double porcentaje){
        if (porcentaje>0 && porcentaje<100){
            salarioBase*=(1 + (porcentaje/100));
            System.out.println("Has introducido "+porcentaje+". tu nuevo salario es: "+salarioBase);
        }else {
            System.out.println("Dato incorrecto...");
        }

    }
    public void resetearHorasExtra(){
        this.horasExtra = 0;
    }
    public void mostrarInforme(){
        System.out.println("nombre = " + nombre);
        System.out.println("dni = " + dni);
        System.out.println("salarioBase = " + salarioBase);
        System.out.println("horasExtra = " + horasExtra);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public int getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(int horasExtra) {
        this.horasExtra = horasExtra;
    }
}
