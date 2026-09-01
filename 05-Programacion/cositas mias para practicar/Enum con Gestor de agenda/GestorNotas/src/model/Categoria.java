package model;

public enum Categoria {
    ALIMENTACION("Producto alimenticios"),
    TECNOGOLOGICO("Producto tecnologico"),
    MUEBLES;

    private String descripcion;

    Categoria(){}

    Categoria(String descripcion){
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
