package oops.abstraction;

/**
 * PaymentGatewayDemo.java
 * Minimal demonstration of Abstraction in a Payment Gateway.
 */

// 1. ABSTRACTION / CONTRACT: Defines WHAT every payment method must do, hiding HOW it's done.
abstract class PaymentMethod {
    public abstract void pay(double amount);
}

// 2. CONCRETE IMPLEMENTATIONS: Each class provides its specific details internally.
class CreditCardPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing $" + amount + " via Credit Card Gateway.");
    }
}

class UPIPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing $" + amount + " via UPI Network.");
    }
}

class NetBankingPayment extends PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Processing $" + amount + " via Net Banking Gateway.");
    }
}

// 3. HIGH-LEVEL MODULE (The Gateway)
// Relies ONLY on the abstract parent type ('PaymentMethod'), NEVER on specific payment classes.
class PaymentGateway {
    public void processTransaction(PaymentMethod paymentMethod, double amount) {
        // Abstraction in action: The gateway calls pay() without caring which provider is behind it!
        paymentMethod.pay(amount);
    }
}

// 4. MAIN EXECUTION CLASS
public class PaymentGatewayDemo {
    public static void main(String[] args) {
        PaymentGateway gateway = new PaymentGateway();

        // Pass any subtype polymorphically through the abstract interface:
        gateway.processTransaction(new CreditCardPayment(), 100.0);
        gateway.processTransaction(new UPIPayment(), 50.0);
        gateway.processTransaction(new NetBankingPayment(), 200.0);
    }
}