package try_thread.second;
/**
 * @see ����interrupt����
 * @author CrabSaber
 *
 *	�Ჶ׽���쳣,֮����н��ɳ������
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
			// ������ӡ�ж�״̬
			System.out.println("This is A -----isInterrupt: " + this.isInterrupted());
		}
	}
}

