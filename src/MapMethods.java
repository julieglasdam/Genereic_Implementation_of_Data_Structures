import java.util.*;


/**
 * Created by Julie on 10-05-2017.
 */
public class MapMethods {

    // Checks if two keys map to the same value, or if they're all unique
    public static boolean isUnique(Map<String, String> map){
        Collection<String> collection = map.values();
        Set<String> set = new HashSet<String>();

        for (String value : collection) {
            set.add(value);
        }

        int collectionSize = collection.size();
        int setSize = set.size();

        if (collectionSize == setSize) {
            return true;
        }
        else if (collectionSize > setSize) {
            return false;
        }
        else {
            return false;
        }

    }

    /* Takes two maps as parameters and returns a new map containing only the keys and values found in
    both map. The keys must map to the same value*/
    public static Map<String, Integer> intersect(Map<String, Integer> map01, Map<String, Integer> map02) {
        Map<String, Integer> map03 = new HashMap<String, Integer>();
        Set<String> set = map01.keySet();

        for (String names : set) {
            int number = map01.get(names);
            if (map02.containsKey(names) && map02.containsValue(number)) {
                map03.put(names, number);
            }
        }

        return map03;
    }


   /* Takes two maps as parameters and checks if the second map is a submap. That is, if it contains the all the same
   keys, and the keys have the same values. The submap can contain other keys as well */
        public static boolean subMap(Map<String, String> map01, Map<String, String> map02) {
            Set<String> set01 = map01.keySet();
            for (String key : set01) {
                String value = map01.get(key);

                if (!(map02.containsKey(key))) { // Tjek om den key findes i det andet map. hvis ikke: return false
                    return false;
                }
                else {
                    if (!(map02.get(key).equals(value))) { // Hvis den gør, tjek om den keys value er den samme. hvis ikke: return false
                        return false;
                    }
                }
            }

            return true;
        }


        /* Takes a map as parameter and returns a reversed map, where the keys are now the values, and the values are now the keys*/
    public static Map<String, String> reverse(Map<String, String> map) {
        Map<String, String> mapReverse = new HashMap<String, String>();
        Set<String> set = map.keySet();
        for (String key : set) {
            // Tjek om den value eksisterer. Hvis ikke:
            String value = map.get(key);

            if (!(mapReverse.containsKey(value))) { // hvis map ikke indeholder value'en i forvejen
                mapReverse.put(value, key);
            }
            else { // Hvis den value eksisterer: erstat value, med den gamle value plus den nye
                String currentKey = mapReverse.get(value);
                mapReverse.put(value,(currentKey+", "+key));
            }
        }

        return mapReverse;

    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<String, String>();

        map.put("Marty", "Stepp");
        map.put("Stuart", "Reges");
        map.put("Jessica", "Miller");
        map.put("sdfdsf", "Miller");
        System.out.println(isUnique(map));


        Map<String, Integer> map01 = new HashMap<String, Integer>();
        map01.put("Janet", 87);
        map01.put("Logan", 62);
        map01.put("Whitaker", 46);
        map01.put("Alyssa", 100);

        Map<String, Integer> map02 = new HashMap<String, Integer>();
        map02.put("Janet", 70);
        map02.put("Logan", 62);
        map02.put("Sylvia", 100);

        System.out.println(intersect(map01, map02));

    }
}
