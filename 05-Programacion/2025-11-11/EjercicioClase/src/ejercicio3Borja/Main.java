package ejercicio3Borja;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Creador de pizzas");
        int precioPizza=0;
        String ingredientesString = "";

            System.out.println("El menu de pizza es: ");
            System.out.println("1. Queso");
            System.out.println("2. Jamon");
            System.out.println("3. Piña");
            System.out.println("4. Tomate");
            System.out.println("5. Pepperoni");
            System.out.println("0. Salir");
        for (int i = 0; i < 5; i++) {
            System.out.println("Indica el ingrediente a agregar");
            int ingrediente = scanner.nextInt();
            if (ingrediente!=0){
                switch (ingrediente){
                    case 1 ->{
                        precioPizza+=10;
                        ingredientesString +="Queso ";
                    }
                    case 2 ->{
                        precioPizza+=15;
                        ingredientesString +="Jamon ";

                    }
                    case 3 ->{
                        precioPizza+=8;
                        ingredientesString +="Piña ";

                    }
                    case 4 ->{
                        precioPizza+=6;
                        ingredientesString +="Tomate ";

                    }
                    case 5 ->{
                        precioPizza+=12;
                        ingredientesString +="Pepperoni ";

                    }

                }
            }else{
                break;
            }

        }
        System.out.println("EL precio de la pizza es: "+precioPizza);
        System.out.println("Los ingredientes de la pizza son: "+ingredientesString);
    }
}
