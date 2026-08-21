package stringmethods;

public class StringBuilderDemo {

    public static void main(String[] args) {

        // Initialize a StringBuilder
        StringBuilder sb = new StringBuilder("Hello");

        // 1. append(String/primitive) -> Appends data to the end of the buffer
        sb.append(" Java");
        System.out.println("1. append(): " + sb); // Output: "Hello Java"

        // 2. length() -> Returns total number of characters currently in buffer
        System.out.println("2. length(): " + sb.length()); // Output: 10

        // 3. capacity() -> Returns total allocated memory capacity (Default initial = 16 + length)
        System.out.println("3. capacity(): " + sb.capacity()); // Output: 21 (16 + 5)

        // 4. charAt(index) -> Returns character at specific 0-based index
        System.out.println("4. charAt(1): " + sb.charAt(1)); // Output: 'e'

        // 5. insert(offset, String) -> Inserts data at specified index position
        sb.insert(5, " World");
        System.out.println("5. insert(): " + sb); // Output: "Hello World Java"

        // 6. replace(start, end, String) -> Replaces sequence from start to (end - 1)
        sb.replace(6, 11, "Spring");
        System.out.println("6. replace(): " + sb); // Output: "Hello Spring Java"

        // 7. deleteCharAt(index) -> Removes single character at target index
        sb.deleteCharAt(5); // Removes space at index 5
        System.out.println("7. deleteCharAt(): " + sb); // Output: "HelloSpring Java"

        // 8. delete(start, end) -> Removes substring from start to (end - 1)
        sb.delete(5, 11); // Removes "Spring"
        System.out.println("8. delete(): " + sb); // Output: "Hello Java"

        // 9. reverse() -> Reverses the entire character sequence in place
        sb.reverse();
        System.out.println("9. reverse(): " + sb); // Output: "avaJ olleH"

        // Re-reversing back for further operations
        sb.reverse(); // Back to "Hello Java"

        // 10. ensureCapacity(minimumCapacity) -> Guarantees buffer size is at least minimumCapacity
        sb.ensureCapacity(50);
        System.out.println("10. ensureCapacity(50): " + sb.capacity()); // Output: 50 (or 2*capacity + 2 if expanded)


        // =========================================================================
        // ADDITIONAL ESSENTIAL STRINGBUILDER METHODS
        // =========================================================================

        // 11. setCharAt(index, ch) -> Modifies a character at specific position
        sb.setCharAt(0, 'h');
        System.out.println("11. setCharAt(): " + sb); // Output: "hello Java"

        // 12. substring(start, end) -> Extracts a portion as a new String (does not mutate StringBuilder)
        String sub = sb.substring(0, 5);
        System.out.println("12. substring(0, 5): " + sub); // Output: "hello"

        // 13. trimToSize() -> Shrinks internal buffer capacity down to match current length
        sb.trimToSize();
        System.out.println("13. trimToSize() capacity: " + sb.capacity()); // Output: 10 (matches length)

        // 14. toString() -> Converts the mutable StringBuilder into an immutable String
        String result = sb.toString();
        System.out.println("14. toString(): " + result); // Output: "hello Java"
    }
}