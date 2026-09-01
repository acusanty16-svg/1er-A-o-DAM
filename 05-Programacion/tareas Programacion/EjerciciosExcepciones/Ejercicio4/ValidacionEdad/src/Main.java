import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Introduce tu edad"
        );
        boolean edadValida=false;
        int intentos=0;
        int intentosMax=3;
        Scanner scanner = new Scanner(System.in);
        while(!edadValida && intentos<intentosMax){
            try{
                int edad=scanner.nextInt();
                validadEdad(edad);
                edadValida=true;
            }catch (EdadInvalidaException e){
                intentos++;
                System.out.println("Registro denegado: "+e.getMessage());
                System.out.println("Te quedan "+(intentosMax-intentos)+" intentos");
            }catch (InputMismatchException e){
                intentos++;
                System.out.println("Introduce un numero y no una letra");
                System.out.println("Te quedan "+(intentosMax-intentos)+" intentos");
                scanner.next();
            }
        }
        if(!edadValida){
            System.out.println("Te quedaste sin intentos");
        }else {
            System.out.println("Gracias por jugar");
        }

    }
    public static void validadEdad(int edad){
    if (edad<20 || edad>120){
        throw new EdadInvalidaException("Debes se mayor de 20 años y menor de 120");
    }
        System.out.println("Bienvenido registro completado");
    }
}