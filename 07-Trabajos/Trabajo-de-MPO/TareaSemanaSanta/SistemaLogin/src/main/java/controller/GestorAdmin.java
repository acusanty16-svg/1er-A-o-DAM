package controller;

import model.Trabajador;

import java.io.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GestorAdmin {
    public boolean loginSystemAdmin(String usuario, String password) {
        File file = new File("src/main/java/files/contraseniasAdmins.txt");
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
                        String user = partes[0].trim();
                        String pass = partes[1].trim();
                        if (user.equals(usuario) && pass.equals(password)) {
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
            System.out.println("Usuario o contrasenia incorrecta. Te quedan " + intentos + " intentos.");
            if (intentos == 0) {
                System.out.println("Acceso denegado. Saliendo...");
                System.exit(0);
            }
            return false;
        }
        return false;
    }
    public void darDeAlta(Trabajador trabajador) {
        File file = new File("src/main/java/files/trabajadores.csv");
        PrintWriter printWriter = null;

        try {
            if (!file.exists()) {
                file.createNewFile();
                printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.println("ID,NOMBRE,APELLIDO,DNI,CORREO,ESTADO");
            } else {
                printWriter = new PrintWriter(new FileWriter(file, true));
            }
            int nuevoId = obtenerUltimoId() + 1;
            trabajador.setId(nuevoId);
            printWriter.println(trabajador.toString());
            printWriter.close();
            
        } catch (Exception e) {
            System.out.println("Error en la escritura del ficheo");
        }
    }
    public int obtenerUltimoId(){
        File file = new File("src/main/java/files/trabajadores.csv");
        int ultimoId=0;
        BufferedReader reader = null;
        String linea;
        try {
            reader = new BufferedReader(new FileReader(file));
            reader.readLine();
            while ((linea = reader.readLine())!= null){
                if (!linea.trim().isEmpty()){
                    String[] elementos = linea.trim().split(",");
                    ultimoId = Integer.parseInt(elementos[0].trim());
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }finally {
            if (reader!= null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ultimoId;
    }
    public List<Trabajador> importarTrabajadores(){
        File file = new File("src/main/java/files/trabajadores.csv");
        List<Trabajador> trabajadores = new ArrayList<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String linea = reader.readLine();
            while ((linea = reader.readLine())!= null){
                if (linea.trim().isEmpty()) continue;
                String[] elementos = linea.trim().split(",");
                if (elementos.length >= 6) {
                    int id = Integer.parseInt(elementos[0].trim());
                    String nombre = elementos[1].trim();
                    String apellido = elementos[2].trim();
                    String dni = elementos[3].trim();
                    String correo = elementos[4].trim();
                    String estado = elementos[5].trim();

                    Trabajador trabajador = new Trabajador(id, nombre, apellido, dni, correo, estado);
                    trabajadores.add(trabajador);
                }
            }
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }finally {
            try {
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return trabajadores;
    }
    public void darDeBaja(String dni){
        File file = new File("src/main/java/files/trabajadores.csv");
        PrintWriter printWriter = null;
        String linea;
        List<Trabajador> trabajadores = importarTrabajadores();
        boolean encontrado = false;
        for(Trabajador t:trabajadores){
            if (t.getDni().equals(dni)){
                t.setEstado("Despedido");
                encontrado = true;
                break;
            }
        }
        if (!encontrado){
            System.out.println("No se encontro ningun trabajador con ese dni");
            return;
        }
        try {
            printWriter = new PrintWriter(new FileWriter(file, false));
            printWriter.println("ID,NOMBRE,APELLIDO,DNI,CORREO,ESTADO");
            for (Trabajador t:trabajadores){
                printWriter.println(t.toString());
            }
            System.out.println("Trabajador dado de baja correctamente");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }
    }
    public void buscarTrabajadorPorDni(String dni){
        List<Trabajador> trabajadores = importarTrabajadores();
        for(Trabajador t:trabajadores){
            if (t.getDni().equals(dni)){
                System.out.println(t);
                break;
            }
        }
    }
    public void mostrarATodosLosTrabajadores(){
        List<Trabajador> trabajadores = importarTrabajadores();
                for (Trabajador t :trabajadores) {
                    System.out.println(t);
                }
    }
    public void verFichajeJornada(){
        File file = new File("src/main/java/files/horas.txt");
        BufferedReader reader= null;
        String linea;
        try {
            reader= new BufferedReader(new FileReader(file));
            System.out.println("===REGISTROS DE JORNADA===");
            while ((linea = reader.readLine())!=null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al encontrar el fichero");
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void cambiarPasswordTrabajadores(String dni, String nuevaContrasenia) {
        File file = new File("src/main/java/files/contraseniasTrabajador.txt");
        List<String[]> contrasenias = new ArrayList<>();
        boolean encontrado = false;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 2 && partes[0].trim().equals(dni)) {
                    partes[1] = nuevaContrasenia;
                    encontrado = true;
                }
                contrasenias.add(partes);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer");
        }
        if (encontrado) {
            try (PrintWriter writer = new PrintWriter(new FileWriter(file, false))) {
                for (String[] contra : contrasenias) {
                    writer.println(contra[0].trim() + "," + contra[1].trim());
                }
                System.out.println("Contraseña cambiada correctamente");
            } catch (IOException e) {
                System.out.println("Error al escribir");
            }
        } else {
            System.out.println("No se encontró un trabajador con ese DNI");
        }
    }
}


