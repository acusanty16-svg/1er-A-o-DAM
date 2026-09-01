import java.util.Locale;
import java.util.Scanner;

public class Controller {
    Scanner scanner = new Scanner(System.in);
    private static boolean validarContrasenia(String password){
        if (password.length()<8){
            System.out.println("La contraseña debe tener al menos 8 caracteres");
            return false;
        }
        boolean tieneMayus = false;
        for(char c:password.toCharArray()){
            if (Character.isUpperCase(c)){
                tieneMayus=true;
                break;
            }
        }
        if(!tieneMayus){
            System.out.println("La contraseña debe tener al menos una mayuscula");
            return false;
        }
        boolean tieneNumero = false;
        for(char c:password.toCharArray()){
            if(Character.isDigit(c)){
                tieneNumero=true;
                break;
            }
        }
        if (!tieneNumero){
            System.out.println("La contraseña debe tener al menos un numero");
            return false;
        }
        return true;
    }
    public static boolean comprobar (String password){
        boolean resultado= validarContrasenia(password);
        if (resultado){
            System.out.println("¡Contraseña válida!");
        }else {
            System.out.println("Contraseña incorrecta");
        }
        return resultado;
    }
    public static int buscarNumero(int[] numeros, int objetivo){
        int sumando = 0;
        for(int item:numeros){
            if (item==objetivo){
                return sumando;
            }
            sumando++;
        }
        return -1;
    }
    public static void mostrarPares(int[] numeros){

        for(int item:numeros){
            if (item %2 !=0){
                continue;
            }
            System.out.println("Par encontrado: "+item);
        }
    }
    public static void calcularPromedio(double[] notas){
        double sumando =0;
        int contador =0;
        double [] notasValidas = guardarNumeros(notas);
        for(double item:notasValidas){
            if (item<0 || item>10){
                continue;
            }
            System.out.println("NOTA ASIGNADA: "+item);
            sumando+=item;
            contador++;
        }
        if (contador>0){
            double promedio = sumando/contador;
            System.out.printf("PROMEDIO: %.2f%n",promedio);
        }else {
            System.out.println("No hay notas validas para calcular el promedio");
        }
    }
    private static double[] guardarNumeros (double [] notasGuardadas){
    int sumando =0;
        for(double item:notasGuardadas){
            if (item>=0 && item<=10){
                sumando++;
            }
        }
        double [] notasValidas = new double[sumando];
        int sum =0;
        for(double item:notasGuardadas){
            if (item>=0 && item<=10){
                notasValidas[sum++] = item;
            }
        }
        return notasValidas;
    }
    public static boolean intentarLogin (String usuarioCorrecto, String contraseniaCorrecta){
        for(UsuarioContrasenia general:UsuarioContrasenia.values()){
            if (general.getUsuarios().equals(usuarioCorrecto) && general.getContrasenias().equals(contraseniaCorrecta)){
                return true;
            }
        }
        return false;
    }
    public static String procesarTareas(String[]tareas){
        String palabraUrgente = "Urgente";
        for(String item:tareas){
            if (item.equalsIgnoreCase(palabraUrgente)){
                return "urgente";
            }
        }
        return "normal";
    }
    public static void generarFibonacci(int limite){
        int sumatoriaA=0, sumatoriaB=1;
        while(true){
            System.out.println(sumatoriaA);
            int siguiente = sumatoriaB+sumatoriaA;
            if (siguiente>limite){
                break;
            }
            sumatoriaA=sumatoriaB;
            sumatoriaB=siguiente;
        }

    }
    public static int[] guardarEdades (int []edades){
    return contarEdadesValidas(edades);
    }
    private static int[] contarEdadesValidas(int []edades) {
        int contador=0;
        for(int item:edades){
            if (item<0 || item>120){
                continue;
            }
            contador++;
        }
        int [] edadesValidas = new int[contador];
        int conta=0;
        for (int item:edades){
            if (item<0 || item>120){
                continue;
            }
            edadesValidas[conta++]=item;
        }
        return edadesValidas;
    }
    public static boolean contienePalabraProhibida(String texto, String[] palabraProhibida){
        for(String item:palabraProhibida){
            if(texto.contains(item.toLowerCase())){
                return true;
            }
        }
        return false;
    }
    private static int contarVocales (String texto){
        int contador=0;
        texto=texto.toLowerCase();
        for (int i = 0; i < texto.length(); i++) {
            char c = texto.charAt(i);
            if (c!= 'a' && c!= 'e' && c!= 'i' && c!= 'o' && c!='u'){
                continue;
            }
            contador++;
        }
        return contador;
    }
    public static String primeraPalabraLarga(String texto, int longitudMinima){
        if (texto == null || texto.isEmpty()){
            return null;
        }
        String[] palabras = texto.split("\\s+");
        for (String item : palabras){
            if (item.length() > longitudMinima){
                return item;
            }
        }
        return null;
    }
    public static void poderJugar (String texto){
    String[] palabrasProhibidas ={"Malo","Edulcorante","Amiguis"};
    int longitud=3;
    texto = texto.toLowerCase();
        for (int i = 0; i < palabrasProhibidas.length; i++) {
            palabrasProhibidas[i] = palabrasProhibidas[i].toLowerCase();
        }
    if (contienePalabraProhibida(texto,palabrasProhibidas)){
        System.out.println("¡Atencion! contiene palabra prohibida");
    }
    int numeroVocales =contarVocales(texto);
        System.out.println("Numero de vocales: "+numeroVocales);
    }
    

}
