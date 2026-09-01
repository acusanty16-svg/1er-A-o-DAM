import controller.AgendaPersonas;
import model.Persona;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        AgendaPersonas agenda= new AgendaPersonas();
        Persona persona;
        int opcion =0;
        do {
            System.out.println("---BIENVENIDO A LA AGENDA BORJA---");
            System.out.println("1-Agregar persona");
            System.out.println("2-Buscar persona");
            System.out.println("3-Borrar persona");
            System.out.println("4-Listar persona");
            System.out.println("5-Salir");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion){
                case 1->{
                    System.out.println("¡¡Has escogido agregar contacto!!");
                    persona = new Persona();
                    System.out.println("Introduce el nombre: ");
                    persona.setNombre(scanner.nextLine());
                    System.out.println("Introduce el apellido: ");
                    persona.setApellido(scanner.nextLine());
                    System.out.println("Introduce el DNI: ");
                    persona.setDni(scanner.nextLine());
                    System.out.println("Introduce el Correo: ");
                    persona.setCorreo(scanner.nextLine());
                    System.out.println("Introduce el Telefono: ");
                    persona.setTelefono(scanner.nextInt());
                    agenda.agregarPersona(persona);
                }
                case 2->{
                    System.out.println("¡¡Has escogido buscar contacto!!");
                    System.out.println("Introduce el DNI de la persona que quieres buscar: ");
                    String buscarDNI=scanner.next();
                    agenda.buscarPersona(buscarDNI);
                }
                case 3->{
                    System.out.println("¡¡Has escogido listar contacto!!");
                    System.out.println("Introduce el DNI de la persona que quieres borrar");
                    String borrarPersona=scanner.next();
                    agenda.borrarPersona(borrarPersona);
                }
                case 4->{
                    System.out.println("¡¡Has escogido borrar contacto!!");
                    agenda.listarPersona();
                }
                case 5->{
                    System.out.println("Saliendo...");
                }
            };
        }while(opcion!=5);
    }
}