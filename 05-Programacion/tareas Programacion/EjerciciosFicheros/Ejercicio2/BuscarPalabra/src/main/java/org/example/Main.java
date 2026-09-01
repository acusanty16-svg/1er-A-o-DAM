package org.example;

import controller.ControllerVariosEjercicios;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ControllerVariosEjercicios controller = new ControllerVariosEjercicios();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bienvenido a juegos Santi");
        int opcion;
        do {
            System.out.println("Selecciona una opcion: ");
            System.out.println("1. Listar elementos");
            System.out.println("2. Leer elementos");
            System.out.println("3. Buscar palabra dentro de un archivo");
            System.out.println("4. Copiar un fichero");
            System.out.println("5. Ver informacion de un fichero");
            System.out.println("6. Saber cuantas lineas tiene un fichero");
            System.out.println("7. Importar un archivo csv");
            System.out.println("8. Convertir archivo a csv");
            System.out.println("9. Exploracion de la ruta introducida...");
            System.out.println("10. Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1 ->{
                    System.out.println("Escribe el path donde tienes los elementos: ");
                    String listar = scanner.nextLine();
                    controller.listarElementos(listar);
                }
                case 2 ->{
                    System.out.println("Escribe el elemento .txt que quieres leer");
                    System.out.println("Si no esta creado lo hacemos por ti");
                    String leerElemento= scanner.nextLine();
                    controller.leerElementos(leerElemento);
                }
                case 3 ->{
                    System.out.println("Introduce la palabra que quieres buscar dentro del fichero");
                    String palabraABuscar= scanner.nextLine();
                    System.out.println("Introduce el path donde quieres buscar la palabra");
                    String ficheroAEscoger=scanner.nextLine();
                    controller.buscarPorPalabra(palabraABuscar,ficheroAEscoger);
                }
                case 4 ->{
                    System.out.println("Introduce el archivo de origen");
                    String archivoOrigen = scanner.nextLine();
                    System.out.println("Introduce el archivo de destino");
                    String archivoDestino = scanner.nextLine();
                    controller.copiarFichero(archivoOrigen, archivoDestino);
                }
                case 5->{
                    System.out.println("Introduce el archivo que deseas revisar: ");
                    String archivo = scanner.nextLine();
                    controller.obtenerInformacion(archivo);

                }
                case 6->{
                    System.out.println("Introduce el archivo para ver sus lineas: ");
                    String lineas = scanner.nextLine();
                    controller.leerArchivo(lineas);
                }
                case 7 ->{
                    System.out.println("Introduce el archivo para importarlo: ");
                    String agregarEstudiantes = scanner.nextLine();
                    controller.agregarEstudiantes(agregarEstudiantes);
                }
                case 8->{
                    System.out.println("Introduce el archivo para convertirlo: ");
                    String convetirCsv = scanner.nextLine();
                    controller.convertirCsv(convetirCsv);
                }
                case 9->{
                    System.out.println("Introduce la ruta para revisar que contiene: ");
                    String informacionFichero = scanner.nextLine();
                    controller.exploracionConFile(informacionFichero);
                }
                case 10->{


                }
                case 11->{
                    System.out.println("Saliendo...");
                }
                default -> System.out.println("Opcion no valida");
            }
        }while(opcion!=11);


    }
}