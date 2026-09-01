package model;

public abstract class Vehiculo {
    private String marca;
    private int modelo;

    public Vehiculo(){}
    public Vehiculo(String marca, int modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }
    public Vehiculo(String marca){
        this.marca=marca;
    }
    public void mostrarDatos(){
        System.out.print("Vehículo: "+marca+" con un numero de modelo: "+modelo);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getModelo() {
        return modelo;
    }

    public void setModelo(int modelo) {
        this.modelo = modelo;
    }
}
