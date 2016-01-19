
public class ImmutableClassDemo {
	public static void main(String[] args) {
		ImmutableClass im = new ImmutableClass();
		FirstThread A = new FirstThread(im);
		FirstThread B = new FirstThread(im);
		A.start();
		B.start();
	}
}

class ImmutableClass {
	private int count = 0;

	//the synchronized function makes the immutable variable count to be updated properly by the two threads
	public synchronized void addValue(int num){
		count+=num;
		System.out.println("addValue:"+Thread.currentThread().getName()+"--->Counter:"+count);
	}
	public synchronized void increment(){
		count++;
		System.out.println("increment:"+Thread.currentThread().getName()+"--->Counter:"+count);
	}
}

class FirstThread extends Thread{
	ImmutableClass immutable;
	public FirstThread(ImmutableClass immutableClass) {
		this.immutable = immutableClass;
	}
	@Override
	public void run() {
		immutable.addValue(1);
	}
}

class SecondThread extends Thread{
	ImmutableClass immutable;
	public SecondThread(ImmutableClass immutableClass) {
		this.immutable = immutableClass;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void run() {
		immutable.increment();
	}
}
