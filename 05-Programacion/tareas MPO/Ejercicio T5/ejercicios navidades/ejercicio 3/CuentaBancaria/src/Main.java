import model.CuentaBancaria;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("---Bienvenido al Banco Santi---");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el titular de la cuenta: ");
        String titular = scanner.nextLine();
        System.out.println("Introduce el numero de la cuenta: ");
        String numero = scanner.nextLine();
        int opcion=0;
        CuentaBancaria cuentaBancaria = new CuentaBancaria(titular,numero);
        do {
            System.out.println("¿Qué quieres realizar?");
            System.out.println("1. realizar ingreso ");
            System.out.println("2. Retirar ingreso ");
            System.out.println("3. Transferir ingreso ");
            System.out.println("4. Mostrar ingreso ");
            System.out.println("5. Salir ");
            opcion = scanner.nextInt();
            switch (opcion){
                case 1: {
                    System.out.println("Ingresa la cantidad que quieres ingresar: ");
                    double ingreso= scanner.nextDouble();
                    cuentaBancaria.ingresar(ingreso);
                    break;
                }
                case 2: {
                    System.out.println("Ingresa la cantidad que quieres retirar: ");
                    double retirar= scanner.nextDouble();
                    cuentaBancaria.retirar(retirar);
                    break;
                }
                case 3: {
                    System.out.println("Ingresa la cantidad que quieres transferir: ");
                    double transferir= scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Introduce el titular de la cuenta bancaria a transferir");
                    String nuevaCuentaBancariaTitu = scanner.nextLine();
                    System.out.println("Introduce el numero de la cuenta bancaria a transferir");
                    String nuevaCuentaBancariaNumero= scanner.nextLine();
                    CuentaBancaria cuentaBancariaNew = new CuentaBancaria(nuevaCuentaBancariaTitu,nuevaCuentaBancariaNumero);
                    cuentaBancaria.transferir(cuentaBancariaNew,transferir);
                    break;
                }
                case 4: {
                    cuentaBancaria.mostrarInfo();
                    break;
                }
                case 5: {System.out.println("Saliendo del sistema..."); break;}
                default: System.out.println("Opcion no valida");
            }

        }while(opcion!=5);
    }
}