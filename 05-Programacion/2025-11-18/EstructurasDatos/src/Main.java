import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        /*
        Cuando hablamos de variables tenemos
        String, int, double, float, boolean


        Estructuras de datos:
        Estatcias: aquellas que no pueden alterar su tamaño
            Array unidimensionales: aquel que solo tiene una fila con "n" columnas
            Array bidimensionales: aquel que tiene "n" filas y en cada una de ellas
            hay "n" columnas, que se llama Matriz

        Dinamicas: aquellas que pueden alterar su tamaño
            Basadas en posiciones: ArrayList
            Basadas en claves: HashMap
        */
        //Array, se puede medir mediante, numero de huecos y mediante elementos
        System.out.println("Cuantos numeros quieres guardar? ");
        //int tamanioNumeros = scanner.nextInt();
        int[] listaNumeros = new int[8];
        //aqui me esta guardando cinco 0
        boolean[] listaAciertos = new boolean[3];
        //aqui me esta guardando tres false
        double[] listaNotas = new double[6];
        //[0.0,0.0,0.0,0.0,0.0,0.0]
        String[] listaNombres = new String[4];
        //[null,null,null,null]
        //cuando hablamos de una variable compleja solamente guarda nulls
        int[] listaNumerosIntroducidos= new int[]{78,23,45,72,24,65};

        System.out.println("El tamaño del array es: "+listaNumeros.length);
        listaNumeros[listaNumeros.length-1] =34;
        listaNumeros[0] = 64;
        listaNumeros[listaNumeros.length/2] = 56;

        System.out.println("Accediendo a posisicones");
        System.out.println("LA posicion 0 es el valor "+listaNumeros[3]);
        System.out.println("LA posicion 0 es el valor "+listaNumeros[1]);
        System.out.println("La posicion 0 es el valor "+listaNumeros[1]);
        System.out.println("Imprimiendo los elementos del array");
       int sumatorio =0;
        /*for (int i = 0; i < listaNumeros.length; i++) {
            listaNumeros[i] = (int) (Math.random()*50);
            System.out.println(listaNumeros[i]);
            sumatorio+=listaNumeros[i];
        }
        System.out.println("El sumatorio del array es: "+sumatorio);*/
        for ( int item : listaNumeros) {
            item = (int) (Math.random()*50);
            System.out.println("Ejecutando valor item "+item);
            sumatorio+=item;
        }
        System.out.println("El sumatorio de los numeros es: "+sumatorio);

    }
}