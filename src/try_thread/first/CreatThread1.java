package try_thread.first;

public class CreatThread1 {

	public static void main(String[] args) {
		Thread th1 = new Thread(new Hello("th1"));
		Thread th2 = new Thread(new Hello("th2"));
		
		// 运行线程
		th1.start();
		th2.start();
		
	}

}

class Hello implements Runnable{
	public String name;
	public Hello(String name) {
		this.name = name;
	}
	// 线程体，内部实现线程需要做的事
	public void run() {
		System.out.println("Hello! This is " + this.name);
	}
}