package controller;

import model.Alumno;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.OptionalDouble;

public class Gestor {
    private ArrayList<Alumno> alumnos;
    private HashMap<String, Alumno> alumnosMap;

    public Gestor (){
        alumnos = new ArrayList<>();
        alumnosMap = new HashMap<>();
    }
    public void agregarAlumno(Alumno alumno){
        /*if (alumnosMap.containsKey(alumno.getDni())){
            System.out.println("No se puede agregar");
        }else{
            alumnosMap.put(alumno.getDni(), alumno);
            System.out.println("Agregado correctamente");
        }
        if(alumnosMap.put(alumno.getDni(), alumno)==null){
            System.out.println("Alumno agregado correctamente");
        }else {
            System.out.println("Alumno no agreagado correctamente, dni duplicado");
        }*/
        /*for(Alumno item:alumnos){
            if(item.getDni().equals(alumno.getDni())){
                System.out.println("No puedo");
                return;
            }
        }
        alumnos.add(alumno);*/
        boolean esta=alumnos.stream().anyMatch(item->item.getDni().equals(alumno.getDni()));
        if (esta){
            System.out.println("El dni esta en la lista y no se puede agregar");
        }else {
            System.out.println("Usuario agregado con exito");
            alumnos.add(alumno);
        }
    }
    public void mostrarAlumnos(){
       /* alumnos.forEach(item->{
            if (item.getNota()>5){
                item.mostrarDatos();
            }
        });*/
        alumnos.forEach(Alumno::mostrarDatos);
        //alumnosMap.values().forEach(Alumno::mostrarDatos);
    }
    public void calificarAlumno (){
        alumnos.forEach(item->{
            if (item.getNota()==-1){
                item.setNota((int)(Math.random()*11));
            }
        });
    }

    public void calificarMedia(){
        double acumulador=0;
       // alumnos.stream().map(item->item.getNota()).forEach(item->acumulador+=item);
       //double media= alumnos.stream().mapToDouble(Alumno::getNota).sum()/alumnos.size();
        OptionalDouble media= alumnos.stream().mapToDouble(Alumno::getNota).average();
        System.out.println(media.getAsDouble());
    }
}
