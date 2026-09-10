package collection_s;

import java.util.ArrayDeque;
import java.util.Deque;

public class ArrayDequeDemo {

    // DSA Use Case: Stacks (DFS, Monotonic Stack, Valid Parentheses), Queues (BFS, Sliding Window).
    // NOTE: NEVER use the legacy 'Stack' class in Java. Always use ArrayDeque for stacks and queues.
    public static void main(String[] args) {
        
        System.out.println("--- ArrayDeque as a STACK (LIFO) ---");
        Deque<Integer> stack = new ArrayDeque<>();
        
        // 1. Push (Add to top) - O(1)
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        // 2. Peek (Look at top) - O(1)
        System.out.println("Stack Top: " + stack.peek()); // Prints 30
        
        // 3. Pop (Remove from top) - O(1)
        System.out.println("Popped: " + stack.pop()); // Removes 30
        System.out.println("New Stack Top: " + stack.peek()); // Prints 20
        
        
        System.out.println("\n--- ArrayDeque as a QUEUE (FIFO) ---");
        Deque<Integer> queue = new ArrayDeque<>();
        
        // 1. Offer (Add to back) - O(1)
        // Note: Using offer/poll is safer than add/remove as they don't throw exceptions if empty/full
        queue.offer(100);
        queue.offer(200);
        queue.offer(300);
        
        // 2. Peek (Look at front) - O(1)
        System.out.println("Queue Front: " + queue.peek()); // Prints 100
        
        // 3. Poll (Remove from front) - O(1)
        System.out.println("Polled (Served): " + queue.poll()); // Removes 100
        System.out.println("New Queue Front: " + queue.peek()); // Prints 200
        
        
        System.out.println("\n--- ArrayDeque as a DOUBLE-ENDED QUEUE (Deque) ---");
        // DSA Use Case: Sliding Window Maximum, Monotonic Deque.
        // When you explicitly need to add/remove from BOTH ends.
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        
        // 1. Adding to both ends - O(1)
        deque.addLast(10);  // State: [10]
        deque.addLast(20);  // State: [10, 20]
        deque.addFirst(5);  // State: [5, 10, 20]
        
        System.out.println("Deque Elements: " + deque);
        
        // 2. Peeking at both ends - O(1)
        System.out.println("Deque Front: " + deque.peekFirst()); // Prints 5
        System.out.println("Deque Back: " + deque.peekLast());   // Prints 20
        
        // 3. Removing from both ends - O(1)
        System.out.println("Removed from Front: " + deque.pollFirst()); // Removes 5
        System.out.println("Removed from Back: " + deque.pollLast());   // Removes 20
        
        System.out.println("Remaining Deque: " + deque); // Prints [10]
    }
}