package model;

public class Gato extends Animal{
    @Override
    public void hacerSonido() {
        mostrarDatos();
        System.out.println(getNombre()+" hace: Miauu, Miauu");
    }
    public Gato(){}

    public Gato(String nombre, int edad){
        super(nombre,edad);
    }

}
