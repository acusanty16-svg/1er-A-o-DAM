import controller.Gestor;
import model.Categoria;
import model.Producto;

import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {
        Producto producto1 = new Producto("TV LG", "001-LG", 300, Categoria.TECNOLOGICO);
        Producto producto2 = new Producto("MOVIL LG", "002-LG", 100, Categoria.MUEBLES);
        Producto producto3 = new Producto("PORTATIL LG", "003-LG", 200, Categoria.MUEBLES);
        Gestor gestor = new Gestor();
       // gestor.agregarProducto(television);
       // gestor.agregarProducto(movil);
        /*try{
            System.out.println(gestor.calcularPrecioMedio().getAsDouble());
        }catch (NoSuchElementException e){
            System.out.println("Error en el calculo de la media");
        }*/
        //System.out.println(gestor.calcularPrecioMedio());
        /*gestor.getProductosPorCondicion((item, val)-> item.getPrecio()> val && item.getCategoria() == Categoria.ROPA
        ,90);
        gestor.getProductosPorCondicion((item, val)-> item.getPrecio()< val && item.getCategoria() == Categoria.TECNOLOGICO
                ,90);*/
        gestor.agregarProducto(producto1);
        gestor.agregarProducto(producto2);
        gestor.agregarProducto(producto3);

        //System.out.println(gestor.getEstadisticas().getMax());
        //gestor.consultarProductos();
        gestor.consultarCositas();
    }
}