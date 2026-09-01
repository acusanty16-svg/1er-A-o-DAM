import java.util.Scanner;

public class SolucionBorja {

    public void ejercicio3() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el numero de 5 digitos: ");
        int numeroAnalizar = scanner.nextInt();
        if (numeroAnalizar > 9999 && numeroAnalizar < 100000) {
            int decenasMil = numeroAnalizar / 10000;
            int unidadesMil = (numeroAnalizar % 10000) / 1000;
            int centenas = ((numeroAnalizar % 1000) % 1000) / 100;
            int decenas = (((numeroAnalizar % 1000) % 1000) % 100) / 10;
            int unidades = (((numeroAnalizar % 1000) % 1000) % 100) % 10;
        } else {
            System.out.println("numero incorrecto");
        }
    }
    public void ejercicio31() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Indica el numero de 5 digitos: ");
        int numeroAnalizar = scanner.nextInt();
        if (numeroAnalizar > 9999 && numeroAnalizar < 100000) {
            //98342 --> "98342"
            String numeroPalabra = String.valueOf(numeroAnalizar);
            String decenasMil =String.valueOf(numeroPalabra.charAt(0));
            String centenasMil =String.valueOf(numeroPalabra.charAt(1));
            String centenas =String.valueOf(numeroPalabra.charAt(2));
            String decenas =String.valueOf(numeroPalabra.charAt(3));
            String unidades =String.valueOf(numeroPalabra.charAt(4));
        }
    }
    }
