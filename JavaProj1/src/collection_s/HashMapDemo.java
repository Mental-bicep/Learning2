package collection_s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    // DSA Use Case: Frequency counting, Two-Sum problem, Memoization for DP, O(1) lookups.
    public static void main(String[] args) {
        System.out.println("--- HashMap Operations ---");
        
        // 1. Initialization
        Map<String, Integer> map = new HashMap<>();
        
        // 2. Inserting / Updating - O(1)
        map.put("Alice", 25);
        map.put("Bob", 30);
        map.put("Alice", 26); // Overwrites the existing value for Alice
        
        // 3. Accessing - O(1)
        int aliceAge = map.get("Alice");
        
        // *** CRUCIAL DSA METHOD: getOrDefault ***
        // Prevents NullPointerException. Great for frequency maps!
        int charlieAge = map.getOrDefault("Charlie", 0); 
        
        // Example: Frequency Map logic
        String word = "programming";
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : word.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        System.out.println("Frequency Map: " + freqMap);
        
        // --- NEW: ADVANCED MAP METHODS FOR DSA ---
        
        // 4a. putIfAbsent - O(1)
        // Only inserts if the key doesn't exist. Prevents overwriting!
        map.putIfAbsent("Alice", 99); 
        
        // 4b. computeIfAbsent - O(1)
        // CRUCIAL FOR GRAPHS (Adjacency Lists)! Initializes a list if missing, then adds to it.
        Map<Integer, java.util.List<Integer>> graph = new HashMap<>();
        // Adds edge from node 1 to node 2 effortlessly
        graph.computeIfAbsent(1, k -> new java.util.ArrayList<>()).add(2);
        
        // 4c. merge - O(1)
        // The cleanest, most modern way to do frequency counting or updating values!
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Apples", 5);
        // If "Apples" exists, adds 3 to current value. If not, sets to 3.
        inventory.merge("Apples", 3, Integer::sum);
        
        // 4. Checking existence - O(1)
        boolean hasBob = map.containsKey("Bob");
        boolean hasAge30 = map.containsValue(30); // O(N) operation, rarely used in DSA
        
        // 5. Removing - O(1)
        map.remove("Bob");
        
        // 6. Iterating (Most common way in DSA)
        System.out.println("\nIterating through Map:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
        }
        
        // Iterate just keys
        for (String key : map.keySet()) {
            // Do something with key
        }
        
        
        System.out.println("------------------------------------------------------------------------------------");
        HashMap<Integer,Integer> intMap = new HashMap<>();
        intMap.put(3,400);
        intMap.put(4,600);
        
        System.out.println(intMap.get(3));
        System.out.println(intMap.get(9));
        System.out.println(intMap.getOrDefault(9, -1));
        
        String s1 = "abcd";
        HashMap<Character, Integer> charMap = new HashMap<>();
        for(char c: s1.toCharArray()) {
        	charMap.put(c,charMap.getOrDefault(c,0) + 1);
        }
        System.out.println(charMap);
        
        HashMap<Integer, ArrayList<Integer>> mp1 = new HashMap<>();
        for(int i=0; i< 5; ++i) 
        	mp1.put(i, new ArrayList<>());
        
        mp1.get(2).add(200);
        mp1.get(2).add(500);
        
        System.out.println(mp1);
        
        mp1.putIfAbsent(2,new ArrayList<>(Arrays.asList(400,600)));
        mp1.putIfAbsent(9,new ArrayList<>(Arrays.asList(-1,-1,-1)));
        System.out.println(mp1);
        
        System.out.println(mp1.containsKey(2));
        System.out.println(mp1.containsKey(20));
        
        for(var arr: mp1.keySet())
        	System.out.println(mp1.get(arr));
        
        for(int key : mp1.keySet()) {
        	for(var x: mp1.get(key)) System.out.print(x + " ");
        	System.out.println("*****");
        }
        
        mp1.remove(4);
        mp1.forEach((k,v) -> System.out.println(k + "-> "+v));
        
//        System.out.println("*************************************************************************************");
        
        mp1.forEach((k,v) ->{
        	for(var x: v) System.out.print(x + " ");
        	System.out.println("$$$$$");
        });
        
        System.out.println("*************************************************************************************");
        mp1.forEach((k,v)-> v.add(-100));
        
        mp1.forEach((k,v) -> System.out.println(k + " -> "+v));
    }
}