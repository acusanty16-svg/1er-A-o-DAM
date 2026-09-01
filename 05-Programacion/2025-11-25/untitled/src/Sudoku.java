public class Sudoku {

    }
}
private int[][] cuadrado = new int[3][3];

public void iniciarCuadrado(){
    System.out.println("Procedemos a iniciar el sudoku");
    rellenarNumeros();
    mostrarNumeros();
}
private boolean estaNumero(int numero){
    //lo primero que tengo que hacer es el numero que tengo que comparar (es el numero que pongo entre el parentesis, porque es el que voy a comparar despues) OK
    //despues tendre que recorrerlo
    //compararlo
    for (int[] fila : cuadrado) {
        for (int item : fila) {
            if(item==numero){
                return true;
            }
        }
    }
    return false;
}
public void mostrarNumeros(){
    for (int[] row : cuadrado) {
        for (int fila : row) {
            System.out.print(fila + "\t");
        }
        System.out.println();
    }
}
public void rellenarNumeros(){
    for (int i = 0; i < cuadrado.length; i++) {
        for (int j = 0; j < cuadrado[i].length; j++) {
           /*     System.out.print(numeros[i][j]+"\t");
            }
            System.out.println();*/
            int aleatorio;
            do {
                aleatorio= (int) (Math.random() * 17) + 1;
            }while(estaNumero(aleatorio));
            cuadrado[i][j] = aleatorio;
        }
    }