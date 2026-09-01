public class TareasBorja {


    public void ejercicio1Tema3(int edad){

        if (edad>=18){
            System.out.println("Eres mayor de edad. Puedes votar");
        }else {
            System.out.println("No eres mayor de edad y no puedes votar");
        }
    }
    public void ejercicio2Tema3 (int edad){
        if (edad>0){
            System.out.println("El numero es positivo");
        }else {
            System.out.println("El numero es negativo");
        }

    }
    public void ejercicio3Tema3 (int edad){
        if (edad>=0 && edad<=10){
            if (edad>=5) {
                System.out.println("¡Enhorabuena! Has aprobado");
            }else {
                System.out.println("¡Lo sentimos! A la proxima chaval");
            }
        } else {
            System.out.println("Error, fuera de rango");
        }

    }
    public void ejercicio4Tema3 (double precio){

        if(precio>0) {
            if (precio >= 100) {
                double descuento = (precio * 0.1);
                double importeTotal = precio - (precio * 0.1);
                System.out.println("Importe original: " + precio);
                System.out.println("Descuento aplicado: " + descuento);
                System.out.println("Importe final: " + importeTotal);
            } else {
                System.out.println("Importe original: " + precio);
                System.out.println("No tienes descuento porque la compra es inferior a 100");
                System.out.println("Importe final: " + precio);

            }
        }else{
            System.out.println("Error, fuera de rango");
        }

    }
    public void ejercicio5Tema3 (int numero){

        if(numero%2==0){
            System.out.println("El numero "+numero+" es par.");
        }else {
            System.out.println("El numero "+numero+" es impar.");
        }
    }
    public void ejercicio6Tema3 (int edad){

        if (edad>0){
            if (edad<=16){
                System.out.println("Acceso denegado");
            }else{
                System.out.println("Acesso permitido");
            }

        }else{
            System.out.println("Fuera de rango");
        }
    }
    public void ejercicio7Tema3 (int nota){

        if(nota>=0 && nota<=10){
            if (nota<=4){
                System.out.println("Has suspendido chavar, a la proxima será. porque tu nota es: "+nota);
            } else if (nota<=6) {
                System.out.println("tu calificacion es : "+nota+" aprobado");
            } else if (nota<=8) {
                System.out.println("tu calificacion es : "+nota+" Notable");
            } else {
                System.out.println("tu calificacion es : "+nota+" Sobresaliente");
            }
        }else{
            System.out.println("Error, fuera de rango");
        }
    }


    public void practicas(int edad){

        int age = 18;
        boolean ismael = age >= 18;
        if (ismael){
            System.out.println("Acces granted");
        }else{
            System.out.println("Better luck next time, buddy");
        }

    }
}
