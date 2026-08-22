package oops.constructors;

/**
 * ConstructorDemo.java
 * Complete demonstration of Java Constructor Types and Chaining:
 * 1. Intra-class Chaining using `this(...)`
 * 2. Parent-Child Chaining using `super(...)`
 */

// 1. Parent / Superclass
class Vehicle {
    private String brand;
    private int year;

    // Parent No-Arg Constructor: Chains to Parent Parameterized Constructor using this(...)
    public Vehicle() {
        this("Generic Brand", 2024);
        System.out.println("  [Parent] Vehicle No-Arg Constructor completed");
    }

    // Parent Parameterized Constructor
    public Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
        System.out.println("  [Parent] Vehicle Parameterized Constructor executed (Brand: " + brand + ", Year: " + year + ")");
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public void displayVehicleInfo() {
        System.out.print("Brand: " + brand + " | Year: " + year);
    }
}

// 2. Child / Subclass extending Vehicle
class Car extends Vehicle {
    private String model;
    private double price;

    // TYPE 1: Child Default Constructor
    // Chains to Child 2-Parameter Constructor using this(...)
    public Car() {
        this("Base Model", 20000.0);
        System.out.println("  [Child] Car No-Arg Constructor completed");
    }

    // TYPE 2: Child Partially Parameterized Constructor
    // Chains to Child Full 4-Parameter Constructor using this(...)
    public Car(String model, double price) {
        this("Toyota", 2025, model, price);
        System.out.println("  [Child] Car 2-Parameter Constructor completed");
    }

    // TYPE 3: Child Full Parameterized Constructor
    // PARENT-CHILD CHAINING: Calls parent constructor using super(brand, year)
    public Car(String brand, int year, String model, double price) {
        super(brand, year); // Must be the FIRST statement in child constructor!
        this.model = model;
        this.price = price;
        System.out.println("  [Child] Car 4-Parameter Constructor executed (Model: " + model + ", Price: $" + price + ")");
    }

    // TYPE 4: Copy Constructor
    // Chains to Child Full Constructor using this(...)
    public Car(Car otherCar) {
        this(otherCar.getBrand(), otherCar.getYear(), otherCar.model, otherCar.price);
        System.out.println("  [Child] Car Copy Constructor completed (Cloned " + otherCar.model + ")");
    }

    public void displayDetails() {
        System.out.print("   ");
        displayVehicleInfo(); // Calling parent method
        System.out.println(" | Model: " + model + " | Price: $" + price);
    }
}

// 3. Main Execution Class
public class ConstructorDemo {
    public static void main(String[] args) {

        System.out.println("=== 1. Creating Car using No-Arg Constructor ===");
        System.out.println("--- Execution Chain Begins ---");
        Car car1 = new Car();
        System.out.println("--- Resulting Object State ---");
        car1.displayDetails();

        System.out.println("\n=== 2. Creating Car using Direct Parent-Child Chaining (super) ===");
        System.out.println("--- Execution Chain Begins ---");
        Car car2 = new Car("Tesla", 2026, "Model Y", 52000.0);
        System.out.println("--- Resulting Object State ---");
        car2.displayDetails();

        System.out.println("\n=== 3. Creating Car using Copy Constructor ===");
        System.out.println("--- Execution Chain Begins ---");
        Car car3 = new Car(car2);
        System.out.println("--- Resulting Object State ---");
        car3.displayDetails();
    }
}