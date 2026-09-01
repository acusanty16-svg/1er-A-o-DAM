import model.Desarrollador;
import model.Empleado;
import model.Gerente;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Desarrollador desarrollador1 = new Desarrollador("Santiago", 4000, "Python");
        Desarrollador desarrollador2 = new Desarrollador("Maria", 4000, "JS");
        Desarrollador desarrollador3 = new Desarrollador("Jose", 4000, "Java");
        Gerente gerente= new Gerente("Arturo",5000,1000);
        ArrayList<Empleado>listaEmpleados= new ArrayList<>();
        listaEmpleados.add(desarrollador1);
        listaEmpleados.add(desarrollador2);
        listaEmpleados.add(desarrollador3);
        listaEmpleados.add(gerente);
        for(Empleado item:listaEmpleados){
            if (item instanceof Gerente){
                ((Gerente) item).calcularSalarioTotal();
            } else if (item instanceof Desarrollador) {
                item.mostrarDatos();
            }
        }

    }
}