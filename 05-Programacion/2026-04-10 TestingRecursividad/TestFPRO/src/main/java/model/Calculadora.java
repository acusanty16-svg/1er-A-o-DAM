package model;

public class Calculadora {
    public int sumar(int a, int b){
        return a+b;
    }
    public int restar(int a, int b){
        return a-b;
    }public int multiplicar(int a, int b){
        return a*b;
    }
    public double dividir(int a, int b){
        if (b==0){
            throw new IllegalArgumentException("Error en el parametro divisor");
        }
        return a/b;
    }

}
