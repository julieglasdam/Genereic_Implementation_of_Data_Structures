import java.util.EmptyStackException;


/**
 * Created by Julie on 05-10-2016.
 */

public class MyQueue<E> {
    private E[] queue;
    private int elementCount;
    public static final int DEFAULT_CAPACITY = 100;

    public MyQueue() {
        queue = (E[]) new Object[DEFAULT_CAPACITY];
        elementCount = 0;
    }

    // ---- Check capacity ----
    @SuppressWarnings("unchecked")
    private void checkCapacity(int capacity) {
        if (capacity > queue.length) {
            int newCapacity = queue.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            E[] newQueue = (E[]) new Object[newCapacity];
            for (int i = 0; i < elementCount; i++) {
                newQueue[i] = queue[i];
            }
            queue = newQueue;

        }
    }

    // ---- Add ----
    public void add(E value) {
        checkCapacity(elementCount + 1);
        queue[elementCount] = value;
        elementCount++;
    }

    // ---- Peek ----
    // Returnerer det foreste element (første i rækken), uden at fjerne det
    public E peek() {
        if (elementCount == 0) {
            throw new EmptyStackException();
        }
        return queue[0];
    }


    // isEmpty
    public boolean isEmpty() {
        if (elementCount == 0) {
            return true;
        }
        return false;
    }

    // ---- size ----
    public int size() {
        return elementCount;
    }

    // ---- Search ----
    // returnerer indexet
    public int search(E value) {
        for (int i = 0; i < elementCount; i++) {
            if (queue[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // ---- To String ----
    @Override
    public String toString() {
        if (elementCount == 0) {
            return "[]";
        }
        else {
            String result = "[" + queue[0];
            for (int i = 1; i < elementCount; i++) {
                result += ", " + queue[i];
            }
            result += "]";
            return result;
        }
    }

}