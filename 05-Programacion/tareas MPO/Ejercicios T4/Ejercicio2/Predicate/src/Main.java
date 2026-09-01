import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> listaNumeros = new ArrayList<>();
        Predicate<Integer> esPar = n -> n%2==0;
        for (int i = 1; i < 21; i++) {
            listaNumeros.add(i);
        }
        System.out.print("[");
        listaNumeros.stream().filter(esPar).forEach(n->{
            System.out.print(n+", ");
        });
        System.out.print("]");

    }
}