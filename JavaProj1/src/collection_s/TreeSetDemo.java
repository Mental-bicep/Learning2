package collection_s;

import java.util.TreeSet;
import java.util.Iterator;

public class TreeSetDemo {
    public static void main(String[] args) {

        // 1. Creating a TreeSet (stores elements in sorted order, no duplicates)
        TreeSet<Integer> ts = new TreeSet<>();

        // 2. Adding elements
        ts.add(50);
        ts.add(10);
        ts.add(30);
        ts.add(20);
        ts.add(40);
        ts.add(10); // duplicate, will be ignored

        System.out.println("TreeSet after adding elements: " + ts);
        // Output is always sorted: [10, 20, 30, 40, 50]

        // 3. Checking size
        System.out.println("Size: " + ts.size());

        // 4. Checking if an element exists
        System.out.println("Contains 30? " + ts.contains(30));
        System.out.println("Contains 100? " + ts.contains(100));

        // 5. Removing an element
        ts.remove(20);
        System.out.println("After removing 20: " + ts);

        // 6. First and last elements
        System.out.println("First (smallest): " + ts.first());
        System.out.println("Last (largest): " + ts.last());

        // 7. Navigation methods
        System.out.println("Higher than 30: " + ts.higher(30)); // smallest element > 30
        System.out.println("Lower than 30: " + ts.lower(30));   // largest element < 30
        System.out.println("Ceiling of 25: " + ts.ceiling(25)); // smallest element >= 25
        System.out.println("Floor of 25: " + ts.floor(25));     // largest element <= 25

        // 8. Poll first / last (retrieve and remove)
        System.out.println("Poll first: " + ts.pollFirst());
        System.out.println("Poll last: " + ts.pollLast());
        System.out.println("After polling: " + ts);

        // 9. Iterating using for-each
        ts.add(60);
        ts.add(70);
        System.out.print("Iterating with for-each: ");
        for (int val : ts) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 10. Iterating using Iterator
        System.out.print("Iterating with Iterator: ");
        Iterator<Integer> it = ts.iterator();
        while (it.hasNext()) {
            System.out.print(it.next() + " ");
        }
        System.out.println();

        // 11. Descending order iteration
        System.out.print("Descending order: ");
        for (int val : ts.descendingSet()) {
            System.out.print(val + " ");
        }
        System.out.println();

        // 12. headSet / tailSet / subSet
        ts.clear();
        ts.add(10); ts.add(20); ts.add(30); ts.add(40); ts.add(50);
        System.out.println("Full set: " + ts);
        System.out.println("headSet(30) [elements < 30]: " + ts.headSet(30));
        System.out.println("tailSet(30) [elements >= 30]: " + ts.tailSet(30));
        System.out.println("subSet(20,40) [20 <= x < 40]: " + ts.subSet(20, 40));

        // 13. Checking if empty
        System.out.println("Is empty? " + ts.isEmpty());
    }
}
