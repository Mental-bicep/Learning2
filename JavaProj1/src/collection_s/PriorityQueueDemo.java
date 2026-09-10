package collection_s;

import java.util.PriorityQueue;
import java.util.Collections;
import java.util.Comparator;

public class PriorityQueueDemo {

    // DSA Use Case: Top K elements, Dijkstra's Shortest Path, Median in a stream, Merge K sorted lists.
    public static void main(String[] args) {
        System.out.println("--- PriorityQueue (Heap) Operations ---");
        
        // 1. Initialization (Min-Heap by default)
        // The smallest element is always at the top (head).
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        // 2. Adding - O(log N)
        minHeap.offer(10); // 'offer' is preferred over 'add' for queues/heaps
        minHeap.offer(5);
        minHeap.offer(20);
        
        // 3. Peeking at the top element - O(1)
        System.out.println("Min-Heap Top (Smallest): " + minHeap.peek()); // Prints 5
        
        // 4. Removing the top element - O(log N)
        int smallest = minHeap.poll(); 
        System.out.println("Removed: " + smallest + ". New Top: " + minHeap.peek());
        
        
        // --- MAX HEAP ---
        // To get the largest element at the top, we pass a reverse comparator
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.offer(10);
        maxHeap.offer(5);
        maxHeap.offer(20);
        System.out.println("\nMax-Heap Top (Largest): " + maxHeap.peek()); // Prints 20
        
        
        // --- CUSTOM OBJECT COMPARATOR HEAP (Crucial for Dijkstra's) ---
        // Example: Storing [node, distance] and sorting by distance (smallest first)
        PriorityQueue<int[]> customHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        
        customHeap.offer(new int[]{0, 15}); // Node 0, dist 15
        customHeap.offer(new int[]{1, 5});  // Node 1, dist 5
        customHeap.offer(new int[]{2, 25}); // Node 2, dist 25
        
        int[] closestNode = customHeap.poll();
        System.out.println("\nClosest Node: " + closestNode[0] + " with distance " + closestNode[1]);
    }
}