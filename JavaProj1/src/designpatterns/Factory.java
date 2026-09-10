package designpatterns;

abstract class Troop {
    abstract void attack();
}

// 2. Concrete Implementations
class Barbarian extends Troop {
    void attack() { System.out.println("Barbarian attacks with a sword!"); }
}

class Archer extends Troop {
    void attack() { System.out.println("Archer shoots an arrow!"); }
}

class Wizard extends Troop {
    void attack() { System.out.println("Wizard throws a fireball!"); }
}

class TroopFactory {
    static Troop createTroop(String type) {
        if (type.equalsIgnoreCase("barbarian")) return new Barbarian();
        else if (type.equalsIgnoreCase("archer")) return new Archer();
        else if (type.equalsIgnoreCase("wizard")) return new Wizard();
        return null;
    }
}

public class Factory {
	
	public static void main(String [] args) {
		Troop t1 = TroopFactory.createTroop("barbarian");
		Troop t2 = TroopFactory.createTroop("archer");
		
		t1.attack();
		t2.attack();
		
	}

}
