import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Controler controler = new Controler();
        Scanner scanner = new Scanner(System.in);
        int opcion;
        do {
            System.out.println("1 Añadir correo");
            System.out.println("2 listar correo");
            System.out.println("3 buscar correo");
            System.out.println("4 Salir");
            System.out.println("Indica la opcion que quieres hacer");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1->{
                    System.out.println("Dime el correo que quieres añadir");
                    String correoPedido = scanner.next();
                    if (controler.metodoAnadir(correoPedido)){
                        System.out.println("Usuario agragado correctamente");
                    }else {
                        System.out.println("El usuario no se ha podido agregar");
                    };
                }
                case 2->{controler.metodoListar();}
                case 3->{controler.metodoBuscar();}
            }
        }while(opcion!=4);
    }
}