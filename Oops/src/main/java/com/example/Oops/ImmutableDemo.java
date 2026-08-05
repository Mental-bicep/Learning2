package com.example.Oops;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 1. The class is declared as 'final' so it cannot be subclassed.
 */
final class Developer {
    
    // 2. All fields are private and final
    private final String name;
    private final List<String> skills;

    /**
     * 3. Fields are initialized via the constructor.
     */
    public Developer(String name, List<String> skills) {
        this.name = name;
        
        // DEFENSIVE COPY IN CONSTRUCTOR:
        // We do NOT do: this.skills = skills;
        // Instead, we create a brand new list in memory. This ensures that if the 
        // original list is modified outside this class, our internal list remains safe.
        this.skills = new ArrayList<>(skills);
    }

    // 4. No setter methods are provided anywhere in this class.

    public String getName() {
        return name;
    }

    public List<String> getSkills() {
        // DEFENSIVE COPY IN GETTER:
        // We do NOT return the original list. If we did, someone could call 
        // dev.getSkills().add("Hacked!") and change our internal state.
        // Returning an unmodifiable list throws an error if anyone tries to change it.
        return Collections.unmodifiableList(skills);
    }

    @Override
    public String toString() {
        return "Developer{name='" + name + "', skills=" + skills + "}";
    }
}

public class ImmutableDemo {
    public static void main(String[] args) {
        System.out.println("--- Testing Java Immutability & Defensive Copying ---\n");

        // Step 1: Create an external mutable list
        List<String> originalSkills = new ArrayList<>();
        originalSkills.add("Java");
        originalSkills.add("Spring Boot");

        // Step 2: Create our immutable object
        Developer dev = new Developer("Alice", originalSkills);
        System.out.println("Initial Developer State: " + dev);

        // --- ATTEMPT 1: Trying to hack it from the outside ---
        System.out.println("\nAttempt 1: Modifying the original list passed to the constructor...");
        originalSkills.add("Python (Hacked!)");
        System.out.println("Original Skills List is now: " + originalSkills);
        
        // Because of the defensive copy in the constructor, the Developer object is safe!
        System.out.println("Developer State after Attempt 1: " + dev); 

        // --- ATTEMPT 2: Trying to hack it via the getter ---
        System.out.println("\nAttempt 2: Modifying the list returned by the getter...");
        try {
            List<String> retrievedSkills = dev.getSkills();
            retrievedSkills.add("C++ (Hacked!)");
        } catch (UnsupportedOperationException e) {
            System.out.println("Caught Exception: Cannot modify the list returned by getSkills()!");
        }

        System.out.println("\nFinal Developer State: " + dev);
        System.out.println("Success! The Developer object is completely immutable.");
    }
}