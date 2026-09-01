package controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import model.Contacto;

import java.util.ArrayList;
@Getter
@Setter
public class AgendaContacto {
    private ArrayList<Contacto> listaContactos;
    private int id;

    public AgendaContacto(){
    listaContactos = new ArrayList<>();
    id=1;
    }

    public void agregarContacto(Contacto contacto){
        if (estaContacto(contacto.getDni())==null){
            listaContactos.add(contacto);
            contacto.setId(id);
            id++;
            System.out.println("Agregado correctamente");
        }else{
            System.out.println("No se puede agregar dni duplicado");
        }
    }

    private Contacto estaContacto(String dni){
        for(Contacto item:listaContactos){
            if(item.getDni().equals(dni)){
                return item;
            }
        }
        return null;
    }

    public void borrarContacto(String dni){
        Contacto contacto = estaContacto(dni);
        if (contacto!=null){
            listaContactos.remove(contacto);
            System.out.println("Borrado correctamente");
        }else{
            System.out.println("Contacto no encontrado, no se puede borrar");
        }
    }
    public void buscarContacto(String dni){
        Contacto contacto = estaContacto(dni);
        if (contacto!=null){
            contacto.mostrarDatos();
        }else{
            System.out.println("Contacto no encontrado");
        }
    }
    public void listarContactos(){
        for(Contacto contacto:listaContactos){
            contacto.mostrarDatos();
        }
    }
    public void vaciarLista(){
        listaContactos.clear();
    }
}

