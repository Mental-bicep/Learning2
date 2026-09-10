package collection_s;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class HashSetDemo {

    // DSA Use Case: Removing duplicates, O(1) lookups for existence, detecting cycles (Linked Lists/Graphs).
    public static void main(String[] args) {
        System.out.println("--- HashSet Operations ---");
        
        // 1. Initialization
        Set<Integer> set = new HashSet<>();
        
        // 2. Adding - O(1). Returns true if added, false if already exists.
        set.add(10);
        set.add(20);
        boolean isAdded = set.add(10); // Returns false, 10 is a duplicate
        
        System.out.println("Set contents: " + set);
        
        // 3. Checking existence - O(1). This is the main reason we use HashSet!
        if (set.contains(20)) {
            System.out.println("Set contains 20!");
        }
        
        // 4. Removing - O(1)
        set.remove(10);
        
        // --- NEW: SET THEORY METHODS (Crucial for DSA) ---***************************************************************
        
        java.util.Set<Integer> setA = new HashSet<>(java.util.Arrays.asList(1, 2, 3));
        java.util.Set<Integer> setB = new HashSet<>(java.util.Arrays.asList(3, 4, 5));
        
        // 5a. Union (addAll) - Modifies setA to contain all elements of setB
        // setA.addAll(setB); // setA becomes [1, 2, 3, 4, 5]
        
        // 5b. Intersection (retainAll) - CRUCIAL for "Find Common Elements" problems
        setA.retainAll(setB); // setA becomes [3]
        System.out.println("Intersection: " + setA);
        
        // 5c. Difference (removeAll) - Removes elements of setB from setA
        // setA.removeAll(setB); 
        
        // 5. Iterating
        for (int num : set) {
            System.out.println("Element: " + num);
        }
        
        // Note: HashSet DOES NOT maintain insertion order. 
        // If you need order + uniqueness, use LinkedHashSet.
        // If you need sorted + uniqueness, use TreeSet.
        
        System.out.println("*******************************************************************************************");
        
        HashSet<Integer> hs = new HashSet<>();
        hs.add(10);
        hs.add(20);
        
        boolean gotAdded = hs.add(40);
        System.out.println("got Added = "+ gotAdded);
        System.out.println(hs.contains(40));
        
        System.out.println(hs);
        if(hs.contains(40)) hs.remove(40);
        System.out.println(hs);
        
        hs.remove(50);
        
        for(int ele: hs) System.out.print(ele + " ");
        
        
        HashSet<Integer> st1 = new HashSet<>(Arrays.asList(10,20,30,40));
        HashSet<Integer> st2 = new HashSet<>(Arrays.asList(20,30,40,50));
        System.out.println("------------------------------Break1--------------------------------");
        HashSet<Integer> st3 = new HashSet<>(st1);
        st3.retainAll(st2);
        System.out.println(st1 + " " + st2 + "--> "+ st3);
        
        var st4 = new HashSet<>(st1);
        st4.addAll(st2);
        System.out.println(st4);
        
        var st5 = new HashSet<>(st1);
        st5.removeAll(st2);
        System.out.println(st5);
    }
}