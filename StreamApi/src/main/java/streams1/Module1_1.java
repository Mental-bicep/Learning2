package streams1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.*;

import javax.swing.plaf.synth.SynthOptionPaneUI;

public class Module1_1 {

    /**
     * CHALLENGE 1.1: Even & Squared Numbers
     * Target Methods: filter, map, distinct, sorted
     */
    public List<Integer> getPositiveEvenSquares(List<Integer> numbers) {
        if (numbers == null) return List.of();

//        return numbers.stream()
//            // 1. Filter out null values safely
//            .filter(Objects::nonNull)
//            // 2. Keep strictly positive (>0) and even (% 2 == 0) numbers
//            .filter(n -> n > 0 && n % 2 == 0)
//            // 3. Square each number
//            .map(n -> n * n)
//            // 4. Remove duplicate squared values
//            .distinct()
//            // 5. Sort in natural ascending order
//            .sorted()
//            // 6. Return an unmodifiable List (Java 16+)
//            .toList();
        
//        return numbers.stream().filter(Objects::nonNull).distinct().filter(n-> n>0 && n%2==0).map(n-> n*n).sorted().toList();
        return numbers.stream().filter(n -> n!=null && n>0 && n%2==0).map(n -> n*n).sorted().toList();
    }

    /**
     * CHALLENGE 1.2: Word Pipeline Debugger & Window
     * Target Methods: filter, map, peek, skip, limit
     */
    public List<String> processAndWindowWords(List<String> words) {
        if (words == null) return List.of();

//        return words.stream()
//            // 1. Filter nulls and strings with length < 3
//            .filter(w -> w != null && w.length() >= 3)
//            // 2. Map to UPPERCASE
//            .map(String::toUpperCase)
//            // 3. Peek for side-effect logging / debugging
//            .peek(w -> System.out.println("Processing word: " + w))
//            // 4. Skip the first 1 matching word
//            .skip(1)
//            // 5. Limit to at most 3 words
//            .limit(3)
//            // 6. Collect to list
//            .toList();
        
        return words.stream().filter(w -> w!=null && w.length()>=3).map(w -> w.toUpperCase()).
        		peek(w -> System.out.println("processing word "+w)).skip(1).limit(3).toList();
        
        
    }

    /**
     * CHALLENGE 1.3: Unique Sorted Character Extractor
     * Target Methods: Stream.ofNullable, flatMap, distinct, sorted
     */
    public List<Character> extractUniqueCharacters(List<String> sentences) {
        if (sentences == null) return List.of();

//        return sentences.stream()
//            // 1. Safely handle null elements inside the sentences list (Java 9+)
//            .flatMap(Stream::ofNullable)
//            // 2. Convert each sentence into a stream of Character objects
//            .flatMap(sentence -> sentence.chars().mapToObj(c -> (char) c))
//            // 3. Exclude space characters
//            .filter(ch -> ch != ' ')
//            // 4. Distinct unique characters
//            .distinct()
//            // 5. Sort in natural ASCII/Unicode order
//            .sorted()
//            // 6. Collect to list
//            .toList();
        
//        sentences.stream().filter(w -> w!=null).flatMapToInt(sen -> sen.chars()).peek(ch -> System.out.println(ch +" "+ (char)ch)). 
//        	mapToObj(ch -> (char)ch).toList();
        
        return sentences.stream().filter(w -> w!=null).flatMap(sen -> sen.chars().mapToObj(c -> (char)c)).
        	filter(c -> c!=' ').distinct().sorted().toList();
        
    }

    // ==========================================
    // MAIN METHOD TO RUN LOCALLY IN ECLIPSE
    // ==========================================
    public static void main(String[] args) {
    	Module1_1 practice = new Module1_1();

//        System.out.println("==================================================");
//        System.out.println("--- TESTING CHALLENGE 1.1: POSITIVE EVEN SQUARES ---");
//        System.out.println("==================================================");
//        List<Integer> numbersWithNull = java.util.Arrays.asList(4, null, -2, 4, 3, 6, null, 8, 2);
//        List<Integer> res1 = practice.getPositiveEvenSquares(numbersWithNull);
//        System.out.println("Input: [4, null, -2, 4, 3, 6, null, 8, 2]");
//        System.out.println("Result (Expected: [16, 36, 64]): " + res1);
        
        // arr = Arrays.asList(1,2,3,4,5) 
        //ArrayList<Integer> arr = new ArrayList<Integer>(List.of(1,2,3));
        
//        System.out.println("\n==================================================");
//        System.out.println("--- TESTING CHALLENGE 1.2: WORD PIPELINE WINDOW ---");
//        System.out.println("==================================================");
//        List<String> words = java.util.Arrays.asList("hi", "java", null, "stream", "api", "code", "developer");
//        List<String> res2 = practice.processAndWindowWords(words);
//        System.out.println("Result (Expected: [STREAM, API, CODE]): " + res2);


        System.out.println("\n==================================================");
        System.out.println("--- TESTING CHALLENGE 1.3: CHARACTER EXTRACTION ---");
        System.out.println("==================================================");
        List<String> sentences = java.util.Arrays.asList("hello world", null, "java");
        List<Character> res3 = practice.extractUniqueCharacters(sentences);
        System.out.println("Result: " + res3);
    }
}
//
//public class Module1_1 {
//
//}
