import controller.ControllerMatematico;

public class Main {
    public static void main(String[] args) {
        ControllerMatematico controller = new ControllerMatematico();
        for (int i = 0; i < 100; i++) {
            System.out.println("EL numero Fb de la posicion "+i+" es: "+controller.calculoNumeroFB(i));
        }
    }
}
