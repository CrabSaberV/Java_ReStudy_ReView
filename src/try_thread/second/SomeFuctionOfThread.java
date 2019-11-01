package try_thread.second;
/**
 * 
 * @author CrabSaber
 * @see 测试 yield（）方法
 * 
 * Thread.sleep（）会使得当前所在的线程域的线程 进入休眠
 */
public class SomeFuctionOfThread {

	public static void main(String[] args) throws InterruptedException {
		Thread thA = new Thread(new NobFirst());
		Thread thB = new Thread(new NobSecond());
		
		thA.start();
		thB.start();
		
		// yield是个静态方法，所以这么写
		Thread.yield();	//让掉cpu资源，thA与thB重新争夺
		
		
		/*// 测试sleep 到底是怎么休眠
		thA.sleep(1000000);
		System.out.println("tha.." + thA.isAlive());
		System.out.println("thb..." + thB.isAlive());
		// 结论： Thread.sleep（）会使得当前所在的线程域的线程 进入休眠
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
