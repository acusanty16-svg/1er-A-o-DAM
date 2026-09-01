import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce el primer numero que quieres dividir");
        Scanner scanner = new Scanner(System.in);
        int primerNumero= scanner.nextInt();
        System.out.println("Introduce el segundo numero:");
        int segundoNumero= scanner.nextInt();
        try{
            int resultado= primerNumero/segundoNumero;
        } catch (ArithmeticException e) {
            System.out.println("Error: no se puede dividir por cero");;
        }
    }
}