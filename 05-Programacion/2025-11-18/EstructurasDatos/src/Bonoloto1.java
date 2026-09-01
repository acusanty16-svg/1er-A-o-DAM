import java.util.Scanner;

public class Bonoloto1 {
    Scanner scanner = new Scanner(System.in);
    private int numeroSistema[] = new int[5];
    private int numeroJugador[] = new int[5];
    private int sumando=0;
    public void jugar() {
        System.out.println("----EMPIEZA EL JUEGO----");
        System.out.println("Introduce 5 numeros: \n");
        for (int i = 0; i < 5; i++) {
            int numeroIntroducido;
            do {
                System.out.println("Introduce el numero con el que quieres jugar: ");
                numeroIntroducido = scanner.nextInt();
                if (numeroIntroducido < 0 || numeroIntroducido > 20) {
                    System.out.println("Numero incorrecto");
                }
            } while (numeroIntroducido < 0 || numeroIntroducido > 20);
            numeroJugador[i] = numeroIntroducido;
        }
        for (int i = 0; i < 5; i++) {
            numeroSistema[i] = (int) (Math.random() * 21);
        }
        System.out.println("\n----VERIFICANDO COINCIDENCIAS----");
        for(int item:numeroJugador){
            coincidencias(item);
        }
        System.out.println("El numero de aciertos totales es: "+sumando);

    }

    public void coincidencias(int numero){
        for(int item:numeroSistema){
            if (item==numero){
                sumando++;
                break;
            }
        }

    }
    public void mostrarNumerosJugador(){
    for(int item: numeroJugador){
        System.out.println(item);
    }
    }
    public void mostrarNumerosMaquina(){
        for(int item:numeroSistema){
            System.out.println(item);
        }
    }

}