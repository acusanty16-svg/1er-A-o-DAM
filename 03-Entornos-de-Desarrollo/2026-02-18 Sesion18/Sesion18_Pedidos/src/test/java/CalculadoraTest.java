import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private final Calculadora calculadora = new Calculadora();
    @Test
    void sumar() {
        int resultado = calculadora.sumar(5,3);
        assertEquals(8,resultado, "la suma de 5+3 debe ser 8");

        resultado = calculadora.sumar(-5,-3);
        assertEquals(-8,resultado, "la suma de -5 + -3 debe ser -8");

        resultado = calculadora.sumar(5,-3);
        assertEquals(2,resultado, "la suma de 5 + -3 debe ser 2");


        resultado= calculadora.sumar(-5,3);
        assertEquals(-2, resultado, "la suma de -5 + 3 debe ser -2 ");
    }

    @Test
    void restar() {
        int resultado = calculadora.restar(5,3);
        assertEquals(2,resultado,"La resta de 5 - 3 es 2");
         resultado = calculadora.restar(-5,-3);
        assertEquals(-2,resultado,"La resta de -5 - -3 es -2");
         resultado = calculadora.restar(-5,3);
        assertEquals(-8,resultado,"La resta de -5 - 3 es -8");
         resultado = calculadora.restar(5,-3);
        assertEquals(8,resultado,"La resta de 5 - -3 es 8");
    }
}