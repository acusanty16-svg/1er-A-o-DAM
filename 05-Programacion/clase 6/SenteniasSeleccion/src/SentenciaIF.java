public class SentenciaIF {
    public void examenAprobado(int nota){

        System.out.println("procedemos a evaluar si un examen esta OK");
        System.out.println("la nota que vamos a evuluar es: "+nota);
        if (nota>=5){
            System.out.println("El examen esta aprobado");
        } else {
            System.out.println("El examen esta suspenso");
        }
        System.out.println("terminando la evaluacion del examen");
        System.out.println("programa finalizado");
    }

    public void notaExamen (int nota){

        //suspenso ->0-4,99
        //aprobado ->5-7,99
        //notable ->8-8,99
        //sobresaliente ->9,99
        //MH->10
        String resultadoExamen;
   if (nota>0 && nota<=10){
       if (nota<5){
         //  System.out.println("El examen esta suspenso");
           resultadoExamen ="suspenso";
       } else if (nota<8) {
          // System.out.println("El examen esta aprobado");
           resultadoExamen = "aprobado";
       } else if (nota<9) {
         //  System.out.println("El examen esta notable");
           resultadoExamen ="notable";
       } else if (nota<10) {
        //   System.out.println("El examen esta sobresaliente");
           resultadoExamen ="sobresaliente";
       } else  {
         //  System.out.println("El examen esta de MH");
           resultadoExamen ="MH";
       }
   }else {
      // System.out.println("la nota no esta en la escala correcta");
       resultadoExamen = "fuera de rango";
   }
        System.out.println("El resultado del examen es: "+resultadoExamen);
    }
}
