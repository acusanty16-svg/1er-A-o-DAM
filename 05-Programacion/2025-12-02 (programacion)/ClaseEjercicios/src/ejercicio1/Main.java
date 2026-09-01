package ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Que tamaño tienen las matrices");
        int tamnio = scanner.nextInt();
        int[][] matriz1 = new int[tamnio][tamnio];
        int[][] matriz2 = new int[tamnio][tamnio];
        int[][] sumaMatrices= new int[tamnio][tamnio];
        for (int i = 0; i < tamnio; i++) {
            for (int j = 0; j < tamnio; j++) {
                matriz2[i][j] = (int) (Math.random()*51);
                matriz1[i][j] = (int) (Math.random()*51);
            }
        }
        System.out.println("Imprimiento matriz 1");
        imprimirArray(matriz1);
        System.out.println("Imprimiento matriz 2");
        imprimirArray(matriz2);

        for (int i = 0; i < tamnio; i++) {
            for (int j = 0; j < tamnio; j++) {
                sumaMatrices[i][j]= matriz1[i][j] + matriz2[i][j];
            }
        }
        System.out.println("Imprimiendo suma");
        imprimirArray(sumaMatrices);
    }
    public static void imprimirArray(int[][] matriz){
        for (int[] fila : matriz) {
            for (int item : fila) {
                System.out.print(item+"\t");
            }
            System.out.println();
        }
    }
}
