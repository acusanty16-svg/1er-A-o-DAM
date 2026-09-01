import java.util.Scanner;

public class SentenciaSwitch {

    public void usoSwitch(int numero){
        //obtenido por el usuario o por parametros
        int valor = numero;
        //1,5,7, resto
        String nombre;
        switch (valor){
            case 1:
                //cuerpo cuando la variable toma valor 1
                System.out.println("Toma valor de 1");
                nombre = "Paco";
                break;
            case 5:
                //cuerpo cuando la variable toma valor 5
                System.out.println("Toma valor de 5");
                nombre = "Salome";
                break;
            case 7:
                System.out.println("Toma valor de 7");
                nombre = "Andres";
                //cuerpo cuando la variable toma valor 7
                break;
            default:
                nombre = "Sin nombre";
                System.out.println("Valor no contemplado");
        }
        System.out.println("El nombre resultante es: "+nombre);
        System.out.println("terminando el bloque de Switch");
    }
    public void usoSwitchString (String nombr){
    String nombre=nombr;
        switch (nombre.toLowerCase()){
            case "borja":
                System.out.println("El nombre es Borja");
                break;
            case "maria":
                System.out.println("El nombre es Maria");
                break;
            case "joñi":
                System.out.println("El nombre es Toñi");
                break;
            default:
                System.out.println("Nombre no contemplado");
        }

    }
    public void usoSwitchChar (){

        char letra ='A';
        switch (letra){
            case 'A':
                break;
            case 'B':
                break;
            case 'a':
                break;
            case 'C':
                break;
            case 'd':
                break;
            default:
                System.out.println("Letra no contemplada");
        }
    }
    public void usoSwitchlambda(){

        int nota =7;
        switch (nota){
            case 1->{
                System.out.println("Seleccionado el caso 1");
            }
            case 2->{
                System.out.println("Seleccionado el caso 2");
            }
            case 3->{
                System.out.println("Seleccionado el caso 3");

            }
            case 4,5,6,7,8,9-> {
                System.out.println("Seleccionado el caso 4");

            }
            default -> {
                System.out.println("Sin contemplar");
            }
        }
    }
    public void menuOpciones(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Menu operaciones");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("Que operacion quieres hacer? ");
    int opcion = scanner.nextInt();
        System.out.println("Dimer el primer operando");
        int op1 = scanner.nextInt();
        System.out.println("Dimer el segundo operando");
        int op2 = scanner.nextInt();
        double resultado = 0;
    switch (opcion){
        case 1->{

            System.out.println("Vas a sumar");
           resultado= op1 + op2;

        }
        case 2->{
            System.out.println("Vas a restar");
            resultado= op1 - op2;

        }
        case 3->{
            System.out.println("Vas a multiplicar");
            resultado= op1 * op2;

        }
        case 4->{
            System.out.println("Vas a dividir");
            if (op2==0){
                System.out.println("resultado incierto, se aplica la regla de 0");
                resultado =0;
            }else {
                resultado= (double)op1 / op2;
            }




        }
        case 5->{
            System.out.println("Vas a modular");
            resultado= op1 % op2;

        }
        default -> {
            System.out.println("Datos incorrectos");
        }
    }
        System.out.printf("el resultado de la operacion es: %.1f\n",resultado);
    }
}
