import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

class MyThread extends Thread{
	
	@Override
	public void run() {
		System.out.println("inside th run function extending thread");
	}
	
}

class MyRunnable implements Runnable{
	@Override 
	public void run() {
		System.out.println("sinde the run of runnabe");
	}
}

public class HelloWorld {
	
	public static void main(String[] args) {
		
		Thread t1 = new Thread(new MyRunnable());
		MyThread t2 = new MyThread();
		
		t1.start();
		t2.start();
		
		Runnable r1 = () -> {System.out.println("sinde the lambda runnable");};
		
		Thread t3 = new Thread(r1);
		t3.start();
}
}
