package model;

import java.util.HashMap;

public class Almacen {
    private HashMap<String, Integer> listaAlmacen;

    public Almacen() {this.listaAlmacen = new HashMap<>();}

    public void agregarProducto ( String codigo, int cantidad){
       if (listaAlmacen.containsKey(codigo)){
           listaAlmacen.put(codigo,listaAlmacen.get(codigo)+cantidad);
           System.out.println("Stock actualizado. Nuevo total: "+listaAlmacen.get(codigo));
       }else {
           listaAlmacen.put(codigo,cantidad);
           System.out.println("Producto nuevo registrado");
       }

    }
    public boolean venderProducto (String codigo, int cantidad){
        if (listaAlmacen.containsKey(codigo)){
            if (listaAlmacen.get(codigo) >=cantidad){
                listaAlmacen.put(codigo, listaAlmacen.get(codigo)-cantidad);
                System.out.println("Venta realizada. Nuevo total: "+listaAlmacen.get(codigo));
                return true;
            }else{
                System.out.println("No te podemos vender todos esos elementos, te podemos vender: "+listaAlmacen.get(codigo));
                listaAlmacen.put(codigo,0);
                System.out.println("El Stock ha quedado en 0");
                return true;
            }
        }else{
            System.out.println("No existe el elemento dentro del almacen");
            return false;
        }
    }
    public Integer consultarStock ( String codigo, int cantidad){
        if (listaAlmacen.get(codigo)>=0) {

        }
    }

    public void listarElementos () {
        listaAlmacen.forEach((nombre, cantidad)->{
            System.out.println("EL nombre del producto es: "+nombre+" | Su cantidad es: "+cantidad);
        });
    }


    public HashMap<String, Integer> getListaAlmacen() {
        return listaAlmacen;
    }

    public void setListaAlmacen(HashMap<String, Integer> listaAlmacen) {
        this.listaAlmacen = listaAlmacen;
    }
}
