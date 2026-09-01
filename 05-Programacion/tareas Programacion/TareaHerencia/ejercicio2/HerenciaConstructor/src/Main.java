import model.Coche;
import model.Vehiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("---BIENVENIDO AL CONCESIONARIO BORJA---");
        Coche coche1= new Coche("Corza",4);
        Coche coche2=new Coche("Corza",45,5);
        ArrayList<Vehiculo>listaVehiculos= new ArrayList<>();
        listaVehiculos.add(coche1);
        listaVehiculos.add(coche2);

        for(Vehiculo vehiculo:listaVehiculos){
            vehiculo.mostrarDatos();
        }
    }
}