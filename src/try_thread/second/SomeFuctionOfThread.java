package try_thread.second;
/**
 * 
 * @author CrabSaber
 * @see ���� yield��������
 * 
 * Thread.sleep������ʹ�õ�ǰ���ڵ��߳�����߳� ��������
 */
public class SomeFuctionOfThread {

	public static void main(String[] args) throws InterruptedException {
		Thread thA = new Thread(new NobFirst());
		Thread thB = new Thread(new NobSecond());
		
		thA.start();
		thB.start();
		
		// yield�Ǹ���̬������������ôд
		Thread.yield();	//�õ�cpu��Դ��thA��thB��������
		
		
		/*// ����sleep ��������ô����
		thA.sleep(1000000);
		System.out.println("tha.." + thA.isAlive());
		System.out.println("thb..." + thB.isAlive());
		// ���ۣ� Thread.sleep������ʹ�õ�ǰ���ڵ��߳�����߳� ��������
		*/
	}

}

class NobFirst implements Runnable{

	public void run() {
		for (int i = 0; i < 10; i++) {

			System.out.println("This is A ------" + i);
		}
	}
}

class NobSecond implements Runnable{

	public void run() {
		System.out.println("Here is B!");
	}
}
