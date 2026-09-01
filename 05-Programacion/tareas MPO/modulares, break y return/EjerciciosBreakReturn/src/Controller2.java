public class Controller2 {
    private static double [] guardarNotas (double [] notas){
        int sumando=0;
        for(double item:notas){
            if (item<0 || item>10){
                continue;
            }
            sumando++;
        }
        double [] guardarNotas = new double[sumando];
        int index=0;
        for(double item:notas){
            if(item<0 || item>10){
            guardarNotas[index++] = item;
            }
        }
        return guardarNotas;
    }
    public static void calcularPromedio(double[] notas){
        int contador = 0;
        double sumando =0;
        double [] notasGuardadas = guardarNotas(notas);
        for(double item:notasGuardadas){
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
}
