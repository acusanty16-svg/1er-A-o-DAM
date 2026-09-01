import model.Rectangulo;

public class Main {
    public static void main(String[] args) {
        double escalar=5;
        Rectangulo rectangulo = new Rectangulo(5,80);
        rectangulo.mostrarInfo();
        rectangulo.escalar(escalar);
        Rectangulo rectangulo1 = new Rectangulo(80,80);
        rectangulo1.mostrarInfo();
        rectangulo1.escalar(escalar);

    }
}