package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.*;

import src.MiStack;

public class PruebaMiStack {
    int[] numeros = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

    @Test
    public void pruebaDeStack() {
        MiStack<Integer> pila = new MiStack<>();
        for (int numero : numeros) {
            pila.push(numero);
        }
        assertEquals(9, pila.pop());
        assertEquals(8, pila.pop());
        assertEquals(7, pila.pop());

        assertEquals(6, pila.peek());

        assertEquals(false, pila.isEmpty());
    }
}
