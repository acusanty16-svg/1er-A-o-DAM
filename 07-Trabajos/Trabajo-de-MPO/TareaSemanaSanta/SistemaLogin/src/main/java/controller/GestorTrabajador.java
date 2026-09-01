package controller;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class GestorTrabajador {
    public boolean loginSystemTrabajador(String dni, String password) {
        File file = new File("src/main/java/files/contraseniasTrabajador.txt");
        BufferedReader reader = null;
        String linea;
        int intentos = 5;
        while (intentos > 0) {
            boolean coincide = false;
            try {
                reader = new BufferedReader(new FileReader(file));
                while ((linea = reader.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length >= 2) {
                        String dniArchivo = partes[0].trim();
                        String passArchivo = partes[1].trim();
                        if (dniArchivo.equals(dni) && passArchivo.equals(password)) {
                            coincide = true;
                            break;
                        }
                    }
                }
            } catch (FileNotFoundException e) {
                System.out.println("No se encontro el archivo");
            } catch (IOException e) {
                System.out.println("Error en la lectura");
            } finally {
                try {
                    if (reader != null) {
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error en la salida");
                }
            }
            if (coincide) {
                return true;
            }
            intentos--;
            System.out.println("DNI o contrasenia incorrecta. Te quedan " + intentos + " intentos.");
            if (intentos == 0) {
                System.out.println("Acceso denegado. Saliendo...");
                System.exit(0);
            }
            return false;
        }
        return false;
    }
    //Sé que en el enunciado aparecia que debiamos hacerlo con email pero es un poco lioso, igual seria solo cambiar un parametro, en vez de dni el correo
    public void ficharEntrada(String dni){
        File file = new File("src/main/java/files/horas.txt");
        LocalDateTime ahora = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm:ss");
        String fechaHora = ahora.format(formato);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write(dni + " - " + fechaHora + "\n");
            System.out.println("Fichaje registrado correctamente");
        } catch (IOException e) {
            System.out.println("Error al escribir el ficheo");
        }
    }

}
