import java.util.Scanner;

public class Bonoloto {
    private int[] numerosSistema = new int[5];
    private int[] numerosUsuario = new int[5];
    private Scanner scanner = new Scanner(System.in);
    private int aciertos =0;
    public void iniciarJuego(){
        for (int i = 0; i < 5; i++) {
            numerosSistema[i] = (int) (Math.random()*21);
        }
        System.out.println("Procedemos a sellar tu boleto");
        for (int i = 0; i < 5; i++) {

            int numeroIntroducido;
            do {
                System.out.println("Introduce el numero con el que quieres jugar: ");
                numeroIntroducido = scanner.nextInt();
                if (numeroIntroducido <0 || numeroIntroducido>20){
                    System.out.println("Incorrecto");
                }
            }while (numeroIntroducido <0 || numeroIntroducido>20);
            numerosUsuario[i] = numeroIntroducido;

        }
        System.out.println("Procedemos a ver las consicidencias del sistema");
        for (int item:numerosUsuario){
            buscarNumero(item);
        }
        System.out.println("Has acertado una cantidad de: "+aciertos);
    }


    public void buscarNumero(int numero){
        for(int item : numerosSistema){
            if(item==numero){
                aciertos++;
                break;
            }
        }
    }
    public void listarNumerosSistema(){
        System.out.println("Los numeros del sistema son: ");
        for (int numero : numerosSistema){
            System.out.println(numero);
        }

    }
    public void listarNumerosUsuario(){
        for (int item:numerosUsuario){
            System.out.println(item);
        }
    }
}
