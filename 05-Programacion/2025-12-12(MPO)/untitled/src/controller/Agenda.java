package controller;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Agenda {
    private ArrayList<Object []> listaContactos;

    public Agenda(){
        listaContactos= new ArrayList<>();
    }
    public void agregarContacto (Object[] contacto){
        listaContactos.add(contacto);
        System.out.println("Contacto agregado correctamente");
    }
    public void buscarContacto(String dni){
        for(Object[] item:listaContactos){
            if (item[2].equals(dni)){
                System.out.println("Contacto encontrado");
                System.out.println("Nombre: "+item[0]);
                System.out.println("Apellido: "+item[1]);
                System.out.println("Correo: "+item[3]);
                System.out.println("telefono: "+item[4]);
                return;
            }
        }
        System.out.println("Contacto no encontrado");
    }
    public void borrarContacto(String dni){
       boolean borrado= listaContactos.removeIf(new Predicate<Object[]>() {
           @Override
           public boolean test(Object[] objects) {
               return objects[2].equals(dni);
           }
       });
       if(borrado){
           System.out.println("Contacto borrado correctamente");
       }else{
           System.out.println("Contacto no encontrado");
       }

       /* for(Object[] item:listaContactos){
            if (item[2].equals(dni)){
                listaContactos.remove(item);
                return;
            }
        }
        System.out.println("Contacto no encontrado");*/
    }
    public void listarContacto(){
        for(Object[] item:listaContactos){
                System.out.println("Contacto encontrado");
                System.out.println("Nombre: "+item[0]);
                System.out.println("Apellido: "+item[1]);
                System.out.println("Dni: "+item[2]);
                System.out.println("Correo: "+item[3]);
                System.out.println("telefono: "+item[4]);
                return;
        }
        System.out.println();
    }

    public ArrayList<Object[]> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(ArrayList<Object[]> listaContactos) {
        this.listaContactos = listaContactos;
    }
}
