package oops.inheritance;

/**
 * MultilevelInheritanceDemo.java
 * Demonstrates Multilevel Inheritance in Java:
 * BaseAccount (Level 1) -> StandardSavingsAccount (Level 2) -> PremiumSavingsAccount (Level 3)
 */

// 1. Top-Level Parent Class (Renamed to avoid duplicate class collision in the same package)
class BaseAccount {
    public void accountInfo() {
        System.out.println("-> [BaseAccount] Standard banking features activated.");
    }
}

// 2. Intermediate Child Class (Inherits from BaseAccount)
class StandardSavingsAccount extends BaseAccount {
    public void savingsInfo() {
        System.out.println("-> [StandardSavingsAccount] Interest calculation features activated.");
    }
}

// 3. Bottom-Level Child Class (Inherits from StandardSavingsAccount)
class PremiumSavingsAccount extends StandardSavingsAccount {
    public void premiumInfo() {
        System.out.println("-> [PremiumSavingsAccount] Zero-fee transfers and VIP support activated.");
    }
}

// 4. Main Execution Class
public class MultilevelInheritanceDemo {
    public static void main(String[] args) {
        System.out.println("=== Instantiating PremiumSavingsAccount ===");
        PremiumSavingsAccount myPremiumAcc = new PremiumSavingsAccount();

        System.out.println("\n=== Testing Inherited Capabilities ===");
        
        // 1. Method inherited from Level 1 grandparent (BaseAccount)
        myPremiumAcc.accountInfo();

        // 2. Method inherited from Level 2 parent (StandardSavingsAccount)
        myPremiumAcc.savingsInfo();

        // 3. Method defined in Level 3 child class (PremiumSavingsAccount)
        myPremiumAcc.premiumInfo();
    }
}