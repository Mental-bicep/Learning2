package collection_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    
    // DSA Use Case: Dynamic arrays, Adjacency Lists for Graphs, returning a list of results.
    public static void main(String[] args) {
        System.out.println("--- ArrayList Operations ---");
        
        // 1. Initialization with default elements
//        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
        ArrayList<Integer> list = new ArrayList<>();
        
        // 2. Adding / Inserting - O(1) amortized for add, O(N) for insert
        list.add(10); // Appends to end
        boolean res =list.add(30);
        System.out.println("insertion successful for element = "+list);
        list.add(20);
        list.add(1, 15); // Inserts at index 1 (Shifts elements right)
        list.add(40);
        list.add(3,100);
        
        
        System.out.println("Initial List: " + list);
        
        // 3. Accessing & Updating - O(1)
        int element = list.get(2); // Get element at index 2 (which is 30)
//        list.set(2, 25); // Update element at index 2 to 25
        list.set(2,25);
        // 4. Removing - O(N) because it shifts elements left
        list.remove(list.size() - 1); // Remove last element (Fastest remove: O(1))
        
        // list.remove(Integer.valueOf(15)); // Remove by value (Object)
        list.remove((Integer)15);
        // 5. Utility Methods
        boolean exists = list.contains(10); // O(N) search
        
        
        int size = list.size();
        
        
        // 6. Sorting (Crucial for DSA)
        list.add(5);
        list.add(50);
        System.out.println("Before Sort: " + list);
        
        // Ascending Order (Natural Ordering)
        Collections.sort(list); 
        
        System.out.println("Ascending Sort: " + list);
        
        // Descending Order
//        list.sort(Collections.reverseOrder());
        list.sort((a,b) -> Integer.compare(b,a));
        
        System.out.println("Descending Sort: " + list);
        
        // 7. Custom Comparator (Sorting objects or arrays)
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[]{1, 3});
        intervals.add(new int[]{2, 6});
        intervals.add(new int[]{8, 10});
        intervals.add(new int[]{15, 18});
        
        // Sort based on the first element of each array
        intervals.sort((a, b) -> Integer.compare(a[0], b[0]));
        
        
        System.out.println("\nSorted Intervals based on start time:");
        for (int[] interval : intervals) {
            System.out.println("[" + interval[0] + ", " + interval[1] + "]");
        }
        
     // 1. Initialization with default elements
     // 2. Adding in the end/ Inserting - O(1) amortized for add, O(N) for insert
     // 3. Accessing & Updating - O(1)
     // 4. Removing both index and value - O(N) because it shifts elements left
     // 5. check if element exists Utility Methods
     // 6. Sorting (Crucial for DSA) Natural + custom;
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(1);
        arr.add(2);
        arr.add(0);
        arr.add(-1);
        arr.add(-5);
        
        arr.remove(0);
        arr.remove((Integer)0);
        
        System.out.println(list.get(0));
        list.set(0,100);
        
    }
}