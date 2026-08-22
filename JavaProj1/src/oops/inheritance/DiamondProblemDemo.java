package oops.inheritance;

/**
 * DiamondProblemDemo.java
 * Demonstrates the Diamond Problem in Object-Oriented Programming:
 * 1. Conceptual explanation of why Java disallows multiple class inheritance (`extends ClassA, ClassB`).
 * 2. How Java 8+ solves default method collisions using Interfaces and `Interface.super.method()`.
 */

// ============================================================================
// PART 1: WHY MULTIPLE CLASS INHERITANCE IS FORBIDDEN IN JAVA
// ============================================================================

class AccountDiamond {
    public void showBalance() {
        System.out.println("Base Account Balance: $0.0");
    }
}

class SavingsAccountDiamond extends AccountDiamond {
    @Override
    public void showBalance() {
        System.out.println("Savings Account Balance: $5,000 (Includes 5% Interest)");
    }
}

class CurrentAccountDiamond extends AccountDiamond {
    @Override
    public void showBalance() {
        System.out.println("Current Account Balance: $10,000 (Includes Overdraft Facility)");
    }
}

/*
 * THE DIAMOND PROBLEM VISUALIZATION:
 *
 * AccountDiamond
 * /            \
 * SavingsAccountDiamond   CurrentAccountDiamond
 * \            /
 * PremiumAccountDiamond  <-- AMBIGUITY!
 *
 * UNCOMMENTING THE CLASS BELOW WILL CAUSE A COMPILE ERROR IN JAVA:
 *
 * class PremiumAccountDiamond extends SavingsAccountDiamond, CurrentAccountDiamond {
 * // COMPILE ERROR: Java does not allow extending multiple classes!
 * // WHY? If someone calls `premiumAcc.showBalance()`, the JVM cannot determine
 * // whether to call SavingsAccountDiamond's showBalance() or CurrentAccountDiamond's showBalance().
 * }
 */


// ============================================================================
// PART 2: HOW JAVA SOLVES AMBIGUITY USING INTERFACES (JAVA 8+ DEFAULT METHODS)
// ============================================================================

interface BaseAccountInterface {
    default void showBalance() {
        System.out.println("Base Interface Balance");
    }
}

interface SavingsInterface extends BaseAccountInterface {
    @Override
    default void showBalance() {
        System.out.println("Savings Interface Balance: $5,000");
    }
}

interface CurrentInterface extends BaseAccountInterface {
    @Override
    default void showBalance() {
        System.out.println("Current Interface Balance: $10,000");
    }
}

// When implementing two interfaces with conflicting default methods,
// Java FORCES the child class to explicitly override and resolve the method.
class PremiumAccountResolved implements SavingsInterface, CurrentInterface {

    @Override
    public void showBalance() {
        System.out.println("--- Resolving Diamond Collision Explicitly in Subclass ---");
        
        // Explicitly calling SavingsInterface's version using Interface.super syntax
        System.out.print("[Savings Branch]: ");
        SavingsInterface.super.showBalance();

        // Explicitly calling CurrentInterface's version
        System.out.print("[Current Branch]: ");
        CurrentInterface.super.showBalance();

        // Providing custom logic for the combined account
        System.out.println("Combined Premium Account Total Balance: $15,000");
    }
}


// ============================================================================
// PART 3: MAIN EXECUTION CLASS
// ============================================================================

public class DiamondProblemDemo {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("1. THE DIAMOND PROBLEM IN CLASSES (COMPILE TIME)");
        System.out.println("=================================================");
        System.out.println("In Java, 'class Premium extends Savings, Current' is illegal.");
        System.out.println("This design choice protects developers from method ambiguity.\n");

        System.out.println("=================================================");
        System.out.println("2. RESOLVING MULTIPLE INTERFACE COLLISIONS");
        System.out.println("=================================================");
        PremiumAccountResolved premiumAcc = new PremiumAccountResolved();
        premiumAcc.showBalance();
    }
}