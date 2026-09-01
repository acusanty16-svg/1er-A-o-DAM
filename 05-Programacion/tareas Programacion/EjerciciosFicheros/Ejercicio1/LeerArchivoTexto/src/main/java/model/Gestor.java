package model;

import java.io.*;

public class Gestor {
    public void leerArchivo (String path){
        boolean existe = crearArchivo(path);
        File file = new File(path);
        BufferedReader reader = null;
        if (existe) {
            try {
                reader = new BufferedReader(new FileReader(file));
                String linea ;
               while((linea = reader.readLine())!= null){
                   System.out.println(linea);
               }
            } catch (FileNotFoundException e) {
                System.out.println("Error en la creacion del archivo");
            } catch (IOException e) {
                System.out.println("Error en la lectura del archivo");
            } catch (Exception e){
                System.out.println("Error detectado");
        }finally {
                try {
                    if (reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error al cerrar el archivo");
                }
            }
        }
    }
    private boolean crearArchivo (String path){
        File file = new File(path);
        try {
            if (!file.exists()){
                return file.createNewFile();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error en la creacion del archivo");
            return false;
        }
    }
}
