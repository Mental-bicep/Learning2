package threadProgram5;



class Cooking implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("food is being prepared --> "+ Thread.currentThread().getName());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Food Preparation done --> "+ Thread.currentThread().getName());
	}
}

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread.currentThread().setName("waiter thread - main method thread");
		System.out.println("Waiter took the order --> " + Thread.currentThread().getName());
		
		Cooking t1 = new Cooking();
		Thread t2 = new Thread(t1);
		t2.setName("cook Thread --> Function thread");
		t2.start();
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("waiter started serving the food "+ Thread.currentThread().getName());

	}

}
