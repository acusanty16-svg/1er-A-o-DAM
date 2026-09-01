import java.util.Scanner;

public class SentenciaFor {
    public void sentenciaFor() {
        //inicial;final;incrementa
/*
        for(int i=0; i<100;i++){

            try {
                System.out.printf("%d",i);
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
} */
        for (int i = 100; i >= 0; i--) {
            if (i % 2 == 0) {
                System.out.println("Numeros pares " + i);
            } else {
                System.out.println("Numeros impares " + i);

            }

        }

    }

    public void tablaMultiplicarNumero(int numero) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Procedemos a escribir la tabla de multiplicar del " + numero);

        for (int i = 0; i < 11; i++) {
            System.out.printf("%d * %d = %d%n", numero, i, numero * i);
        }
    }

    public void todasTablas() {
        for (int i = 1; i < 11; i++) {
            System.out.println("Sacando la tabla del " + i);
            for (int j = 0; j < 11; j++) {
                System.out.printf("\t%d * %d = %d%n", j, i, i * j);
            }
        }
    }

    public void dibujarCuadrado() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i==4){
                    System.out.print("*");
                }else if(j ==0 || j==4){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



    }

    public void palabraPalidromo (){

        String frase = "Hola que tal estas";
        for (int i = 0; i < frase.length(); i++) {
            System.out.print(frase.charAt(i));
        }


    }
}
