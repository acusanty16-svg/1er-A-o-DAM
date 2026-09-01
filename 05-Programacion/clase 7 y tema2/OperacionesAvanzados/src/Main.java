import Controller.GestorDocumental;
import Controller.GestorUsuarios;
// puedo poner un * tambien para seleccionar todos los paquetes e importarlos, pero eso puede cargar un monton la memoria
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Siempre debe haber una carpeta src");
        GestorDocumental gestorDocumental = new GestorDocumental();
        Scanner scanner = new Scanner(System.in);
        GestorUsuarios gestorUsuarios = new GestorUsuarios();

    }
}