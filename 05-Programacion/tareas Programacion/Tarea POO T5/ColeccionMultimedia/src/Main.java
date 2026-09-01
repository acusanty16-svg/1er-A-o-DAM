import controller.GestionMultimedia;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---BIENVENIDO A LA GESTION SANTI---");
        Scanner scanner = new Scanner(System.in);
        boolean jugarOtraVez = true;
        GestionMultimedia gestionMultimedia = new GestionMultimedia();
        do {
            System.out.println("Introduce el tipo de elemento que quieres guardar");
            System.out.println("A. Audio");
            System.out.println("B. Libro");
            System.out.println("C. Video");
            System.out.println("D. O si quieres salir...");
            String tipoElemento=scanner.nextLine();
            switch (tipoElemento){
                case "A"->{
                    System.out.println("Has escogido Audio");
                    System.out.println("¿Que quieres hacer?");
                    System.out.println("1. Añadir un Audio");
                    System.out.println("2. Eliminar un Audio");
                    System.out.println("3. Listar Audios");
                    int opcion = scanner.nextInt();
                    String titulo =null, autor=null, soporte=null;
                    int duracion =0;
                    Audio audio = new Audio();

                    switch (opcion){
                        case 1 ->{
                            System.out.println("Has escogido Añadir audio");
                            System.out.println("¿Cuantos Audios quieres añadir?");
                            int numeroLibros=scanner.nextInt();
                            scanner.nextLine();
                            int id = 0;
                            for (int i = 0; i < numeroLibros; i++) {
                                id = (int) (Math.random()*1500);
                                System.out.println("El id del Audio es: "+id);
                                System.out.println("Introduce el titulo del Audio: ");
                                titulo= scanner.nextLine();
                                System.out.println("Introduce el nombre del autor:");
                                autor = scanner.nextLine();
                                System.out.println("Introduce la duracion del audio: ");
                                duracion = scanner.nextInt();
                                scanner.nextLine();
                                System.out.println("Introduce el soporte de tu audio: ");
                                soporte = scanner.nextLine();
                                audio = new Audio(id,titulo,autor,duracion,soporte);
                                gestionMultimedia.aniadirElemento(audio);
                            }
                        }
                        case 2 ->{
                            System.out.println("Has escogido Eliminar audio");
                            System.out.println("Introduce el id del libro que quieres borrar: ");
                            int opcionBorrado = scanner.nextInt();
                            scanner.nextLine();
                            gestionMultimedia.eliminarElemento(opcionBorrado);
                        }
                        case 3 ->{
                            System.out.println("Has escogido Listar elementos");
                            gestionMultimedia.listarElementos();
                        }
                    }
                }
                case "B"->{
                    System.out.println("Has escogido Libro");
                    System.out.println("¿Que quieres hacer?");
                    System.out.println("1. Añadir un Libro");
                    System.out.println("2. Eliminar un Libro");
                    System.out.println("3. Listar Libros");
                    int opcion = scanner.nextInt();
                    String titulo =null;
                    String autor = null;
                    String isbn = null;
                    int numeroPaginas =0;
                    Elemento elemento = new Elemento();

                    switch (opcion){
                        case 1 ->{
                            System.out.println("Has escogido Añadir Libro");
                            System.out.println("¿Cuantos Audios quieres añadir?");
                            int numeroAudios=scanner.nextInt();
                            scanner.nextLine();
                            int id = 0;
                            for (int i = 0; i < numeroAudios; i++) {
                                id = (int) (Math.random()*1500);
                                System.out.println("El id del Libro es: "+id);
                                System.out.println("Introduce el titulo del Libro: ");
                                titulo= scanner.nextLine();
                                System.out.println("Introduce el nombre del autor:");
                                autor = scanner.nextLine();
                                isbn = String.valueOf(Math.random()*2500+i);
                                System.out.println("el ISBN asignado es: "+isbn);
                                System.out.println("Introduce el numero de paginas: ");
                                numeroPaginas = scanner.nextInt();
                                scanner.nextLine();
                                elemento = new Libro(id,titulo,autor,isbn,numeroPaginas);
                                gestionMultimedia.aniadirElemento(elemento);
                            }
                        }
                        case 2 ->{
                            System.out.println("Has escogido Eliminar audio");
                            System.out.println("Introduce el id del libro que quieres borrar: ");
                            int opcionBorrado = scanner.nextInt();
                            scanner.nextLine();
                            gestionMultimedia.eliminarElemento(opcionBorrado);
                        }
                        case 3 ->{
                            System.out.println("Has escogido Listar elementos");
                            gestionMultimedia.listarElementos();
                        }
                    }
                }
                case "C"->{
                    System.out.println("Has escogido Video");
                    System.out.println("¿Que quieres hacer?");
                    System.out.println("1. Añadir un Video");
                    System.out.println("2. Eliminar un Video");
                    System.out.println("3. Listar Videos");
                    int opcion = scanner.nextInt();
                    String titulo =null, autor=null, director=null;
                    int duracion =0;
                    Video video = new Video();

                    switch (opcion){
                        case 1 ->{
                            System.out.println("Has escogido Añadir video");
                            System.out.println("¿Cuantos actores quieres añadir (principales o secundarios)?");
                            int numeroActores=scanner.nextInt();
                            scanner.nextLine();
                            Actor actor = new Actor();
                            ArrayList<Actor> actores= new ArrayList<>();
                            for (int i = 0; i < numeroActores; i++) {
                                System.out.println("Introduce el nombre del actor: ");
                                String nombreActor= scanner.nextLine();
                                System.out.println("¿Es secundario o principal?");
                                String principalOSecundario= scanner.nextLine();
                                actor= new Actor(nombreActor,principalOSecundario);
                                actores.add(actor);
                            }
                            System.out.println("¿Cuantos Videos quieres añadir?");
                            int numeroVideos=scanner.nextInt();
                            scanner.nextLine();
                            int id = 0;
                            for (int i = 0; i < numeroVideos; i++) {
                                id = (int) (Math.random()*1500);
                                System.out.println("El id del Video es: "+id);
                                System.out.println("Introduce el titulo del Video: ");
                                titulo= scanner.nextLine();
                                System.out.println("Introduce el nombre del autor:");
                                autor = scanner.nextLine();
                                System.out.println("Introduce el nombre del director:");
                                director = scanner.nextLine();
                                System.out.println("Introduce la duracion del Video: ");
                                duracion = scanner.nextInt();
                                scanner.nextLine();
                                video= new Video(id,titulo,autor,director,actores,duracion);
                                gestionMultimedia.aniadirElemento(video);
                            }
                        }
                        case 2 ->{
                            System.out.println("Has escogido Eliminar Video");
                            System.out.println("Introduce el id del libro que quieres borrar: ");
                            int opcionBorrado = scanner.nextInt();
                            scanner.nextLine();
                            gestionMultimedia.eliminarElemento(opcionBorrado);
                        }
                        case 3 ->{
                            System.out.println("Has escogido Listar elementos");
                            gestionMultimedia.listarElementos();
                        }
                    }
                }
                case "D" ->{
                    System.out.println("Saliendo...");
                    jugarOtraVez=false;
                }
            }
        }while (jugarOtraVez);
    }
}