import controller.Gestor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        //gestor.exportarXML();
        //gestor.importarXML();
        gestor.lectorJSON();
        Scanner scanner = new Scanner(System.in);
        System.out.println("De que producto quieres informacion: ");
        int id = scanner.nextInt();
        gestor.getPoductoById(id);
    }
}
