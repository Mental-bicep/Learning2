package threadProgram2;

class MyThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<10; ++i) {
			System.out.println(i);
			
			if(i==5) {
				System.out.println("sending "+ Thread.currentThread().getName()+ " to sleep for 5s");
				try {
					Thread.currentThread().sleep(5000);
				} catch (InterruptedException e) {
					// TODO: handle exception
					e.printStackTrace();
				
				}
				System.out.println("Sleep time over executing again");
			}
			
			
		}
	}

}

public class Driver {
	
	public static void main(String [] args) {
		System.out.println("inside the second driver class");
		Thread t1 = new Thread(new MyThread());
		t1.start();
		
	}
}
