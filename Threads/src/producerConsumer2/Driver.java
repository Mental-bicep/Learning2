package producerConsumer2;

public class Driver {
	public static void main(String [] args) {
		SharedQueue q = new SharedQueue();
		
		Producer p = new Producer(q);
		Consumer c = new Consumer(q);
		p.start();
		c.start();
	}
}
