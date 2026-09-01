package controller;

import model.Alumno;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Agenda {
    private HashMap <String, Alumno> listaAlumnos;

    public Agenda (){this.listaAlumnos = new HashMap<>();}
    public void anadirEstudiante(Alumno alumno){
        if (listaAlumnos.containsKey(alumno.getDni())){
            System.out.println("No se puede añadir al estudiante porque ya esta registrado");
        }else{
            listaAlumnos.put(alumno.getDni(), alumno);
            System.out.println("Alumno agregado correctamente");
        }
    }
    public void eliminarAlumno(String dni){
        if (listaAlumnos.remove(dni)!=null){
            System.out.println("Alumno borrado correctamente");
        }else {
            System.out.println("Error al borrar el estudiante, porque no esta registrado en el sistema");
        }
    }
    public void mejoresNotas(){
        double mejorNota=0;
        Collection<Alumno>values=listaAlumnos.values();
        for (Alumno alumno:values){
            if (alumno.getNota()>mejorNota){
                mejorNota=alumno.getNota();
            }
        }
        for (Alumno alumno:values){
            System.out.println("Los estudiantes destacados por sus mejores notas son: ");
            if (alumno.getNota()==mejorNota){
                alumno.mostrarDatos();
            }
        }
    }
    public void expedientesPorNota(double nota){
        Collection<Alumno> values=listaAlumnos.values();
        System.out.println("Los alumnos con notas superiores a "+nota+" son: ");
        for (Alumno alumno:values){
            if (alumno.getNota()>nota){
                alumno.mostrarDatos();
            }
        }
    }
    public void buscarAlumno (String dni){
       /* Alumno alumno = new Alumno();
        Set<String> keys = listaAlumnos.keySet();
        Alumno alumnoEncontrado= null;
        for (String item:keys){
            if (item.equals(dni)){
                alumnoEncontrado = listaAlumnos.get(item);
            }
        }
        if (alumnoEncontrado!= null){
            alumnoEncontrado.mostrarDatos();
        }else {
            System.out.println("No se encontro ningun alumno con el DNI: "+dni);
        }*/
        Alumno alumnoEncontrado = listaAlumnos.get(dni);
        if (alumnoEncontrado==null){
            System.out.println("No se ha encontrado al alumno");
        }else {
            alumnoEncontrado.mostrarDatos();
        }

    }
}


