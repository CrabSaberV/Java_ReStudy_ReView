package try_thread.first;

public class CreatThread2 {

	public static void main(String[] args) {
		HelloE thr1 = new HelloE("thr1");
		HelloE thr2 = new HelloE("thr2");
		
		thr1.start();
		thr2.start();
		
	}

}

class HelloE extends Thread{
	
	public String name;
	public HelloE(String name) {
		this.name = name;
	}
	
	// �߳��壬�ڲ�ʵ���߳���Ҫ������
	public void run() {
		System.out.println("Hello! This is " + this.name);
	}
}