package model;

public class Circulo extends Figura{
    private double radio;
    public Circulo(){}
    public Circulo(double radio){
        this.radio=radio;
    }
    @Override
    public void calcularArea() {
        double area= Math.PI* Math.pow(radio,2);
        System.out.println("El radio del objeto es: "+radio+" y su area es: "+area);
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }
}
