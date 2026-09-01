package model;

public class Cuadrado extends Figura{
    private double lado;
    public Cuadrado(){}
    public Cuadrado(double lado){
        this.lado=lado;
    }
    @Override
    public void calcularArea() {
        double area= lado*lado;
        System.out.println("El lado del objeto es: "+lado+" y su area es: "+area);
    }

    public double getLado() {
        return lado;
    }

    public void setLado(double radio) {
        this.lado = radio;
    }
}

