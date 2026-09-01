import java.util.Scanner;

public class MainBonoloto1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraVez = false;
        do {
            Bonoloto1 bonoloto1 = new Bonoloto1();
            bonoloto1.jugar();
            System.out.println("los numeros del jugador son: ");
            bonoloto1.mostrarNumerosJugador();
            System.out.println("Los numeros de la maquina son: ");
            bonoloto1.mostrarNumerosMaquina();
            System.out.println("Quieres volver a jugar?");
            jugarOtraVez = scanner.nextBoolean();
        }while(jugarOtraVez);


    }
}
