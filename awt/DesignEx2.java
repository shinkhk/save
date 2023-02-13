package awt;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;


public class DesignEx2 extends MFrame2{

	TextField tf;
	TextArea ta;
	Button btn1, btn2;
	Panel p1, p2;
	
	public DesignEx2() {
		super(500,400);
		setLayout(new BorderLayout());
		setTitle("디자인 예제2");
		Panel p1, p2;
		tf = new TextField("Hello JUN!", 30);
		p1 = new Panel();
		p1.add(tf);
		ta = new TextArea();
		p2 = new Panel();
		p2.add(btn1 = new Button("마우스 시험용"));
		p2.add(btn2 = new Button("종료"));
		add(p1, BorderLayout.NORTH);
		add(ta);
		add(p2, BorderLayout.SOUTH);
		validate();
	}
	
	public static void main(String[] args) {
		new DesignEx2();
	}
}

