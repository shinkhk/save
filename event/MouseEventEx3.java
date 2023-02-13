package event;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseEventEx3 extends MFrame {
	
	Button btn;
	
	public MouseEventEx3() {
		add(btn = new Button("버튼"), BorderLayout.SOUTH);
		btn.addMouseListener(new MyMouseAdapter());
	}

	class MyMouseAdapter extends MouseAdapter{
		//Adapter : 필요한 메서드만 override하면 된다.
		@Override
		public void mouseEntered(MouseEvent e) {
			setBackground(MColor.rColor());
		}
		@Override
		public void mouseExited(MouseEvent e) {
			setBackground(MColor.rColor());
		}
	}
	
	public static void main(String[] args) {
		new MouseEventEx3();
	}

}
