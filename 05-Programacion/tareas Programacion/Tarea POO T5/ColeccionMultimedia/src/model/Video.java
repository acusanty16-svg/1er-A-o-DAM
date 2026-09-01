package model;

import java.util.ArrayList;

public final class Video extends Elemento{
    private String director;
    private ArrayList<Actor> actores;
    private int duracion;

    public Video() {
        this.actores = new ArrayList<>();
    }

    public Video(int id, String titulo, String autor, String director, ArrayList<Actor> actores, int duracion) {
        super(id, titulo, autor);
        this.director = director;
        this.actores = actores;
        this.duracion = duracion;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Esto es un video");
        super.mostrarDatos();
        System.out.println("director = " + director);
        System.out.println("actores = " + actores);
        System.out.println("duracion = " + duracion);
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public ArrayList<Actor> getActores() {
        return actores;
    }

    public void setActores(ArrayList<Actor> actores) {
        this.actores = actores;
    }
}
