package try_ConnetSocket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 有连接通信socket 客户端
 * 实现简单的交互功能 
 * 与服务端交流，当出现‘bye‘ 退出连接
 * 
 * 
 * 流程
 * 创建socket
 * 创建输入/输出流
 * 通讯
 * 关闭流
 * @author CrabSaber
 *
 *
 */
public class SocketClient {

	public static void main(String[] args) {
		// socket 本地地址（由于测试，所以服务端在本机） 端口
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 1999);
			// 如果没有捕捉到异常，那么一般就是连接到了
			System.out.println("连接成功！");
			
			// 接下来创建输入输出流
			// 输入流
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// 输出流
			PrintWriter outWriter = new PrintWriter(socket.getOutputStream());
			// 键盘接收
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			// 数据内容
			String msgString="" ;
			do {

				// 给服务端发送信息
				System.out.println("我：");
				msgString = sin.readLine();
				outWriter.println(msgString);
				
				if (!msgString.equals("bye")) {
					// 获取服务端的数据
					// 清除缓存
					outWriter.flush();
					System.out.println("---------------------------------");
					System.out.println("--服务端:" + inputReader.readLine());
				}else {
					System.out.println("连接断开！！！！");
				}
			} while (!msgString.equals("bye"));
			
			// 结束后关闭流
			sin.close();
			outWriter.close();
			inputReader.close();
			socket.close();
			System.out.println("----------------已断开连接");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("主机未知异常");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("i/o异常");
		}

	}

}
