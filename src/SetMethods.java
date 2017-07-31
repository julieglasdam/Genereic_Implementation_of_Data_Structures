import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Julie on 10-05-2017.
 */
public class SetMethods {

    /* Takes a Set of strings as parameter and removes all words with odd lengths*/
        public static Set<String> removeOddLength(Set<String> set) {
            Iterator<String> itr = set.iterator();

            while (itr.hasNext()) {
                String current = itr.next();
                if (!(current.length()%2==0)) {
                    itr.remove();
                }
            }
            return set;
        }



        /* Takes two sets as parameters and returns a new set containing values that exist in one
        of the two sets, but not in both of them*/
    public static Set<Integer> symmetricSetDifference(Set<Integer> set01, Set<Integer> set02) {
        Set<Integer> set03 = new HashSet<Integer>();

        Iterator<Integer> itr01 = set01.iterator();
        Iterator<Integer> itr02 = set02.iterator();


        while (itr01.hasNext()) {
            int current = itr01.next();
            set03.add(current);
        }

        while (itr02.hasNext()) {
            int current = itr02.next();
            set03.add(current);
        }
        return set03;
    }

    // Takes a set as parameter and returns the shortest string
    public static int minLength(Set<String> set01){
        Iterator<String> itr = set01.iterator();
        int shortestString = 0;
        int count = 0;

        while (itr.hasNext()){
            String current = itr.next();
            if (count == 0) {
                shortestString = current.length();
            }
            if (current.length() < shortestString) {
                shortestString = current.length();
            }
            count++;
        }
        return shortestString;
    }


    // Checks if a number in the set is even
    public static boolean hasEven(Set<Integer> set) {
        Iterator<Integer> itr = set.iterator();
        boolean even = false;

        while (itr.hasNext()) {
            int current = itr.next();
            if (current%2==0) {
                even = true;
            }
        }

        return even;
    }

    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        set.add("abc");
        set.add("asdfgh");
        set.add("qwe");
        set.add("hjkl");

        System.out.println(removeOddLength(set));

        Set<Integer> set01 = new HashSet<Integer>();
        set01.add(1);
        set01.add(2);
        set01.add(3);
        set01.add(4);

        Set<Integer> set02 = new HashSet<Integer>();
        set02.add(2);
        set02.add(4);
        set02.add(6);

        System.out.println(symmetricSetDifference(set01, set02));

    }
}
