package try_thread.thrid;

import java.util.Scanner;

/**
 * @see 测试wait（） 和 notify（）
 * @author CrabSaber
 *
 */
public class SomeFuncOfThread {
	
	public static void main(String[] args) {
		PrintOKK aOkk = new PrintOKK();
		
		Thread thA = new Thread(new NobA(aOkk));
		Thread thB = new Thread(new NobB(aOkk));
		
		
		thA.start();
		thB.start();
	}

}
// NobA 与NobB 共同访问这一个对象实例，确保是共享数据
class NobA implements Runnable{
	
	public PrintOKK aOkk;
	
	public NobA(PrintOKK aOkk) {
		this.aOkk = aOkk;
	}
	
	// 循环打印一些数，确保能看到其在运作
	public void run() {
		// 此线程运行打印
		aOkk.up();
		System.out.println("这里A就基本上结束了");
	}
}

class NobB implements Runnable{
	public PrintOKK aOkk;
	
	public NobB(PrintOKK aOkk) {
		this.aOkk = aOkk;
	}
	
	//就是看A是否会让道
	public void run() {
		aOkk.down();
		System.out.println("这里表示B也要结束了");
		
	}
}

class PrintOKK{
	public int a;
	
	public PrintOKK() {
		a= 0;
	}
	
	//不停的打印 直到5 让其进入wait
	public synchronized void up() {
		//打印
		for (int i = 0; i < 20; i++) {
			System.out.println("A。。。。" + i);
			
			if (i == 5) {
				
				while (this.a == 0) {	//在B中a不为0 就跳出循环
					//此时就需要等待了
					try {
						System.out.println("111111111111111111111111111111111");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("此时A 中断？");
					}
					
				}// while
				continue;
				
			}//if
		}
	}
	
	// 进入输入即可
	public synchronized void down() {
		//提醒等待的进程
		this.notify();
		
		Scanner input = new Scanner(System.in);
		System.out.println("需要输入了：");
		input.next();
		this.a = 1;
		System.out.println("down结束了");
	}
}