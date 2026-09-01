import model.Animal;
import model.Gato;
import model.Perro;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Perro perro1 = new Perro("Matias1",10);
        Perro perro2 = new Perro("Matias2",11);
        Perro perro3 = new Perro("Matias3",12);
        Gato gato = new Gato("Michi1",7);
        Gato gato2 = new Gato("Michi2",8);
        Gato gato3 = new Gato("Michi3",9);
        ArrayList<Animal>listaAnimales=new ArrayList<>();
        listaAnimales.add(perro1);
        listaAnimales.add(perro2);
        listaAnimales.add(perro3);
        listaAnimales.add(gato);
        listaAnimales.add(gato2);
        listaAnimales.add(gato3);

        for(Animal animal:listaAnimales){
            animal.hacerSonido();
        }

    }
}