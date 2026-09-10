package solidprinciples;

//1. Interface for extension
interface PaymentMethod {
 void pay();
}

//2. Specialized classes
class PayPal implements PaymentMethod {
 public void pay() { System.out.println("PayPal"); }
}

class GPay implements PaymentMethod {
 public void pay() { System.out.println("GPay"); }
}

//3. Main class is now CLOSED to change
class Payment {
 private PaymentMethod method;
 public Payment(PaymentMethod method) {
     this.method = method;
 }
 public void process() { method.pay(); }
}

public class OpenClosedPrinciple {

}
