package collection_s;

import java.util.Arrays;
import java.util.List;

public class ArraysDemo {

    // DSA Use Case: Sorting primitive arrays, binary search, filling arrays, converting to collections.
    public static void main(String[] args) {
        System.out.println("--- Arrays Utility Operations ---");
        
        // 1. Initialization & Default Elements
        int[] arr = {5, 2, 8, 1, 9};
        
        // 2. Printing Arrays (Crucial for debugging, avoid printing memory addresses!)
        System.out.println("Initial Array: " + Arrays.toString(arr));
        
        // 3. Sorting Primitive Arrays - O(N log N)
        Arrays.sort(arr);
        System.out.println("Sorted Array (Ascending): " + Arrays.toString(arr));
        
        // 4. Binary Search - O(log N) (Array MUST be sorted first!)
        int index = Arrays.binarySearch(arr, 8);
        System.out.println("Index of 8: " + index);
        
        // 5. Filling Arrays - O(N) (Useful for DP memoization)
        int[] dp = new int[5];
        Arrays.fill(dp, -1);
        System.out.println("DP Array filled with -1: " + Arrays.toString(dp));
        
        // 6. Custom Sorting using Lambdas 
        // Note: Java requires Objects (like Integer) for custom comparators, not primitives (int).
        Integer[] objArr = {5, 2, 8, 1, 9};
        
        // Descending order using lambda
        Arrays.sort(objArr, (a, b) -> Integer.compare(b, a));
        System.out.println("Sorted Array (Descending): " + Arrays.toString(objArr));
        
        // 7. Sorting 2D Arrays (Matrix/Intervals) using Lambda
        int[][] intervals = {
            {3, 4},
            {1, 2},
            {5, 6}
        };
        
        // Sort by the first column
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        System.out.println("Sorted 2D Array:");
        for (int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }
        
        // 8. Converting Array to List (Returns a fixed-size list)
        List<String> list = Arrays.asList("Apple", "Banana", "Cherry");
        System.out.println("Array to List: " + list);
    }
}
