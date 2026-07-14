package producerConsumer1;

public class SharedResource {
	boolean isDataAvailable = false;
	int num;
	
	public synchronized void produce(int n) throws InterruptedException {
		if(isDataAvailable) wait();
		System.out.println("producing num = "+n);
		num = n;
		isDataAvailable = true;
		notify();
	}
	
	public synchronized void consume() throws InterruptedException {
		if(isDataAvailable == false) wait();
		System.out.println("consuming data = "+num);
		isDataAvailable = false;
		notify();
	}
}

class Producer implements Runnable{
	SharedResource sharedResource;
	
	public Producer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}
	
	public void run() {
		for(int i=1; i<=10; ++i)
			try {
				sharedResource.produce(i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}

class Consumer implements Runnable{
	SharedResource sharedResource;
	
	public Consumer(SharedResource sharedResource) {
		this.sharedResource = sharedResource;
	}
	
	@Override
	public void run() {
		for(int i=1;i<=10;++i)
			try {
				sharedResource.consume();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
