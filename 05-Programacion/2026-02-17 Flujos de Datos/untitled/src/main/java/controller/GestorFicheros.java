package controller;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GestorFicheros {
    public void crearFichero (String path){
        File file = new File(path);
        try{
            file.createNewFile();
        }catch (IOException e){
            System.out.println("Error en la creacion del fichero");
            System.out.println(e.getMessage());
        }
    }
    public void crearCarpeta ( String path){
    File file = new File(path);
    file.mkdir();
    }
    public void informacionFicheros ( String path){
        File file = new File(path);
       // Arrays.stream(file.listFiles()).toList().forEach();
    }

    public void lectorFichero (String path){
        File file = new File(path);
        FileReader reader= null;
        try{
            reader = new FileReader(file);
            int codigo;
            while((codigo=reader.read())!=-1){
                System.out.print((char) codigo);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error. El fichero no existe");
            lectorFichero("nueva ruta");
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }finally {
            try{
                reader.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }
    }

    public void lectorLineas (String path){
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try{
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = null;
            while ((linea = bufferedReader.readLine())!=null){
                System.out.println(linea);
            }
            System.out.println(linea);
        }catch (FileNotFoundException e ){
            System.out.println("Error. el fichero no existe");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        } finally {
            try{
                bufferedReader.close();
            }catch (Exception e){
                System.out.println("Error al cerrar el fichero");
            }
        }

    }

    public void escribirCaracteres (String path){
        File file = new File(path);
        FileWriter fileWriter =null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime que me mensaje quieres guardar: ");
        String mensaje = scanner.nextLine();

        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write(123);
            fileWriter.write("palabra");
            fileWriter.write("\n");
            /*for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                fileWriter.write(String.valueOf((int) letra));
                fileWriter.write(" ");
            }*/
        } catch (IOException e) {
            System.out.println("Error en la escritura");;
        }finally {
            try{
                fileWriter.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void escribirLineas (String path){
        File file = new File(path);
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(file, true));
            printWriter.println("Esta linea es un ejemplo de la nueva forma de escribir");
            printWriter.println("Ahora se como hacer la escritura en forma conjunta");
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println();
            printWriter.println();
        } catch (IOException e) {
            System.out.println("Error en la escritura");;
        }finally {
            try{
                printWriter.close();
            } catch (Exception e) {
                System.out.println("Error en el cerrado");;
            }
        }


    }

    public void codificarMensaje (String path){
        File file = new File(path);
        FileWriter fileWriter =null;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dime que me mensaje quieres modificar: ");
        String mensaje = scanner.nextLine();
        scanner = new Scanner(System.in);
        System.out.println("Dime la fase de cifrado");
        int fase = scanner.nextInt();


        try {
            fileWriter = new FileWriter(file, false);
            for (int i = 0; i < mensaje.length(); i++) {
                char letra = mensaje.charAt(i);
                fileWriter.write((String.valueOf(((int) letra)*fase)));
                fileWriter.write(" ");
            }
        } catch (IOException e) {
            System.out.println("Error en la escritura");;
        }finally {
            try{
                fileWriter.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }


    }

    public void descifrarMensaje(String path){
        File file = new File(path);
        BufferedReader bufferedReader = null;
        System.out.println("Dime cual es la fase de codificacion: ");
        Scanner scanner = new Scanner(System.in);
        try {
            int fase = scanner.nextInt();
            bufferedReader = new BufferedReader(new FileReader(file));
            String linea = bufferedReader.readLine();
            String[] codigos = linea.split(" ");
            for (String code : codigos) {
                int numero = Integer.parseInt(code) / fase;
                System.out.print(((char) numero));
            }
        }catch (InputMismatchException e){
            System.out.println("La fase es incorrecta, por favor empieza el proceso nuevamente");
            descifrarMensaje(path);
        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("No hay permisos de lectura");
        }finally {
            try{
                bufferedReader.close();
            }catch (Exception e){
                System.out.println("Error en el cerrado");
            }
        }
    }
}
