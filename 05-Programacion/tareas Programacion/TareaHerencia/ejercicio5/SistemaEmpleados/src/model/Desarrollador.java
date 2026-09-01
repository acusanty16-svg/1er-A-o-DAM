package model;

public class Desarrollador extends Empleado{
    private String lenguajePrincipal;
    public Desarrollador(){}

    public Desarrollador(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public Desarrollador(String nombre, double salarioBase, String lenguajePrincipal) {
        super(nombre, salarioBase=3500.00);
        this.lenguajePrincipal = lenguajePrincipal;
    }

    @Override
    public void mostrarDatos() {
        super.mostrarDatos();
        System.out.println("Puesto = Desarrollador");
        System.out.println("lenguajePrincipal = " + lenguajePrincipal);
        System.out.println();
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }
}
