package threadsPrograms6;

import threadPrograms7.MyThread;

class SyncTest{
//	public  void  print() {
//		System.out.println("printing non critical 50 lines --> "+ Thread.currentThread().getName());
//		
//		synchronized (this) {
//			for(int i=0; i<10; ++i) 
//				System.out.println(i+" --> "+ Thread.currentThread().getName());
//		}
//		
//		System.out.println("printing non critical 50 lines --> "+ Thread.currentThread().getName());
//	}
	
	public  static void  print() {
		System.out.println("printing non critical 50 lines --> "+ Thread.currentThread().getName());
		
		synchronized (SyncTest.class) {
			for(int i=0; i<10; ++i) 
				System.out.println(i+" --> "+ Thread.currentThread().getName());
		}
		
		System.out.println("printing non critical 50 lines --> "+ Thread.currentThread().getName());
	}
}

class MyThread implements Runnable{
	
	SyncTest obj;
	public MyThread(SyncTest obj) {
		// TODO Auto-generated constructor stub
		this.obj = obj;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		obj.print();
	}
}

public class Driver {
	
	public static void main(String[] args) {
		SyncTest obj = new SyncTest();
		SyncTest obj2 = new SyncTest();
		Thread t1 = new Thread(new MyThread(obj));
		Thread t2 = new Thread(new MyThread(obj));
		
//		t1.start();
		t1.start();
		t2.start();
	}
	
	
}
