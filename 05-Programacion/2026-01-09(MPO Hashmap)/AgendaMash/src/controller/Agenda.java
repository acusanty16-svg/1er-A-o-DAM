package controller;

import model.Persona;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Set;

public class Agenda {
    private HashMap<String, Persona> listaContactos;

    public Agenda(){
        listaContactos = new HashMap<>();
    }

    public void agregarPersona(Persona persona){
        if(listaContactos.containsKey(persona.getDni())){
            System.out.println("No se puede agregar, dni duplicado");
        }else{
            listaContactos.put(persona.getDni(), persona);
            System.out.println("Persona agregada correctamente");
        }
    }

    public void borrarPersona (String dni){
        /*if(listaContactos.containsKey(dni)){
            listaContactos.remove(dni);
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("EL dni no se encuentra en la lista, no se puede borrar");
        }*/
        if (listaContactos.remove(dni)!=null){
            System.out.println("Persona borrada correctamente");
        }else{
            System.out.println("Error en el borrado, no se encuentra el DNI");
        }
    }
    public Persona obtenerPersona (String dni){
        return listaContactos.get(dni);
    }
    public void obtenerPersonas (){
        System.out.println("Mostrando con keys");
        Set<String> keys = listaContactos.keySet();
        for(String item:keys){
            listaContactos.get(item).mostrarDatos();
        }

        System.out.println("Mostrando con values");
        Collection<Persona> values = listaContactos.values();
        for (Persona item:values){
            item.mostrarDatos();
        }
    }
}
