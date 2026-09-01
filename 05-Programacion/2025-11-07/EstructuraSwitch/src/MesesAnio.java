public enum MesesAnio {

    Enero("invierno", 1, 30), Febrero("invierno", 2, 28),
    Marzo("primavera", 3, 30), Abril("invierno", 4, 30),
    Mayo("primavera", 5, 31), Junio("verano", 6, 30), Julio("verano", 7, 30),
    Agosto("verano", 8, 30), Septiembre("verano", 9, 31), Noviembre("invierno", 11, 30);


    int numeroMes;
    String estacion;
    int dias;

    MesesAnio(String estacionP, int numeroMesp, int diasMes){

        estacion =estacionP;
        numeroMes=numeroMesp;
        dias=diasMes;

    }

}

