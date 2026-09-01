package model;

public class CuentaBancaria {
    private String titular;
    private String numeroCuenta;
    private double saldo;

    public CuentaBancaria(){}

    public void ingresar(double sumaIngreso){
        saldo+=sumaIngreso;
        System.out.println("Tu saldo actual es: "+saldo);
    }
    public boolean retirar(double cantidad){
        if (saldo>=cantidad){
            saldo-=cantidad;
            System.out.println("Tu saldo actual es: "+saldo);
            return true;
        }else {
            System.out.println("Saldo insuficiente");
        }
        return false;
    }
    public void transferir(CuentaBancaria destino, double cantidad){
        if (retirar(cantidad)){
           destino.ingresar(cantidad);
            System.out.println("Transferencia realizada con exito");
            System.out.println("Tu saldo actual es: "+saldo);
        }else {
            System.out.println("No se pudo realizar la transferencia");
        }
    }
    public void mostrarInfo(){
        System.out.println("titular = " + titular);
        System.out.println("numeroCuenta = " + numeroCuenta);
        System.out.println("saldo = " + saldo);
    }

    public CuentaBancaria(String titular, String numeroCuenta) {
        this.titular = titular;
        this.numeroCuenta = numeroCuenta;
        this.saldo =0;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    private double getSaldo() {
        return saldo;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
