public class Controller {
    private int[][] cuadrado;
    private boolean estaNumero(int numero){
        for(int[] fila:cuadrado){
            for(int item:fila){
                if (item==numero){
                    return true;
                }
            }
        }
        return false;
    }
    public void inicializarMatriz(int numero){
        this.cuadrado=new int[numero][numero];
    }
    public void rellenarNumeros() {
        int n = cuadrado.length;
        int sumaObjetivo = (n * (n * n + 1)) / 2;
        boolean matrizCompleta;
        int maximo = n*n;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cuadrado[i][j]=0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n ; j++) {
                int aleatorio=0;
                do {
                    aleatorio = (int) (Math.random()*maximo)+1;
                }while(estaNumero(aleatorio));
                cuadrado[i][j]=aleatorio;
            }
        }
    }
    public boolean esMagico(){
       int n = cuadrado.length;
       int sumaObjetivo = constanteMagica();
        for (int[] fila : cuadrado) {
            int suma = 0;
            for (int j = 0; j < n; j++) {
                suma += fila[j];
            }
            if (suma != sumaObjetivo) {
                return false;
            }
        }
        for (int j = 0; j < n; j++) {
            int suma=0;
            for (int i = 0; i < n; i++) {
                suma+=cuadrado[i][j];
            }
            if (suma!=sumaObjetivo){
                return false;
            }
        }
        int sumaD1=0, sumaD2=0;
        for (int i = 0; i < n; i++) {
            sumaD1+=cuadrado[i][i];
            sumaD2+=cuadrado[i][n-1-i];
        }
        return (sumaD1==sumaObjetivo && sumaD2==sumaObjetivo);
    }
    public void mostrarNumeros(){
        for (int [] row:cuadrado){
            for(int fila:row){
                System.out.print(fila+"\t");
            }
            System.out.println();
        }
    }
    public int constanteMagica(){
        int n = cuadrado.length;
        return (n*(n*n+1))/2;
    }
}
