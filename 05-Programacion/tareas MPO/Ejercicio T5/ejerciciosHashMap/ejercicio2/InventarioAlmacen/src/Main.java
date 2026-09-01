import model.Almacen;

public class Main {
    public static void main(String[] args) {
        Almacen almacen = new Almacen();
        almacen.agregarProducto("12345k",4);
        almacen.listarElementos();
        almacen.agregarProducto("12345k",10);
        almacen.listarElementos();
    }
}