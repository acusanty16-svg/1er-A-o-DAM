import model.Estudiante;
import model.Persona;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante= new Estudiante("Santiago",25,2);
        Estudiante estudiante2= new Estudiante("Maria",23,1);
        Estudiante estudiante3= new Estudiante("Alejandro",27,3);

        ArrayList<Estudiante>estudiantes=new ArrayList<>();
        estudiantes.add(estudiante);
        estudiantes.add(estudiante2);
        estudiantes.add(estudiante3);

        for(Estudiante item:estudiantes){
            item.presentarse();
        }

    }
}