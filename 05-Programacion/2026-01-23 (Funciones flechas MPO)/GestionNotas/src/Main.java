import controller.Gestor;
import model.Alumno;

public class Main {
    public static void main(String[] args) {
        Gestor gestor = new Gestor();
        gestor.agregarAlumno(new Alumno("Alumno1", "Alumno1", "1234P",1));
        gestor.agregarAlumno(new Alumno("Alumno2", "Alumno2", "1244P",2));
        gestor.agregarAlumno(new Alumno("Alumno3", "Alumno3", "12345P", 3));
        gestor.agregarAlumno(new Alumno("Alumno4", "Alumno4", "12445P", 4));
        //gestor.calificarAlumno();
        gestor.calificarMedia();
        //gestor.mostrarAlumnos();
    }
}