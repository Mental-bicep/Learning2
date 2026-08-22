package oops.encapsulation;

/**
 * ATM Encapsulation Demo
 * Demonstrates Data Hiding (private variables) and Controlled Access (PIN verification).
 */

// 1. Encapsulated ATM Class
class ATM {
    // PRIVATE fields: Direct access from outside this class is blocked (Data Hiding)
    private double balance;
    private String pin;

    // Constructor: Initializes the balance and PIN safely
    public ATM(double initialBalance, String initialPin) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Warning: Initial balance cannot be negative. Defaulting to $0.0");
            this.balance = 0.0;
        }
        this.pin = initialPin;
    }

    // Private helper method: Internal verification logic (not exposed publicly)
    private boolean verifyPin(String enteredPin) {
        return this.pin != null && this.pin.equals(enteredPin);
    }

    // Public method to check balance (requires correct PIN)
    public double getBalance(String enteredPin) {
        if (verifyPin(enteredPin)) {
            return this.balance;
        } else {
            System.out.println("Access Denied: Incorrect PIN!");
            return -1.0; // Return invalid marker if PIN check fails
        }
    }

    // DEPOSIT METHOD: Validates entered PIN and deposit amount
    public void deposit(double amount, String enteredPin) {
        // Step 1: Verify PIN security
        if (!verifyPin(enteredPin)) {
            System.out.println("Deposit Failed: Incorrect PIN!");
            return;
        }

        // Step 2: Validate business rules (amount must be positive)
        if (amount > 0) {
            this.balance += amount;
            System.out.println("Successfully deposited $" + amount + " | New Balance: $" + this.balance);
        } else {
            System.out.println("Deposit Failed: Amount must be greater than $0.0");
        }
    }

    // WITHDRAW METHOD: Validates entered PIN, withdrawal amount, and sufficient balance
    public void withdraw(double amount, String enteredPin) {
        // Step 1: Verify PIN security
        if (!verifyPin(enteredPin)) {
            System.out.println("Withdrawal Failed: Incorrect PIN!");
            return;
        }

        // Step 2: Validate business rules (positive amount and sufficient funds)
        if (amount <= 0) {
            System.out.println("Withdrawal Failed: Amount must be greater than $0.0");
        } else if (amount > this.balance) {
            System.out.println("Withdrawal Failed: Insufficient funds! Current Balance: $" + this.balance + ", Attempted: $" + amount);
        } else {
            this.balance -= amount;
            System.out.println("Successfully withdrew $" + amount + " | Remaining Balance: $" + this.balance);
        }
    }
}

// 2. Main Class to run and test the program
public class ATMDemo {
    public static void main(String[] args) {
        System.out.println("=== Initializing ATM with $1500.00 and PIN '1234' ===");
        ATM myAtm = new ATM(1500.00, "1234");

        // Attempting direct access to private fields will cause a compilation error:
        // myAtm.balance = 100000.00; // Error: balance has private access in ATM
        // myAtm.pin = "0000";        // Error: pin has private access in ATM

        System.out.println("\n=== 1. Security Check: Invalid PIN Operations ===");
        myAtm.deposit(200.00, "9999");   // Incorrect PIN
        myAtm.withdraw(100.00, "0000");  // Incorrect PIN

        System.out.println("\n=== 2. Valid Operations (Correct PIN: '1234') ===");
        myAtm.deposit(500.00, "1234");   // Valid deposit
        myAtm.withdraw(300.00, "1234");  // Valid withdrawal

        System.out.println("\n=== 3. Business Rule Checks (Insufficient Funds & Invalid Amount) ===");
        myAtm.withdraw(5000.00, "1234"); // Overdraw attempt
        myAtm.deposit(-50.00, "1234");   // Negative deposit attempt

        System.out.println("\n=== 4. Checking Final Balance ===");
        double currentBalance = myAtm.getBalance("1234");
        if (currentBalance != -1.0) {
            System.out.println("Final Account Balance: $" + currentBalance);
        }
    }
}