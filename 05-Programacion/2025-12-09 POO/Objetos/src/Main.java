import model.Coche;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Coche ford = new Coche("Ford","Focus","1234A","Verde",80000);
        Coche opel = new Coche();
        Coche mercedes= new Coche("Mercedes","Clase C",80000);
        Coche audi= new Coche("Audi","Etron",120000,500);
        System.out.println("Los nuevos caballos del audi son: "+audi.getCv());
        System.out.println("el modelo del audi es: "+audi.getModelo());
        System.out.println(mercedes);
        ford.mostrarDatos();
        //System.out.println("Los caballos que tiene el audi son: "+audi.getCv());


    }
}