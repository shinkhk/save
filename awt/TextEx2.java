package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TextEx2 extends MFrame 
implements ActionListener{
	
	TextField tf;
	TextArea ta;
	Button btn;
	
	public TextEx2() {
		super(260, 300);
		setTitle("MyChat v1.0");
		setLayout(new BorderLayout());
		add(ta = new TextArea(), "Center");
		Color c[] = MColor.rColor2();
		ta.setBackground(c[0]);
		ta.setForeground(c[1]);
		ta.setEditable(false);
		//그룹 컨테이너
		Panel p = new Panel();
		p.add(tf = new TextField(22));
		p.add(btn = new Button("SEND"));
		tf.addActionListener(this);//Enter 이벤트
		btn.addActionListener(this);//클릭 이벤트
		add(p, "South");
		validate();
		tf.requestFocus();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = tf.getText().trim();
		if(str.length()==0)
			str = "입력을 하세요";
		ta.append(str+"\n");
		tf.setText("");
		tf.requestFocus();
	}
	
	public static void main(String[] args) {
		new TextEx2();
	}
}