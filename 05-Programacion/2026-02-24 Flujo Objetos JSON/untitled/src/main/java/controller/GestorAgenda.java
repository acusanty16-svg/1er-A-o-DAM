package controller;

import model.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorAgenda {
    private List<Usuario> contactos;
    private GestorFicheros gestorFicheros;
    public GestorAgenda(){
        contactos = new ArrayList<>();
        this.gestorFicheros = new GestorFicheros();
    }
    public void listarContactos(){
    contactos.forEach(Usuario::mostrarDatos);
    }

    public void agregarUsuario(Usuario usuario){
       Optional<Usuario> usuarioExistente =contactos.stream()
                .filter(item->item.getDni().equalsIgnoreCase(usuario.getDni())).findAny();
       if (usuarioExistente.isPresent()){
           System.out.println("El DNI que intentas agregar ya existe");
       }else {
           contactos.add(usuario);
           System.out.println("Usuario agregado correctamente");
       }
    }
    public void exportarContenido(){
        //contactos.forEach(item->gestorFicheros.exportarUsuario(item));
        gestorFicheros.escribirUsuario(contactos);
    }
    public void importarUsuarios(){
        contactos = gestorFicheros.importarUsuarios();
    }

    public List<Usuario> getContactos() {
        return contactos;
    }

    public void setContactos(List<Usuario> contactos) {
        this.contactos = contactos;
    }

    public GestorFicheros getGestorFicheros() {
        return gestorFicheros;
    }

    public void setGestorFicheros(GestorFicheros gestorFicheros) {
        this.gestorFicheros = gestorFicheros;
    }
}
