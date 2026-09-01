package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

@NoArgsConstructor
public class Alumno {

    private String nombre;
    private int nMat;
    private Asignatura asignatura1, asignatura2, asignatura3;

    public Alumno(int nMat, String nombre,int id1, int id2, int id3){
        this.nombre=nombre;
        this.nMat= nMat;
        this.asignatura1= new Asignatura(id1);
        this.asignatura2=new Asignatura(id2);
        this.asignatura3=new Asignatura(id3);
    }
    public Alumno(int nMat, String nombre, Asignatura asignatura1, Asignatura asignatura2, Asignatura asignatura3){
        this.nombre=nombre;
        this.nMat=nMat;
        this.asignatura1=asignatura1;
        this.asignatura2=asignatura2;
        this.asignatura3=asignatura3;

    }
    public void mostradDatos(){
        System.out.println("Mostrando los datos del alumno con nombre: "+nombre);
        System.out.println("Los datos de la primera asignatura son: ");
        asignatura1.mostrarDatos();
        System.out.println("Los datos de la primera asignatura son: ");
        asignatura2.mostrarDatos();
        System.out.println("Los datos de la primera asignatura son: ");
        asignatura3.mostrarDatos();
    }
}
