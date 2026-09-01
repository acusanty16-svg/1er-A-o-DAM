import java.util.Scanner;

interface Operacion{
    int calcular (int n);
}
public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce el numero que quieres transformar a a cuadrado: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        Operacion cuadrado = (n)->n*n;

        int resultado = cuadrado.calcular(opcion);
        System.out.println("El cuadrado de "+opcion+" es: "+resultado);

        for (int i = 1; i < 5; i++) {
            System.out.println(i+" al cuadrado es: "+cuadrado.calcular(i));
        }

    }
}