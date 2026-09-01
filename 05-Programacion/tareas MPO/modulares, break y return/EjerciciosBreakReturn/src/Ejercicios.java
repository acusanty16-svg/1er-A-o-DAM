import java.util.Scanner;

public class Ejercicios {
    Controller controller = new Controller();
    Scanner scanner = new Scanner(System.in);
    public void ejercicio1(){
        Scanner scanner= new Scanner(System.in);
        boolean contraseniaValida;
        do {
            System.out.println("Introduce una contraseña para validar: ");
            String contrasenia = scanner.nextLine();
            contraseniaValida= Controller.comprobar(contrasenia);

        }while(!contraseniaValida);
        scanner.close();
    }
    public void ejercicio2() {
        int numeroObjetivo =0;
        int []aleatorio;
        int resultado;
        do {
            numeroObjetivo = (int) (Math.random()*20)+1;
            aleatorio=new int[5];
            for (int i = 0; i < aleatorio.length; i++) {
                aleatorio[i]= (int) (Math.random()*20)+1;
            }
            resultado = Controller.buscarNumero(aleatorio,numeroObjetivo);
        }while(resultado==-1);
        System.out.print("Numeros del Array: ");
        for(int item: aleatorio){
            System.out.printf("%d\t",item);
        }
        System.out.println("\nNumero objetivo: "+numeroObjetivo);
        System.out.println("Veces que lo ha intentado el sistema: "+resultado);
    }
    public void ejercicio3(){
       int[] aleatorio = new int[20];
        for (int i = 0; i < aleatorio.length; i++) {
            /*aleatorio[i] = (int) (Math.random()*20);*/
            aleatorio[i] = i+1;
        }
        System.out.println("---MOSTRANDO PARES---");
        Controller.mostrarPares(aleatorio);
    }
    public void ejercicio4() {
        boolean otraVez = false;
        do {
            System.out.println("---BIENVENIDO A LA CALCULADORA DE TUS NOTAS---");
            System.out.print("Cuantas notas quieres ingresar:  ");
            int notasIntroducidas = scanner.nextInt();
            double [] notas = new double[notasIntroducidas];
            for (int i = 0; i < notasIntroducidas; i++) {
                double nota;
                do {
                    System.out.println("Ingresa la nota que quieres evaluar: "+(i+1)+"(0-10): ");
                    nota = scanner.nextDouble();
                    if (nota<0 || nota>10){
                        System.out.println("Nota invalida, debe ser un numero entre 0 y 10");
                    }
                }while(nota<0 || nota>10);
                notas[i] = nota;
            }
            Controller.calcularPromedio(notas);
            System.out.println("¿Quieres calcular otra vez? (true o false)");
            otraVez = scanner.nextBoolean();
        }while(otraVez);
        
    }
    public void ejercicio5(){
        int intentos = 3;
        String contrasenia, usuario;
        System.out.println("Bienvenido a la comprobacion de contraseñas");
        for (int i = 0; i < intentos; i++) {
            System.out.println("Introduce un usuario: ");
            usuario = scanner.next();
            System.out.println("Introduce una contraseña: ");
            contrasenia = scanner.next();
            if (Controller.intentarLogin(usuario,contrasenia)){
                System.out.println("Acceso concedido. puedes ingresar");
                return;
            }else{
                System.out.println("Acesso denegado, no puedes entrar");
            }
        }
        System.out.println("Has agotado todas tus opciones");
    }
    public void ejercicio6(){
        System.out.println("BIENVENIDO A TU AGENDADOR DE TAREAS");
        System.out.println("Introduce el numero de tareas que quieres realizar: ");
        int numeroTareas= scanner.nextInt();
        scanner.nextLine();
        String [] tareas = new String[numeroTareas];
        for (int i = 0; i < numeroTareas; i++) {
            System.out.printf("Tarea Nº %d: %n",i+1);
            String tarea = scanner.nextLine().trim();
            tareas[i] = tarea;
            if (tarea.equalsIgnoreCase("urgente")){
                System.out.println("¡Tarea urgente detectada! Se detiene el proceso");
                break;
            }
        }

        String resutlado =Controller.procesarTareas(tareas);
        System.out.println("El estado de tu tarea es: "+resutlado);
        System.out.print("Tus tareas son: ");
        for(String item:tareas){
            if (item!=null){
                System.out.print(item+", ");
            }
        }
        System.out.println();
    }
    public void ejercicio7(){
        boolean jugarOtraVez = false;
        do {
            System.out.println("---BIENVENIDO A LA SECUENCIA DE FIBONACCI---");
            System.out.print("Introduce el limite de la secuencia: ");
            int limite = scanner.nextInt();
            Controller.generarFibonacci(limite);
            System.out.println("Quieres jugar otra vez? (true o false)");
            jugarOtraVez = scanner.nextBoolean();
        }while(jugarOtraVez);


    }
    public void ejercicio8(){
        System.out.println("\n---BIENVENIDO A LOS GRUPOS DE CLASE---");
        System.out.print("Introduce el numero de edades que quieres registrar: ");
        int numeroEdades= scanner.nextInt();
        int[] edadesValidas = new int[numeroEdades];
        for (int i = 0; i < numeroEdades; i++) {
            System.out.printf("Introduce la edad: %d: ",i+1);
            edadesValidas[i] = scanner.nextInt();
        }
        int [] edades=Controller.guardarEdades(edadesValidas);
        System.out.print("\nEdades validas: ");
        for(int item:edades){
            System.out.print(item+" ");
        }
    }
    public void ejercicio9(){
        System.out.println("\n---BIENVENIDO A MUCHAS COSAS---");
        System.out.print("Introduce las palabras que quieres revisar y evaluar: ");
        String palabraUsuario = scanner.nextLine();
        int longitudMinima = 3;
        String [] palabraprohibida ={"Malo","Albacete","Especulacion"};
        boolean contiene = Controller.contienePalabraProhibida(palabraUsuario,palabraprohibida);
        if(contiene){
            System.out.println("¡Atencion! contiene palabra prohibida");
        }
    }

}
