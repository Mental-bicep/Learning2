package stringmethods;

import java.util.Arrays;

public class StringMethodsDemo {

    public static void main(String[] args) {
        
        String text = "  Hello Java World!  ";
        String sample = "Hello Java World!";
        
        // 1. Returns total number of characters -> length()
        System.out.println("1. length(): " + sample.length()); // Output: 17
        
        // 2. Returns character at specific 0-based index -> charAt(index)
        System.out.println("2. charAt(1): " + sample.charAt(1)); // Output: 'e'

        // String overrides equals and hashCode - so any two strings with same content will produce same hashCode and .equals will give true
        // 3. Performs exact case-sensitive content comparison -> equals(Object)
        System.out.println("3. equals(): " + "Java".equals("java")); // Output: false
        
        // 4. Performs case-insensitive content comparison -> equalsIgnoreCase(String)
        System.out.println("4. equalsIgnoreCase(): " + "Java".equalsIgnoreCase("java")); // Output: true
        System.out.println(text.equalsIgnoreCase(sample));
        
        // 5. Finds the first occurrence index of substring (-1 if not found) -> indexOf(String)
        System.out.println("5. indexOf('o'): " + sample.indexOf("o")); // Output: 4
        
        // 6. Finds the last occurrence index of substring -> lastIndexOf(String)
        System.out.println("6. lastIndexOf('o'): " + sample.lastIndexOf("o")); // Output: 12
        System.out.println(sample.lastIndexOf("o"));
        
        // 7. Extracts portion from beginIndex to end of string -> substring(beginIndex)
        System.out.println("7. substring(6): " + sample.substring(6)); // Output: "Java World!"
        System.out.println(sample.substring(6));
        
        // 8. Extracts portion from beginIndex to (endIndex - 1) -> substring(beginIndex, endIndex)
        System.out.println("8. substring(6, 10): " + sample.substring(6, 10)); // Output: "Java"
        System.out.println(sample.substring(6,10));
        
        // 9. Converts all characters to uppercase -> toUpperCase()
        System.out.println("9. toUpperCase(): " + sample.toUpperCase()); // Output: "HELLO JAVA WORLD!"
        System.out.println((sample.toUpperCase()));
        
        // 10. Converts all characters to lowercase -> toLowerCase()
        System.out.println("10. toLowerCase(): " + sample.toLowerCase()); // Output: "hello java world!"
        System.out.println(sample.toLowerCase());
        
        // 11. Removes leading and trailing whitespace -> trim()
        System.out.println("11. trim(): '" + text.trim() + "'"); // Output: 'Hello Java World!'
        System.out.println(sample.trim());
        
        // 12. Replaces target character/sequence with a new one -> replace(oldChar, newChar)
        System.out.println("12. replace(): " + sample.replace("Java", "Spring")); // Output: "Hello Spring World!"
        System.out.println(sample.replace("Java", "Spring"));
        
        // 13. Splits string into a String array based on delimiter -> split(regex)
        String[] words = sample.split(" ");
        System.out.println("13. split(): " + Arrays.toString(words)); // Output: [Hello, Java, World!]
        String [] wds = sample.split(" ");
        System.out.println(Arrays.toString(wds));
        
        // 14. Checks if substring exists anywhere within string -> contains(CharSequence)
        System.out.println("14. contains('Java'): " + sample.contains("Java")); // Output: true
        System.out.println(sample.contains("Java"));
        
        // 15. Checks if string starts with given prefix -> startsWith(prefix)
        System.out.println("15. startsWith('Hello'): " + sample.startsWith("Hello")); // Output: true
        System.out.println(sample.startsWith("Hello"));
        
        // 16. Converts string into a primitive char[] array -> toCharArray()
        char[] charArray = "Java".toCharArray();
        System.out.println("16. toCharArray(): " + Arrays.toString(charArray)); // Output: [J, a, v, a]
        char [] ch =  "Java".toCharArray();
        System.out.println(Arrays.toString(ch));
        
        // 17. Joins strings using arithmetic concatenation -> + Operator
        System.out.println("17. + operator: " + "Hello " + "World"); // Output: "Hello World"
        System.out.println("Hello" + "world");
        
        // 18. Appends specified string to the end -> concat(String)
        System.out.println("18. concat(): " + "Hello ".concat("World")); // Output: "Hello World"
        System.out.println("Hello".concat("World"));

        // =========================================================================
        // ADDITIONAL ESSENTIAL STRING METHODS
        // =========================================================================

        // 19. Checks if string ends with given suffix -> endsWith(suffix)
        System.out.println("19. endsWith('!'): " + sample.endsWith("!")); // Output: true
        System.out.println(sample.endsWith("!"));
        
        // 20. Checks if length() is 0 -> isEmpty()
        System.out.println("20. isEmpty(): " + "".isEmpty()); // Output: true
        System.out.println(sample.isEmpty());
        
        // 21. Checks if string is empty or contains only whitespace (Java 11+) -> isBlank()
        System.out.println("21. isBlank(): " + "   ".isBlank()); // Output: true
        System.out.println(sample.isBlank());
        
        // 22. Formats string using placeholders (%s, %d) (Java 15+) -> formatted()
        System.out.println("22. formatted(): " + "User: %s, Age: %d".formatted("Alice", 25)); // Output: "User: Alice, Age: 25"
        System.out.println("checking formatted string %d %s".formatted(19,"Hello"));
    
    }
}