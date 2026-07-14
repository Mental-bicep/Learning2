package threadsPrograms;

class MyThread implements Runnable{
	
	@Override
	public void run() { // Thread enters in running state
		// TODO Auto-generated method stub
		System.out.println("My thread using runnable interface");
		System.out.println("runn......");
		System.out.println("runn......");
		System.out.println("runn......");
		//Thread goes to wait/sleep state
		
		// When thread comes out of sleep/wait state then again it is runnable state
		// Thread in runnable State
		System.out.println("runn......"); // Cpu allocated -> Thread enters running state
		System.out.println("runn......");
		
		// Run method completed, Thread is terminated/died.
	}
}

public class Driver {

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1 = new Thread(new MyThread()); // Thread created - New Born
		t1.start(); // Thread moved to runnable state it can run 
	}				// but waiting for CPU allocation to run

}
