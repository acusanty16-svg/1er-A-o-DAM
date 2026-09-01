package model;

public abstract class Animal {
    private String nombre;
    private int edad;

    public Animal(){}

    public Animal(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    public abstract void hacerSonido();
    public void mostrarDatos(){
        System.out.println("nombre = " + nombre+" y tiene: "+edad+" años");
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
}
