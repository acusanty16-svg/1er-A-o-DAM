import model.Alumno;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class MainPruebas {
    public static void main(String[] args) {
        Alumno alumno1 = new Alumno("Santiago","Acuña","12345K",8);
        Alumno alumno2 = new Alumno("Maria","Jimenez","456789L");
        Alumno alumno3 = new Alumno("Pedro","Andrade","123456F");
        Alumno alumno4 = new Alumno("Lorena","Gomez","789456Ñ");
        Alumno alumno5 = new Alumno("Juan","Martin","456123T");
        ArrayList<Alumno> listaAlumnos = new ArrayList<>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        listaAlumnos.add(alumno5);
       /* for(Alumno item:listaAlumnos){
            item.mostrarDatos();
        }*/

      /*  listaAlumnos.forEach(element-> {
            System.out.println("Vamos a imprimir los datos de: "+element.getNombre());
            element.mostrarDatos();
        });*/
        //listaAlumnos.forEach(Alumno::mostrarDatos);
        //listaAlumnos.forEach(Alumno::calcularRestante);
        //listaAlumnos.forEach(Alumno::getNota);
        BiFunction<Double, Integer, Integer> funcionMulti = (p1, p2) ->{
            return (int) (p1*p2);
        };
        listaAlumnos.stream()
                .map(Alumno::getNota)
                .forEach(nota-> System.out.println(funcionMulti.apply(nota,2)));

        //BiFunction<Integer, Integer, Integer> funcionMulti = (p1,p2) -> p1*p2;
    }
}