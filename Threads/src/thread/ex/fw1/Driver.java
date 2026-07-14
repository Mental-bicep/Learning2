package thread.ex.fw1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class EmailSender implements Callable<String> {
	@Override
	public String call() {
		System.out.println("Inside with thread = "+ Thread.currentThread().getName());
		return "Task done";
	}
}

public class Driver {
	public static void main(String [] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(4);
		EmailSender task = new EmailSender();
		
		for(int i=1; i<=10; ++i) {
			Future<String> resp = es.submit(task);
			System.out.println("Reponse from call method is "+ resp.get());
		}
		
		
	}
}
