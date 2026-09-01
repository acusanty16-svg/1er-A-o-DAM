import java.util.Arrays;
import java.util.Comparator;

public class Main{
    public static void main(String[] args) {
        int[] numeros = {15, 8, 23, 4, 19, 12};
        String[] palabras = {"hola","adios","cosa","palabra","programacion"};
        Arrays.sort(palabras, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){
                    return 1;
                }else if (o1.length()<o2.length()){
                    return -1;
                }
                return 0;
            }
        });
        for (String item : palabras) {
            System.out.println(item);
        }
   /* int max=numeros[0],min=numeros[0];
    for(int item:numeros){
        if (item>max){
            max=item;
        }
        if (item<min){
            min=item;
        }
    }
        for (int item : numeros) {
            System.out.print(item+"\t");
        }
    }*/
        //hace la ordenacion numericamente
        /*String maxPal=palabras[0],minPal=palabras[0];
        for (String item : palabras) {
            if (item.length()>maxPal.length()){
                maxPal=item;
            }
            if (item.length()<minPal.length()){
                minPal=item;
            }
        }
        Arrays.sort(numeros);
        Arrays.sort(palabras, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()>o2.length()){

                    return 1;
                }else {
                    return -1;
                }
            }
        });
        int min=numeros[0], max=numeros[numeros.length-1];
        System.out.println("max = "+max);
        System.out.println("min = "+min);*/
    }
}