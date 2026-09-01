package controller;


import model.Audio;
import model.Elemento;
import model.Libro;
import model.Video;

import java.util.ArrayList;


public class GestionMultimedia {

  private ArrayList<Elemento> listaElementos;

  public GestionMultimedia(){
      listaElementos=new ArrayList<>();

  }
  public void aniadirElemento(Elemento elemento){
      listaElementos.add(elemento);
      System.out.println("Libro añadido correctamente: "+elemento.getTitulo());
  }


  public void eliminarElemento(int id){
      Elemento elementoAEliminar = null;
      for (Elemento elemento:listaElementos){
          if (elemento.getId()==id){
              elementoAEliminar=elemento;
              break;
          }
      }
      if (elementoAEliminar!=null){
          String elementoBorrado = elementoAEliminar.getTitulo();
          listaElementos.remove(elementoAEliminar);
          System.out.println("El elemento: "+elementoBorrado+" ha sido borrado correctamente");
      }else{
          System.out.println("El id: "+id+" no existe dentro de la multimedia");
      }
  }
  public void listarElementos (){
      for(Elemento elemento:listaElementos){
          if (elemento instanceof Video){
              elemento.mostrarDatos();
          }
          if (elemento instanceof Audio){
              elemento.mostrarDatos();
          }
          if (elemento instanceof Libro){
              elemento.mostrarDatos();
          }
      }
  }


    public ArrayList<Elemento> getListaElementos() {
        return listaElementos;
    }

    public void setListaElementos(ArrayList<Elemento> listaElementos) {
        this.listaElementos = listaElementos;
    }
}
