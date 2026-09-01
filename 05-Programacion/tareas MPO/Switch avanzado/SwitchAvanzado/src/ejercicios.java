import java.util.Scanner;

public class ejercicios {
    Scanner scanner = new Scanner(System.in);
    public void ejercicio2(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa la cantidad en euros: ");
        double euros = scanner.nextDouble();
        System.out.println("Selecciona la moneda a convertir:");
        System.out.println("1. Dólar");
        System.out.println("2. Libra");
        System.out.println("3. Yen");
        System.out.println("4. Peso");
        int opcion = scanner.nextInt();
        Moneda moneda;
        double operaciones;
        switch (opcion){
            case 1->{ moneda = Moneda.DOLAR;}
            case 2->{ moneda = Moneda.LIBRA;}
            case 3->{moneda = Moneda.YEN;}
            case 4->{moneda = Moneda.PESO;}
            default -> {
                System.out.println("Opcion invalida");
                return;
            }
        }
        operaciones = 0;
        switch (moneda){
            case DOLAR -> {operaciones = euros*0.86;}
            case LIBRA -> {operaciones = euros*1.14;}
            case YEN -> {operaciones = euros*0.005;}
            case PESO -> {operaciones = euros*0.04;}
        }
        System.out.printf("%.2f equivalen a %.2f",euros,operaciones);

    }
    public void ejercicio3(){/*
        System.out.println("Introduce los grados Celcius: ");
        final int temperaturaC;
        temperaturaC = scanner.nextInt();
        switch (true){
            if(temperaturaC<0){
                System.out.println();
            } else if (temperaturaC>=0 && temperaturaC<15) {
                System.out.println("sdf");
        }
            switch (true){
                if(temperaturaC>=15 && temperaturaC<25){
                    System.out.println();
                } else if (temperaturaC>=25 && temperaturaC<35) {
                    System.out.println();
                }
            }*/}
    public void ejercicio4(){
    CategoriaPlato categoriaPlato;
        System.out.println("\n---AQUI PODRAS ESCOGER EL MENU QUE PREFIERAS---");
        System.out.println("1. Menu de Lunes a Viernes");
        System.out.println("2. Menu de Viernes");
        System.out.println("3. Menu de Domingo");
        System.out.println("Elige la opcion que quieras ver en pantalla: ");
        int opcion = scanner.nextInt();
    switch (opcion){
        case 1->{categoriaPlato = CategoriaPlato.LUNESAVIERNES;}
        case 2->{categoriaPlato = CategoriaPlato.SABADO;}
        case 3->{categoriaPlato = CategoriaPlato.DOMINGO;}
        default -> {
            System.out.println("Opcion no valida");
            return;
        }
    }
        System.out.println("---LAS OPCIONES QUE HAS ESCOGIDO SON: ---");
        System.out.printf("%nEntrada: %s%n",categoriaPlato.getEntradas());
        System.out.printf("Principales: %s%n",categoriaPlato.getPrincipales());
        System.out.printf("Bebidas: %s%n",categoriaPlato.getBebidas());
        System.out.printf("Postres: %s%n",categoriaPlato.getPostres());
    }
    public void ejercicio5(){
    double num1 =0, num2 =0, operaciones=0;
    boolean jugarOtravez = false;
    do {
        num1 =0;
        num2 =0;
        operaciones=0;
        System.out.println("---BIENVENIDO A LA CALCULADORA MAS FUNCIONAL DE TODAS---");
        System.out.print("Introduce el primer numero: ");
        num1 = scanner.nextInt();
        System.out.print("Introduce el segundo numero: ");
        num2 = scanner.nextInt();
        System.out.print("Introduce la operacion que deseas realizar(+,-,*,/): ");
        char operador = scanner.next().charAt(0);
        switch (operador){
            case '+'->{
                operaciones = num1+num2;
                System.out.printf("El resultado de la operacion es: %.2f%n",operaciones);
            }
            case '-'->{
                operaciones = num1-num2;
                System.out.printf("El resultado de la operacion es: %.2f%n",operaciones);
            }
            case '*'->{
                operaciones = num1*num2;
                System.out.printf("El resultado de la operacion es: %.2f%n",operaciones);
            }
            case '/'->{
                operaciones = num1/num2;
                System.out.printf("El resultado de la operacion es: %.2f%n",operaciones);
            }
        }
        System.out.println("¿Quisieras volver a jugar? (true or false)");
        jugarOtravez = scanner.nextBoolean();

    }while(jugarOtravez);


    }
    public void ejercicio6(){
        System.out.println("---BIENVENIDO A SALUDOS SANTI---");
        System.out.println("Escribe cualquier hora (0-24) y te devolveremos un saludo magico");
        int obtenerHoraActual = scanner.nextInt();
        int rango=
                obtenerHoraActual >= 0 && obtenerHoraActual <= 5 ?1:
                        obtenerHoraActual<=11 ?2:
                                obtenerHoraActual<=19 ?3:
                                        obtenerHoraActual<=23 ?4:
                                                obtenerHoraActual == 24 ?5:
                                                        6;
        switch (rango){
            case 1->{System.out.println("Buenos dias campeon");}
            case 2->{System.out.println("Buenas tardes crack");}
            case 3->{System.out.println("¿Y si nos despertamos?");}
            case 4->{System.out.println("A ponerse la pijama");}
            case 5->{System.out.println("Sueña con los angelitos");}
            case 6->{System.out.println("Resultado no valido");}
        }





    }
    public void ejercicio7(){
        System.out.println("\n---BIENVENIDO AL ANALIZADOR DE ARCHIVOS BORJA---");
        System.out.println("Introduce un numero seleccionado para ejecutar el programa");
        System.out.println("1. Imagenes");
        System.out.println("2. Documentos");
        System.out.println("3. Audio");
        System.out.println("4. Video");
        int opcion = scanner.nextInt();
        ArchivosImagenes archivosImagenes;
        ArchivosImagenes.ArchivosDocumentos archivosDocumentos;
        ArchivosImagenes.ArchivosAudio archivosAudio;
        ArchivosImagenes.ArchivosVideo archivosVideo;
        switch (opcion){
            case 1 ->{
                archivosImagenes=ArchivosImagenes.IMAGENES;
                System.out.println("Has elegido "+archivosImagenes+" Se espera que tu documento sea abierto con "+archivosImagenes.jpgs);
            }
            case 2 ->{
                archivosDocumentos= ArchivosImagenes.ArchivosDocumentos.DOCUMENTOS;
                System.out.println("Has elegido "+archivosDocumentos+" Se espera que tu documento sea abierto con "+archivosDocumentos.pdfs);
            }
            case 3 ->{
                archivosAudio=ArchivosImagenes.ArchivosAudio.AUDIO;
                System.out.println("Has elegido "+archivosAudio+" Se espera que tu documento sea abierto con "+archivosAudio.mp3s);
            }
            case 4 ->{
                archivosVideo=ArchivosImagenes.ArchivosVideo.VIDEO;
                System.out.println("Has elegido "+archivosVideo+" Se espera que tu documento sea abierto con "+archivosVideo.mp4s);
            }
            default ->{
                System.out.println("Opcion no valida");
            }
        }

    }
    private  EstadoPedido obtenerEstadoActual(){
        int aleatorio = (int) (Math.random()*6);
        EstadoPedido estadoPedido;
        switch (aleatorio){
            case 0->{estadoPedido = EstadoPedido.PENDIENTE;}
            case 1->{estadoPedido = EstadoPedido.PROCESANDO;}
            case 2->{estadoPedido = EstadoPedido.ENVIADO;}
            case 3->{estadoPedido = EstadoPedido.EN_TRANSITO;}
            case 4->{estadoPedido = EstadoPedido.ENTREGADO;}
            default->{estadoPedido = EstadoPedido.CANCELADO;}
        }
        return estadoPedido;
    }
    public void ejercicio9(){
        EstadoPedido estadoActual =obtenerEstadoActual();
        System.out.println("Estado actual: "+estadoActual);
        switch (estadoActual){
            case PENDIENTE:
                System.out.println("➡ Siguiente paso: PROCESANDO");
                break;

            case PROCESANDO:
                System.out.println("➡ Siguiente paso: ENVIADO");
                break;

            case ENVIADO:
                System.out.println("➡ Siguiente paso: EN_TRANSITO");
                break;

            case EN_TRANSITO:
                System.out.println("➡ Siguiente paso: ENTREGADO");
                break;

            case ENTREGADO:
            case CANCELADO:
                System.out.println("➡ No hay más pasos.");
                break;
        }
    }



}
