import Controller.GestorDocumental;
import Controller.GestorUsuarios;

public class MainUnitario {
    public static void main(String[] args) {
        GestorUsuarios gestordocumental = new GestorUsuarios();
        gestordocumental.enviarDocumento("hola", "que hace");
    }
}
