import controller.GestorFicheros;

public class Main {
    public static void main(String[] args) {
        GestorFicheros gestor = new GestorFicheros();
        //gestor.crearFichero("src/main/java/recursos/escritura.txt");
        //gestor.crearCarpeta("src/main/java/recursos/ejemplo");
        //gestor.lectorLineas("src/main/java/recursos/lectura.txt");
        //gestor.escribirCaracteres("src/main/java/recursos/escritura.txt");
        //gestor.escribirLineas("src/main/java/recursos/escritura.txt");
        //gestor.codificarMensaje("src/main/java/recursos/codificando.txt");
        gestor.descifrarMensaje("src/main/java/recursos/codificando.txt");
    }
}
