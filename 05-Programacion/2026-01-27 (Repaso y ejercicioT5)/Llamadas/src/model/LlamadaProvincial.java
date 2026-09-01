package model;

public class LlamadaProvincial extends Llamada implements Tarificable{
    private final double COSTE_SEG = 0.15;
    @Override
    public void calcularCoste() {
        setCoste(getDuracion()*COSTE_SEG);
    }

    public LlamadaProvincial(){}
    public LlamadaProvincial(long nOrigen, long nDestino, int duracion){
        super(nOrigen, nDestino, duracion);
        calcularCoste();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Llamada PROVINCIAL");
        super.mostrarDatos();
    }
}
