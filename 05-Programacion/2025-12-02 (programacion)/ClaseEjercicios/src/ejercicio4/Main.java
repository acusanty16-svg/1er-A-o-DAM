package ejercicio4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String [] bombo1= new String[5];
        String [] bombo2= new String[5];
        for (int i = 0; i < 2; i++) {
            System.out.println("Equipos del bombo "+i+1);
            for (int j = 0; j < bombo1.length; j++) {
                System.out.println("Indica la seleccion");
                String seleccion = scanner.next();
                if (i==0){
                    bombo1[j]=seleccion;
                }else {
                    bombo2[j]=seleccion;
                }
            }
        }
        System.out.println("Imprimiendo bombo1");
        imprimiendoBombo(bombo1);
        System.out.println("Imprimiendo bombo2");
        imprimiendoBombo(bombo2);


    }
    public static void imprimiendoBombo(String[]bombo){
        for (String item : bombo) {
            System.out.println(item);
        }
    }
}
