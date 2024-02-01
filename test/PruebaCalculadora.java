package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import src.Calculadora;

public class PruebaCalculadora {
    @Test
    public void pruebaCalcular() {
        Calculadora calculadora = new Calculadora();
        assertEquals(12, calculadora.calcular("2 4 + 2 *"));
    }

    @Test
    public void pruebaException1() {
        Calculadora calculadora = new Calculadora();
        assertEquals(-10, calculadora.calcular("2 3 %"));
    }

    @Test
    public void pruebaException2() {
        Calculadora calculadora = new Calculadora();
        assertEquals(-20, calculadora.calcular("2 *"));
    }

    @Test
    public void pruebaException3() {
        Calculadora calculadora = new Calculadora();
        assertEquals(-30, calculadora.calcular("6 0 /"));
    }

}