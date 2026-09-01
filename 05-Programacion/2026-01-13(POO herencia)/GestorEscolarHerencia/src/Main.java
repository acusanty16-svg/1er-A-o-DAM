import model.Alumno;
import model.Persona;
import model.Profesor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido al gestor escolar");
        /*Persona borja= new Persona("Borja","Martin");
        borja.saludar();
        borja.mostrarDatos();*/
        Alumno alumno1= new Alumno("Borja1","Martin",1234,"DAM");
        Alumno alumno2= new Alumno("Borja2","Martin",1234,"DAM");
        Alumno alumno3= new Alumno("Borja3","Martin",1234,"DAM");
        Alumno alumno4= new Alumno("Borja4","Martin",1234,"DAM");
        /*alumno.setNombre("Borja");
        alumno.setApellido("Martin");
        alumno.setCurso("DAM");
        alumno.setnMatricula(1234);*/
        Profesor profesor1= new Profesor("Maria1","Lopez",30000,6);
        Profesor profesor2= new Profesor("Maria2","Lopez",30000,6);
        Profesor profesor3= new Profesor("Maria3","Lopez",30000,6);
        Profesor profesor4= new Profesor("Maria4","Lopez",30000,6);

        ArrayList<Persona>listaPersonas=new ArrayList<>();
        listaPersonas.add(alumno1);
        listaPersonas.add(alumno2);
        listaPersonas.add(alumno3);
        listaPersonas.add(alumno4);
        listaPersonas.add(profesor1);
        listaPersonas.add(profesor2);
        listaPersonas.add(profesor3);
        listaPersonas.add(profesor4);

        for(Persona item:listaPersonas){
            item.saludar();
            item.mostrarDatos();
            if(item instanceof Alumno){
                ((Alumno) item).realizarExamen();
            }else if(item instanceof Profesor){
                ((Profesor)item).corregirExamen();
            }
        }
        /*ArrayList<Alumno>listaAlumnos=new ArrayList<>();
        listaAlumnos.add(alumno1);
        listaAlumnos.add(alumno2);
        listaAlumnos.add(alumno3);
        listaAlumnos.add(alumno4);
        ArrayList<Profesor>listaProfesorres=new ArrayList<>();
        listaProfesorres.add(profesor1);
        listaProfesorres.add(profesor2);
        listaProfesorres.add(profesor3);
        listaProfesorres.add(profesor4);*/

        //alumno.mostrarDatos();
//        alumno.realizarExamen();

    }
}