package org.example;

import controller.AgendaController;
import model.Agenda;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AgendaController controller= new AgendaController();
        //controller.crearFichero("src/main/java/resources/Usuarios.txt");
        /*Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el numero de usuarios que quieres dentro de la agenda");
        int numeroUsuarios = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < numeroUsuarios; i++) {
            controller.introducirInformacion("src/main/java/resources/Usuarios.txt");
        }*/
        controller.rellenarArrayList("src/main/java/resources/Usuarios.txt");
        controller.mostrarDatos("src/main/java/resources/Usuarios.txt");
    }
}