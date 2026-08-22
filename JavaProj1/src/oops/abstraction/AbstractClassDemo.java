package oops.abstraction;

/**
 * AbstractClassDemo.java
 * Complete demonstration of Abstract Classes and Abstract Methods in Java.
 * * Note: If you compile all practice files in the same folder/package, 
 * ensure previous files (like InheritanceDemo.java) are in a different package,
 * or rename these classes to avoid duplicate class compilation errors.
 */

// 1. Abstract Parent Class
abstract class Account {
    protected double balance; // Protected variable accessible by child classes

    // Constructor of an Abstract Class
    public Account(double balance) {
        this.balance = balance;
        System.out.println("-> [Account Abstract Constructor] Initialized balance: $" + balance);
    }

    // Concrete Method: Shared implementation inherited by all child classes
    public void showBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    // Abstract Method: No body here; MUST be overridden by concrete child classes
    public abstract double calculateInterest();
}

// 2. Concrete Child Class 1: SavingsAccount
class SavingsAccount extends Account {
    private double interestRate; // Interest rate percentage (e.g., 5.0 for 5%)

    // Constructor: Calls parent abstract class constructor using super(balance)
    public SavingsAccount(double balance, double interestRate) {
        super(balance);
        this.interestRate = interestRate;
        System.out.println("-> [SavingsAccount Constructor] Interest Rate set to: " + interestRate + "%");
    }

    // Overriding the abstract method with actual interest calculation
    @Override
    public double calculateInterest() {
        double interest = (balance * interestRate) / 100.0;
        System.out.println("Savings Account Interest Earned (" + interestRate + "%): $" + interest);
        return interest;
    }
}

// 3. Concrete Child Class 2: CurrentAccount
class CurrentAccount extends Account {

    // Constructor: Calls parent abstract class constructor using super(balance)
    public CurrentAccount(double balance) {
        super(balance);
        System.out.println("-> [CurrentAccount Constructor] Current account created.");
    }

    // Overriding the abstract method to state that Current Account earns no interest
    @Override
    public double calculateInterest() {
        System.out.println("Current Account Interest: $0.0 (No interest applicable for Current Accounts)");
        return 0.0;
    }
}

// 4. Main Execution Class
public class AbstractClassDemo {
    public static void main(String[] args) {
        System.out.println("=== 1. Testing SavingsAccount (Abstract Class Implementation) ===");
        // Polymorphic reference: Parent Abstract type holding Child object
        Account savings = new SavingsAccount(10000.0, 5.0);
        savings.showBalance();
        savings.calculateInterest();

        System.out.println("\n=== 2. Testing CurrentAccount (Abstract Class Implementation) ===");
        Account current = new CurrentAccount(25000.0);
        current.showBalance();
        current.calculateInterest();

        System.out.println("\n=== 3. Abstract Class Rules Check ===");
        System.out.println("Attempting 'new Account(5000.0)' is prohibited by Java compiler.");
        // UNCOMMENTING THE LINE BELOW WILL CAUSE A COMPILE ERROR:
        // Account acc = new Account(5000.0); // Error: Account is abstract; cannot be instantiated
    }
}