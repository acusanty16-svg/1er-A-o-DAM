package model;

public class Coche extends Vehiculo{
    private int numeroPuertas;
    public Coche(){};
    public Coche(String marca, int modelo, int numeroPuertas){
        super(marca,modelo);
        this.numeroPuertas=numeroPuertas;
    }
    public Coche(String marca, int numeroPuertas){
    super(marca);
    this.numeroPuertas=numeroPuertas;
    }
    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println(", tiene: "+numeroPuertas+" puertas");
    }

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }


}
