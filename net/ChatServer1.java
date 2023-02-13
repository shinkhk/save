package net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer1 {

	public static final int PORT = 8001;
	ServerSocket server;
	Vector<ClientThread1> vc;
	
	public ChatServer1() {
		try {
			server = new ServerSocket(PORT);
			vc = new Vector<ClientThread1>();
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Error in Server");
			System.exit(1);//비정상적인 종료
		}
		System.out.println("***********************");
		System.out.println("ChatServer1 v1.0 시작되었습니다");
		System.out.println("***********************");
		try {
			while(true) {
				Socket sock = server.accept();
				ClientThread1 ct = new ClientThread1(sock);
				ct.start();
				//접속한 클라이언트 Socket객체를 Vector 저장
				vc.addElement(ct);
			}
		} catch (Exception e) {
			//e.printStackTrace();
			System.err.println("Error in Socket");
		}
	}
	
	//전체 접속자에게 메세지 전달
	public void sendAllMessage(String msg) {
		for (int i = 0; i < vc.size(); i++) {
			ClientThread1 ct = vc.get(i);
			ct.sendMessage(msg);
		}
	}
	
	//접속이 끊어진 Client를 Vector에서 제거
	public void removeClient(ClientThread1 ct) {
		vc.remove(ct);
	}
	
	class ClientThread1 extends Thread{
		
		Socket sock;
		BufferedReader in;
		PrintWriter out;
		String id;
		
		public ClientThread1(Socket sock) {
			try {
				this.sock = sock;
				in = new BufferedReader(
						new InputStreamReader(sock.getInputStream()));
				out = new PrintWriter(sock.getOutputStream(),true);
				System.out.println(sock.toString() + " 접속됨...");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			try {
				//Client에게 최초 보내는 메세지
				out.println("사용하실 아이디를 입력하세요");
				//Client에서 입력한 id를 저장
				id = in.readLine();
				//접속한 모든 Client에게 welcome 메시지 전달
				sendAllMessage("["+id+"]님이 입장 하였습니다");
				String line = "";
				while(true) {
					line = in.readLine();
					if(line==null)
						break;//Client 접속 종료
					sendAllMessage("["+id+"]"+ line);
				}
				in.close();
				out.close();
				sock.close();
			} catch (Exception e) {
				//자신의 객체를 Vector에서 제거
				removeClient(this);
				System.err.println(sock + " 끊어짐...");
			}
		}
		
		//Client에게 메세지 보내는 메소드
		public void sendMessage(String msg) {
			out.println(msg);
		}
		
	}//--ClientThread1
	
	public static void main(String[] args) {
		new ChatServer1();
	}

}
