import controller.Gestor;
import model.Alumno;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        gestor.agregarAlumno(new Alumno("Alumno1", "Alumno1", "1234P",1));
        gestor.agregarAlumno(new Alumno("Alumno3", "Alumno3", "12345P", 6));
        gestor.agregarAlumno(new Alumno("Alumno4", "Alumno4", "12445P", 9));
        gestor.agregarAlumno(new Alumno("Alumno2", "Alumno2", "1244P",7));
        gestor.agregarAlumno(new Alumno("Alumno5", "Alumno3", "12347P", 10));
        gestor.agregarAlumno(new Alumno("Alumno6", "Alumno3", "12348P", 2));
        //gestor.calificarAlumno();
        //gestor.calificarMedia();
        //gestor.mostrarAlumnos();
        //System.out.println(gestor.getNumeroAprobados());
        //gestor.getAprobados().forEach(Alumno::mostrarDatos);
       /* if (gestor.getAlumnoByDni("1234B").isPresent()){
            System.out.println("El usuario esta");
        }else {
            System.out.println("El usuario no esta");
        }*/
        String dni ="678B";
       // gestor.getAlumnoByDni(dni).ifPresent(Alumno::mostrarDatos);
        gestor.getAlumnoByDni(dni).ifPresentOrElse(Alumno::mostrarDatos,
                ()->gestor.agregarAlumno(new Alumno("nuevo", "nuevo",dni,4)));
        //gestor.ordenarNotas();
        //gestor.mostrarAlumnos();
        //gestor.getAlumnosUmbral(6);
        System.out.println("Que nota quieres como umbral: ");
        Scanner scanner= new Scanner(System.in);
        int umbral = scanner.nextInt();
        gestor.getAlumnosUmbral((item, nota)->item.getNota()>nota, umbral);
        gestor.getAlumnosUmbral((item, nota)->item.getNota()<nota, 8);
        gestor.getAlumnosUmbral((item, nota)->(item.getNota()*2)/3<nota, 8);
    }
}