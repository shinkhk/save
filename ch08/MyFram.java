package ch08;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

public class MyFram extends MFrame 
implements ActionListener{
	
	Button btn;
	Boolean falg = false;
	
	public MyFram() {
		btn = new Button("Button");
		add(btn, BorderLayout.SOUTH);
		setBackground(Color.ORANGE);
//		내 자신이 addActionListener 타입이므로 this 가능
//		버튼을 클린하면 ActionEvent 객체가 내부적 생성됨
		btn.addActionListener(this);
	}
@Override
	public void actionPerformed(ActionEvent e) {
	if(falg) {
		setBackground(Color.ORANGE);
	}else {
		setBackground(Color.PINK);
	}
	falg =! falg;
	}

	public static void main(String[] args) {
		new MyFram();
	}

}
