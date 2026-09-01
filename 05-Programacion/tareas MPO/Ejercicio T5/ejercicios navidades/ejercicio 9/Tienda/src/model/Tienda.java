package model;

import java.util.ArrayList;

public class Tienda {
    private String nombre;
    private ArrayList<Producto> listaProductos;
    private int numProductos;

    public Tienda() {
        listaProductos = new ArrayList<>();
    }

    public Tienda(String nombre, ArrayList<Producto> listaProductos) {
        this.nombre = nombre;
        this.listaProductos = listaProductos;
    }

    public boolean agregarProducto(Producto producto){
        if (listaProductos.size()<50){
            listaProductos.add(producto);
            System.out.println("Producto agregado correctamente");
            return true;
        }else {
            System.out.println("Producto no agregado porque no hay espacio");
            return false;
        }
    }
    public Producto buscarProducto(String codigo){
        for(Producto producto:listaProductos){
         if (producto.getCodigo().equals(codigo)){
             return producto;
         }
        }
        System.out.println("No hemos encontrado el producto dentro de la tienda");
        return null;
    }
    public void listarProductos(){
        for(Producto producto:listaProductos){
            producto.mostrarInformacion();
        }
    }
    public double calcularValorTotalInventario(){
        double contador =0;
            for (Producto producto:listaProductos){
                contador+=producto.getPrecio();
            }
            return contador;
    }
    public void listarProductosSinStock(){
        boolean haySinStock=false;
        for(Producto producto:listaProductos){
            if (producto.getStock()==0){
                System.out.println("Producto agotado: " + producto.getNombre());
                haySinStock=true;
            }
        }
        if (!haySinStock){
            System.out.println("Los elementos tienen Stock");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }

    public int getNumProductos() {
        return numProductos;
    }

    public void setNumProductos(int numProductos) {
        this.numProductos = numProductos;
    }
}
