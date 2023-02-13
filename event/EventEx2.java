package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyAction implements ActionListener{
	
	EventEx2 f;
	
	public MyAction(EventEx2 f) {
		this.f = f;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		f.setBackground(MColor.rColor());
		f.btn.setBackground(MColor.rColor());
	}
}

public class EventEx2 extends MFrame {
	
	Button btn;
	
	public EventEx2() {
		add(btn = new Button("¹öÆ°"), BorderLayout.SOUTH);
		MyAction ma = new MyAction(this);
		btn.addActionListener(ma);
	}

	public static void main(String[] args) {
		new EventEx2();
	}

}
