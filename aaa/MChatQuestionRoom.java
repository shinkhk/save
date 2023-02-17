package aaa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MChatQuestionRoom extends JFrame
implements ActionListener{
	 
	String roomname;
	List userlist;
	JButton bt1,bt2,bt3;
	JTextField tf;
	TextArea ta;
	String id;
	BufferedReader in;
	PrintWriter out;
	Socket sock;
	
	public MChatQuestionRoom(String roomname,BufferedReader in, PrintWriter out, String id) {
		System.out.println("방생성");
		setSize(450, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.roomname = roomname;
		this.in = in;
		this.out = out;
		this.id = id;
		setTitle(this.roomname);
		// //////////////////////////////////////////////////////////////////////////////////////////
		ta = new TextArea("["+ id +"] enter \n");
		ta.setBackground(Color.DARK_GRAY);
		ta.setForeground(Color.PINK);
		ta.setEditable(false);
		add(BorderLayout.CENTER, ta);
		// /////////////////////////////////////////////////////////////////////////////////////////
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		userlist = new List();
		p2.add(BorderLayout.CENTER, userlist);
		JPanel p3 = new JPanel();
		bt2 = new JButton("나가기");
		bt2.addActionListener(this);
		p3.add(bt2);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		JPanel p4 = new JPanel();
		tf = new JTextField("", 30);
		bt1 = new JButton("보내기");
		p4.add(tf);
		p4.add(bt1);
		add(BorderLayout.SOUTH, p4);
		bt1.addActionListener(this);
		tf.addActionListener(this);
		setVisible(true);
		validate();
	}
	
	public MChatQuestionRoom(String roomname,BufferedReader in, PrintWriter out, String id, int orner) {
		System.out.println("방생성");
		setSize(450, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.roomname = roomname;
		this.in = in;
		this.out = out;
		this.id = id;
		setTitle(this.roomname);
		// //////////////////////////////////////////////////////////////////////////////////////////
		ta = new TextArea("["+ id +"] enter \n");
		ta.setBackground(Color.DARK_GRAY);
		ta.setForeground(Color.PINK);
		ta.setEditable(false);
		add(BorderLayout.CENTER, ta);
		// /////////////////////////////////////////////////////////////////////////////////////////
		JPanel p2 = new JPanel();
		p2.setLayout(new BorderLayout());
		userlist = new List();
		p2.add(BorderLayout.CENTER, userlist);
		JPanel p3 = new JPanel();
		bt3 = new JButton("질문 종료");
		bt3.addActionListener(this);
		p3.add(bt3);
		p2.add(BorderLayout.SOUTH, p3);
		add(BorderLayout.EAST, p2);
		// ///////////////////////////////////////////////////////////////////////////////////////////
		JPanel p4 = new JPanel();
		tf = new JTextField("", 30);
		bt1 = new JButton("보내기");
		p4.add(tf);
		p4.add(bt1);
		add(BorderLayout.SOUTH, p4);
		bt1.addActionListener(this);
		tf.addActionListener(this);
		setVisible(true);
		validate();
	}
	
	
//	public MChatQuestionRoom(String roomname, String msg) {
//		if(roomname == this.roomname) {
//			ta.append(msg);
//		}
//	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == bt2) {	//나가기
			dispose();
		}else if(obj == bt1 || obj == tf) {
			String msg = tf.getText();
			sendMessage(ChatProtocol2.CHAT+ChatProtocol2.MODE+roomname+ChatProtocol2.MODE+id+";"+msg); // -> CHAT:방이름:aaa;안녕하세요
			tf.setText("");
			tf.requestFocus();
		}else if(obj == bt3) {
			sendMessage(ChatProtocol2.DELETELIST+ChatProtocol2.MODE+roomname);
			dispose();
		}
	}
	
	
	public void routine(String line) {
		System.out.println("룸 line");
		int idx = line.indexOf(ChatProtocol2.MODE);
		String cmd = line.substring(0, idx);
		String data = line.substring(idx+1);
		if(cmd == roomname) {
			ta.append(data+"\n");
		}
	}//--routine
	
	public void addText(String msg) {
		ta.append(msg+"\n");
	}
	
	
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	
	public static void main(String[] args) {

	}



}
