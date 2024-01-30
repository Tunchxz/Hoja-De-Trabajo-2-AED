package src;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class MiStack<T> {
    private ArrayList<T> stack;

    public MiStack() {
        this.stack = new ArrayList<>();
    }

    public void push(T dato) {
        stack.add(dato);
    }

    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        T dato = stack.get(stack.size() - 1);
        stack.remove(stack.size() - 1);
        return dato;
    }

    public T peek() {
        return stack.get(stack.size() - 1);
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }
}