package model;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Usuario> listaUsuarios;

    public Agenda(){
        this.listaUsuarios = new ArrayList<>();
    }
    public Agenda(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
}
