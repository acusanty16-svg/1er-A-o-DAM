package controller;

import lombok.Data;
import model.Persona;

import java.util.ArrayList;
import java.util.Objects;
import java.util.function.Predicate;

@Data
public class AgendaPersonas {
    private ArrayList<Persona> listaPersonas;
    public AgendaPersonas(){
        this.listaPersonas=new ArrayList<>();
    }
    public void agregarPersona(Persona contacto){
        listaPersonas.add(contacto);
        System.out.println("Contacto agregado correctamente");
    }
    public void buscarPersona(String dni){
        for(Persona item:listaPersonas){
            if (Objects.equals(item.getDni(), dni)){
                System.out.println("Usuario encontrado correctamente");
                System.out.println("Nombre: "+item.getNombre());
                System.out.println("Apellido: "+item.getApellido());
                System.out.println("Telefono: "+item.getTelefono());
                return;
            }
        }
        System.out.println("Usuario no encontrado");
    }
    public void borrarPersona(String dni){
        Persona borrarPersona=null;
       for(Persona item:listaPersonas){
           if (item.getDni().equals(dni)){
               borrarPersona=item;
               break;
           }
       }
       if (borrarPersona!=null) {
           boolean eliminado = listaPersonas.removeIf(persona -> persona.getDni().equals(dni));
           if (eliminado) {
               System.out.println("Eliminado con exito");
           } else {
               System.out.println("No se encontro ningun contacto con ese DNI");
           }
       }
    }
    public void listarPersona(){
        for(Persona item:listaPersonas){
            System.out.println("Nombre: "+item.getNombre());
            System.out.println("Apellido: "+item.getApellido());
            System.out.println("Nombre: "+item.getCorreo());
            System.out.println("Nombre: "+item.getTelefono());
            System.out.println("DNI: "+item.getDni());
        }
        System.out.println();
    }

}
