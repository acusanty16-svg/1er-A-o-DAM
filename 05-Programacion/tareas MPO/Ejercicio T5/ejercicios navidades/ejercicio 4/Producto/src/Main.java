import model.Producto;

public class Main {
    public static void main(String[] args) {
        Producto p1 = new Producto("P001", "Laptop Gaming", 1200.50, 5);

        System.out.println("--- Intento de venta mayor al stock ---");
        p1.vender(10);

        System.out.println("\n--- Venta válida ---");
        p1.vender(3);

        System.out.println("\n--- Reabastecimiento ---");
        p1.reAbastecer(8);

        System.out.println("\n--- Resumen de inventario ---");
        p1.mostrarInformacion();
        p1.calcularValorInventario();
    }
}