package try_ConnetSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 有连接通信Socket 服务端
 * 与客户端连接，且进行交流
 * 当发送'bye'断开连接
 * 
 *  *流程：
 *创建服务
 *接受连接请求
 *创建输入/输出流
 *通讯
 *关闭流 关闭连接
 *
 *
 * @author CrabSaber
 *
 */
public class SocketServer {

	public static void main(String[] args) {
		
		try {
			// 首先建立服务,打开一个交流的端口
			ServerSocket server = new ServerSocket(1999);
			// 监听socket 可以接受连接请求, 
			// 数据的传输 主要靠 socket
			Socket socket = server.accept();
			
			System.out.println("XXX服务端");
			
			//创建输入输出流
			// 输入流
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 输出流
			PrintWriter outWriter = new PrintWriter(socket.getOutputStream());
			// 键盘接收
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			
			String msgString="";
			// 先向客户端发消息，告诉其，连接成功
			outWriter.println("你好，你已成功建立连接！");
			do {
				// 获取客户端的数据
				msgString = inputReader.readLine();
				System.out.println("--客户端:" + msgString);
				System.out.println("------------------------------------");
				// 给服务端发送信息
				System.out.println("我：");
				outWriter.println(sin.readLine());
				// 清除缓存
				outWriter.flush();
			} while (!msgString.equals("bye"));
			
			// 关闭流
			sin.close();
			outWriter.close();
			inputReader.close();
			socket.close();
			server.close();
			System.out.println("-----已断开连接");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("i/o异常");
		}

	}

}
