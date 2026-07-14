package Thread1;

class BankAccount{
	private int balance = 1000;
	
	public void deposit(int amount) {
		synchronized(this) {
			this.balance += amount;
		}
	}
	
	public int getBalance() {return balance;}
}



public class Thread2 {
	
	static class MyRunnable implements Runnable{
		
		BankAccount acc;
		
		public MyRunnable(BankAccount acc) {
			this.acc = acc;
		}
		
		@Override
		public void run() {
			acc.deposit(100);
		}
	}
	
	public static void main(String [] args) throws InterruptedException {
		BankAccount acc = new BankAccount();
		Thread t1 = new Thread(new MyRunnable(acc));
		Thread t2 = new Thread(new MyRunnable(acc));
		Thread t3 = new Thread(new MyRunnable(acc));
		
		t1.start();
		t2.start();
		t3.start();
		
		
		t1.join();
		t2.join();
		t3.join();
		
		System.out.println("final balance = "+ acc.getBalance()) ;
		
	}
}
