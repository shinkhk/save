package net;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class ChatClient1 extends JFrame 
implements ActionListener, Runnable{
	
	JButton btn1, btn2;
	JTextField tf1, tf2;
	TextArea ta;
	JPanel p1, p2;
	BufferedReader in;
	PrintWriter out;
	String id;
	public static final int PORT = 8001;
	
	public ChatClient1()  {
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChat v1.0");
		p1 = new JPanel();
		p1.setBackground(new Color(100,200,100));
		p1.add(new Label("HOST ",Label.CENTER));
		p1.add(tf1 = new JTextField("127.0.0.1",15));
		p1.add(btn1 = new JButton("Connect"));
		
		p2 = new JPanel();
		p2.setBackground(new Color(100,200,100));
		p2.add(new Label("CHAT ",Label.CENTER));
		p2.add(tf2 = new JTextField("",15));
		p2.add(btn2 = new JButton("SEND"));	
		
		tf1.addActionListener(this);
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(ta=new TextArea());
		add(p2,BorderLayout.SOUTH);
		setVisible(true);
		validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==tf1||obj==btn1/*connect*/) {
			connect(tf1.getText().trim());
			tf1.setEnabled(false);
			btn1.setEnabled(false);
			tf2.requestFocus();
		}else if(obj==tf2||obj==btn2/*send*/) {
			String str = tf2.getText().trim();
			if(str.length()==0)
				return;//서버로 전송하지 않고 메서드 빠져 나감
			if(id==null) {//최초 한번만 실행
				id = str;
				setTitle(getTitle() + " [" + id + "]");
				ta.setText("채팅을 시작합니다\n");
			}
			out.println(str);//서버 전송
			tf2.setText("");
			tf2.requestFocus();
		}
	}//--actionPerformed
	
	@Override //서버로 부터 메세지가 들어오면 반응하는 기능
	public void run() {
		try {
			while(true) {
				ta.append(in.readLine()+"\n");
				tf2.requestFocus();
			}
		} catch (Exception e) {
			System.err.println("Error in run");
			e.printStackTrace();
			System.exit(1);
		}
	}//--run
	
	public void connect(String host){
		try {
			Socket sock = new Socket(host, PORT);
			in = new BufferedReader(
					new InputStreamReader(sock.getInputStream(),"EUC_KR"));
			out = new PrintWriter(sock.getOutputStream(),true);
			ta.append(in.readLine()+"\n");
			tf2.requestFocus();
		} catch (Exception e) {
			e.printStackTrace();
		}
		//Thread Start -> run 메서드 호출
		new Thread(this).start();
	}//--connect
	
	public static void main(String[] args) {
		new ChatClient1();
	}
}



