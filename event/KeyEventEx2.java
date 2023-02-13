package event;

import java.awt.Button;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyEventEx2 extends MFrame {

	Button move;
	
	public KeyEventEx2() {
		super(400, 500, new Color(100, 200, 100));
		setLayout(null);
		move = new Button("move");
		move.setBounds(200, 250, 50, 30);
		move.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int code = e.getKeyCode();
				String txt = KeyEvent.getKeyText(code);
				//System.out.println(code + " : " + txt);
				int x = move.getX();
				int y = move.getY();
				if(txt.equals("Right")) {
					x+=10;
				}else if(txt.equals("Left")) {
					x-=10;
				}else if(txt.equals("Up")) {
					y-=10;
				}else if(txt.equals("Down")) {
					y+=10;
				}
				if(x>0 && x<getWidth()-50 && 
						y>20 && y<getHeight()-30) {
					move.setLocation(x, y);
				}
			}
		});
		
		add(move);
		move.requestFocus();
		validate();
	}
	
	public static void main(String[] args) {
		new KeyEventEx2();
	}

}
