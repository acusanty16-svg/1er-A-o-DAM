package model;

public class Rectangulo {
    private double base, altura;

    public Rectangulo(){}
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    public double calcularArea(){
        double area = base*altura;
        if (esCuadrado()){
            System.out.println("No es un rectangulo, es un cuadrado con area de: "+area);
        }else {
            System.out.println("Es un rectangulo con area: "+area);
        }
        return area;
    }
    public double calcularPerimetro(){
        return 2*(base+altura);
    }
    private boolean esCuadrado(){
        return base == altura;
    }
    public void escalar(double escalar){
        base = base*escalar;
        altura=altura*escalar;
        System.out.println("La figura escalada por un vector es: "+escalar);
    }
    public void mostrarInfo(){
        System.out.println("base = " + base);
        System.out.println("altura = " + altura);
        System.out.println("El perimetro del rectangulo es: "+calcularPerimetro());
        calcularArea();

    }


    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}
