package try_ConnetSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ������ͨ��Socket �����
 * ��ͻ������ӣ��ҽ��н���
 * ������'bye'�Ͽ�����
 * 
 *  *���̣�
 *��������
 *������������
 *��������/�����
 *ͨѶ
 *�ر��� �ر�����
 *
 *
 * @author CrabSaber
 *
 */
public class SocketServer {

	public static void main(String[] args) {
		
		try {
			// ���Ƚ�������,��һ�������Ķ˿�
			ServerSocket server = new ServerSocket(1999);
			// ����socket ���Խ�����������, 
			// ���ݵĴ��� ��Ҫ�� socket
			Socket socket = server.accept();
			
			System.out.println("XXX�����");
			
			//�������������
			// ������
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// �����
			PrintWriter outWriter = new PrintWriter(socket.getOutputStream());
			// ���̽���
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			
			String msgString="";
			// ����ͻ��˷���Ϣ�������䣬���ӳɹ�
			outWriter.println("��ã����ѳɹ��������ӣ�");
			do {
				// ��ȡ�ͻ��˵�����
				msgString = inputReader.readLine();
				System.out.println("--�ͻ���:" + msgString);
				System.out.println("------------------------------------");
				// ������˷�����Ϣ
				System.out.println("�ң�");
				outWriter.println(sin.readLine());
				// �������
				outWriter.flush();
			} while (!msgString.equals("bye"));
			
			// �ر���
			sin.close();
			outWriter.close();
			inputReader.close();
			socket.close();
			server.close();
			System.out.println("-----�ѶϿ�����");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("i/o�쳣");
		}

	}

}
