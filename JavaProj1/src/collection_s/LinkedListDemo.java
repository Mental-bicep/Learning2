package collection_s;

import java.util.Arrays;
import java.util.LinkedList;

public class LinkedListDemo {

    // DSA Use Case: When you need O(1) insertions/deletions at BOTH ends.
    // Note: For pure Stacks or Queues, ArrayDeque is usually faster due to cache locality,
    // but LinkedList is required if you heavily manipulate the middle with Node references.
    public static void main(String[] args) {
        System.out.println("--- LinkedList Operations ---");
        
        // 1. Initialization with default elements
        // Using LinkedList explicitly instead of List interface to access addFirst/addLast
        LinkedList<Integer> list = new LinkedList<>(Arrays.asList(20, 30, 40));
        System.out.println("Initial LinkedList: " + list);
        
        // 2. Adding / Inserting - O(1) at ends, O(N) in middle
        list.addFirst(10); // Adds to the head
        list.addLast(50);  // Adds to the tail (same as add())
        list.add(2, 25);   // Inserts at index 2 (O(N) traversal)
        
        System.out.println("After Adding: " + list);
        
        // 3. Accessing & Updating - O(N) traversal (Not recommended for random access!)
        int element = list.get(2); // Gets element at index 2 (25)
        list.set(2, 28);           // Updates element at index 2
        
        // 4. Removing - O(1) at ends
        list.removeFirst(); // Removes head (10)
        list.removeLast();  // Removes tail (50)
        
        System.out.println("After Removing ends: " + list);
        
        // 5. Utility Methods
        boolean exists = list.contains(30); // O(N) search
        
        // 6. Custom sorting with Lambda
        list.add(15);
        list.add(5);
        
        // Sorting descending using Lambda
        list.sort((a, b) -> Integer.compare(b, a));
        System.out.println("Sorted Descending: " + list);
    }
}