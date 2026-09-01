import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        ArrayList<Integer> listaCosas = new ArrayList<>();
        System.out.println("El tamaño es de "+listaCosas.size());
        listaCosas.add(5);
        listaCosas.add(15);
        listaCosas.add(25);
        System.out.println("El tamaño es de "+listaCosas.size());
        listaCosas.remove(1);
        System.out.println("El elemento es posicion 1 es: "+listaCosas.get(1));
        System.out.println("El tamaño es de "+listaCosas.size());


        /* int numero =2;
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[]{21,12,33,14,25,6,17};
        String[] palabras = new String[]{"programacion","hola","elemento","curiosidad","adios","ordenacion","cuiasbkadbslfgiadbfg"};
        //Arrays.sort(numeros);
       // Arrays.sort(palabras);

        Arrays.sort(palabras, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1.length()>o2.length())&& o1.contains("a") ){
                    return -1;
                }else if (o1.length()<o2.length()){
                    return 1;
                }
                return 0;
            }
        });
        numeros = Arrays.copyOf(numeros,numeros.length+1);
        for(String item:palabras){
            System.out.println(item);
        }
        /*System.out.println("Indica que numero queires eleminar");
        int numeroBorrar = scanner.nextInt();
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i]==numeroBorrar){
                numeros[i]=-1;
                break;
            }
        }
        for(int item:numeros){
            System.out.println(item);
        }*/
    }
}