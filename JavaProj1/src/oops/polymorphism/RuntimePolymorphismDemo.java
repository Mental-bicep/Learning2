package oops.polymorphism;

/**
 * RuntimePolymorphismDemo.java
 * Minimal demonstration of Runtime Polymorphism (Dynamic Method Dispatch) in Java.
 */

// 1. BASE CLASS
class Payment {
    public void processPayment(double amount) {
        System.out.println("Processing generic payment of $" + amount);
    }
}

// 2. SUBCLASS 1: Overrides processPayment()
class UpiPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via UPI Payment.");
    }
}

// 3. SUBCLASS 2: Overrides processPayment()
class CcPayment extends Payment {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card Payment.");
    }
}

// 4. MAIN CLASS DEMONSTRATING RUNTIME POLYMORPHISM
public class RuntimePolymorphismDemo {
    public static void main(String[] args) {
        // Step 1: Declare a base class reference variable
        Payment payment;

        // Step 2: Assign a UpiPayment object to the base reference
        payment = new UpiPayment();
        // At runtime, JVM resolves and executes UpiPayment's overridden method
        payment.processPayment(100.00);

        // Step 3: Reassign a CcPayment object to the same base reference
        payment = new CcPayment();
        // At runtime, JVM resolves and executes CcPayment's overridden method
        payment.processPayment(250.50);
    }
}