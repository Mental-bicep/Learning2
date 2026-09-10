package solidprinciples;

//1. Segregated Interfaces
interface ChefDuties { void cook(); }
interface WaiterDuties { void serve(); }

//2. Focused Implementations
class Chef implements ChefDuties {
 public void cook() { System.out.println("Cooking food..."); }
}

class Waiter implements WaiterDuties {
 public void serve() { System.out.println("Serving guests..."); }
}

public class InterfaceSegregationPrinciple {

}
