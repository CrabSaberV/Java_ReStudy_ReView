package try_thread.second;
/**
 * 
 * @author CrabSaber
 *@see ≤‚ ‘join£®£©
 */
public class SomeFuncOfThread2 {

	public static void main(String[] args) throws InterruptedException {
		int i = 0;
		Thread thB = new Thread(new NobSecond1());	
		thB.start();

		while (true) {
			System.out.println("This is Main ------" + i);
			if (i == 5 && thB.isAlive() ) {
				thB.join();
			}
			
			i++;
			
			if (i == 7) {
				break;
			}
		}
		
	}
}

class NobSecond1 implements Runnable{

	public void run() {
		for (int i = 0; i < 6; i++) {
			System.out.println("Here is B!");
		}
		
	}
}