package collection_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsDemo {

    // DSA Use Case: Utility methods for operating on Lists (sorting, searching, reversing, min/max).
    public static void main(String[] args) {
        System.out.println("--- Collections Utility Operations ---");
        
        // 1. Initialization with default elements
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9, 2, 2));
        System.out.println("Initial List: " + list);
        
        // 2. Sorting - O(N log N)
        Collections.sort(list); // Natural ascending order
        System.out.println("Sorted (Ascending): " + list);
        
        // Custom Sorting (Descending) using Lambda
        Collections.sort(list, (a, b) -> Integer.compare(b, a));
        System.out.println("Sorted (Descending): " + list);
        
        // 3. Reversing a list - O(N)
        // Let's reverse it back to ascending
        Collections.reverse(list);
        System.out.println("Reversed List (Back to Ascending): " + list);
        
        // 4. Binary Search - O(log N) 
        // NOTE: The list MUST be sorted in ascending order before using binary search!
        int index = Collections.binarySearch(list, 8);
        System.out.println("Index of 8: " + index);
        
        // 5. Finding Min and Max - O(N)
        // Works on unsorted lists too!
        int min = Collections.min(list);
        int max = Collections.max(list);
        System.out.println("Min: " + min + ", Max: " + max);
        
        // 6. Frequency of an element - O(N)
        // Very useful instead of writing a manual loop to count occurrences
        int countOfTwos = Collections.frequency(list, 2);
        System.out.println("Frequency of 2: " + countOfTwos);
        
        // 7. Swapping elements - O(1)
        // Swaps the element at index 0 with the last element
        Collections.swap(list, 0, list.size() - 1);
        System.out.println("After swapping first and last: " + list);
        
        // 8. Shuffling - O(N)
        // Useful for randomized algorithms or games (like shuffling a deck of cards)
        List<Integer> deck = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.shuffle(deck);
        System.out.println("Shuffled Deck: " + deck);
        
        // 9. Filling a list with a specific value - O(N)
        // Note: This replaces existing elements, it doesn't add new ones.
        Collections.fill(list, 0);
        System.out.println("List filled with 0s: " + list);
        
        // --- NEW ALGORITHMIC SHORTCUTS ---
        
        // 10. Rotating a list - O(N)
        // Shifts elements by a distance. Positive = right shift, Negative = left shift.
        // Solves the "Rotate Array" problem instantly!
        List<Integer> rotList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.rotate(rotList, 2); 
        System.out.println("Rotated Right by 2: " + rotList); // [4, 5, 1, 2, 3]
        
        // 11. Replace All Occurrences - O(N)
        // Replaces all instances of one value with another.
        List<Integer> replaceList = new ArrayList<>(Arrays.asList(1, 2, 1, 3, 1));
        Collections.replaceAll(replaceList, 1, 99);
        System.out.println("After Replace All (1 to 99): " + replaceList); // [99, 2, 99, 3, 99]
        
        // 12. Check for disjoint collections - O(N)
        // Returns true if the two collections have NO elements in common.
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5, 6);
        boolean isDisjoint = Collections.disjoint(list1, list2);
        System.out.println("Are lists disjoint (no common elements)? " + isDisjoint);
        
        // 13. SubList matching (Like string matching, but for lists) - O(N*M)
        List<Integer> source = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> target = Arrays.asList(3, 4);
        int subListIndex = Collections.indexOfSubList(source, target);
        System.out.println("Index of sublist [3, 4]: " + subListIndex);
        
        // 14. Create a list of N identical elements - O(1) memory!
        // Very useful for initializing DP (Dynamic Programming) defaults.
        List<String> nCopies = Collections.nCopies(5, "Java");
        System.out.println("5 Copies of Java: " + nCopies);
        
        // --- NEW: IMMUTABILITY, MEMORY & THREAD SAFETY ---
        
        // 15. Unmodifiable Collections - O(1)
        // Wraps a list so it cannot be changed. 
        // This is exactly what we use for "Defensive Copying" to prevent bugs!
        List<Integer> readOnlyList = Collections.unmodifiableList(source);
        // readOnlyList.add(100); // If you uncomment this, it throws UnsupportedOperationException!
        
        // 16. Empty Collections - O(1)
        // Golden Rule of DSA: NEVER return 'null' from a function that returns a List.
        // Always return Collections.emptyList() to prevent NullPointerExceptions.
        List<String> safeEmptyReturn = Collections.emptyList();
        
        // 17. Singleton Collections - O(1)
        // Creates a fast, immutable list containing exactly ONE element. Memory efficient!
        List<String> oneItem = Collections.singletonList("Just Me");
        
        
        // --- MODERN JAVA 8+ SHORTCUTS (Called directly on the object) ---
        
        // 18. Remove If (Predicate) - O(N)
        // Safely removes items based on a condition without writing a messy Iterator loop!
        List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        numbers.removeIf(n -> n % 2 == 0); // Removes all even numbers instantly
        System.out.println("After removeIf (Odds only): " + numbers); // Prints [1, 3, 5]
    }
}