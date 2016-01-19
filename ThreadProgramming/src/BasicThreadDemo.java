
public class BasicThreadDemo {
	public static void main(String[] args) {
		Thread thread1 = new Thread(new RunnableThread(),"thread1");
		thread1.start();

		ThreadClass threadClass = new ThreadClass("thread2");
		threadClass.start();
	}
}

class RunnableThread implements Runnable{
	@Override
	public void run() {
		System.out.println("hi");
		System.out.println(Thread.currentThread().getName());
	}
}

class ThreadClass extends Thread{

	public ThreadClass(String threadName) {
		super(threadName);
	}
	@Override
	public void run() {
		try {
			Thread.sleep(50);//this sleep is give so that the thread1 get sufficient time to execute
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aloha!!!");
		System.out.println(this.getName());
	}



}
