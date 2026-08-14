package streams1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArraysStreamPractice {

    public static void main(String[] args) {
        System.out.println("=== 1. Primitive Int Array Processing ===");
        int[] scores = {45, 88, 92, 100, 30, 88, 74, 100, 60};
        System.out.println("Top 3 Distinct Scores Average: " + getTop3Average(scores)); // 100, 92, 88 -> 93.333...

//        System.out.println("\n=== 2. Range Slicing on Sub-array ===");
//        int[] numbers = {10, 20, 30, 40, 50, 60, 70, 80};
//        // Process only slice from index 2 (inclusive) to 6 (exclusive) -> {30, 40, 50, 60}
//        System.out.println("Sum of subarray slice (index 2 to 6): " + sumSubArraySlice(numbers, 2, 6)); // 180
//
//        System.out.println("\n=== 3. String Array Transformations & Mapping ===");
//        String[] words = {"  java ", null, "  STREAM ", "", "   ", "API  ", "  code  "};
//        System.out.println("Cleaned uppercase words: " + cleanAndTransformWords(words));
//
//        System.out.println("\n=== 4. Primitive to Object Boxing & String Joining ===");
//        int[] digits = {3, 1, 4, 1, 5, 9, 2, 6, 5};
//        System.out.println("Formatted CSV String: " + formatDigitsToCSV(digits));
//
//        System.out.println("\n=== 5. 2D Array Flattening (int[][]) ===");
//        int[][] matrix = {
//            {1, 2, 3},
//            null,
//            {4, 5},
//            {6, 7, 8, 9}
//        };
//        System.out.println("Flattened 2D array sum: " + sum2DMatrix(matrix)); // 45
    }

    /**
     * Problem 1: Primitive Int Stream Processing
     * Demonstrates using Arrays.stream(int[]) which directly produces an IntStream (no boxing).
     */
    public static double getTop3Average(int[] scores) {
        if (scores == null || scores.length == 0) {
            return 0.0;
        }

//        return Arrays.stream(scores)
//                .distinct()                             // Remove duplicates
//                .boxed()                                // Convert IntStream to Stream<Integer> to use custom Comparator
//                .sorted(Comparator.reverseOrder())      // Sort descending
//                .mapToInt(Integer::intValue)            // Convert back to IntStream for primitive average()
//                .limit(3)                               // Pick top 3
//                .average()                              // Returns OptionalDouble
//                .orElse(0.0);
        return Arrays.stream(scores).distinct().mapToObj(n -> (Integer)n).sorted(Comparator.reverseOrder()).
        		mapToInt(n->(int)n).limit(3).average().orElse(0.0);
    }

    /**
     * Problem 2: Overloaded Arrays.stream(array, startInclusive, endExclusive)
     * Demonstrates stream processing directly over a slice/range of an array without allocating a new sub-array!
     */
    public static int sumSubArraySlice(int[] numbers, int startInclusive, int endExclusive) {
        if (numbers == null) {
            return 0;
        }

        // Arrays.stream handles index boundaries out-of-the-box
        return Arrays.stream(numbers, startInclusive, endExclusive)
                .sum();
        
    }

    /**
     * Problem 3: Object Array Processing (String[])
     * Demonstrates handling String arrays with null safe operations and cleaning strings.
     */
    public static List<String> cleanAndTransformWords(String[] words) {
        if (words == null) {
            return List.of();
        }

        return Arrays.stream(words)
                .filter(w -> w != null && !w.trim().isEmpty()) // Filter out nulls and blank strings
                .map(String::trim)                            // Trim leading/trailing whitespace
                .map(String::toUpperCase)                     // Convert to uppercase
                .sorted()                                     // Alphabetical sort
                .toList();
    }

    /**
     * Problem 4: Primitive Array Boxing & Joining
     * Demonstrates converting an int[] array into a single formatted CSV String using mapToObj.
     */
    public static String formatDigitsToCSV(int[] digits) {
        if (digits == null || digits.length == 0) {
            return "";
        }

        return Arrays.stream(digits)
                .mapToObj(String::valueOf)  // IntStream -> Stream<String>
                .collect(Collectors.joining(", ", "[", "]"));
    }

    /**
     * Problem 5: 2D Array Flattening (int[][])
     * Demonstrates flattening a 2D primitive array using Arrays.stream and flatMapToInt.
     */
    public static int sum2DMatrix(int[][] matrix) {
        if (matrix == null) {
            return 0;
        }

        return Arrays.stream(matrix)
                .filter(row -> row != null)       // Handle null rows safely
                .flatMapToInt(Arrays::stream)    // Flatten each int[] row into a single continuous IntStream
                .sum();
    }
}
