/**
 * Created by Julie on 01-10-2016.
 */

public class MyLinkedList<E> {
    private ListNode<E> front;
    private int size;


    public MyLinkedList() {
        front = null;
        size = 0;
    }

    // ---- Add ----
    //  O(n)
    public void add(E value) {
        if (front == null) {
            front = new ListNode<E>(value);
            size++;
        }
        else {
            ListNode<E> current = front;
            while (current.next != null) {
                current = current.next;
            }
            current.next = new ListNode<E>(value);
            size++;
        }
    }

    // ---- Size ----
    //  O(1)
    public int size() {
     /*   int size = 0;
        ListNode<E> current = front;
        while (current != null) {
            size++;
            current = current.next;
        } */

        return size;
    }

    // ---- Get value at specific index ----
    //  O(n)
    public E get(int index) {
       if (index < 0) {
           throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
       }
       else if ((size-1) < index) {
           throw new ArrayIndexOutOfBoundsException("Index out of range");
       }
        ListNode<E> current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    // ---- Add value at specific index ----
    //  O(n)
    public void add (int index, E value) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
        }
        else if ((size-1) < index) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            front = new ListNode<E>(value, front);
            size++;
        }
        else {
            ListNode<E> current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = new ListNode<E>(value, current.next);
            size++;
        }
    }

    // ---- Remove ----
    //  O(n)
    public void remove(int index) {
        if (index < 0) {
            throw new ArrayIndexOutOfBoundsException("Index must be equal to or greater than 0");
        }
        else if ((size-1) < index) {
            throw new ArrayIndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            front = front.next;
            size--;
        }
        else {
            ListNode<E> current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            size--;
        }
    }


    // ---- to string ----
    //  O(n)
    @Override
    public String toString() {
        if (front == null) {
            return "[]";
        }
        else {
            String result = "[" + front.data;
            ListNode<E> current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }
}
