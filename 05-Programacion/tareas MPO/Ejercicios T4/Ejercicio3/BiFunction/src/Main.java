import java.util.function.BiFunction;
enum Operaciones{
    SUMA((a,b)-> a+b),
    RESTA((a,b)->a-b),
    MULTI((a,b)->a-b),
    DIVISION((a,b)-> {
        if (b == 0)throw new ArithmeticException("Division por cero");
        return a / b;
    });
    public final BiFunction<Integer, Integer, Integer> accion;
    Operaciones (BiFunction<Integer, Integer, Integer> accion){
        this.accion=accion;
    }
}

public class Main {
    public static void main(String[] args) {
        try{
            int resultado = Operaciones.SUMA.accion.apply(5,4);
            System.out.println(resultado);
            resultado = Operaciones.DIVISION.accion.apply(5,0);
            System.out.println(resultado);
        }catch (ArithmeticException e){
            System.out.println("No se puede dividir por cero, intentalo con otro numero");
        }
    }
}