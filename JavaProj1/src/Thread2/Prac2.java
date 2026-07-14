package Thread2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ScheduledExecutorService;

class MyRunnable implements Runnable {
	
	@Override
	public void run() {
		System.out.println("Inside at the Runnable begining "+ Thread.currentThread().getName());
	}
}


class MyCallable implements Callable<Boolean>{
	@Override
	public Boolean call() {
		System.out.println("Inside the callable running "+ Thread.currentThread().getName());
		return true;
	}
}


public class Prac2{

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		// TODO Auto-generated method stb
		MyRunnable runnableTask = new MyRunnable();
		
//		ExecutorService es = Executors.newFixedThreadPool(5);
//		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es = Executors.newSingleThreadExecutor();
//		ScheduledExecutorService es = Executors.newScheduledThreadPool(3);
//		
//		for(int i=1;i<=10; ++i) 
//			 es.submit(runnableTask);
		
		
		MyCallable callableTask = new MyCallable();
		
//		ExecutorService es = Executors.newFixedThreadPool(5);
//		ExecutorService es = Executors.newCachedThreadPool();
//		ExecutorService es = Executors.newSingleThreadExecutor();
		ScheduledExecutorService es = Executors.newScheduledThreadPool(5);
		
		for(int i=1; i<=10; ++i) {
			Future<Boolean> fut = es.submit(callableTask);
			System.out.println("fut return value is "+ fut.get());
		}
			
	}

}
