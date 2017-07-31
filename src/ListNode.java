/**
 * Created by Julie on 13-09-2016.
 */
public class ListNode<E> {
    public E data; // Selve tallet på pladsen
    public ListNode next; // Referencen til den næste

    public ListNode() {
        this(null, null);
    } // tom constructor sætter feltet til 0 og next til null

    public ListNode(E data) {
        this(data, null);
    } // constructor kun med data, sætter feltet til data og next til null

    public ListNode(E data, ListNode next) { // constructor med data og next
        this.data = data;
        this.next = next;
    }
}
