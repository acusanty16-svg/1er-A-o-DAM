import java.util.Scanner;

public class tareaBorja {

   /* public void ejercicioNotion4Tema2 (){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Que numero quieres comprobar si es par");
        int numero = scanner.nextInt();
        boolean numeroPar = numero%2==0;
        System.out.printf("el numero %d es par: %b",numero,numeroPar);
        scanner.close();
    }

    */
public void ejercicioNotion10Tema2 (){

    Scanner scanner = new Scanner(System.in);
    System.out.println("Indica el salario base: ");
    int salarioBaseHora = scanner.nextInt();
    System.out.println("Indica horas trabajadas: ");
    int horasTrabajadas = scanner.nextInt();
    System.out.println("has realizado horas extras: ");
    boolean horasExtras = scanner.nextBoolean();

    boolean condicionExtras = horasTrabajadas>40 && horasExtras;
        int horasExtrasTotal = horasTrabajadas -40;
         int salarioBase= 40*salarioBaseHora;
         int salarioBaseExtra = horasExtrasTotal*salarioBaseHora*2;
         int salarioTotal = salarioBase+salarioBaseExtra;
         System.out.println("Has cobrado un total de: "+salarioTotal);
         System.out.println("Has cobrado una base de: "+salarioBase);
         System.out.println("Has cobrado un extra de: "+salarioBaseExtra);


}
}
