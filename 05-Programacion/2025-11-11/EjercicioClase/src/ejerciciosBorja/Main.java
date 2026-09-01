package ejerciciosBorja;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int intentos = 7;
        int numeroSistema = (int) (Math.random()*50)+1;
        boolean acertado=false;
        System.out.println("EL numero de adivinacion es: "+numeroSistema);
        do {
            System.out.println("Introduce el numero para ver si aciertas: ");
            int numeroAzar = scanner.nextInt();
            intentos--;
            if (numeroSistema == numeroAzar){
                System.out.println("Numero acertado");
                acertado = true;
                break;
            }
            System.out.println("Vas por el intento numero "+intentos);
            if (numeroAzar > numeroSistema){
                System.out.println("Numero mas pequeño");
            }else{
                System.out.println("Numero mas grande");
            }
        }while(intentos > 0);

        if(!acertado){
            System.out.println("Has perdido, suerte a la proxima chaval");
        }else {
            System.out.println("Eres el mejor, has ganado");
        }
        System.out.printf("Terminando el juego con %d intentos",7-intentos);
    }
}
