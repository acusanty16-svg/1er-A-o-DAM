import model.Calculadora;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido a la aplicacion del testing");
        Calculadora calculadora = new Calculadora();
        System.out.println(calculadora.sumar(55,8));;
        System.out.println(calculadora.restar(55,8));;
        System.out.println(calculadora.multiplicar(5,7));;
        System.out.println(calculadora.dividir(4,0));
    }
}
