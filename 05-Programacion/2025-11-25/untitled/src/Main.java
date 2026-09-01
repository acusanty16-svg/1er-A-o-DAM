import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Dime el nombre de la persona: ");
        String nombre = scanner.next();
        System.out.println("Dime el apellido de la persona: ");
        String apellido = scanner.next();
        System.out.println("Dime el correo de la persona: ");
        String correo = scanner.next();
        System.out.println("Dime el telefono de la persona: ");
        int telefono  = scanner.nextInt();
        Object[] persona = new Object[]{nombre, apellido, correo, telefono};
        System.out.println("Los datos del usuario son: ");
        for (Object item:persona)
            System.out.println(item);*/

        int[][] numeros = new int[4][4];
        /*System.out.println(numeros[2][1]);*/
        numeros[2][0] = 20;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros[i].length; j++) {
           /*     System.out.print(numeros[i][j]+"\t");
            }
            System.out.println();*/
                numeros[i][j] = (int) (Math.random() * 16) + 1;
            }
        }
        for(int[] row:numeros){
            for(int fila :row){
                if (fila%2==0){
                    System.out.print(fila+ "\t");
                }
            }
            System.out.println();
        }

    }
}