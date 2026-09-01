package model;

public final class Actor {
    private String nombre;
    private String papel;

    public Actor(){}
    public Actor(String nombre, String papel) {
        this.nombre = nombre;
        this.papel = papel;
    }
    @Override
    public String toString(){
        return nombre +" ("+papel+")";
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }
}
