import java.util.*;

/**
 * Created by Julie on 10-05-2017.
 */
public class LinkedListMethods {
    // Takes a linkedlist as a parameter and returns the number of most occurances of a word
    public static int maxOccurences(LinkedList<Integer> list01) {
        Iterator<Integer> itr = list01.iterator();
        Map<Integer, Integer> temp = new HashMap<Integer, Integer>();
        int highestNumber = 0;


        while (itr.hasNext()) {
            int current = itr.next();
            if (temp.containsKey(current)) {
                int count = temp.get(current);
                temp.put(current, count+1);
            }
            else {
                temp.put(current, 1);
            }
        }

        Collection<Integer> countNumbers = temp.values();
        for (int currentNumber : countNumbers) {
            if (currentNumber > highestNumber) {
                highestNumber = currentNumber;
            }
        }

        for (Map.Entry<Integer, Integer> entry : temp.entrySet()) {
            if (Objects.equals(highestNumber, entry.getValue())) {
                return entry.getKey();
            }
        }

        return 0;
    }

    // Takes two lists as parameters and returns a new list with all values, in alternating order
    public static List<Integer> alternate (List<Integer> a, List<Integer> b) {
        ArrayList<Integer> c = new ArrayList();
        Iterator<Integer> d = a.iterator();
        Iterator<Integer> e = b.iterator();
        int count = 1;

        while (d.hasNext() || e.hasNext()) {
            if (count > a.size()) {
                int y = e.next();
                c.add(y);
            }
            else if (count > b.size()) {
                int x = d.next();
                c.add(x);
            }
            else {
                int x = d.next();
                int y = e.next();
                c.add(x);
                c.add(y);
            }
            count++;
        }

        return c;
    }



    // Takes a list as parameter as well as a starting index and an encing index. Removes all occurrences of even numbers between the two indexes
    public static List<Integer> removeEvenInRange(List<Integer> linkedlist, int getStart, int getStop) {
        int start = getStart; // 1
        int stop = getStop;   // 5


        for (int i = 0; i < linkedlist.size(); i++) {
            if (i >= start && i < stop) { // Hvis indexene er mellem start og stop
                if (linkedlist.get(i) % 2 == 0) {
                    linkedlist.remove(i);
                    stop = stop - 1;
                }
            }

        }
        return linkedlist;

    }



// Takes a list as parameter and a value. It rearanges the list, so that lower values comes first, and values greater than, comes after
    public static List<Integer> partition(List<Integer> list, int value) {
        for (int i = 0; i < list.size(); i++) {
            if (value > list.get(i)) {
                list.add(0, list.get(i));
                list.remove(i+1);

            }
        }
        return list;
    }


    // Takes two lists as parameters and returns the number of values that occors in both lists
    public static int countCommon(List<Integer> list01, List<Integer> list02){
        Set<Integer> set01 = new HashSet<Integer>(list01);
        Set<Integer> set02 = new HashSet<Integer>(list02);
        set01.retainAll(set02);

        return set01.size();
    }

    public static void main(String[] args) {

    }
}
