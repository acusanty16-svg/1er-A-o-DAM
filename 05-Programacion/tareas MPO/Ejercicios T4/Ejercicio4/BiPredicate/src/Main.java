import java.util.function.BiPredicate;

public  class Main {
    public static void main(String[] args) {
        BiPredicate<String, String> rectificador = (palabra1, palabra2)->{
            if (palabra1.length()==palabra2.length()){
                System.out.println("Las palabras tienen la misma longitud");
                return true;
            }else{
                System.out.println("Las palabras no son iguales");
                System.out.println("La palabra: "+palabra1+" tiene: "+palabra1.length()+" letras");
                System.out.println("La palabra: "+palabra2+" tiene: "+palabra2.length()+" letras");
                return false;
            }
        };
        String palabra1 = "Soy Santi";
        String palabra2 = "Soy Daniel";
        boolean resultado =rectificador.test(palabra1,palabra2);
        System.out.println(resultado);

    }
}