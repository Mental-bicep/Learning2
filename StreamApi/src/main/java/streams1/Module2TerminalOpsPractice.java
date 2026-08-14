package streams1;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Module2TerminalOpsPractice {

    // =========================================================================
    // PROBLEM 2.1: Transaction Security & Status Audit
    // Target Methods: anyMatch, allMatch, noneMatch, findFirst, findAny
    // =========================================================================
    /**
     * PROBLEM STATEMENT 2.1:
     * You are auditing a financial stream of transaction amounts (Doubles).
     * * Implement the following 5 individual audit checks:
     * 1. checkAnyHighValue: Return true if ANY amount is strictly greater than $10,000.00.
     * 2. checkAllValid: Return true if ALL non-null amounts are strictly positive (> 0.0).
     * 3. checkNoneNegative: Return true if NO amount is negative (< 0.0).
     * 4. findFirstLargeAmount: Find and return the FIRST amount that is >= $1,000.00 wrapped in an Optional<Double>.
     * 5. findAnyMediumAmount: Find and return ANY amount that is between $500.00 and $1,000.00 (inclusive) wrapped in an Optional<Double>.
     *
     * Sample Input: [150.0, 750.0, 1200.0, 15000.0, null, 80.0]
     * Expected Output:
     * - checkAnyHighValue: true (15000.0 > 10000.0)
     * - checkAllValid: true
     * - checkNoneNegative: true
     * - findFirstLargeAmount: Optional[1200.0]
     * - findAnyMediumAmount: Optional[750.0]
     */
    public boolean checkAnyHighValue(List<Double> amounts) {
        if (amounts == null) return false;
        return amounts.stream()
            .filter(amt -> amt != null)
            .anyMatch(amt -> amt > 10_000.0);
    }

    public boolean checkAllValid(List<Double> amounts) {
        if (amounts == null) return true;
        return amounts.stream()
            .filter(amt -> amt != null)
            .allMatch(amt -> amt > 0.0);
    }

    public boolean checkNoneNegative(List<Double> amounts) {
        if (amounts == null) return true;
        return amounts.stream()
            .filter(amt -> amt != null)
            .noneMatch(amt -> amt < 0.0);
    }

    public Optional<Double> findFirstLargeAmount(List<Double> amounts) {
        if (amounts == null) return Optional.empty();
        return amounts.stream()
            .filter(amt -> amt != null)
            .filter(amt -> amt >= 1000.0)
            .findFirst();
    }

    public Optional<Double> findAnyMediumAmount(List<Double> amounts) {
        if (amounts == null) return Optional.empty();
        return amounts.stream()
            .filter(amt -> amt != null)
            .filter(amt -> amt >= 500.0 && amt <= 1000.0)
            .findAny();
    }

    // =========================================================================
    // PROBLEM 2.2: Price & Inventory Aggregations
    // Target Methods: count, min, max
    // =========================================================================
    /**
     * PROBLEM STATEMENT 2.2:
     * Given a list of product prices (Doubles, which may contain nulls):
     * * 1. countValidPrices: Count how many non-null prices are strictly greater than $50.0.
     * 2. findMinPrice: Find the minimum non-null price using an explicit lambda comparator:
     * (p1, p2) -> Double.compare(p1, p2). Return Optional<Double>.
     * 3. findMaxPrice: Find the maximum non-null price using an explicit lambda comparator:
     * (p1, p2) -> Double.compare(p1, p2). Return Optional<Double>.
     *
     * Sample Input: [29.99, null, 149.50, 89.99, 12.00, 199.99]
     * Expected Output:
     * - countValidPrices (> $50.0): 3 (149.50, 89.99, 199.99)
     * - findMinPrice: Optional[12.0]
     * - findMaxPrice: Optional[199.99]
     */
    public long countValidPrices(List<Double> prices) {
        if (prices == null) return 0;
        return prices.stream()
            .filter(p -> p != null)
            .filter(p -> p > 50.0)
            .count();
    }

    public Optional<Double> findMinPrice(List<Double> prices) {
        if (prices == null) return Optional.empty();
        return prices.stream()
            .filter(p -> p != null)
            .min((p1, p2) -> Double.compare(p1, p2));
    }

    public Optional<Double> findMaxPrice(List<Double> prices) {
        if (prices == null) return Optional.empty();
        return prices.stream()
            .filter(p -> p != null)
            .max((p1, p2) -> Double.compare(p1, p2));
    }

    // =========================================================================
    // PROBLEM 2.3: Reductions with Identity & BinaryOperator (1-arg & 2-arg)
    // Target Methods: reduce(identity, accumulator), reduce(accumulator)
    // =========================================================================
    /**
     * PROBLEM STATEMENT 2.3:
     * Given a list of Integers (may contain nulls and negative numbers):
     * * 1. calculateTotalSum: Calculate the sum of all valid, positive (> 0) integers using 
     * 2-argument reduce: reduce(0, (acc, val) -> acc + val).
     * 2. calculateProduct: Calculate the product of all valid, positive (> 0) integers using 
     * 1-argument reduce: reduce((acc, val) -> acc * val).
     * Return Optional<Integer> (if the list is empty or has no positive numbers, returns Optional.empty()).
     *
     * Sample Input 1: [2, 3, 4, -5, null]
     * - Total Sum: 2 + 3 + 4 = 9
     * - Product: 2 * 3 * 4 = 24 -> Optional[24]
     * Sample Input 2: [-1, -2]
     * - Total Sum: 0 (identity)
     * - Product: Optional.empty()
     */
    public int calculateTotalSum(List<Integer> numbers) {
        if (numbers == null) return 0;
        return numbers.stream()
            .filter(n -> n != null && n > 0)
            .reduce(0, (acc, val) -> acc + val);
        
//        return numbers.stream()
//                .filter(n -> n != null && n > 0)
//                .mapToInt(n -> n.intValue()) // Or mapToInt(n -> n) due to auto-unboxing
//                .sum();
        
    }

    public Optional<Integer> calculateProduct(List<Integer> numbers) {
        if (numbers == null) return Optional.empty();
        return numbers.stream()
            .filter(n -> n != null && n > 0)
            .reduce((acc, val) -> acc * val);
    }

    // =========================================================================
    // PROBLEM 2.4: Advanced 3-Argument Reduction (Parallel-Safe)
    // Target Method: reduce(identity, accumulator, combiner)
    // =========================================================================
    /**
     * PROBLEM STATEMENT 2.4:
     * Given a list of String words:
     * Calculate the TOTAL length (number of characters) across all words using 
     * the 3-argument reduce variant:
     * Identity: 0
     * Accumulator: (accumulatedLength, word) -> accumulatedLength + word.length()
     * Combiner: (length1, length2) -> length1 + length2
     *
     * Why 3 Arguments?
     * The 3-argument reduce allows reducing elements of type T (String) to a completely 
     * different output type U (Integer). The 'combiner' function is essential when running 
     * in parallel streams so worker threads can merge their partial Integer counts together!
     *
     * Sample Input: ["Java", "Stream", "API"]
     * Expected Output: 4 + 6 + 3 = 13
     */
    public int calculateTotalCharacterCount(List<String> words) {
        if (words == null) return 0;
        return words.stream()
            .filter(w -> w != null)
            .reduce(
                0,                                                  // Identity (starting count)
                (accumulatedLength, word) -> accumulatedLength + word.length(), // Accumulator
                (length1, length2) -> length1 + length2             // Combiner (merges thread results)
            );
        
        
//        return words.stream()
//                .filter(w -> w != null)
//                .mapToInt(w -> w.length()) // Extract the length as a primitive int
//                .sum();
    }

    // =========================================================================
    // PROBLEM 2.5: Stream to Array Conversion
    // Target Methods: toArray(), toArray(IntFunction<A[]> generator)
    // =========================================================================
    /**
     * PROBLEM STATEMENT 2.5:
     * Given a list of String words (may contain nulls):
     * 1. convertToObjectArray: Filter out nulls, convert remaining words to UPPERCASE, 
     * and collect into a generic Object[] array using stream.toArray().
     * 2. convertToStringArray: Filter out nulls, convert remaining words to UPPERCASE, 
     * and collect into a strongly-typed String[] array using 
     * stream.toArray(size -> new String[size]).
     *
     * Sample Input: ["apple", null, "banana"]
     * Expected Output:
     * - Object[]: ["APPLE", "BANANA"]
     * - String[]: ["APPLE", "BANANA"]
     */
    public Object[] convertToObjectArray(List<String> words) {
        if (words == null) return new Object[0];
        return words.stream()
            .filter(w -> w != null)
            .map(w -> w.toUpperCase())
            .toArray();
    }

    public String[] convertToStringArray(List<String> words) {
        if (words == null) return new String[0];
        return words.stream()
            .filter(w -> w != null)
            .map(w -> w.toUpperCase())
            .toArray(size -> new String[size]); // Explicit lambda array generator
    }

    // =========================================================================
    // MAIN METHOD TO RUN & VERIFY ALL PROBLEMS LOCALLY IN ECLIPSE
    // =========================================================================
    public static void main(String[] args) {
        Module2TerminalOpsPractice practice = new Module2TerminalOpsPractice();

        System.out.println("==================================================");
        System.out.println("--- TESTING PROBLEM 2.1: MATCHING & FINDING ---");
        System.out.println("==================================================");
        List<Double> amounts = Arrays.asList(150.0, 750.0, 1200.0, 15000.0, null, 80.0);
        System.out.println("Input: " + amounts);
        System.out.println("Any High Value (> $10k): " + practice.checkAnyHighValue(amounts));
        System.out.println("All Positive (> 0): " + practice.checkAllValid(amounts));
        System.out.println("None Negative (< 0): " + practice.checkNoneNegative(amounts));
        System.out.println("First Large Amount (>= $1k): " + practice.findFirstLargeAmount(amounts));
        System.out.println("Any Medium Amount ($500-$1k): " + practice.findAnyMediumAmount(amounts));

        System.out.println("\n==================================================");
        System.out.println("--- TESTING PROBLEM 2.2: COUNT, MIN, MAX ---");
        System.out.println("==================================================");
        List<Double> prices = Arrays.asList(29.99, null, 149.50, 89.99, 12.00, 199.99);
        System.out.println("Input: " + prices);
        System.out.println("Count (> $50): " + practice.countValidPrices(prices));
        System.out.println("Min Price: " + practice.findMinPrice(prices));
        System.out.println("Max Price: " + practice.findMaxPrice(prices));

        System.out.println("\n==================================================");
        System.out.println("--- TESTING PROBLEM 2.3: REDUCTIONS (1-ARG & 2-ARG) ---");
        System.out.println("==================================================");
        List<Integer> numbers = Arrays.asList(2, 3, 4, -5, null);
        System.out.println("Input: " + numbers);
        System.out.println("Total Sum (2-arg reduce): " + practice.calculateTotalSum(numbers));
        System.out.println("Product (1-arg reduce): " + practice.calculateProduct(numbers));

        System.out.println("\n==================================================");
        System.out.println("--- TESTING PROBLEM 2.4: 3-ARGUMENT REDUCTION ---");
        System.out.println("==================================================");
        List<String> words = Arrays.asList("Java", "Stream", "API");
        System.out.println("Input: " + words);
        System.out.println("Total Character Count: " + practice.calculateTotalCharacterCount(words));

        System.out.println("\n==================================================");
        System.out.println("--- TESTING PROBLEM 2.5: STREAM TO ARRAYS ---");
        System.out.println("==================================================");
        List<String> fruits = Arrays.asList("apple", null, "banana");
        Object[] objArray = practice.convertToObjectArray(fruits);
        String[] strArray = practice.convertToStringArray(fruits);
        System.out.println("Object[] Result: " + Arrays.toString(objArray));
        System.out.println("String[] Result: " + Arrays.toString(strArray));
    }
}