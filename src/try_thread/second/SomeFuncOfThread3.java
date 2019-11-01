package try_thread.second;
/**
 * @see 测试interrupt（）
 * @author CrabSaber
 *
 *	会捕捉到异常,之后的行进由程序决定
 */
public class SomeFuncOfThread3 {

	public static void main(String[] args) {
		NobFirst2 th1 = new NobFirst2();
		th1.start();
		
		th1.interrupt();
	}

}

class NobFirst2 extends Thread{

	public void run() {
		for (int i = 0; i < 10; i++) {
			if (i == 1) {
				try {
					Thread.sleep(10000);
					
				} catch (InterruptedException e) {
					e.printStackTrace();
					System.out.println("here interrupt!!!");
				}
			}
			// 持续打印中断状态
			System.out.println("This is A -----isInterrupt: " + this.isInterrupted());
		}
	}
}

