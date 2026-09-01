package controller;

import model.Agenda;
import model.Usuario;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class AgendaController {
    public void crearFichero(String path){
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error. No se ha podido crear el fichero");;
        }
    }
    public void introducirInformacion(String path){
        File file = new File(path);
        PrintWriter writer = null;
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Introduce el nombre de la persona: ");
            String nombre = scanner.nextLine();
            System.out.println("Introduce el dni de la persona: ");
            String dni = scanner.nextLine();
            System.out.println("Introduce el correo de la persona: ");
            String correo = scanner.nextLine();
            writer = new PrintWriter(new FileWriter(file, true));
            writer.println(nombre+", "+ dni+ ", "+ correo);

        }catch (InputMismatchException e){
            System.out.println("Introduce un valor valido");
            introducirInformacion(path);
        } catch (Exception e) {
            System.out.println("Error al crear el fichero");
            System.out.println("Introduce un valor valido");
            introducirInformacion(path);
        }finally {
            try{
                if (writer!=null){
                    writer.close();
                }
            }catch (Exception e){
                System.out.println("Error. No se puede crear el fichero");
            }
        }


    }
    public ArrayList<Usuario> rellenarArrayList(String path){
        ArrayList<Usuario> lista = new ArrayList<>();
        File file = new File(path);
        BufferedReader bufferedReader=null;
        try {
            String linea;
            bufferedReader = new BufferedReader(new FileReader(file));
            while((linea= bufferedReader.readLine())!=null){
                String [] datos = linea.split(", ");
                if (datos.length==3){
                    Usuario auxiliar = new Usuario(datos[0].trim(),datos[1].trim(),datos[2].trim());
                    lista.add(auxiliar);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error no se ha encontrado el fichero");
        } catch (IOException e) {
            System.out.println("Error al reproducir la lectura");
        }finally {
            try{
                if(bufferedReader != null){
                    bufferedReader.close();
                }
            }catch (Exception e){
                System.out.println("Error al cerrar el programa");
            }
        }
        return lista;
    }
    public void mostrarDatos(String path) {
       ArrayList<Usuario> listaAuxiliar = rellenarArrayList(path);
        System.out.println("Listado de la agenda");
        if (listaAuxiliar.isEmpty()){
            System.out.println("La agenda esta vacia y no se puede hacer nada");
        }else{
            for(Usuario item:listaAuxiliar){
                System.out.println("Nombre: " + item.getNombre());
                System.out.println("DNI:    " + item.getDni());
                System.out.println("Correo: " + item.getCorreo());
                System.out.println("------------------------------------");
            }
        }
    }

}
