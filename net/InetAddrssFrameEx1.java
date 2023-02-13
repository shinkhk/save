package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddrssFrameEx1 extends MFrame implements ActionListener {

	TextField tf;
	TextArea ta;
	Button btn;
	
	
	public InetAddrssFrameEx1() {
		super(300,400);
		Panel p = new Panel();
		tf = new TextField();
		ta = new TextArea();
		btn = new Button("호스트 정보 보기");
		p.setLayout(new GridLayout(2,1));
		p.add(tf);
		p.add(btn);
		add(p,BorderLayout.NORTH);
		add(ta=new TextArea("인터넷주소\n"));
		ta.setEditable(false);
		
		tf.addActionListener(this);
		btn.addActionListener(this);
		tf.requestFocus();
		validate();
	}
	
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String host = tf.getText().trim();
		
		try {
			InetAddress add = InetAddress.getLocalHost();
			add = InetAddress.getByName(host);
			ta.append(host+"\n");
			ta.append(add.getHostAddress().toString() + "\n");
			tf.setText("");
			tf.requestFocus();
		} catch (UnknownHostException e1) {
			ta.append("["+host+"]\n");
			ta.append("해당되는 호스트가 없습니다\n");
			tf.setText("");
			tf.requestFocus();
		}
	}

	public static void main(String[] args) {
		new InetAddrssFrameEx1();
	}

}
