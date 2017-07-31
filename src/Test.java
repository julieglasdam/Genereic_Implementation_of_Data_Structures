import java.util.ArrayList;

/**
 * Created by Julie on 29-09-2016.
 */
public class Test {
    public static void main(String[] args) {
        MyArrayList<Integer> array = new MyArrayList();
        array.add(7);
        array.add(8);
        array.add(7);
        array.add(8);
        array.add(7);
        array.add(8);
        array.add(7);
        array.add(8, 30);

        MyArrayList<String> array2 = new MyArrayList<String>();
        array2.add("joxzcxzcij");
        array2.add("hohcxvzvæo");

        MyLinkedList<Integer> list = new MyLinkedList<Integer>();
        list.add(7);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(4, 11);



        System.out.println(list.toString());
        System.out.println(array.toString());

    }
}
