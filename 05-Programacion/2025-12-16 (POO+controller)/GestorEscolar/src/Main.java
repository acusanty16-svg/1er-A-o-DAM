import controller.Colegio;
import model.Alumno;
import model.Asignatura;
import model.Profesor;

import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        /*Asignatura programacion = new Asignatura(1);
        Asignatura sistemas = new Asignatura(2);
        Asignatura marcas = new Asignatura(3);*/
        /*Profesor profesor = new Profesor();
        ArrayList<Alumno> listaAlumnos= new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i < 5; i++) {
            System.out.println("Introduce el nombre de alumno");
            String nombre = scanner.next();
            listaAlumnos.add(new Alumno(i,nombre,new Asignatura(1),new Asignatura(2),new Asignatura(3)));

        }
        System.out.println("Vamos a proceder a poner las notas de los alumnos");
        for(Alumno item:listaAlumnos){
            profesor.ponerNotas(item);
            item.mostradDatos();
            System.out.println("La media del alumno es: "+profesor.calcularMedia(item));
            System.out.println();*/
        /*
        borja.mostradDatos();
        Alumno celia = new Alumno(new Asignatura(1),new Asignatura(2),new Asignatura(3));
        celia.mostradDatos();
        Alumno claudia = new Alumno(new Asignatura(1),new Asignatura(2),new Asignatura(3));
        Profesor profesor = new Profesor();
        profesor.ponerNotas(celia);
        profesor.ponerNotas(claudia);
        System.out.println("LA media obtenida por Borja es: "+profesor.calcularMedia(celia));
        System.out.println("La media obtenida por Claudia es: "+profesor.calcularMedia(claudia));*/
        Scanner scanner = new Scanner(System.in);
        Colegio colegio=new Colegio();
        int opcion =0;
        do {
            System.out.println("1-Matricular alumno");
            System.out.println("2-Poner notas");
            System.out.println("3-Ver notas alumno y media");
            System.out.println("4-Buscar expediente");
            System.out.println("5-Salir");
            System.out.println("Que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Procedemos a matricular");
                    System.out.println("Indica el nombre del Alumno a matricular: ");
                    String nombre = scanner.next();
                    colegio.matricularAlumno(nombre);
                }
                case 2->{
                    colegio.ponerNotas();
                }
                case 3->{
                colegio.mostrarDatos();
                }
                case 4->{
                    System.out.println("Indicame la matricual dle alumno a buscar: ");
                    int alumno =scanner.nextInt();
                    colegio.buscarExpediente(alumno);
                }
                case 5->{
                    System.out.println("Saliendo...");
                }
            }
        }while(opcion!=5);
    }
    }
