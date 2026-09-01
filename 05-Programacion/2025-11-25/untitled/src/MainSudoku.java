import java.util.Scanner;

public class MainSudoku {
    public static void main(String[] args) {
        Sudoku sudoku1 = new Sudoku();
        /*sudoku1.iniciarCuadrado();*/
        //sudoku.iniciarCuadrado();
        int opcion =0;
        Scanner scanner = new Scanner(System.in);

        do {
            scanner = new Scanner(System.in);
            System.out.println("1. Rellenar cuadrados");
            System.out.println("2. Listar cuadrados");
            System.out.println("Que opcion quieres usar?");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    sudoku1.rellenarNumeros();
                }
                case 2->{
                    sudoku1.mostrarNumeros();
                }
            }

        }while(opcion !=3);
    }
}
