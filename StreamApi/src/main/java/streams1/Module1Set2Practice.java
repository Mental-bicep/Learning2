package streams1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.*;

public class Module1Set2Practice {

    /**
     * PRACTICE 2.1: Nested Matrix & Delimited Token Flattening
     * Target Methods: flatMap (nested lists & string splitting), filter, map, distinct, sorted
     */
    public List<String> flattenAndCleanTags(List<List<String>> csvRows) {
        if (csvRows == null) return List.of();

//        return csvRows.stream()
//            // Step 1: Safely filter null rows
//            .flatMap(Stream::ofNullable)
//            // Step 2: Flatten inner list of strings
//            .flatMap(List::stream)
//            // Step 3: Safely handle null string elements in inner lists
//            .flatMap(Stream::ofNullable)
//            // Step 4: Split comma-separated tokens into stream
//            .flatMap(row -> Arrays.stream(row.split(",")))
//            // Step 5: Trim whitespace and lowercase
//            .map(String::trim)
//            .map(String::toLowerCase)
//            // Step 6: Exclude empty strings
//            .filter(tag -> !tag.isEmpty())
//            // Step 7: Deduplicate and sort natural order
//            .distinct()
//            .sorted()
//            .toList();
        
        return csvRows.stream().filter(row -> row!=null).flatMap(row -> row.stream())
        	.filter(elems -> elems!=null).flatMap(w -> Arrays.stream(w.split(",")))
        	.map(w -> w.trim()).filter(w-> w.isEmpty()==false).map(w -> w.toLowerCase()).distinct().sorted().toList();
        
    }

    /**
     * PRACTICE 2.2: Custom Multi-Level Comparator Sorting & Windowing
     * Target Methods: filter, sorted (with Comparator composition), skip, limit
     */
    public List<String> sortAndWindowWords(List<String> words) {
        if (words == null) return List.of();

//        Comparator<String> compoundComparator = Comparator
//            .comparingInt(String::length)
//            .reversed() // Descending by length
//            .thenComparing(String.CASE_INSENSITIVE_ORDER); // Ascending A-Z
//
//        return words.stream()
//            .filter(Objects::nonNull)
//            .filter(w -> !w.toLowerCase().startsWith("test"))
//            .sorted(compoundComparator)
//            .skip(1)
//            .limit(3)
//            .toList();
        
        return words.stream().filter(obj -> obj!=null).filter(w -> w.toLowerCase().startsWith("test") == false)
        		.sorted((a,b) -> {
        			int lenCompare = Integer.compare(a.length(), b.length());
        			if(lenCompare != 0) return lenCompare;
        			return a.compareToIgnoreCase(b);
        		}).skip(1).limit(3).toList();
    }

    /**
     * PRACTICE 2.3: Lazy Evaluation & Statefulness Trace
     * Target Methods: map, filter, peek, distinct, limit
     */
    public List<Integer> tracePipelineExecution(List<Integer> numbers) {
        if (numbers == null) return List.of();

        return numbers.stream()
            .filter(Objects::nonNull)
            .filter(n -> n > 0)
            .map(n -> n * 10)
            .peek(val -> System.out.println("Mapped: " + val))
            .distinct()
            .peek(val -> System.out.println("After Distinct: " + val))
            .limit(2)
            .toList();
        
//        return numbers.stream().filter(obj -> obj!=null)
        
    }

    /**
     * PRACTICE 2.4: Log Stream Filtering with takeWhile & dropWhile (Java 9+)
     * Target Methods: dropWhile, takeWhile
     * * Requirement:
     * 1. Ignore initial logs while they start with "START" or "LOG:" (using dropWhile).
     * 2. Take subsequent logs as long as they start with "ERROR:" (using takeWhile).
     * 3. Return as a List<String>.
     */
    public List<String> extractErrorBatch(List<String> logLines) {
        if (logLines == null) return List.of();

//        return logLines.stream()
//        	    .filter(Objects::nonNull)
//        	    // 1. Skip all startup/log lines at the beginning until the first non-matching line is hit
//        	    .dropWhile(line -> line.startsWith("START") || line.startsWith("LOG:"))
//        	    // 2. Take contiguous error lines, and STOP the stream the moment a non-error line appears
//        	    .takeWhile(line -> line.startsWith("ERROR:"))
//        	    .toList();
        
        return logLines.stream().dropWhile(w -> w.startsWith("START") || w.startsWith("LOG:"))
        		.takeWhile(w -> w.startsWith("ERROR:")).toList();
    }

    /**
     * PRACTICE 2.5: Bounded Mathematical Sequence Generator (Java 9+)
     * Target Methods: Stream.iterate (3-parameter version), dropWhile, takeWhile
     * * Requirement:
     * 1. Generate numbers starting at 2, doubling each step (n -> n * 2), bounded by n < 2000.
     * 2. Drop initial values that are strictly less than 16 (dropWhile).
     * 3. Keep taking values while they are strictly less than 512 (takeWhile).
     * 4. Return as a List<Integer>.
     */
    public List<Integer> generateAndWindowSequence() {
//        return Stream.iterate(
//                2,                  // Seed
//                n -> n < 2000,      // HasNext Predicate
//                n -> n * 2          // Next step function
//            )
//            .dropWhile(n -> n < 16)
//            .takeWhile(n -> n < 512)
//            .toList();
        
    	return Stream.iterate(2,
    			n -> n<2000,
    			n -> n*2).dropWhile(n -> n<16).takeWhile(n -> n<512).toList();
    	
    }

    /**
     * PRACTICE 2.6: Null-Safe Custom Key Sorting
     * Target Methods: sorted with Comparator.nullsLast / nullsFirst
     * * Requirement:
     * Sort a list of strings containing nulls:
     * 1. Place null elements LAST.
     * 2. Sort non-null strings by length ASCENDING, then natural alphabetical ASCENDING.
     */
    public List<String> sortStringsWithNullsLast(List<String> strings) {
        if (strings == null) return List.of();

//        Comparator<String> nonNullComparator = Comparator
//            .comparingInt(String::length)
//            .thenComparing(Comparator.naturalOrder());
//
//        Comparator<String> nullsLastComparator = Comparator.nullsLast(nonNullComparator);
//
//        return strings.stream()
//            .sorted(nullsLastComparator)
//            .toList();
        
        return strings.stream().sorted((a,b) -> {
        	if(a == null && b == null) return 0;
        	else if(a == null) return 1;
        	else if(b == null) return -1;
        	
        	int len = Integer.compare(a.length(),b.length());
        	if(len != 0 ) return len;
        	return a.compareTo(b);
        }).toList();
        
    }

    // ==========================================
    // MAIN METHOD TO RUN LOCALLY IN ECLIPSE
    // ==========================================
    public static void main(String[] args) {
        Module1Set2Practice practice = new Module1Set2Practice();

//        System.out.println("==================================================");
//        System.out.println("--- TESTING PRACTICE 2.1: FLATTEN & CLEAN TAGS ---");
//        System.out.println("==================================================");
//        List<List<String>> csvRows = Arrays.asList(
//            Arrays.asList("java, spring ", null, "  "),
//            null,
//            Arrays.asList(" DOCKER , java ", "kubernetes", "SPRING")
//        );
//        List<String> res21 = practice.flattenAndCleanTags(csvRows);
//        System.out.println("Result 2.1: " + res21);

//        System.out.println("\n==================================================");
//        System.out.println("--- TESTING PRACTICE 2.2: COMPOUND COMPARATOR SORT ---");
//        System.out.println("==================================================");
//        List<String> words = Arrays.asList("apple", null, "Testing", "banana", "kiwi", "TEST_code", "elephant", "fig");
//        List<String> res22 = practice.sortAndWindowWords(words);
//        System.out.println("Result 2.2: " + res22);
//
//        System.out.println("\n==================================================");
//        System.out.println("--- TESTING PRACTICE 2.3: LAZY EVALUATION TRACE ---");
//        System.out.println("==================================================");
//        List<Integer> numbers = Arrays.asList(5, 5, 3, 3, 8, 1);
//        List<Integer> res23 = practice.tracePipelineExecution(numbers);
//        System.out.println("Result 2.3: " + res23);
//
//        System.out.println("\n==================================================");
//        System.out.println("--- TESTING PRACTICE 2.4: TAKE & DROP WHILE LOGS ---");
//        System.out.println("==================================================");
//        List<String> logs = Arrays.asList(
//            "START: System initialized",
//            "LOG: User login",
//            "ERROR: 500 Internal Error",
//            "ERROR: 404 Not Found",
//            "LOG: System shutting down",
//            "ERROR: Ignored Error"
//        );
//        List<String> res24 = practice.extractErrorBatch(logs);
//        System.out.println("Result 2.4 (Expected 2 errors): " + res24);
//
//        System.out.println("\n==================================================");
//        System.out.println("--- TESTING PRACTICE 2.5: GENERATE & WINDOW SEQUENCE ---");
//        System.out.println("==================================================");
//        List<Integer> res25 = practice.generateAndWindowSequence();
//        System.out.println("Result 2.5 (Expected: [16, 32, 64, 128, 256]): " + res25);
//
        System.out.println("\n==================================================");
        System.out.println("--- TESTING PRACTICE 2.6: NULLS LAST SORT ---");
        System.out.println("==================================================");
        List<String> listWithNulls = Arrays.asList("banana", null, "fig", "apple", null, "kiwi");
        List<String> res26 = practice.sortStringsWithNullsLast(listWithNulls);
        System.out.println("Result 2.6: " + res26);
    }
}