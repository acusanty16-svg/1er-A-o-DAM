import java.sql.SQLOutput;
import java.util.Scanner;

public class EntradaDatos {
    public void trabajoNavidad(){
        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();
        int numeroMatriz=0;
        int contador=0;
        int opcion;
        do {
            System.out.println("---BIENVENIDO AL CUADRO MAGICO BORJA---");
            System.out.println("Selecciona la opcion que quieres para jugar:");
            System.out.println("1.Generar un cubo magico");
            System.out.println("2.Mostrar mas opciones");
            System.out.println("3.Salir");
            System.out.print("Eleccion: ");
            opcion=scanner.nextInt();
            switch (opcion){
                case 1-> {
                    System.out.println("!!Genial¡¡ Has escogido: Generar un cubo magico");
                    System.out.print("\n Introduce el tamaño de la matriz (minimo 3): ");
                    numeroMatriz = scanner.nextInt();
                    if (numeroMatriz >= 3) {
                        controller.inicializarMatriz(numeroMatriz);
                        int contadorIntentos = 0;
                        boolean encontrado = false;
                        System.out.println("Buscando cuadro magico... Puede tardar para n>=4");
                        while (!encontrado) {
                            controller.rellenarNumeros();
                            contadorIntentos++;
                            if (controller.esMagico()) {
                                encontrado = true;
                            }
                            if (contadorIntentos%5000000==0){
                                System.out.println("Llevo "+contadorIntentos+" intentos...");
                            }
                        }
                        System.out.println("\n¡Encontrado!");
                        System.out.println("Constante magica "+controller.constanteMagica());
                        System.out.println("Total de intentos: " + contadorIntentos);
                        System.out.println("---------------------------------");
                        controller.mostrarNumeros();
                        return;
                    } else {
                        System.out.println("Error: El tamaño mínimo para un cuadrado mágico es 3.");
                    }
                }
                case 2->{
                    System.out.println("No hay ninguna otra opcion jeje. Es jugar o salir");
                }
                case 3->{
                    System.out.println("Saliendo del juego...");
                }
                default -> {
                    System.out.println("Opcion no valida, intenta de nuevo");
                }
            }

        }while(opcion != 3);
    }
}
