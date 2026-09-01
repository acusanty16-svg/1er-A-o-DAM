package model;


import lombok.*;

@Getter
@Setter
@Data
@AllArgsConstructor
public class Coche {
    private String color, bastidor,marca, modelo;
    private int cv, velocidad;
    private double precio;
    private boolean usado;

    public Coche(){}
    public Coche(String marca, String modelo, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Coche(String marca, String modelo, int cv, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.cv = cv;
        this.precio = precio;
    }

    public Coche(String marca, String modelo, String bastidor, String color, double precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.bastidor = bastidor;
        this.color = color;
        this.precio = precio;
    }
    public void mostrarDatos(){
        System.out.println("Mostrando datos: ");
        System.out.println("Marca: "+marca);
        System.out.println("Modelo: "+modelo);
        System.out.println("Bastidor: "+bastidor);
        System.out.println("Color: "+color);
        System.out.println("Cv: "+cv);
    }

   /* public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBastidor() {
        return bastidor;
    }

    public void setBastidor(String bastidor) {
        this.bastidor = bastidor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCv(){
        return this.cv;
    }

    public void setCv(int cv){
        this.cv+=cv;
    }

    public boolean isUsado() {
        return usado;
    }

    public void setUsado(boolean usado) {
        this.usado = usado;
    }*/
    @Override
    public String toString(){
        return this.modelo+" "+this.marca+" "+this.precio;
    }
}
