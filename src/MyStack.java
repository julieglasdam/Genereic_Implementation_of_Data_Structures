import java.util.EmptyStackException;
import java.util.Stack;

/**
 * Created by Julie on 05-10-2016.
 */

public class MyStack<E> {
    private E[] stack;
    private int elementCount;
    public static final int DEFAULT_CAPACITY = 100;

    public MyStack() {
        stack = (E[]) new Object[DEFAULT_CAPACITY];
        elementCount = 0;
    }

    // ---- Check capacity ----
    @SuppressWarnings("unchecked")
    private void checkCapacity(int capacity) {
        if (capacity > stack.length) {
            int newCapacity = stack.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            E[] newStack = (E[]) new Object[newCapacity];
            for (int i = 0; i < elementCount; i++) {
                newStack[i] = stack[i];
            }
            stack = newStack;

        }
    }

    // ---- Empty ----
    public boolean isEmpty() {
        if (elementCount == 0) {
            return true;
        }
        return false;
    }

    // ---- Peek ----
    // Returnerer det øverste element (sidste i rækken), uden at fjerne det
    public E peek() {
        if (elementCount == 0) {
            throw new EmptyStackException();
        }
        return stack[elementCount-1];
    }

    // ---- Pop ----
    // Returnerer det øverste (sidste i rækken) element og fjerner det
    public E pop() {
        if (elementCount == 0) {
            throw new EmptyStackException();
        }
        E returnValue = stack[elementCount-1];
        elementCount--;
        return returnValue;

    }

    // ---- Push ----
    // ---- Tilføj value ----
    public void push(E value) {
        checkCapacity(elementCount + 1);
        stack[elementCount] = value;
        elementCount++;
    }

    // ---- Search ----
    // returnerer indexet
    public int search(E value) {
        for (int i = 0; i < elementCount; i++) {
            if (stack[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // ---- Size ----
    public int size() {
        return elementCount;
    }

    // ---- Remove ----
    // Fjern det øverste element
    public void remove() {
        elementCount--;
    }



    // ---- To String ----
    @Override
    public String toString() {
        if (elementCount == 0) {
            return "[]";
        }
        else {
            String result = "[" + stack[0];
            for (int i = 1; i < elementCount; i++) {
                result += ", " + stack[i];
            }
            result += "]";
            return result;
        }
    }


}

