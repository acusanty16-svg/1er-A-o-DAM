import java.util.ArrayList;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        BiConsumer<String, ArrayList<String>> agregarALista = (nombre, lista)->{
            String formato = "Estudiante: "+nombre;
            lista.add(formato);
        };
        ArrayList<String> estudiantes = new ArrayList<>();

        agregarALista.accept("Santiago",estudiantes);
        agregarALista.accept("Daniel",estudiantes);

        System.out.println("----Agenda Estudiantes----");
        estudiantes.stream().forEach(System.out::println);
    }
}