
public class ThreadLocalDemo {

	ThreadLocal threadLocal = new ThreadLocal<String>();

	public static void main(String[] args) throws InterruptedException {
		ThreadLocalTester sharedThread = new ThreadLocalTester();
		Thread t1 = new Thread(sharedThread,"A");
		Thread t2 = new Thread(sharedThread,"B");
		t1.start();
		t2.start();
		//t1.join();
		//t2.join();
		System.out.println("current value:"+sharedThread.threadLocal.get());

	}
}

class ThreadLocalTester implements Runnable{

	ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();
//			{
//		protected Integer initialValue() {
//			return 0;
//		};
//	};
	@Override
	public void run() {
		threadLocal.set((int) (Math.random() * 100D));
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}


