package controller;

import model.Partido;

import java.util.ArrayList;

public class Registrador {
    private ArrayList<Partido> listaPartidos;

    public Registrador (){
        this.listaPartidos=new ArrayList<>();
    }
    public void anadirPartidos(Partido partido){
        this.listaPartidos.add(partido);
    }
    public void jugarAplazados(){
        for(Partido partido:listaPartidos){
            if (!partido.isJugado()){
                partido.jugarPartido();
            }
        }
    }
    public void mostrarPartidos(String nombre){
        for(Partido partido:listaPartidos){
            if (partido.isJugado() && (partido.getEquipolocal().getNombre().equals(nombre) || partido.getEquipoVisitante().getNombre().equals(nombre))) {
            partido.mostrarDatos();
            }
        }
    }
    public void mostrarEstadisticas(String nombre){
        for(Partido partido:listaPartidos){
            if (partido.getEquipolocal().getNombre().equals(nombre)){
                partido.getEquipolocal().mostrarEstadisticas();
                return;
            }else if (partido.getEquipoVisitante().getNombre().equals(nombre)){
                partido.getEquipoVisitante().mostrarEstadisticas();
                return;
            }
        }
    }
    public void mostrarPartidos(){
        for(Partido partido:listaPartidos){
            partido.mostrarDatos();
        }
    }
}
