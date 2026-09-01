import java.util.Scanner;

public class Ejercicio {

    private Scanner lecturaTeclado;
   /* public void ejercicio1 (){
        //segmento el problema por primera vez
        //1. introducir valores
        //2. guardar variables
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Cuantos bocatas van a pedir: ");
        int numeroBocatas = lecturaTeclado.nextInt();
        System.out.println("Cuantos bebidas van a pedir: ");
        int numeroBebidas = lecturaTeclado.nextInt();
        System.out.println("Cuanto cuesta cada bocata van a pedir: ");
        double precioBocata = lecturaTeclado.nextDouble();
        System.out.println("Cuanto cuesta cada bebida van a pedir: ");
        double precioBebida = lecturaTeclado.nextDouble();
        System.out.println("Cuantas personas entran en la cuenta: ");
        int personas = lecturaTeclado.nextInt();
        //3. realizar calculos
        double precioBocatas = numeroBocatas *precioBocata;
        double precioBebidas = numeroBebidas *precioBebida;
        double precioTotal = precioBocatas + precioBebidas;
        double precioPersona = precioTotal/personas;

        //4. Mostrar datos
        System.out.printf("El precio de los bocatas es: %.2f\n",precioBocatas);
        System.out.printf("El precio de los bebidas es: %.2f\n",precioBebidas);
        System.out.printf("El precio total es: %.2f\n",precioTotal);
        System.out.printf("El precio por persona es: %.2f\n",precioPersona);
        lecturaTeclado.close();
        lecturaTeclado=null;
    }
    public void ejercicio4 (){
        //1. pedir datos
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Cuantos segundos quieres pasar a tiempo: ");
        int segundosTotal = lecturaTeclado.nextInt();
        //2. realizar los calculos
            //segundos --> 1 hora --> 3600
            //minutos --> 1 hora --> 60
            //segundos --> 1 minuto --> 60
        int horas = segundosTotal/3600;
        int minutos = (segundosTotal%3600)/60;
        int segundos = segundosTotal%60;
        //3. mostrar los datos
        System.out.println("Número de horas es: "+horas);
        System.out.println("Número de minutos es: "+minutos);
        System.out.println("Número de segundos es: "+segundos);
        lecturaTeclado.close();
        lecturaTeclado = null;

    }
    public void
*/
 /*  public void ejercicio2 (){
        lecturaTeclado = new Scanner(System.in);
        //1.introducir valores
        System.out.println("Valor de la compra(entre 0.00 y 500.00): ");
        double valorCompra = lecturaTeclado.nextDouble();
        //2.guardar IVA
        System.out.println("IVA(entre 0 y 25%): ");
        int valorIva = lecturaTeclado.nextInt();
        //3.realizar calculos
       //compra-->Iva-->valorTotal
       //iva = compra *
       double decimaliva = (double) valorIva /100;
        double iva = valorCompra * decimaliva;
        double compra = valorCompra - iva;


        //4.mostrar resultados
        System.out.printf("Compra: %.2f\n",compra);
        System.out.printf("IVA: %.2f",iva);


        lecturaTeclado.close();
        lecturaTeclado = null;
    }
*/

    public void ejercicio3 (){

        //1. introducir 5 numeros
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Decenas de miles: ");
        String decenasMiles = lecturaTeclado.nextLine();
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Unidades de mil: ");
        String unidadesMiles = lecturaTeclado.nextLine();
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Centenas: ");
        String centenasMiles = lecturaTeclado.nextLine();
        System.out.println("Decenas: ");
        String decenas = lecturaTeclado.nextLine();
        lecturaTeclado = new Scanner(System.in);
        System.out.println("Unidades: ");
        String unidades = lecturaTeclado.nextLine();
        lecturaTeclado = new Scanner(System.in);

        String resultado = decenasMiles + unidadesMiles +centenasMiles +decenas +unidades;
        System.out.println("Numero introducido: "+resultado);

        //2. replicar los numeros con uniones
        //3. mostrar el resultado
    }
}

