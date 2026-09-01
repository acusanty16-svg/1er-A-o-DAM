package controller;

import model.Usuario;

import java.io.*;
import java.util.*;

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

    public void exportarUsuario(Usuario usuario){
        File file = new File("main/java/recursos/usuarios.csv");
        PrintWriter printWriter = null;

        try{
            if (!file.exists()){
                file.createNewFile();
                printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.println("Nombre, Apellido, DNI");
            }
                printWriter = new PrintWriter(new FileWriter(file, true));
                printWriter.println(usuario);
                printWriter.close();

        }catch (Exception e){
            System.out.println("Error en la escritura del fichero");
        }
    }

    public List<Usuario> importarUsuarios(){
        File file = new File("main/java/recursos/usuarios.csv");
        List<Usuario> lista = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String linea = reader.readLine();
            while((linea = reader.readLine())!= null){
                if (linea.trim().isEmpty()) continue;
                String[] elementos = linea.trim().split(",");
                if (elementos.length>=3){
                    Usuario usuario = new Usuario(elementos[0].trim(), elementos[1].trim(), elementos[2].trim());
                    lista.add(usuario);
                }
            }


        } catch (FileNotFoundException e) {
            System.out.println("Error en la ruta de lectura");
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }finally {
            try{
                reader.close();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }
        return lista;
    }

    public void escribirObjetos(){
        File file = new File("main/java/recursos/objetos.obj");
        ObjectOutputStream objectOutputStream = null;

        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeInt(56);

        } catch (IOException e) {
            System.out.println("Error en los permisos de escritura");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public void leerObjeto(){
        File file = new File("main/java/recursos/objetos.obj");
        ObjectInputStream objectInputStream = null;

        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            int dato = objectInputStream.readInt();
            System.out.println(dato);
        } catch (IOException e) {
            System.out.println("Error en la lectura");
        }
    }

    public void escribirUsuario(List<Usuario> lista){
        File file = new File("main/java/recursos/usuarios.obj");
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(lista);

        } catch (IOException e) {
            System.out.println("Error en el proceso de escritura");
        }finally {
            try {
                objectOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Usuario> leerUsuarios(){
        File file = new File("main/java/recursos/usuarios.obj");
        ObjectInputStream objectInputStream = null;
        List<Usuario> lista = new ArrayList<>();
        try {
            objectInputStream = new ObjectInputStream(new FileInputStream(file));
            //Usuario usuario = (Usuario) objectInputStream.readObject();
            //System.out.println(usuario);
            lista = (List<Usuario>) objectInputStream.readObject();

        } catch (IOException e) {
            System.out.println("Error en la lectura del fichero");
        }catch (ClassCastException e){
            System.out.println("Error en el casteo de la clase");
        }catch (ClassNotFoundException e){
            System.out.println("Error en la lectura de la clase");
        }

        finally {
            try {
                objectInputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return lista;
    }
}
