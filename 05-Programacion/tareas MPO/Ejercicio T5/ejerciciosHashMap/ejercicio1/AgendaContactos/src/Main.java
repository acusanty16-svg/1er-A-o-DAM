import model.Agenda;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregarContacto("Santiago", 123456);
        agenda.agregarContacto("Marta", 789456);
        agenda.agregarContacto("Carmen", 456123);
        agenda.listarContactos();
        agenda.contarContactos();
    }
}