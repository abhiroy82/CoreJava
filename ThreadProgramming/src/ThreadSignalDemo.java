
public class ThreadSignalDemo {
	public static void main(String[] args) throws InterruptedException {
		SharedObject object = new SharedObject();
		Thread A = new Thread(new SignalThread(object));
		Thread B = new Thread(new SignalThread(object));
		A.start();
		B.start();
		A.join();
		B.join();
		//adding join so that the "main" thread waits for A and B to finish else count will come as 0 instead of 2
		System.out.println(object.count);

	}
}

class SignalThread implements Runnable{
	SharedObject object;

	public SignalThread(SharedObject object) {
		this.object = object;
	}
	@Override
	public void run() {
		while(!object.get()){ // if you put a while instead of if , then one thread waits till the other thread sets the value to false
			object.set(true);
			object.count++;
			System.out.println(Thread.currentThread().getName()+"-->"+object.count);
			object.set(false);
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


class SharedObject {
	boolean isDataAvailable = false;
	int count = 0;
	public  synchronized void set(boolean isDataAvailable){
		this.isDataAvailable = isDataAvailable;
	}

	public synchronized boolean get(){
		return isDataAvailable;
	}
}
