import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean opcionValida= false;
        Scanner scanner = new Scanner(System.in);
        while(!opcionValida){
            try{
                System.out.println("Introduce el primer numero: ");
                int primerNumero= scanner.nextInt();
                System.out.println("Introuce el segundo numero: ");
                int segundoNumero = scanner.nextInt();
                System.out.println("Introduce la operacion que deseas realizar: ");
                String operacion = scanner.next();
                switch (operacion){
                    case "+"->{
                        int resultado = primerNumero+segundoNumero;
                        System.out.println("El resultado de la operacion es "+resultado);
                        opcionValida=true;
                    }
                    case "-"->{
                        int resultado = primerNumero-segundoNumero;
                        System.out.println("El resultado de la operacion es "+resultado);
                        opcionValida=true;
                    }
                    case "*"->{
                        int resultado = primerNumero*segundoNumero;
                        System.out.println("El resultado de la operacion es "+resultado);
                        opcionValida=true;
                    }
                    case "/"->{
                        int resultado = primerNumero/segundoNumero;
                        System.out.println("El resultado de la operacion es "+resultado);
                        opcionValida=true;
                    }
                    default -> {
                        System.out.println("Opcion no valida");
                    }
                }

            } catch (InputMismatchException e){
                System.out.println("Introuce un valor correcto");
                scanner.next();
            }catch (ArithmeticException e){
                System.out.println("No se puede dividir por cero");
            }
        }


    }
}