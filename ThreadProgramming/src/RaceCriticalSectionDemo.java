
public class RaceCriticalSectionDemo {
	public static void main(String[] args) {
		Addition add = new Addition();
		Thread A = new OperationThread("A", add);
		Thread B = new OperationThread("B", add);
		A.start();
		B.start();

	}
}

class Addition{
	private int count=0;
	public void add(int num){
		//synchronization can be done at code block level or the method level
		//public synchronized void add(int num){
		//the synchronized block is added so that only thread can run the section below to prevent race condition
		//synchronized(this){
		count+=num;
		Thread currentThreadExecuting = Thread.currentThread();
		System.out.println("-----------------------------------------------");
		System.out.println("current thread name:"+currentThreadExecuting);
		System.out.println("count-->"+count);
		System.out.println("-----------------------------------------------");
		//}
	}
}

class OperationThread extends Thread{

	Addition addition;
	public OperationThread(String threadName,Addition addition) {
		super(threadName);
		this.addition = addition;
	}

	@Override
	public void run() {
		for (int i =1;i<=10;i++)
			addition.add(1);
	}

}

