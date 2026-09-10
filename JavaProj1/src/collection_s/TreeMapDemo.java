package collection_s;

import java.util.TreeMap;
import java.util.TreeSet;

import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

public class TreeMapDemo {
    public static void main(String[] args) {

        // 1. Creating a TreeMap (keys stored in sorted order, no duplicate keys)
        TreeMap<Integer, String> tm = new TreeMap<>();

        // 2. Adding key-value pairs
        tm.put(50, "Fifty");
        tm.put(10, "Ten");
        tm.put(30, "Thirty");
        tm.put(20, "Twenty");
        tm.put(40, "Forty");
        tm.put(10, "TEN-updated"); // same key -> overwrites old value, no duplicate key

        System.out.println("TreeMap after adding: " + tm);
        // Output is always sorted by key: {10=TEN-updated, 20=Twenty, 30=Thirty, 40=Forty, 50=Fifty}

        // 3. Checking size
        System.out.println("Size: " + tm.size());

        // 4. Checking if a key/value exists
        System.out.println("Contains key 30? " + tm.containsKey(30));
        System.out.println("Contains value \"Forty\"? " + tm.containsValue("Forty"));

        // 5. Getting a value
        System.out.println("Value for key 30: " + tm.get(30));
        System.out.println("Value for missing key 99: " + tm.get(99)); // null, no exception

        // 6. getOrDefault
        System.out.println("Value for 99 (default): " + tm.getOrDefault(99, "NOT_FOUND"));

        // 7. Removing a key
        tm.remove(20);
        System.out.println("After removing key 20: " + tm);

        // 8. First and last entries (by key)
        System.out.println("First key: " + tm.firstKey());
        System.out.println("Last key: " + tm.lastKey());
        System.out.println("First entry: " + tm.firstEntry());
        System.out.println("Last entry: " + tm.lastEntry());

        // 9. Navigation methods (by key)
        System.out.println("Higher than 30: " + tm.higherKey(30)); // smallest key > 30
        System.out.println("Lower than 30: " + tm.lowerKey(30));   // largest key < 30
        System.out.println("Ceiling of 25: " + tm.ceilingKey(25)); // smallest key >= 25
        System.out.println("Floor of 25: " + tm.floorKey(25));     // largest key <= 25

        // Entry versions (return Map.Entry instead of just the key)
        System.out.println("Higher entry than 30: " + tm.higherEntry(30));
        System.out.println("Floor entry of 25: " + tm.floorEntry(25));

        // 10. Poll first / last (retrieve and remove the extreme entry)
        System.out.println("Poll first entry: " + tm.pollFirstEntry());
        System.out.println("Poll last entry: " + tm.pollLastEntry());
        System.out.println("After polling: " + tm);

        // 11. Iterating using entrySet + for-each
        tm.put(60, "Sixty");
        tm.put(70, "Seventy");
        System.out.println("Iterating with entrySet:");
        for (Map.Entry<Integer, String> entry : tm.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }

        // 12. Iterating using Iterator
        System.out.print("Iterating with Iterator (keys only): ");
        Iterator<Integer> it = tm.keySet().iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 13. Iterating using forEach + lambda
        System.out.println("Iterating with forEach:");
        tm.forEach((k, v) -> System.out.println("  " + k + " => " + v));

        // 14. Descending order iteration
        System.out.println("Descending key set: " + tm.descendingKeySet());
        System.out.println("Descending map: " + tm.descendingMap());

        // 15. headMap / tailMap / subMap
        tm.clear();
        tm.put(10, "A"); tm.put(20, "B"); tm.put(30, "C"); tm.put(40, "D"); tm.put(50, "E");
        System.out.println("Full map: " + tm);
        System.out.println("headMap(30) [keys < 30]: " + tm.headMap(30));
        System.out.println("tailMap(30) [keys >= 30]: " + tm.tailMap(30));
        System.out.println("subMap(20,40) [20 <= k < 40]: " + tm.subMap(20, 40));

        // 16. Checking if empty
        System.out.println("Is empty? " + tm.isEmpty());
    }
}