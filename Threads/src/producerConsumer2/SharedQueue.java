package producerConsumer2;

public class SharedQueue { // Assume Queue Size = 1
	int num;
	boolean isAvailable = false;
	
	synchronized public void produce(int n) throws InterruptedException {
		if(isAvailable == true) wait(); // ie. Already available so it cannot produce
		System.out.println("Producer produced "+ n);
		isAvailable = true;
		notify();
		num = n;
	}
	
	synchronized public void consume() throws InterruptedException {
		if(isAvailable == false) wait(); // ie. Not available so cannot be consumed
		System.out.println("Consumer consumed "+num );
		isAvailable = false;
		notify();
	}
}

class Producer extends Thread{
	SharedQueue q;
	public Producer(SharedQueue q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		for(int i=1; i<=10; ++i)
			try {
				q.produce(i);
			}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}


class Consumer extends Thread{
	SharedQueue q;
	
	public Consumer(SharedQueue q) {
		this.q = q;
	}
	
	@Override
	public void run() {
		for(int i=1; i<=10; ++i)
			try {
				q.consume();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		
	}
}
