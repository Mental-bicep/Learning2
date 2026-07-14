package threadPrograms3;

class MyThread extends Thread{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		System.out.println("inside run function by thread "+ Thread.currentThread().getName());
	}
}

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyThread t1 = new MyThread();
		t1.run();
	}

}
