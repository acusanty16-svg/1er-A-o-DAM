import java.io.*;

public class OperacionesFicheros {
    public void leerDatosFichero(){
        File file = new File("src/main/java/resources/ficheros");
        System.out.println("Existe "+file.exists());
        System.out.println("Tamaño "+file.length());
        System.out.println("Es fichero "+file.isFile());
        System.out.println("Es carpeta "+file.isDirectory());
        System.out.println("Ruta abs "+file.getAbsolutePath());

    }

    public void leerHijos(String path){
    File file = new File(path);
        for (File s : file.listFiles()) {
            System.out.println(s);
            if (s.isDirectory()){
                leerHijos(s.getAbsolutePath());
            }
        }
    }

    public void crearFichero(String path){
    File file = new File(path+"/ejemplo.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            System.out.println("Fallo en la escritura");
            System.out.println(e.getMessage());
        }
    }

    public void crearDirectorio(String path){
        File file = new File(path+"/ejemplo/cosa");
        if (!file.exists()){
            //file.mkdir();
            file.mkdirs();
        }
    }

    public void lecturaASCII(String path){
        File file = new File(path);
        FileReader reader=null;
        try {
            reader = new FileReader(file);
            int codigo = -1;
            while((codigo= reader.read())!= -1){
                System.out.print(codigo);
                System.out.print(" - ");
                System.out.print((char) codigo);
                System.out.println();
            }

        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra la ruta a leer");
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println("Error al leer, no y hay permisos");
        } finally {
            try{
                reader.close();
            }catch (IOException | NullPointerException e){
                System.out.println("Error en el cerrado");
            }
        }

    }

    public void lecturaLinea(String path){
        File file = new File(path);
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            System.out.println("Error en la lectura de la ruta");
        }
    }
}
