public class SentenciaFor {
    public void dibujarCuadrado() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == 0 || i==4){
                    System.out.print("*");
                }else if(j ==0 || j==4){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }



    }

    public void palabraPalidromo () {

        String frase = "alli ves sevilla";
        frase = frase.replaceAll(" ","");
        boolean esPalindromo = true;
        for (int i = 0; i <frase.length()/2 ; i++) {
            char letrauno=frase.charAt(i);
            char letrados=frase.charAt(frase.length()-1-i);
            if (letrauno!=letrados){
                esPalindromo = false;
                break;
            }

        }
        if (esPalindromo) {

            System.out.println("La palabra es palindromo");
        }else {
            System.out.println("la palabra no es palindromo");
        }


    }

    public void calcularFactorial(){

        int numeroCalcular = 4;
        int factorial = 1;
        for (int i = 1; i <=numeroCalcular; i++) {
            factorial *=i;

        }
        System.out.printf("El factorial de %d es %d",numeroCalcular,factorial);
    }

    //el for se suele utliizar para poder recorrer una coleccion de datos
    //conjunto de valores de valores guardados en una variable, esto se llama array
    public void recorrerColeccion(){
        int[] numero ={1,10,90,40,98,76,53};
        //un armario de n posiciones
       /* for (int i = 0; i < numero.length; i++) {
            System.out.println(numero[i]);
        }*/

    for (int item :numero ){
        System.out.println(item);
        }
    }
}
