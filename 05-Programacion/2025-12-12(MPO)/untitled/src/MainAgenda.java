import controller.Agenda;

import java.util.Scanner;

public class MainAgenda {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int opcion=0;
        Agenda agenda = new Agenda();
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
                    System.out.println("Introduce el correo del contacto");
                    String correo=scanner.next();
                    System.out.println("Introduce el telefono del contacto");
                    int telefono=scanner.nextInt();
                    agenda.agregarContacto(new Object[]{nombre,apellido,dni,correo,telefono});
                }
                case 2->{
                    System.out.println("Indica el dni que quieres buscar: ");
                    String dni =scanner.next();
                    agenda.borrarContacto(dni);
                }
                case 3->{
                    System.out.println("Indica el dni que quieres buscar: ");
                    String dni =scanner.next();
                    agenda.buscarContacto(dni);
                }
                case 4->{
                    agenda.listarContacto();
                }
                case 5->{
                    System.out.println("Saliendo...");
                }
            }
        }while(opcion!=5);
    }
}
