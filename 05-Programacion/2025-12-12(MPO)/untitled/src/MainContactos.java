import controller.Agenda;
import controller.AgendaContacto;
import model.Contacto;

import java.util.Scanner;

public class MainContactos {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        AgendaContacto agendaContacto = new AgendaContacto();
        int opcion=0;
//        System.out.println("EL tamaño de la lista es de: "+agenda.getListaContactos().size());
        do {
            System.out.println("1 Agregar contacto");
            System.out.println("2 Borrar contacto");
            System.out.println("3 Buscar contacto");
            System.out.println("4 Listar contacto");
            System.out.println("5 Salir");
            System.out.println("Que opcion quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Introduce el nombre del contacto");
                    String nombre=scanner.next();
                    System.out.println("Introduce el apellido del contacto");
                    String apellido=scanner.next();
                    System.out.println("Introduce el DNI del contacto");
                    String dni=scanner.next();
                    System.out.println("Introduce el telefono del contacto");
                    int telefono=scanner.nextInt();
                    agendaContacto.agregarContacto(new Contacto(nombre,telefono,dni,apellido));
                }
                case 2->{
                    System.out.println("Introduce el DNI a borrar");
                    String dni=scanner.next();
                    agendaContacto.borrarContacto(dni);
                }
                case 3->{
                    System.out.println("Introduce el DNI a buscar");
                    String dni=scanner.next();
                    agendaContacto.buscarContacto(dni);
                }
                case 4->{
                    agendaContacto.listarContactos();
                }
                case 5->{
                    System.out.println("Saliendo...");
                }
            }
        }while(opcion!=5);
    }
}
