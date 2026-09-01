public class Operadores {

    public void operadoresAritmeticos (){
        //unarios
        int operando1 = 5;
        //incremento un valor -> para poder hacer un contador
        operando1++;
        operando1++;
        operando1++;
        operando1++;
        System.out.println("el valor del operando1 despues de los incrementos es: "+operando1);
        //decremento -> le resta uno al valor que ya tenia ->
        operando1--;
        operando1--;
        operando1--;
        System.out.println("el valor del operando1 despues de los decrementos es: "+operando1);
        //Binarios->necesitan dos operadores: suma (+), resta (-), multi (*), div (/) modulo-resto division
        operando1 = 8;
        int operandodos = 3;
        int suma = operando1 + operandodos;
        System.out.println("El resultado de la suma es: "+suma);
        int resta = operando1 - operandodos;
        System.out.println("el resultado de la resta es: "+resta);
        int multiplicacion = operando1 * operandodos;
        System.out.println("el resultado de la multiplicacion es: "+multiplicacion);
        double division = (double)operando1 / operandodos;
        System.out.println("el resultado de la division es: "+division);
        int modulo = operando1%operandodos;
        System.out.println("el modulo de la division es: "+modulo);
        //me vale para saber si un numero es par o impar





    }
    public void operadoresAsignacion (){

        int operadorUno = 10;
        int operadorDos = 6;
        operadorUno +=5; //en operadorUno guarda la suma de lo que valia operadorUno +5
        operadorUno +=operadorDos;
        System.out.println("El valor de operadorUno es: "+operadorUno);
        operadorUno-=5; //16
        operadorUno*=2; //32
        operadorUno%=2; //0
        System.out.println("El resultado de las asignaciones completas es de: "+operadorUno);
    }

   //seran utlizados en condiciones para ejecutar una parte del codigo u otra
    public void  operadoresComparacion (){
        int operandoUno = 30;
        int operandoDos = 20;
        boolean resultado = operandoUno > operandoDos;
        System.out.println("El resultado de la comparacion es: "+resultado);
        resultado = operandoUno<operandoDos;
        System.out.println("El resultado de la comparacion es: "+resultado);
    resultado = operandoUno<=operandoDos;
    resultado = operandoUno>=operandoDos;
    resultado = operandoUno==operandoDos;
    resultado = operandoUno!=operandoDos;
    //cuanto quieres cobrar
        //cuantos años tienes
        //tienes carnet


    }
    public void operadoreslogicos(){
int sueldo = 20000;
int edad = 45;
boolean conducir = true;
//cuando quiere cobrar menos de 30000 y tiene menos de 40 años y puede conducir
boolean candidatoValido = sueldo<30000 && edad<40 && conducir; //false
        candidatoValido= sueldo<=20000 || edad<25 || conducir && sueldo>25000 && edad>60;
        System.out.println("EL candidato es valido: "+candidatoValido);

    }
    public void evaluarCandidato (double sueldo, int edad, boolean conducir, String nombre){
        boolean resultado = sueldo<=20000 && edad<40 && conducir;
        System.out.println("Evaluando al candidato: "+nombre);
        System.out.println("La evaluacion del candidato es: "+resultado);
    }
}
