package Thread1;

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("Hello from thread subclass, my name is: "+ Thread.currentThread().getName());
	}
}

class MyRunnable implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("Hello From Runnable implementation, my name is "
				+ Thread.currentThread().getName());
		
	}
}

public class Thread1 {
	
	
	
	 public static void main(String [] args) {
		 MyThread Alpha_Thread = new MyThread();
			Thread Beta_Thread = new Thread(new MyRunnable());
			
			Alpha_Thread.setName("Alpha-Thread");
			Beta_Thread.setName("Beta-Thread");
			
			Alpha_Thread.start();
			Beta_Thread.start();
	 }
	
}
