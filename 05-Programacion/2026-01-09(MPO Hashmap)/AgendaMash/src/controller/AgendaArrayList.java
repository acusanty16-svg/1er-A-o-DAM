package controller;

import model.Persona;

import java.util.ArrayList;
import java.util.Objects;

public class AgendaArrayList {

    private ArrayList<Persona> listaPersonas;

    public AgendaArrayList(){
        listaPersonas=new ArrayList<>();
    }
    public void agregarPersona(Persona persona){
        if (persona==null) {
            System.out.println("No se ha podido agregar a la persona");
            return;
        }
        if (!estaPersona(persona.getDni())){
            listaPersonas.add(persona);
            System.out.println("Persona agregada con exito: "+persona.getNombre());
        }else{
            System.out.println("El dni ya está registrado");
        }
    }
    private boolean estaPersona(String dni){
        for(Persona item:listaPersonas){
            if (item.getDni().equalsIgnoreCase(dni)){
                return true;
            }
        }
        return false;
    }
    public void eliminarPersona(String dni){
        for (Persona item:listaPersonas){
            if (item.getDni().equalsIgnoreCase(dni)){
                listaPersonas.remove(item);
                System.out.println("Persona con DNI: "+item.getDni()+" borrado con exito");
                return;
            }
        }
        System.out.println("No se encontro a nadie con ese DNI");
    }
    public void listarPersonas(){
        if (listaPersonas.isEmpty()){
            System.out.println("No hay personas en la lista");
        }else{
            System.out.println("--- LISTA PERSONAS ---");
            for (Persona item:listaPersonas){
                item.mostrarDatos();
                System.out.println();
            }
        }
    }
}
