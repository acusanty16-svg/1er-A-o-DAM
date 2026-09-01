package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Libro {
    private String titulo, autor;
    private int numeroPaginas;
    private double precio;
    private boolean descuentoRealizado;

    public Libro(){}

    public Libro(String titulo, String autor, int numeroPaginas, double precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.numeroPaginas = numeroPaginas;
        this.precio = precio;
    }

    public void mostrarInfo(){
        System.out.println("El nombre del titulo es: "+titulo);
        System.out.println("El nombre del autor es: "+autor);
        System.out.println("El numero de sus paginas es "+numeroPaginas);
        if (esLibroLargo()){
            System.out.println(titulo+" es un libro largo, bro");
        }
        System.out.println("El precio del titulo es: "+precio);
        if (!descuentoRealizado){
            aplicarDescuento();
        }else{
            System.out.println("El descuento ya fue aplicado anteriormente");
        }

    }
    private boolean esLibroLargo(){
        return numeroPaginas >= 300;
    }
    private void aplicarDescuento(){
        if (esLibroLargo()){
            System.out.println("Genial, acabas de ganar un descuento, porque tu libro es largo");
            double porcentaje= precio*0.10;
            precio= precio-porcentaje;
            System.out.println("Aplicando descuento del 10%");
            System.out.println("Nuevo precio: "+precio);
            descuentoRealizado=true;
        }
    }

}
