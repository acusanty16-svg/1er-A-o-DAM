import Util.ResultadoExcepcion;
import model.Operaciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainThrow {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, ArithmeticException {
        Scanner scanner = new Scanner(System.in);
        Operaciones operaciones = new Operaciones();
        int [] numeros = new int[]{1,2,3,4,5,6,7};
        int op1=0, op2=0;
        boolean fallo = false;
do {
    try {
        System.out.println("Introduce el numero 1");
        op1 = scanner.nextInt();
        System.out.println("Introduce el numero 2");
        op2 = scanner.nextInt();
        System.out.println("Pasamos a calcular los datos");
        int suma = operaciones.operarSuma(op1, op2);
        int resta = operaciones.operarResta(op1, op2);
        int multiplicacion = operaciones.operarMulti(op1, op2);
        int division = operaciones.operarDivi(op1, op2);
        // System.out.println(numeros[70]);
        System.out.println("Los resultados son:");
        String resultados = null;
        System.out.println("la suma es: " + suma);
        System.out.println("la resta es: " + resta);
        System.out.println("la multiplicacion es: " + multiplicacion);
        System.out.println("La division es " + division);
        System.out.println("Terminando la calculadora");
        fallo=false;
    }catch (ArithmeticException | InputMismatchException e){
        scanner = new Scanner(System.in);
        System.out.println("Error en division");
        fallo=true;
    }catch (ResultadoExcepcion e){
        System.out.println(e.getMessage());
        int temporal =op1;
        op1 = op2;
        op2=temporal;
        fallo=true;
        System.out.println("La resta es: "+(op1-op2));
    }
    catch (Exception e){
        System.out.println("Generico");
        fallo=false;
    }
}while (fallo);
    }
}
