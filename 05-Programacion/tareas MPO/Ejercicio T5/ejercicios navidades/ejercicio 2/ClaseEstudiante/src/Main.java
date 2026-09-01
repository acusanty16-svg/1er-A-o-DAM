import model.Estudiante;

public class Main {
    public static void main(String[] args) {
        Estudiante estudiante = new Estudiante("Santiago",25,5.45,7.85,2);
        Estudiante estudiante1 = new Estudiante("Santiago1",25,10,1,2);
        estudiante.mostrarInforme();
        estudiante1.mostrarInforme();
    }
}