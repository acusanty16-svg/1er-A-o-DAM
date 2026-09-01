import model.Libro;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Libro libro= new Libro();
        System.out.println("---Bienvenido a la biblioteca Borja---");
        System.out.println("Introduce el titulo de la obra que quieres agregar");
        String titulo=scanner.nextLine();
        System.out.println("Introduce el autor de la obra que quieres agregar");
        String autor=scanner.nextLine();
        System.out.println("Introduce el numero de paginas de la obra que quieres agregar");
        int numPaginas=scanner.nextInt();
        System.out.println("Introduce el precio de la obra que quieres agregar");
        double precio=scanner.nextDouble();
        libro = new Libro(titulo,autor,numPaginas,precio);
        libro.mostrarInfo();
    }
}