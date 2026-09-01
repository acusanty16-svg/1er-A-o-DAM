import java.sql.SQLOutput;

public class Main{
    public enum DiaSemana{
        lunes, Martes, Miercoles, jueves, Viernes, Sabado, Domingo
    }

    public static void main(String[] args) {
        DiasSemana diaSemana = DiasSemana.Martes;


      /*  switch (diaSemana) {
            case lunes, Martes, Miercoles, Jueves -> {
                System.out.println("Laborable");
            }
            case Viernes -> {
                System.out.println("Laborable, casi lo tenemos");
            }
            case Sabado, Domingo -> {
                System.out.println("Descanso");
            }
        }
        MesesAnio mesActual = MesesAnio.Febrero;
        /*System.out.println("La fecha de hoy es 7 de"+MesesAnio.Noviembre+" de 2025 y es "+DiasSemana.Viernes);*/
       /* System.out.printf("La fecha de hoy es %d de %s %d y es %s estamos en la estacion de %s, los dias que tiene este mes es: %d"
                , 7, mesActual, 2025, DiasSemana.Viernes, mesActual.estacion, mesActual.dias);*/


        int numero = 22;
        //Quiero saber el rango del numero registrado
        //de normal se haria con la sentencia if
        // if numero >=0 && numero<10
        // else if numero >=10 && numero<20
        // else if numero >=20 && numero<30
        //pero tambien se podria encontrar dentro de un swtich, pero se escribe un poco diferente
        //level deberia estar en 23
        //la variable a evaluar en los casos debe ser FINAL
        /*final int NUMERO=12;
        switch (true){
            case (NUMERO>=0 && NUMERO<10)->{
                System.out.println("3214");
            }
            case (NUMERO>=10 && NUMERO<20)->{
                System.out.println("3214");

            }
        }

    }*/
    Operaciones operaciones = new Operaciones();
    operaciones.evaluarServidor(" ");

    }
}