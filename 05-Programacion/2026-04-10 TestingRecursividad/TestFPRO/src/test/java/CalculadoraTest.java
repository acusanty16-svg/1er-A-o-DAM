import model.Calculadora;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculadoraTest {

    public Calculadora calculadora;

    @BeforeEach
    void setUp(){
        calculadora = new Calculadora();
    }
    @Test
    void sumaTest(){
        assertEquals(10,calculadora.sumar(5,5));
    }
    @ParameterizedTest
    @CsvSource({"3,5,8","2,2,4","3,4,7"})
    void sumaTest(int op1, int op2, int resultado){
        assertEquals(resultado,calculadora.sumar(op1,op2));
    }
    @Test
    void restaTest(){
        assertEquals(0,calculadora.restar(5,5));

    }
    @Test
    void multiTest(){
        assertEquals(25,calculadora.multiplicar(5,5));

    }
    @Test
    void divTest(){
        assertEquals(1,calculadora.dividir(5,5));

    }
    @Test
    void divTestEx(){
        assertEquals(1,calculadora.dividir(5,5));
        assertThrows(IllegalArgumentException.class,()->calculadora.dividir(5,0));
        assertEquals(0,calculadora.dividir(0,5));

    }
}
