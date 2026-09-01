import java.util.Scanner;

public class Main{

    public static void main (String[]args){

        System.out.println("Iniciando programa de operadores");
        Operadores operadoresVariables = new Operadores();
        operadoresVariables.operadoresAritmeticos();
        operadoresVariables.operadoresAsignacion();
        operadoresVariables.operadoresComparacion();
        operadoresVariables.operadoreslogicos();
        Scanner lectorTeclado = new Scanner(System.in);
        System.out.println("Dime tu nombre y apellido: ");
        String nombre = lectorTeclado.nextLine();
        System.out.println("Que salario quieres ganar");
        double salarioEntrada = lectorTeclado.nextDouble();
        System.out.println("Que edad tienes");
        int edad = lectorTeclado.nextInt();
        System.out.println("Tienes permiso de conducir");
        boolean conducir = lectorTeclado.nextBoolean();
        operadoresVariables.evaluarCandidato(salarioEntrada,edad,conducir,nombre);

    }
}