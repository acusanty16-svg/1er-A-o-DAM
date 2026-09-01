package Util;

public class ResultadoExcepcion extends Exception{

    public ResultadoExcepcion(String message) {
        super(message);
        System.out.println("Lanzando excepcion");
    }
}
