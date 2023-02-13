package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActionEventEx1 extends MFrame
implements ActionListener{
	
	TextField tf;
	Checkbox cb1, cb2, cb3;
	CheckboxGroup cbg;
	Button btn1, btn2;
	String str[] = {"좋은 아침입니다.",
			             "식사 맛있게 하세요.",
			             "잘가요.내일 봅시다."};
	
	public ActionEventEx1() {
		super(250,150);
		//////////////////////////////////////////////////////////
		tf = new TextField("인사하기 버튼을 눌러주세요.");
		tf.setBackground(Color.GREEN);
		//////////////////////////////////////////////////////////
		cbg = new CheckboxGroup();
		Panel p1 = new Panel();
		p1.add(cb1=new Checkbox("아침",cbg,false));
		p1.add(cb2=new Checkbox("점심",cbg,true));
		p1.add(cb3=new Checkbox("저녁",cbg,false));
		//////////////////////////////////////////////////////////
		Panel p2 = new Panel();
		p2.add(btn1=new Button("인사하기"));
		p2.add(btn2=new Button("종료하기"));
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		//////////////////////////////////////////////////////////
		add(tf, BorderLayout.NORTH);
		add(p1);
		add(p2,BorderLayout.SOUTH);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn1) {
			Checkbox cb =  cbg.getSelectedCheckbox();
			if(cb==cb1) {
				tf.setText(str[0]);
			}else if(cb==cb2) {
				tf.setText(str[1]);
			}else if(cb==cb3) {
				tf.setText(str[2]);
			}
		}else if(obj==btn2) {
			System.exit(0);;
		}
	}

	public static void main(String[] args) {
		new ActionEventEx1();
	}

}
