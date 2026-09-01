package model;

public class Producto {
    private String codigo, nombre;
    private double precio;
    private int stock;

    public Producto(){}

    public Producto(String codigo, String nombre, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public boolean hayStock(){
        if (stock>0){
            System.out.println("La cantidad de elementos dentro de la tienda es: "+stock);
            return true;
        }else {
            System.out.println("No hay mas stock en la tienda");
        }
        return false;
    }
    public boolean vender(int cantidad){
        if (cantidad>0 && stock>=cantidad){
            stock-=cantidad;
            System.out.println("Unidades vendidas: "+cantidad+". Unidades restantes: "+stock);
            return true;
        }else {
            System.out.println("Venta fallida. Stock insuficiente para vender " + cantidad + " unidades.");
        }
        return false;
    }
    public void reAbastecer(int cantidad){
        stock+=cantidad;
        System.out.println("Se han reabastecido: "+cantidad+". En stock hay: "+stock);
    }
    public double calcularValorInventario(){
        double valorInventario = stock*precio;
        System.out.println("El calor del inventario es: "+valorInventario);
        return valorInventario;
    }
    public void mostrarInformacion(){
        System.out.println("nombre = " + nombre);
        System.out.println("codigo = " + codigo);
        System.out.println("precio = " + precio);
        System.out.println("stock = " + stock);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
