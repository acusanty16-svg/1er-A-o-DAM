package ejercicio4Borja;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador 1: ");
        String nombreJugador1 = scanner.nextLine();
        System.out.println("Introduce el nombre del jugador 2: ");
        String nombreJugador2 = scanner.nextLine();

        int puntos1 = 301, puntos2 =301, turnos = 0, puntosTurno;


        do {
            System.out.println("\n---EMPIEZA EL JUEGO---");
            //turno del jugador 1.
            turnos++;
            System.out.printf("Turno %d de %s%n",turnos,nombreJugador1);
            puntosTurno=0;
            for (int i = 0; i < 3; i++) {
                int dardo = (int) (Math.random()*61);
                puntosTurno+=dardo;
                System.out.printf("Dardo %d: %d%n",i,dardo);
            }
            System.out.printf("Puntuacion del turno es: %d%n",puntosTurno);
            int resultado = puntos1-puntosTurno;
            if(resultado<0){
                System.out.println("Te has pasado no te sumamos esta ronda.");
            } else if (resultado==0) {
                puntos1=0;
                System.out.println("Enhorabuena chavar, has ganado");
            }else{
                puntos1=resultado;
                System.out.println("Puntuacion actualizada: "+puntos1);
            }
            //turno del jugador 2
            System.out.printf("\nTurno %d de %s%n",turnos,nombreJugador2);
            puntosTurno =0;
            for (int i = 0; i < 3; i++) {
                int dardo = (int) (Math.random() * 61);
                puntosTurno += dardo;
                System.out.printf("Dardo %d: %d%n", i, dardo);
            }
            System.out.printf("Puntuacion del turno es: %d%n",puntosTurno);
            resultado = puntos2-puntosTurno;
            if(resultado<0){
                System.out.println("Te has pasado no te sumamos esta ronda.");
            } else if (resultado==0) {
                puntos2=0;
                System.out.println("Enhorabuena chavar, has ganado");
            }else{
                puntos2=resultado;
                System.out.println("Puntuacion actualizada: "+puntos2);
            }
        }while(puntos1 !=0 && puntos2!=0);
        if(puntos1 ==0){
            System.out.println("Eres lo mejor, te ganaste un pico en el siempre sucio");
        }else{
            System.out.println("Eres lo mejor, te ganaste un pico en el siempre sucio");
        }

    }
}