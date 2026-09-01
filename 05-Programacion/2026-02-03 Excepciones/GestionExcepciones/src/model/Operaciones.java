package model;

import Util.ResultadoExcepcion;

public class Operaciones {
    public int  operarSuma (int op1, int op2){
        return op1+op2;
    }
    public int  operarResta (int op1, int op2)throws ResultadoExcepcion{
        if (op2>op1){
            throw new ResultadoExcepcion("El resultado de la resta es negativo");

        }
        return op1-op2;
    }
    public int  operarMulti (int op1, int op2) {
        return op1*op2;
    }
    public int  operarDivi (int op1, int op2)throws ArithmeticException{
        return op1/op2;
    }
}
