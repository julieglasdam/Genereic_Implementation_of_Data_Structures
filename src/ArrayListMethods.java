import java.util.*;

/**
 * Created by Julie on 10-05-2017.
 */
public class ArrayListMethods {
    // Takes an arraylist as parameter and checks is a word occours 3 times
    public static boolean contains3(ArrayList<String> list) {
        Map<String, Integer> map = new TreeMap<String, Integer>();
        Iterator<String> itr = list.iterator();


        while (itr.hasNext()) {
            String word = itr.next().toLowerCase();
            if (map.containsKey(word)) { // Hvis ordet allerede er i listen
                int count = map.get(word); // Hent count værdien for det ord
                map.put(word, count+1); // Indsæt ordet igen og indsæt den gamle count værdi plus 1
            }
            else {
                map.put(word, 1); // Indsæt ordet, med count værdien 1
            }
        }

        Collection<Integer> countValues = map.values(); // Keys = Set, Values = collection
        int countOccurences = 0;
        for (int number : countValues) {
            if (number >= countOccurences) {
                countOccurences = number;
            }
        }

        if (countOccurences >= 3) {
            return true;
        }
        else {
            return false;
        }


    }


    public static void main(String[] args) {

    }
}
