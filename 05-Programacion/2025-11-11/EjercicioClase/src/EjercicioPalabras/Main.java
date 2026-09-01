package EjercicioPalabras;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica la frase que quieres analizar: ");
        String frase = scanner.nextLine();
        System.out.println("La frase es "+frase);
        String[] frases =frase.split("\\.");
        String frasePalabra =frase.replaceAll(" ", "")
                .replaceAll(",", "").replaceAll("\\.", "");
        String palabrasFrase = frase.replaceAll(",", " ").replaceAll("\\.", " ");
        String [] palabras = palabrasFrase.split(" ");

        System.out.println("EL numero de oraciones es "+frases.length);
        System.out.println("El numero de letras es "+frasePalabra.length());
        System.out.println("El resultado es "+frasePalabra);
        System.out.println("El numero de palabras es: "+palabras.length);
        for (String item:frases){
            int contador = item.split(" ").length;
            System.out.println("El numero de palabras de la oracion es: "+contador);
        }
    }
}