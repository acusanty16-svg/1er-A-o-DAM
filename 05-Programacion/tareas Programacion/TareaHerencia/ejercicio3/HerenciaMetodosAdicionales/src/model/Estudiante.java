package model;

public class Estudiante extends Persona{
    int curso;
    public Estudiante(){}
    public Estudiante(String nombre, int edad, int curso){
        super(nombre,edad);
        this.curso=curso;
    }
    @Override
    public void presentarse() {
        super.presentarse();
        System.out.println("Estoy estudiando: "+curso+" DAM");
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }
}
