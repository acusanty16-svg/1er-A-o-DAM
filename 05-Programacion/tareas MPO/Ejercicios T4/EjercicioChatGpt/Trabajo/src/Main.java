import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> registroVentas = new ArrayList<>();
        BiPredicate<Integer, Double> esVIP = (aniosCliente, gasto)->{
            return aniosCliente > 5 && gasto > 100.00;
        };
        BiFunction<Double, Double, Double> aplicarDescuento = (precioOriginal, descuento)->{
            return (precioOriginal-(precioOriginal*descuento));
        };
        BiConsumer<String, Double> registrar = (nombre, precioFinal)->{
            System.out.println("Cliente: "+nombre+" - "+" Total: "+precioFinal);
            registroVentas.add(nombre);
        };
        String nombre = "Santi";
        int anios = 6;
        double gastoActual = 150.0;
        double precioProducto = 200.0;

        if (esVIP.test(anios, gastoActual)) {
            double finalPrice = aplicarDescuento.apply(precioProducto, 0.20); // 20% desc
            registrar.accept(nombre, finalPrice);
        }

        System.out.println(registroVentas);
    }
    }
