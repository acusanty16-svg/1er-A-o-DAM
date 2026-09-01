package model;

import java.util.HashMap;

public class Agenda {
    private HashMap<String,Integer> listaContactos;

    public Agenda (){
        this.listaContactos = new HashMap<>();
    }
    public void agregarContacto (String nombre, int telefono){
        if (!listaContactos.containsKey(nombre)){
            listaContactos.put(nombre, telefono);
        }else {
            System.out.println("El usuario ya esta registrado en el sistema");
        }
    }
    public void buscarContacto (String nombre){
        if(listaContactos.containsKey(nombre)){
            System.out.println("Nombre: "+nombre+" | Telefono: "+listaContactos.get(nombre));
        }else {
            System.out.println("EL nombre introducido es incorrecto");
        }
    }
    public void eliminarContacto (String nombre){
        if (!listaContactos.containsKey(nombre)){
            System.out.println("El usuario no se encuentra dentro del HashMap");
        }else{
            listaContactos.remove(nombre);
        }
    }
    public void listarContactos () {
        listaContactos.forEach((nombre, telefono)->{
            System.out.println("EL nombre del contacto es: "+nombre+" y su telefono es: "+telefono);
        });
    }
    public void contarContactos () {
        System.out.println("EL numero de total de contactos es: "+listaContactos.size());
    }
    public boolean estaContacto (String nombre){
        if (!listaContactos.containsKey(nombre)){
            System.out.println("EL usuario no se encuentra dentro de la lista");
            return false;
        }else {
            System.out.println("El usuario tiene nombre "+nombre+" y su telefono es: "+listaContactos.get(nombre));
            return true;
        }
    }

    public HashMap<String, Integer> getListaContactos() {
        return listaContactos;
    }

    public void setListaContactos(HashMap<String, Integer> listaContactos) {
        this.listaContactos = listaContactos;
    }
}
