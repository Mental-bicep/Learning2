package threadProgram4;

class OddThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=2; i<=20; ++i) {
			if((i&1) == 1) System.out.println(i+" by Oddthread "+ Thread.currentThread().getName());
			if(i==10) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("after sleep printing for OddThread"+ Thread.currentThread().getName());
				
				
			}
		}
	}
}

class EvenThread implements Runnable{
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=2; i<=20; ++i) {
			if((i&1) == 0) System.out.println(i+" by Eventhread "+ Thread.currentThread().getName());
			if(i==10) {
				try {
					Thread.sleep(5000);
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
				System.out.println("after sleep printing for EvenThread"+ Thread.currentThread().getName());
				
			}
		}
	}
}

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stu
		
		Thread t1 = new Thread(new OddThread());
		Thread t2 = new Thread(new EvenThread());
		
		t1.start();
		t2.start();
		
		
		

	}

}
