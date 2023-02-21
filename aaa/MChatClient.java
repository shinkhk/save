package aaa;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;




public class MChatClient extends JFrame
implements ActionListener, Runnable{
	JButton bt1, bt2, bt3, bt4;
	JTextField tf1, tf2, tf3;
	TextArea area;
	List list;
	Socket sock;
	BufferedReader in;
	PrintWriter out;
	String listTitle = "*******���� ���*******";
	String id;
	MChatQuestionRoom[] QR = new MChatQuestionRoom[100];
	boolean flag = false;

	public MChatClient(BufferedReader in, PrintWriter out, String id) {
		setSize(450, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.id = id;
		this.in = in;
		this.out = out;
		setTitle(this.id + "�� �ȳ��ϼ���");
		// //////////////////////////////////////////////////////////////////////////////////////////
		area = new TextArea("�¼���ȣ:05               �����ð�:00:00:00\n");
		area.setBackground(Color.DARK_GRAY);
		area.setForeground(Color.PINK);
		area.setEditable(false);
		add(BorderLayout.CENTER, area);
		// /////////////////////////////////////////////////////////////////////////////////////////
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		list = new List();
		list.add(listTitle);
		p2.add(BorderLayout.CENTER, list);
		JPanel p3 = new JPanel();
		p3.setLayout(new GridLayout(1, 2));
		bt2 = new JButton("�����ϱ�");
		bt2.addActionListener(this);
		bt3 = new JButton("�亯�ϱ�");
		bt3.addActionListener(this);
		p3.add(bt2);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		JPanel p4 = new JPanel();
		tf3 = new JTextField("", 30);
		bt4 = new JButton("send");
		p4.add(tf3);
		p4.add(bt4);
		tf3.addActionListener(this);
		add(BorderLayout.SOUTH, p4);
		
		new Thread(this).start();
		setVisible(true);
		validate();
	}
	
	public void run() {
		System.out.println("Ŭ���̾�Ʈ run");
		try {
			while(true) {
				String line = in.readLine();
				if(line==null) {
					System.out.println("����");
					break;}
				else
					routine(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}//--run
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
			if(obj == bt2) {// �����ϱ�
			MyDialog md = new MyDialog(this, "������ �Է��ϼ���", true);
			//Dialog�� âũ��
			int width = 300;
			int height = 200;
			//int x = fx+getWidth()/2-width/2;
			//int y = fy+getHeight()/2-height/2;
			md.setSize(width, height);
			md.setLocationRelativeTo(this);
			//md.setBounds(x, y, width, height);
			md.setVisible(true);
		}else if(obj == bt3) { // �亯�ϱ�
			if(list.getSelectedItem()!=null) {
			String str = list.getSelectedItem();
			enterRoom(str);
			}
		}else if(obj == tf3) {
			sendMessage(tf3.getText());
			tf3.setText("");
		}
	}
	
	public void routine(String line) {
		System.out.println("Ŭ���̾�Ʈ line");
		int idx = line.indexOf(ChatProtocol2.MODE);
		String cmd = line.substring(0, idx);
		String data = line.substring(idx+1);
		if(cmd.equals(ChatProtocol2.ROOMLIST)) {
			addRoomList(data);}
		else if(cmd.equals(ChatProtocol2.ENTERROOM)) {	// ENTERROOM:���̸�:������;���� �����Ͽ����ϴ�
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); //���̸�
			String str = data.substring(idx1+1); //������;���� �����Ͽ����ϴ�
			int idx2 = str.indexOf(";");
			String Un = str.substring(0, idx2);	//������
			String str1 = str.substring(idx2+1); //���� �����Ͽ����ϴ�
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomname)){
					QR[i].addText("["+Un+"] " + str1);
					}
				}
				
			}
		}else if(cmd.equals(ChatProtocol2.ADDUSER)) {
			// ���̸�:���̸�:������;���̸�:������;���̸�:������;...;
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); //���̸�
			String str = data.substring(idx1+1); //���̸�:������;���̸�:������;���̸�:������;...;
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomname)){
						QR[i].resetList(str);
						break;
					}
				}

			}
//			String userList[] = new String[100];
//			StringTokenizer st = new StringTokenizer(data, ";");
//			while(st.hasMoreTokens()) {
//				int i = 0;
//				userList[i] = st.nextToken(); // ���̸�:���̸�:������ / ���̸�:������ / ���̸�:������/ ... /
//				i++;
//			}
//			for(int i = 0 ;userList.length > i;i++) {
//				int idx2 = userList[i].indexOf(ChatProtocol2.MODE);
//				String Rn1 = userList[i].substring(0,idx2);
//				String Un = userList[i].substring(idx2+1);
//				if(QR[i].roomname.equals(Rn)) {
//					QR[i].resetList(Un);
//				}
//			}

		}else if(cmd.equals(ChatProtocol2.MESSAGE)) { // MESSAGE:���̸�:[id]+ä�ó���
			System.out.println("�޼�������");
			int idx1 = data.indexOf(ChatProtocol2.MODE);
			String Rn = data.substring(0, idx1); // ���̸�
			System.out.println("Rn:"+Rn);
			String msg = data.substring(idx1 + 1);	// [id]:ä�ó���
			System.out.println("msg:"+msg);
//			if(Rn.equals(QR[0].roomname)) {
//				QR[0].addText(msg);
//			}
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(Rn.equals(QR[i].roomname)){
					System.out.println("ä���� ���ȣ = " + i);
					QR[i].addText(msg);
					}
				}

			}
		}else if(cmd.equals(ChatProtocol2.RESETLIST)) {
			System.out.println("����Ʈ����");
			System.out.println(data);
			list.removeAll();
			list.add(listTitle);
			StringTokenizer st = new StringTokenizer(data, ";");
			while(st.hasMoreTokens()) {
				list.add(st.nextToken());
			}
		}else if(cmd.equals(ChatProtocol2.DELETELIST)) {
			list.remove(data);
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(data.equals(QR[i].roomname)){
					System.out.println("ä���� ���ȣ = " + i);
					QR[i].addText("*********OWNER EXIT*********");
					QR[i].addText("Leave the room in 3 seconds");
					sendMessage(ChatProtocol2.DELETUSER+ChatProtocol2.MODE+QR[i].roomname);
					try {
						QR[i].addText("3");
						Thread.sleep(1000);
						QR[i].addText("2");
						Thread.sleep(1000);
						QR[i].addText("1");
						Thread.sleep(1000);
						QR[i].dispose();
						QR[i] = null;
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
					}
				}

			}
		}else if(cmd.equals(ChatProtocol2.EXIT)) {	//EXIT:���̸�
			for(int i = 0; QR.length > i; i++) {
				if(QR[i] != null) {
					if(data.equals(QR[i].roomname)) {
						QR[i] = null;
						break;
					}
				}
			}
		}
	}//--routine
	
	class MyDialog extends Dialog implements ActionListener{
		Button b1, b2;
		TextField tf;
		TextArea ta;
		public MyDialog(Frame owner, String title, boolean modal) {
			super(owner, title, modal);
			setLayout(new BorderLayout());
			tf = new TextField();
			Panel p = new Panel();
			
			b1 = new Button("Ȯ��");
			b2 = new Button("���");
			
			p.add(b1);
			p.add(b2);
			
			add(p,BorderLayout.SOUTH);
			add(tf,BorderLayout.CENTER);
			b1.addActionListener(this);
			b2.addActionListener(this);
			tf.addActionListener(this);//Enter �̺�Ʈ
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			if(obj == b1 || obj == tf) {
				String str = tf.getText().trim();
				sendMessage(ChatProtocol2.ROOMLIST+ChatProtocol2.MODE+id+";"+str);//ROOMRIST:ccc;�̰� ����?
				creatRoom(str);
				dispose();//������� ���
			}else if(obj == b2) {
				dispose();
			}
		}
	}//--MyDialog
	
	public void creatRoom(String roomname) {
//		QR[0] = new MChatQuestionRoom(roomname, in, out, id);
//		System.out.println(QR[0].roomname);
		int orner = 1;
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] == null) {
				System.out.println("������� ���ȣ = " + i);
				QR[i] = new MChatQuestionRoom(roomname, in, out, id, orner);
				QR[i].enterRoom();
				break;
			}
		}
	}
	
	public void enterRoom(String roomname) {
		for(int i = 0; QR.length > i; i++) {
			if(QR[i] == null) {
				System.out.println("������� ���ȣ = " + i);
				QR[i] = new MChatQuestionRoom(roomname, in, out, id);
				QR[i].enterRoom();
				break;
			}
		}
	}
	
	
	public void addRoomList(String str) {
		list.add(str);
	}
	
	
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	public static void main(String[] args) {
	}




}
