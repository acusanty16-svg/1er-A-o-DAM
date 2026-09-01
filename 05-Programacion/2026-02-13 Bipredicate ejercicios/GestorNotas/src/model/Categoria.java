package model;

public enum Categoria {
    ALIMENTICION, MUEBLES("Esta categoria es de mueble para decorar"),
    ROPA,
    TECNOLOGICO("Esta categoria marca productos de ultima generación");

    private String descripcion;

    Categoria(){
    }
    Categoria(String descripcion){
        this.descripcion = descripcion;
    }
    public String getDescripcion(){
        return descripcion;
    }
}
