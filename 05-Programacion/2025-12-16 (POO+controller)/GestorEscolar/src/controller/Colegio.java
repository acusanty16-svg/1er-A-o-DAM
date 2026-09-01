package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import model.Alumno;
import model.Profesor;

import java.util.ArrayList;
@Data

public class Colegio {
    private ArrayList<Alumno> alumnos;
    private Profesor profesor;
    private int matriculas;

    public Colegio(){
        alumnos=new ArrayList<>();
        profesor=new Profesor();
        matriculas=1;
    }

    public Colegio(Profesor profesor) {
        this.alumnos = new ArrayList<>();
        this.profesor = profesor;
    }
    public void matricularAlumno(String nombre){
    alumnos.add(new Alumno(matriculas,nombre,1,2,3));
        System.out.println("Usuario agregado correctamente");
    matriculas++;
    }
    public void ponerNotas(){
        for(Alumno item:alumnos){
            profesor.ponerNotas(item);
        }
        System.out.println("Notas puestas correctamente, podemos hacer el acta");

    }
    public void mostrarDatos(){
        for(Alumno item:alumnos){
            System.out.println("Mostrando datos de "+item.getNombre());
            item.mostradDatos();
            System.out.println("La nota media del alumno es: "+profesor.calcularMedia(item));
        }
    }
    public void buscarExpediente(int nMatricula){
    for(Alumno item:alumnos){
        if (item.getNMat()==nMatricula){
        item.mostradDatos();
            System.out.println("Su media es "+profesor.calcularMedia(item));
            return;
        }
    }
        System.out.println("Usuario no encontrado");
    }
}
