package net;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

public class MsgAWT3 extends MFrame implements ActionListener{
	
	ChatClient3 client;
	String id;
	String title = "Message";
	Button closeBtn;
	List list;
	Vector<MessageBean3> vlist;
	String str;
	String label[] = {"Fid", "Tid", "Msg"};
	
	public MsgAWT3(ChatClient3 client, String str) {
		super(300, 300, new Color(200, 100, 100));
		this.client = client;
		this.str = str;
		setTitle(title);
		list = new List();
		add(list, BorderLayout.CENTER);
		closeBtn = new Button("Close");
		closeBtn.addActionListener(this);
		Panel p = new Panel();
		p.add(closeBtn);
		add(p, BorderLayout.SOUTH);
		addListMsg();
		validate();
	}

	public void addListMsg() {
		//aaa,bbb,π‰∏‘¿⁄;bbb,ccc,«œ¿Ã;
		StringTokenizer st1 = new StringTokenizer(str, ";");
		while(st1.hasMoreElements()) {
			//aaa,bbb,π‰∏‘¿⁄
			StringTokenizer st2 = new StringTokenizer(st1.nextToken(), ",");
			String item = "";
			for (int i = 0; i < label.length; i++) {
				item+=label[i] + ": " + st2.nextToken() + " ";
			}
			list.add(item);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==closeBtn) {
			dispose();
		}
	}
}






