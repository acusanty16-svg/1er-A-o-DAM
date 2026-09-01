import org.w3c.dom.ls.LSOutput;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numeros = new int []{1,2,3,4,5,6,7};
        System.out.print("Array: [");
        for (int i = 0; i < numeros.length; i++) {
            System.out.print(numeros[i]);
            if (i<numeros.length-1){
                System.out.print(", ");
            }
        }
        System.out.print("]");
        System.out.println("\nIntroduce la posicion del array que quieres tener: ");
        Scanner scanner = new Scanner(System.in);
        try{
            int opcion =scanner.nextInt();
            System.out.println("El numero del array es: "+numeros[opcion]);
        }catch (IndexOutOfBoundsException e){
            System.out.println("El array esta fuera del rango establecido");
        } catch (InputMismatchException e) {
            System.out.println("Introduce un numero no una letra");;
        }catch (Exception e){
            System.out.println("Ha ocurrido un error y no se ha podido completar el resultado");
        }finally {
            scanner.close();
            System.out.println("Programa finalizado");
        }

    }

}