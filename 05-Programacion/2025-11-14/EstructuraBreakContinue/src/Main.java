public class Main{
    //break -> para la repeticion en el momento donde se indica
    //break siempre es la ultima linea del cuerpo de repeticion
    //return -> retorna un valor (el metodo). El metodod termina!! el return es la ultima linea del metodo
    //continue -> vas a pasar el turno cuando te lo indique
    //if -> evalua una condicion y decide si entra en nu cuerpo o en otro
    // if ternario -> decide el VALOR de una variable dependiendo de una condicion logica
    public static void main(String[] args) {
        int acumulador=0;
        /* for (int i = 0; i < 10; i++) {
            System.out.println("Repitiendo "+i);
            System.out.println("Terminando");
            if(i==3){
                break;

            }
        }
*/
        /*do {
            acumulador+= (int) (Math.random()*41);
            if (acumulador>100 && acumulador<125){
                System.out.println("Te acercas preligrosamente");
                break;
            }
        }while(acumulador <=301);
        System.out.println("EL acumulador tiene un valor de: "+acumulador);
        System.out.println("Terminando el programa");*/
        /*for (int i = 0; i <11; i++) {
            System.out.println("La tabla del "+i);
            for (int j = 0; j < 11; j++) {
                System.out.printf("El resultado de %d * %d = %d%n",i,j,i*j);
                if(i==1){
                    break;*/
       /* do {
            acumulador+= (int) (Math.random()*41);
        }while(acumulador <=301);
        System.out.println("EL acumulador tiene un valor de: "+acumulador);
        System.out.println("Terminando el programa");*/
       /* int[] numeros = {1,4,34,-12,56,12,-56,78,12,-56}; //length: 10 pero la pos: 0 ultima: 9
        for (int i = 0; i < numeros.length; i++) {

            if(numeros[i]<0){
                continue;
            }
        System.out.println(numeros[i]);*/
        /*if(nota>=5){
            System.out.println("Examen aprobado");
        }else{
            System.out.println("Examen suspenso");
        }*/
        int nota = 7;
        String resultado = nota<=5 ? "suspenso": "aprobado";
        char letranota= nota<=5 ?'F' : 'A';
        System.out.println(resultado);
        System.out.println(letranota);

    }
}