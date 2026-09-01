import java.util.Scanner;
import controller.GestorAdmin;
import controller.GestorTrabajador;
import model.Trabajador;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorAdmin gestorAdmin = new GestorAdmin();
        GestorTrabajador gestorTrabajador = new GestorTrabajador();

        System.out.println("=== SISTEMA DE LOGIN ===");
        System.out.println("Seleccione tipo de usuario:");
        System.out.println("1. Administrador");
        System.out.println("2. Trabajador");
        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();
        int opcion=0;

        if (tipoUsuario == 1) {
            System.out.println("Introduce tu usuario: ");
            String usuario = scanner.nextLine();
            System.out.println("Introduce la contraseña: ");
            String contrasenia = scanner.nextLine();
            if (gestorAdmin.loginSystemAdmin(usuario, contrasenia)){
                do {
                    //gestorAdmin.loginSystem(contrasenia);
                    System.out.println("Bienvenido al perfil de administrador");
                    System.out.println("Estas son las tareas que puede hacer: ");
                    System.out.println("1. Dar de alta trabajadores indicando todos sus datos");
                    System.out.println("2. Dar de baja trabajadores indicando su dni");
                    System.out.println("3. Ver datos de un trabajador indicando su dni");
                    System.out.println("4. Ver datos de todos los trabajadores");
                    System.out.println("5. Cambiar la pass de un trabajador indicando su dni");
                    System.out.println("6. Ver registros de jornada");
                    System.out.println("7. Salir");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            System.out.println("Escribe el nombre del trabajador: ");
                            String nombre = scanner.nextLine();
                            System.out.println("Escribe el apellido del trabajador: ");
                            String apellido = scanner.nextLine();
                            System.out.println("Escribe el dni del trabajador: ");
                            String dni = scanner.nextLine();
                            System.out.println("Escribe el correo del trabajador: ");
                            String correo = scanner.nextLine();
                            Trabajador nuevoTrabajador = new Trabajador(nombre,apellido,dni,correo,0);
                            gestorAdmin.darDeAlta(nuevoTrabajador);
                            System.out.println("Trabajador dado de alta correctamente");
                        }
                        case 2 -> {
                            System.out.println("Introduce el dni del trabajador que quieres dar de baja: ");
                            String dni = scanner.nextLine();
                            gestorAdmin.darDeBaja(dni);
                            System.out.println("Trabajador dado de baja correctamente");
                        }
                        case 3 -> {
                            System.out.println("Introduce el dni del trabajador que quieres ver: ");
                            String dni = scanner.nextLine();
                            gestorAdmin.buscarTrabajadorPorDni(dni);
                        }
                        case 4 -> {
                            gestorAdmin.mostrarATodosLosTrabajadores();
                        }
                        case 5 -> {
                            System.out.println("Introduce el DNI del trabajador: ");
                            String dni = scanner.nextLine();
                            System.out.println("Introduce la nueva contraseña: ");
                            String nuevaPass = scanner.nextLine();
                            gestorAdmin.cambiarPasswordTrabajadores(dni, nuevaPass);
                        }
                        case 6 -> {
                            System.out.println("Los registros de jornada son: ");
                            gestorAdmin.verFichajeJornada();

                        }
                        case 7 -> {
                            System.out.println("Saliendo...");
                        }
                        default -> {
                            System.out.println("Introduzca un parametro valido");
                        }
                    }
                }while (opcion!=7);
            }
        } else if (tipoUsuario == 2) {
            System.out.println("Introduce tu DNI: ");
            String dni = scanner.nextLine();
            System.out.println("Introduce la contraseña: ");
            String contrasenia = scanner.nextLine();
            if (gestorTrabajador.loginSystemTrabajador(dni, contrasenia)){
                do {
                    System.out.println("Bienvenido al perfil de Trabajador");
                    System.out.println();
                    System.out.println("Estas son las tareas que puede hacer: ");
                    System.out.println("1. Realizar fichaje");
                    System.out.println("2. Salir");
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    switch (opcion) {
                        case 1 -> {
                            gestorTrabajador.ficharEntrada(dni);
                        }
                        case 2 -> {
                            System.out.println("Saliendo...");
                        }
                        default -> {
                            System.out.println("Introduzca un parametro valido");

                        }
                    }
                }while (opcion!=2);
            }
        }




    }
}
