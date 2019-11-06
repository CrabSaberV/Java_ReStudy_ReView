package try_URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *  对url的实验测试
 * @author CrabSaber
 *
 */
public class UrlToTry {

	public static void main(String[] args) {
		//TryUrl1();// url一般测试
		TryUrl2(); // urlConnition测试
		
	}
	
	// 创建url 且读取，使用普通的数据流
	public static void TryUrl1() {
		
		// 创建一个比较完整的url
		try {
			// new URL(protocol, host, port, file)
			// 相当于 ("http://www.baidu.com",80,"index.html")
			URL url = new URL("http", "www.baidu.com", 80, "/");
			BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// 获取内容
			String textsString;
			while ((textsString = inputBuffer.readLine())!=null) {
				System.out.println(textsString);
			}
			
			inputBuffer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("url畸形异常");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("I/O异常");
		} 
	}
	
	// 利用urlConnection 来读取数据
	// urlConnection 可是能向服务器发送数据的
	// 读取的数据 也比较整齐
	public static void TryUrl2() {
		try {
			URL url = new URL("http://crabsaberv.github.io");
			URLConnection urlConnection = url.openConnection();
			BufferedReader inpuBuffer = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
			
			String textString;
			while ((textString = inpuBuffer.readLine())!= null) {
				System.out.println(textString);
				
			}
			
			inpuBuffer.close();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

