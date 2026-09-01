import controller.Agenda;
import controller.AgendaArrayList;
import model.Persona;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregarPersona(new Persona("Borja1","Martin","1234"));
        agenda.agregarPersona(new Persona("Borja2","Martin","1235"));
        agenda.borrarPersona("1234");
        agenda.obtenerPersonas();
        System.out.println();
        //agenda.obtenerPersona("1236").mostrarDatos();
        AgendaArrayList agenda2= new AgendaArrayList();
        agenda2.agregarPersona(new Persona("Borja1","Martin","1234"));
        agenda2.agregarPersona(new Persona("Borja2","Martin","1235"));
        agenda2.listarPersonas();
        agenda2.agregarPersona(new Persona("Borja3","Martin","1235"));
        agenda2.listarPersonas();
        

    }
}