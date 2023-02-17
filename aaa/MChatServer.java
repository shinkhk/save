package aaa;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class MChatServer {
	
	public static final int PORT = 8002;
	ServerSocket server;
	Vector<ClientThread2> vc;
	String roomlist[] = new String[100];
	
	public MChatServer() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<ClientThread2>();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);//���������� ����
		}
		System.out.println("****Chat Server 2.0****");
		System.out.println("*Ŭ���̾�Ʈ ������ ��ٸ��� �ֽ��ϴ�");
		System.out.println("**********************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread2 ct = new ClientThread2(sock);
				ct.start();
				vc.addElement(ct);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Error in Socket");
		}
	}
	
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}
	
	public void removeClient(ClientThread2 ct) {
		vc.remove(ct);
	}
	
	//���ӵ� ��� id ����Ʈ ���� ex)aaa;bbb;ȫ�浿;��ȣ��;
	public String getIdList() {
		String list = "";
		for (int i = 0; i < vc.size(); i++) {
			ClientThread2 ct = vc.get(i);
			list+=ct.id+";";
		}
		return list;
	}
	
	//�Ű����� id������ ClientThread2�� �˻�
	public ClientThread2 findClient(String id) {
		ClientThread2 ct = null;
		for (int i = 0; i < vc.size(); i++) {
			ct = vc.get(i);
			if(ct.id.equals(id))//�Ű������� id�� ct�� id�� ���� �ϴٸ�.
				break;
		}
		return ct;
	}
	
	class ClientThread2 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread2(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(),true);
				System.out.println(sock.toString() +" ���ӵ�...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				while(true) {
					String line = in.readLine();
					if(line==null)
						break;
					else
						routine(line);
				}
			} catch (Exception e) {
				removeClient(this);
				System.err.println(sock+"["+ id +"] ������...");
			}
		}
		
		public void routine(String line) {
			//EX)CHATALL:������ ������Դϴ�.
			System.out.println("line:" + line);
			int idx = line.indexOf(ChatProtocol2.MODE);
			String cmd = line.substring(0, idx);//CHATALL
			String data = line.substring(idx+1);//������ ������Դϴ�.
			if(cmd.equals(ChatProtocol2.CHAT)) { // CHAT:���̸�:������;ä�ó��� -> ä�ù濡���� ä���� ����
				//cmd = CHAT | data = ���̸�:������;ä�ó���
				System.out.println("CHAT����");
				System.out.println("data = "+ data);
				int idx1 = data.indexOf(ChatProtocol2.MODE);
				String Rn = data.substring(0,idx1); // ���̸�
				String str = data.substring(idx1+1); // ������;ä�ó���
				System.out.println(Rn +" "+ str);
				int idx2 = str.indexOf(";");
				String Un = str.substring(0,idx2); 
				String msg = str.substring(idx2+1);
				System.out.println(msg);
				sendAllMessage(ChatProtocol2.MESSAGE+ChatProtocol2.MODE+Rn+
						ChatProtocol2.MODE+"["+Un+"]"+msg); // MESSAGE:ä�ù��̸�:[id]+ä�ó���
				System.out.println(Rn+
						ChatProtocol2.MODE+"["+id+"]:"+msg);
			}else if(cmd.equals(ChatProtocol2.ROOMLIST)) {	// ROOMLIST:������;ä�ù��̸� -> ä�ù��� ����
				//ccc;�̰� ����?
				System.out.println("first:" + data);
				idx = data.indexOf(';');
				cmd = data.substring(0, idx);//ccc
				data = data.substring(idx+1);//�̰� ����?
				for(int i = 0;roomlist.length>i;i++) {		// ������ ä�ù� �̸� ����
					if(roomlist[i] == null) {
						roomlist[i] = data;
						break;
					}
				}
				System.out.println(ChatProtocol2.ROOMLIST+ChatProtocol2.MODE+data);
				sendAllMessage(ChatProtocol2.ROOMLIST+ChatProtocol2.MODE+data);//ROOMLIST:�̰Ź���
			}else if(cmd.equals(ChatProtocol2.ID)) {		// ���� �������� ä�ù� ����Ʈ ���ΰ�ħ
				String roomreset = "";
				for(int i = 0;roomlist.length>i;i++) {
					if(roomlist[i] != null) {
						roomreset += roomlist[i]+";";
					}
				}
				System.out.println(roomreset);
				sendAllMessage(ChatProtocol2.RESETLIST+ChatProtocol2.MODE+roomreset);
			}else if(cmd.equals(ChatProtocol2.DELETELIST)) {	// DELETELIST:ä�ù��̸� ������ ä�ù��� ���������� �� ä�ù渮��Ʈ���� ����
				for(int i = 0;roomlist.length>i;i++) {
					if(data.equals(roomlist[i])) {
						sendAllMessage(ChatProtocol2.DELETELIST+ChatProtocol2.MODE+roomlist[i]);
						roomlist[i] = null;
					}
				}
			}
		}
		
		public void sendMessage(String msg) {
			out.println(msg);
		}
		
	}//--ClientThread2
	
	public static void main(String[] args) {
		new MChatServer();
	}
}



