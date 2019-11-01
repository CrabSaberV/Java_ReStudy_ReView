package try_thread.thrid;

import java.util.Scanner;

/**
 * @see ����wait���� �� notify����
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
// NobA ��NobB ��ͬ������һ������ʵ����ȷ���ǹ�������
class NobA implements Runnable{
	
	public PrintOKK aOkk;
	
	public NobA(PrintOKK aOkk) {
		this.aOkk = aOkk;
	}
	
	// ѭ����ӡһЩ����ȷ���ܿ�����������
	public void run() {
		// ���߳����д�ӡ
		aOkk.up();
		System.out.println("����A�ͻ����Ͻ�����");
	}
}

class NobB implements Runnable{
	public PrintOKK aOkk;
	
	public NobB(PrintOKK aOkk) {
		this.aOkk = aOkk;
	}
	
	//���ǿ�A�Ƿ���õ�
	public void run() {
		aOkk.down();
		System.out.println("�����ʾBҲҪ������");
		
	}
}

class PrintOKK{
	public int a;
	
	public PrintOKK() {
		a= 0;
	}
	
	//��ͣ�Ĵ�ӡ ֱ��5 �������wait
	public synchronized void up() {
		//��ӡ
		for (int i = 0; i < 20; i++) {
			System.out.println("A��������" + i);
			
			if (i == 5) {
				
				while (this.a == 0) {	//��B��a��Ϊ0 ������ѭ��
					//��ʱ����Ҫ�ȴ���
					try {
						System.out.println("111111111111111111111111111111111");
						this.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
						System.out.println("��ʱA �жϣ�");
					}
					
				}// while
				continue;
				
			}//if
		}
	}
	
	// �������뼴��
	public synchronized void down() {
		//���ѵȴ��Ľ���
		this.notify();
		
		Scanner input = new Scanner(System.in);
		System.out.println("��Ҫ�����ˣ�");
		input.next();
		this.a = 1;
		System.out.println("down������");
	}
}