package model;

public class Pelicula {
    private String titulo, director;
    private int duracion, anio;
    private double calificacion;

    public Pelicula (){}
    public Pelicula(String titulo, String director, int duracion, int anio, double calificacion) {
        this.titulo = titulo;
        this.director = director;
        this.duracion = duracion;
        this.anio = anio;
        this.calificacion = calificacion;
    }

    public String obtenerDuracionFormateada(){
        int minutos=duracion%60;
        int horas=duracion/60;
        return String.format("La duracion de la pelicula es: %dH%02d",horas,minutos);
    }
    public boolean esClasica(){
        return anio<2000;
    }
    public boolean esRecomendable(){
        return getCalificacion()>7;
    }
    public void mostrarInformacion(){
        System.out.println("titulo = " + titulo);
        System.out.println("director = " + director);
        System.out.println("duracion = " + duracion);
        System.out.println("año = " + anio);
        System.out.println("calificacion = " + calificacion);
        String duracionPelicula= obtenerDuracionFormateada();
        System.out.println(duracionPelicula);
        if (esClasica()){
            System.out.println("la pelicula es clasica porque tiene: "+(2026-anio));
        }
        if (esRecomendable()){
            System.out.printf("La pelicula es recomendable porque tiene: %.1f de calificacion%n",getCalificacion());
        }

    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        if (duracion<0 ){
            System.out.println("Imposible imprimir una duracion negativa");
        }else {
            this.duracion = duracion;
        }
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        if (anio>2026 || anio<1895){
            System.out.println("Año fuera de rango (1895-2026)");
        }else {
            this.anio = anio;
        }
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        if (calificacion<0 || calificacion>10){
            System.out.println("!!Error¡¡ calificacion incorrecta");
        }else {
            this.calificacion=calificacion;
        }

    }
}
