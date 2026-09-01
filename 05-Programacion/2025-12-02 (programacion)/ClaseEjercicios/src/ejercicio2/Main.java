package ejercicio2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] numeros= new int[11];
        Scanner scanner=new Scanner(System.in);
        int opcion=0;
        for (int i = 0; i < numeros.length; i++) {
            numeros[i]= (int) (Math.random()*20)+1;
        }
        System.out.println("1-Imprimir el Array");
        System.out.println("2-mover a la izquierda");
        System.out.println("3-mover a la derecha");
        System.out.println("4-Invertir");
        System.out.println("5-Rotar por pares");
        System.out.println("Que opcion quieres hacer");
        do {

            opcion = scanner.nextInt();
            switch (opcion){
                case 1 ->{for (int item : numeros) {
                    System.out.print(item+" ");

                }
                    System.out.println();}
                case 2 ->{
                    int temporal=numeros[0];
                    for (int i = 0; i < numeros.length-1; i++) {
                        numeros[i]=numeros[i+1];
                    }
                    numeros[numeros.length-1]=temporal;
                }
                case 3 ->{
                    int temporal=numeros[numeros.length-1];
                    for (int i = numeros.length-1; i >0; i--) {
                        numeros[i]=numeros[i-1];
                    }
                    numeros[0]=temporal;
                }
                case 4 ->{
                    for (int i = 0; i < numeros.length/2; i++) {
                        int temporal = numeros[i];
                        numeros[i]=numeros[numeros.length-1-i];
                        numeros[numeros.length-1-i]=temporal;
                    }
                }
                case 5 ->{
                    int recorrido;
                    if (numeros.length%2!=0){
                        recorrido=numeros.length-1;
                    }else {
                        recorrido=numeros.length;
                    }
                    for (int i = 0; i < numeros.length; i+=2) {
                        int temporal = numeros[i];
                        numeros[i]=numeros[i+1];
                        numeros[i+1]=temporal;
                    }
                }
            }
        }while(opcion!=6);
    }
}
