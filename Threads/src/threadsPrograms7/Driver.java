package threadsPrograms7;

import java.util.concurrent.locks.ReentrantLock;

//import threadPrograms7.Account;
//import threadPrograms7.MyThread;



class Account {
	private int balance = 1000;
	
	public void withdraw(int amount) {
		System.out.println("some other logic 50 lines "+ Thread.currentThread().getName());
		
		synchronized (this) {
			if(balance >= amount) {
				System.out.println(Thread.currentThread().getName()+" --> is withdrawing");
				
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				
				balance-=amount;
				System.out.println(Thread.currentThread().getName() + " successfully withdrawed the amount");
			}
			else System.out.println("insufficient balance "+ Thread.currentThread().getName());
		}
		System.out.println("some other logic 50 lines in the end. EXITING -> "+ Thread.currentThread().getName());
	}
	
	public int getBalance() {return balance;}
	
	
	
	
	
}

class MyThread implements Runnable{
	
	Account obj;
	
	public MyThread(Account obj) {
		
		this.obj = obj;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		obj.withdraw(800);
		
	}
}

public class Driver {
	public static void main(String[] args) throws InterruptedException {
		Account acc = new Account();
		Thread t1 = new Thread(new MyThread(acc));
		Thread t2 = new Thread(new MyThread(acc));;
		t1.setName("PhonePay");
		t2.setName("Gpay");
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Final Balance is " + acc.getBalance());
		
	}
	
}

