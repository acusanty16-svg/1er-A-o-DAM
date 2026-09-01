import java.util.Scanner;

public class SentenciaWhile {
    public void evaluacionNumero (){
        Scanner scanner = new Scanner(System.in);
        int aleatorio =(int)(Math.random()*11);
        System.out.println("******El numero generado es: "+aleatorio);
        System.out.println("Introduce un numero");
        int numero = scanner.nextInt();
        int intentos = 0;
        intentos++;
        while(aleatorio!=numero){
            System.out.println("Intento fallido, por favor intentalo de nuevo");
            numero = scanner.nextInt();
            intentos++;
        }

        System.out.printf("Numero acertado, el numero en %d intentos",intentos);
    }

    public void imprimirMenu(){
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;
        do{

            System.out.println("1- Suma");
            System.out.println("2- Resta");
            System.out.println("3- Multiplicacion");
            System.out.println("4- Division");
            System.out.println("5- Salir");
            System.out.println("Indica que operacion quieres realizar");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Opcion selecionada suma");
                }
                case 2->{System.out.println("Opcion selecionada resta");}
                case 3->{System.out.println("Opcion selecionada multiplicacion");}
                case 4->{System.out.println("Opcion selecionada division");}
                case 5->{
                    System.out.println("Saliendo....");
                }
                default ->{
                    System.out.println("opcion no contemplada ");
                }
            }
        }while(opcion!=5);

        System.out.println("finalizando la ejecucion");
    }

}
