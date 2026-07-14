package threadProgram8;

class MyThread extends Thread{
	@Override 
	public void run() {
		System.out.println("Starting line "+ Thread.currentThread().getName());
//		Thread.yield();
		System.out.println("Ending Line "+ Thread.currentThread().getName());
		
		
	}
}

public class Driver {
	
	public static void main(String [] args) {
		MyThread t1 = new MyThread();
		t1.start();
		MyThread t2 = new MyThread();
		
		
		t2.start();
		
		
		
	}
}
