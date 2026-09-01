package model;

public class Perro extends Animal{
    @Override
    public void hacerSonido() {
        mostrarDatos();
        System.out.println(getNombre()+" hace: Guau, Guau");
    }
    public Perro(){}

    public Perro(String nombre, int edad){
        super(nombre,edad);
    }

}