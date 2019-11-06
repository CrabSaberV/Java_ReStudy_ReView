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
 * ������ͨ��socket �ͻ���
 * ʵ�ּ򵥵Ľ������� 
 * �����˽����������֡�bye�� �˳�����
 * 
 * 
 * ����
 * ����socket
 * ��������/�����
 * ͨѶ
 * �ر���
 * @author CrabSaber
 *
 *
 */
public class SocketClient {

	public static void main(String[] args) {
		// socket ���ص�ַ�����ڲ��ԣ����Է�����ڱ����� �˿�
		try {
			Socket socket = new Socket(InetAddress.getLocalHost(), 1999);
			// ���û�в�׽���쳣����ôһ��������ӵ���
			System.out.println("���ӳɹ���");
			
			// �������������������
			// ������
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			// �����
			PrintWriter outWriter = new PrintWriter(socket.getOutputStream());
			// ���̽���
			BufferedReader sin = new BufferedReader(new InputStreamReader(System.in));
			
			// ��������
			String msgString="" ;
			do {

				// ������˷�����Ϣ
				System.out.println("�ң�");
				msgString = sin.readLine();
				outWriter.println(msgString);
				
				if (!msgString.equals("bye")) {
					// ��ȡ����˵�����
					// �������
					outWriter.flush();
					System.out.println("---------------------------------");
					System.out.println("--�����:" + inputReader.readLine());
				}else {
					System.out.println("���ӶϿ���������");
				}
			} while (!msgString.equals("bye"));
			
			// ������ر���
			sin.close();
			outWriter.close();
			inputReader.close();
			socket.close();
			System.out.println("----------------�ѶϿ�����");
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("����δ֪�쳣");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("i/o�쳣");
		}

	}

}
