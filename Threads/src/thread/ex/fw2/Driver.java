package thread.ex.fw2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MyTask implements Runnable
{
	@Override
	public void run() {
		System.out.println("At the begining -> "+ Thread.currentThread().getName());
	}
}

public class Driver {
	
	public static void main(String [] args) {
//		ExecutorService threadExecutor = Executors.newSingleThreadExecutor();
		
//		ExecutorService threadExecutor = Executors.newCachedThreadPool();
		
//		ExecutorService threadExecutor = Executors.newFixedThreadPool(10);
		
		ExecutorService threadExecutor = Executors.newScheduledThreadPool(10);
		
		MyTask obj = new MyTask();
		
		for(int i=1; i<=30; ++i) 
			threadExecutor.execute(obj);
	}
	
		
}
