package src;

import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * Implementación simple de una pila genérica utilizando un ArrayList.
 *
 * @param <T> El tipo de elementos almacenados en la pila.
 */
public class MiStack<T> {
    private ArrayList<T> stack;

    /**
     * Construye una pila vacía.
     */
    public MiStack() {
        this.stack = new ArrayList<>();
    }

    /**
     * Inserta un elemento en la parte superior de la pila.
     *
     * @param dato El elemento que se va a insertar en la pila.
     */
    public void push(T dato) {
        stack.add(dato);
    }

    /**
     * Elimina y devuelve el elemento en la parte superior de la pila.
     *
     * @return El elemento en la parte superior de la pila.
     * @throws EmptyStackException Si la pila está vacía.
     */
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T dato = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return dato;
    }

    /**
     * Devuelve el elemento en la parte superior de la pila sin eliminarlo.
     *
     * @return El elemento en la parte superior de la pila.
     */
    public T peek() {
        return stack.get(stack.size() - 1);
    }

    /**
     * Comprueba si la pila está vacía.
     *
     * @return true si la pila está vacía, false en caso contrario.
     */
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}