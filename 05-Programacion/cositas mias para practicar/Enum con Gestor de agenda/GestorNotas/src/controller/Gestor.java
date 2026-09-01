package controller;

import model.Producto;

import java.util.ArrayList;
import java.util.List;

public class Gestor {
    private List<Producto> listaProductos;

    public Gestor() {
        listaProductos = new ArrayList<>();
    }
    public void agregarProductos(Producto producto){
       boolean existe = listaProductos.stream().anyMatch(item->item.getCodigo()
               .equalsIgnoreCase(producto.getCodigo()));
       if (existe){
           System.out.println("El producto ya esta registrado");
       }else {
           System.out.println(producto.getNombre()+" agregado correctamente");
           listaProductos.add(producto);
       }

    }
    public void asignarPrecios (){
        listaProductos.stream().filter(item->item.getPrecio()<0)
                .forEach(item-> {
                    item.setPrecio((Math.random()*100)+1);
                    System.out.printf("El nuevo precio de %s es:  %.2f$%n ",item.getNombre(),item.getPrecio());
                });

    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(List<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
