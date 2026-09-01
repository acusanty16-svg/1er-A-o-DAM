package ejercicio2Borja;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int intentos = 5, numeroAcierto =0, numeroAprox =0, numeroFallos =0;
        String palabrasSistema= "frase", palabraUsuario;
        Scanner scanner = new Scanner(System.in );
        do {
            System.out.println("Introduce una palabra ");
            palabraUsuario = scanner.next();
            intentos--;
            numeroAprox=0; numeroFallos=0; numeroAcierto=0;
            for (int i = 0; i < palabrasSistema.length(); i++) {
                if (palabrasSistema.equals(palabraUsuario)){
                    numeroAcierto=5;
                    break;
                }
                else if (palabrasSistema.charAt(i) == palabraUsuario.charAt(i)){
                    numeroAcierto++;
                } else if (palabrasSistema.contains(String.valueOf(palabraUsuario.charAt(i)))) {
                    numeroAprox++;
                }else{
                    numeroFallos++;
                }

            }
            System.out.println("Los aciertos en este intento son: "+numeroAcierto);
            System.out.println("Los aciertos en este aproximaciones son: "+numeroAprox);
            System.out.println("Los aciertos en este fallos son: "+numeroFallos);

        }while(intentos > 0 && numeroAcierto<5);
        if(intentos==0){
            System.out.println("Has perdido. Suerte a la proxima campeon");
        }
        if (numeroAcierto==5){
            System.out.println("Has ganado. Eres la leche campeon");
        }
    }
}
