package org.example;

import model.Gestor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try{
            System.out.println("Introduce la ruta del archivo del elemento .txt que quieres leer: ");
            String rutaFile = scanner.nextLine();
            Gestor gestor = new Gestor();
            gestor.leerArchivo(rutaFile);
        }catch (Exception e){
            System.out.println("Error al reproducir el archivo");
        }
    }
}