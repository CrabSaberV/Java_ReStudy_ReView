package try_URL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 *  ��url��ʵ�����
 * @author CrabSaber
 *
 */
public class UrlToTry {

	public static void main(String[] args) {
		//TryUrl1();// urlһ�����
		TryUrl2(); // urlConnition����
		
	}
	
	// ����url �Ҷ�ȡ��ʹ����ͨ��������
	public static void TryUrl1() {
		
		// ����һ���Ƚ�������url
		try {
			// new URL(protocol, host, port, file)
			// �൱�� ("http://www.baidu.com",80,"index.html")
			URL url = new URL("http", "www.baidu.com", 80, "/");
			BufferedReader inputBuffer = new BufferedReader(new InputStreamReader(url.openStream()));
			
			// ��ȡ����
			String textsString;
			while ((textsString = inputBuffer.readLine())!=null) {
				System.out.println(textsString);
			}
			
			inputBuffer.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
			System.out.println("url�����쳣");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("I/O�쳣");
		} 
	}
	
	// ����urlConnection ����ȡ����
	// urlConnection ��������������������ݵ�
	// ��ȡ������ Ҳ�Ƚ�����
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

