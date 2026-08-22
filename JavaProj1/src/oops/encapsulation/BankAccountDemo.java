package oops.encapsulation;

/**
 * BankAccount Demo - Practical Demonstration of Java Encapsulation
 */

// 1. Encapsulated Class
class BankAccount {
    // PRIVATE field: Cannot be accessed or modified directly from outside this class (Data Hiding)
    private double balance;

    // Constructor: Initializes the account balance safely
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Warning: Initial balance cannot be negative. Setting balance to $0.0");
            this.balance = 0.0;
        }
    }

    // GETTER: Public read-only access to the private balance field
    public double getBalance() {
        return this.balance;
    }

    // MUTATOR METHOD: Controlled deposit with validation logic
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited: $" + amount + " | New Balance: $" + this.balance);
        } else {
            System.out.println("Deposit Failed: Amount must be greater than $0.0");
        }
    }

    // MUTATOR METHOD: Controlled withdrawal with business rules (prevent overdrawing)
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal Failed: Amount must be greater than $0.0");
        } else if (amount > this.balance) {
            System.out.println("Withdrawal Failed: Insufficient funds! Current Balance: $" + this.balance + ", Attempted: $" + amount);
        } else {
            this.balance -= amount;
            System.out.println("Successfully withdrew: $" + amount + " | Remaining Balance: $" + this.balance);
        }
    }
}

// 2. Main Execution Class
public class BankAccountDemo {
    public static void main(String[] args) {
        System.out.println("=== Creating Bank Account with Initial Balance of $1000.0 ===");
        BankAccount account = new BankAccount(1000.0);

        // --- DEMO 1: Reading state using public getter ---
        System.out.println("Current Account Balance: $" + account.getBalance());

        // UNCOMMENTING THE LINE BELOW WILL CAUSE A COMPILE ERROR:
        // account.balance = 50000.0; // Error: balance has private access in BankAccount

        System.out.println("\n=== 1. Valid Operations ===");
        account.deposit(500.0);    // Deposit valid amount
        account.withdraw(300.0);   // Withdraw valid amount

        System.out.println("\n=== 2. Encapsulation Rules in Action (Invalid Input Handling) ===");
        account.deposit(-200.0);   // Attempt negative deposit
        account.withdraw(5000.0);  // Attempt to overdraw beyond current balance

        System.out.println("\n=== Final Account State ===");
        System.out.println("Final Balance: $" + account.getBalance());
    }
}