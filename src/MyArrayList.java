
/**
 * Created by Julie on 29-09-2016.
 */
public class MyArrayList<E> {
    private E[] elementData;
    private int size;
    public static final int DEFAULT_CAPACITY = 100;

    public MyArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("The size of the MyArrayList cannot be less than zero");
        }
           elementData = (E[]) new Object[capacity];
           size = 0;
    }

    // ---- Add ----
    //  O(1)
    public void add(E value) {
        checkCapacity(size + 1);
        elementData[size] = value;
        size++;
    }

    // ---- Check capacity ----
    //  O(1)
    @SuppressWarnings("unchecked")
    private void checkCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            E[] newList = (E[]) new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = elementData[i];
            }
            elementData = newList;
        }
    }

    // ---- Add at index ----
    //  O(n)
    public void add(E value, int index) {
        if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
        }
        else if (index > size-1) {
            throw new ArrayIndexOutOfBoundsException("Last index of the MyArrayList: " + (size-1) + ". Input index: " + index);
        }
        for (int i = size; i >= index + 1; i--) {
            elementData[i] = elementData[i-1];
        }
        elementData[index] = value;
        size++;
    }

    // ---- Remove ----
    //  O(n)
    public void remove(int index) {
        if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
        }
        else if (index > size-1) {
            throw new ArrayIndexOutOfBoundsException("Last index of the MyArrayList: " + (size-1) + ". Input index: " + index);
        }
        for (int i = index; i < size; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
    }


    // ---- Get a value at a specific index ----
    //  O(1)
    public E get(int index) {
        if (index < 0 ) {
            throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
        }
        else if (index > size-1) {
            throw new ArrayIndexOutOfBoundsException("Last index of the MyArrayList: " + (size-1) + ". Input index: " + index);
        }
        return elementData[index];
    }


    // ---- Get the index of a specific value ----
    //  O(n)
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    // ---- Size ----
    //  O(1)
    public int size() {
        return size;
    }

    // ---- to string ----
    //  O(n)
    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        else {
            String result = "[" + elementData[0];
            for (int i = 1; i < size; i++) {
                result += ", " + elementData[i];
            }
            result += "]";
            return result;
        }
    }
}
