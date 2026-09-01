package controller;

import model.Estudiante;
import model.SalonClase;

import java.io.*;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.*;

public class ControllerVariosEjercicios {
    private final SalonClase salonClase = new SalonClase();

    public void listarElementos (String path){
        File file = new File(path);
        if (file.exists() && file.isDirectory()){
            File[] contenido = file.listFiles();
            if (contenido==null){
                System.out.println("Error no se puede leer la carpeta");
                return;
            }
            if(contenido.length==0){
                System.out.println("La carpeta esta vacia");
            }else {
                System.out.println("Archivos encontrados en: "+path);
                long contador = Arrays.stream(contenido).filter(File::isFile).
                        peek(item-> System.out.println("- "+item.getName())).count();
                if (contador==0){
                    System.out.println("No se encontraron archivos");
                }
            }

        }else {
            System.out.println("La ruta no es valida");
        }
    }
    private void crearElemento(String path){
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Error en la creacion del fichero");
        }
    }
    public void leerElementos (String path){
    File file = new File(path);
    BufferedReader reader = null;
    if (file.exists()){
        String linea;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((linea = reader.readLine())!= null){
                System.out.println(linea);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura del fichero");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }else{
        System.out.println("Crearemos el archivo con la informacion suministrada");
        crearElemento(path);
    }
    if (file.length()==0 && file.exists()){
        System.out.println("No hay informacion dentro del archivo");
    }

    }
    public void buscarPorPalabra (String palabra, String path ){
        File file = new File(path);
        if (!file.exists() || !file.isFile()){
            System.out.println("El path introducido no existe");
            return;
        }
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            long totalApariciones = reader.lines().flatMap(p->Arrays.stream(p.split("\\s+")))
                    .filter(item->item.equalsIgnoreCase(palabra)).count();
            System.out.println("La palabra: '" + palabra + "' aparece " + totalApariciones + " veces");
        } catch (FileNotFoundException e) {
            System.out.println("Error en la creacion del fichero");
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
    public void copiarFichero(String origen, String destino){
        File fileOriginal = new File(origen);
        File fileCopia = new File(destino);
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String linea;
        if (fileOriginal.exists() && fileOriginal.isFile()){
            try {
                reader = new BufferedReader(new FileReader(fileOriginal));
                writer = new BufferedWriter(new FileWriter(fileCopia));
                while ((linea= reader.readLine())!=null){
                    writer.write(linea);
                    writer.newLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error en la lectura");
            } catch (IOException e) {
                System.out.println("Error en la escritura");
            }finally {
                if (reader!=null){
                    try {
                        reader.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
                if (writer!=null){
                    try {
                        writer.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }else {
            System.out.println("Error en la lectura del fichero");
        }
    }
    public void obtenerInformacion(String path){
        File file = new File(path);

        if (!file.exists() || !file.isFile()){
            System.out.println("El archivo no existe");
            return;
        }else {
            SimpleDateFormat asd = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date fecha = new Date(file.lastModified());
            String fechaFormateada = asd.format(fecha);
            System.out.println("Informacion del archivo: "+path);
            long tamanio = file.length();
            double tamanioMb = (double) tamanio / (1024 * 1024);
            System.out.printf("-Su tamaño es: %.2f MB\n",tamanioMb);
            System.out.println("-Su ultima modificacion fue: "+fechaFormateada);
            boolean puedeLeer = file.canRead();
            boolean puedeEscribir = file.canWrite();
            boolean puedeEjecutar = file.canExecute();
            System.out.println("-Permisos: Lectura-"+puedeLeer+" Escribir-"+puedeEscribir
            +" Ejecutar-"+puedeEjecutar);
            if (file.isHidden()){
                System.out.println("-El archivo esta oculto");
            }else {
                System.out.println("-El archivo no esta oculto");
            }
        }
    }
    public void leerArchivo(String path){
        File file = new File(path);
        BufferedReader reader= null;
        int contar=0;
        String linea=null;
        try {
            reader = new BufferedReader(new FileReader(file));
            while ((linea = reader.readLine())!=null){
               contar++;
            }
            System.out.println("El numero de lineas es: "+contar);
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo");
        } catch (IOException e) {
            System.out.println("Error en la reproduccion del archivo");
        }finally{
            try{
                if (reader != null){
                    reader.close();
                }
            }catch(Exception e){
                System.out.println("Error en la finalizacion del archivo");
            }
        }
    }
    public void agregarEstudiantes (String path){
        File file = new File(path);
        if (!file.exists() || !file.isFile()){
            System.out.println("Error porque el fichero no existe");
        }else{
            BufferedReader reader = null;
            String linea;
            try {
                reader = new BufferedReader(new FileReader(file));
                while ((linea=reader.readLine())!=null){
                    String[] partes = linea.split(",");
                    if (partes.length != 3){
                        System.out.println("Error al crear un estudiantes");
                        continue;
                    }
                    String nombre = partes[0].trim();
                    int edad = Integer.parseInt(partes[1].trim());
                    String dni = partes[2].trim();
                    Estudiante estudiante = new Estudiante(nombre,edad,dni);
                    salonClase.agregarEstudiante(estudiante);
                }
                listarEstudiantes();
            } catch (FileNotFoundException e) {
                System.out.println("Error en la lectura del fichero");
            } catch (IOException e) {
                System.out.println("Error en el proceso de lectura");
            }finally {
                try{
                    if (reader != null){
                        reader.close();
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }
    private void listarEstudiantes(){
        salonClase.mostrarDatos();
    }
    public void convertirCsv(String path){
        File inputFile = new File(path);
        if (!inputFile.exists() || !inputFile.isFile()){
            System.out.println("El archivo no existe");
            return;
        }

        File outputDir = new File("src/main/resourcesCsv");
        if (!outputDir.isDirectory()){
            if (!outputDir.mkdirs()){
                System.out.println("Error al crear la carpeta de salida");
                return;
            }
        }

        File outputFile = new File(outputDir, "resources.csv");
        BufferedReader reader = null;
        BufferedWriter writer = null;
        String linea;
        String[] partes;
        try {
            reader = new BufferedReader(new FileReader(inputFile));
            writer = new BufferedWriter(new FileWriter(outputFile));
            while ((linea = reader.readLine()) != null){
                if (linea.isBlank()){
                    continue;
                }
                partes = linea.split(",");
                if (partes.length != 3){
                    System.out.println("Error al convertir una linea");
                    continue;
                }
                String nombre = partes[0].trim();
                String edad = partes[1].trim();
                String dni = partes[2].trim();
                writer.write(nombre + "," + edad + "," + dni);
                writer.newLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error al iniciar el fichero");
        } catch (IOException e) {
            System.out.println("Error en la lectura o escritura del fichero");
        }finally {
            try{
                if (reader != null){
                    reader.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (writer != null){
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void exploracionConFile (String path){
        File file = new File(path);
        if (!file.exists() || !file.isDirectory()){
            System.out.println("Lo siento, pero estas registrando un dato incorrecto");
        }else{
            File[] elementos = file.listFiles();
            if (elementos==null){
                System.out.println("No existen elementos");
            }
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Arrays.stream(elementos).forEach(item->{
                String fecha = sdf.format(new Date(item.lastModified()));
                if (item.isDirectory()){
                    System.out.println("DIRECTORIO: "+item.getName()+" "
                            +item.length()+" bytes - Ultima modificacion: "+fecha);
                }
                if (item.isFile()){
                    System.out.println("ARCHIVO: "+item.getName()+" "
                            +item.length()+" bytes - Ultima modificacion: "+fecha);
                }
            });
        }
    }
    public void contadorPalabras (String path){
        File file = new File(path);
        BufferedReader reader = null;
        List<String> palabras = new ArrayList<>();
        String[] partes;
        String linea;

        try {
            reader = new BufferedReader(new FileReader(file));
            while((linea = reader.readLine())!=null){
            partes = linea.toLowerCase().trim().split("\\s+");
            for(String p:partes){
                if (!p.isBlank()){
                    palabras.add(p);
                }
            }
            Collections.sort(palabras);
            int i=0;
            while (i< palabras.size()){
                String actual = palabras.get(i);
                int contador =1;
                i++;
                while (i<palabras.size() && palabras.get(i).equals(actual)){
                    contador++;
                    i++;
                }
                if (contador>1){
                    System.out.println(actual + " -> " + contador);
                }
            }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error en e permiso del lectura");
        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }

    }

}
