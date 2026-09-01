package ejercicio3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        double[] notas = new double[10];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < notas.length; i++) {
            double nota;
            do {
                System.out.println("Indicame la nota del alumno");
                nota = scanner.nextDouble();
                if(nota<0.0 || nota>10.0){
                    System.out.println("Invalida");
                }
            }while(nota<0.0 || nota>10.0);
            notas[i]=nota;
        }
        int suspensos=0, aprobados=0;
        double media=0, acumulador=0;
        for (double item : notas) {
            if (item<5){
                suspensos++;
            }else {
                aprobados++;
            }
            acumulador+=item;
        }
        System.out.println("suspensos "+suspensos);
        System.out.println("aprobados "+aprobados);
        System.out.println("media "+acumulador/notas.length);
    }
}
