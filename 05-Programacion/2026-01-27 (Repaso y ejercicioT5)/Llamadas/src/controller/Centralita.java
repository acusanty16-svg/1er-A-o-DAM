package controller;

import model.Llamada;
import model.LlamadaNacional;
import model.Tarificable;

import java.util.ArrayList;

public class Centralita {
    private ArrayList<Llamada> listaLlamadas;
    private double caja;

    public Centralita () {
        listaLlamadas = new ArrayList<>();
    }
    public void registrarLlamada(Llamada llamada){
        listaLlamadas.add(llamada);
       /* if (llamada instanceof Tarificable){
            ((Tarificable) llamada).calcularCoste();
        }*/
        this.caja += llamada.getCoste();
    }

    public void mostrarLlamadas(){
       // listaLlamadas.forEach(item->item.mostrarDatos());
        if (!listaLlamadas.isEmpty()){
            listaLlamadas.forEach(Llamada::mostrarDatos);
        }else {
            System.out.println("Esta vacia");
        }
    }

    public ArrayList<Llamada> getListaLlamadas() {
        return listaLlamadas;
    }

    public void setListaLlamadas(ArrayList<Llamada> listaLlamadas) {
        this.listaLlamadas = listaLlamadas;
    }

    public double getCaja() {
        return caja;
    }

    public void setCaja(double caja) {
        this.caja = caja;
    }
}
