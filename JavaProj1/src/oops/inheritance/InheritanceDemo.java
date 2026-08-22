package oops.inheritance;

/**
 * InheritanceDemo.java
 * Demonstrates the core concept of Inheritance in Java:
 * 1. Code Reusability using the 'extends' keyword.
 * 2. Reusing Parent attributes/methods in a Child class.
 * 3. Calling the Parent Constructor using super(...).
 */

// 1. Parent / Superclass
class Account {
    // Protected access modifier allows direct access to child classes while keeping encapsulation
    protected double balance;

    // Parent Constructor
    public Account(double balance) {
        this.balance = balance;
        System.out.println("-> [Parent] Account initialized with balance: $" + balance);
    }

    // Method to show balance
    public void showBalance() {
        System.out.println("Current Account Balance: $" + balance);
    }
}

// 2. Child / Subclass extending Account
class SavingsAccount extends Account {
    // Additional data member specific to SavingsAccount
    private double interestRate;

    // Child Constructor with two parameters: balance and interestRate
    public SavingsAccount(double balance, double interestRate) {
        // Step 1: Call parent class constructor FIRST using super(...)
        super(balance);
        
        // Step 2: Initialize child's own variable
        this.interestRate = interestRate;
        System.out.println("-> [Child] SavingsAccount initialized with interest rate: " + interestRate + "%");
    }

    // Method to calculate interest using formula: (balance * interestRate) / 100
    public double calculateInterest() {
        double interest = (balance * interestRate) / 100.0;
        return interest;
    }

    // Helper method to display complete savings details
    public void displayAccountSummary() {
        System.out.println("\n--- Savings Account Summary ---");
        showBalance(); // Inherited from Account parent class!
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Earned Interest: $" + calculateInterest());
    }
}

// 3. Main Execution Class
public class InheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating a Parent Account Object ===");
        Account generalAccount = new Account(1000.0);
        generalAccount.showBalance();

        System.out.println("\n=== Creating a Child SavingsAccount Object ===");
        // Creating SavingsAccount with initial balance $5000.0 and interest rate 5.5%
        SavingsAccount mySavings = new SavingsAccount(5000.0, 5.5);

        // Demonstrating inherited capabilities and child-specific methods
        mySavings.displayAccountSummary();
    }
}