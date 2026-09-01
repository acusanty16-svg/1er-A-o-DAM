package model;

public class Gerente extends Empleado{
    private double bonus;

    public Gerente(){}
    public Gerente(double bonus) {
        this.bonus = bonus;
    }

    public Gerente(String nombre, double salarioBase, double bonus) {
        super(nombre, salarioBase);
        this.bonus = bonus;
    }

    public void calcularSalarioTotal(){
    mostrarDatos();
        System.out.println("Puesto = Gerente");
        System.out.println("bonus = " + this.bonus);
        System.out.println("Salario total: " + (bonus+getSalarioBase()));
        System.out.println();
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
}
