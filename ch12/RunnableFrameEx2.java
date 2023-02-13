package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class RunnableFrameEx2 extends MFrame 
implements Runnable{

	Random r = new Random();
	int x, y;
	Color c;
	
	public RunnableFrameEx2(Color c) {
		super(300, 300);
		this.c = c;
	}
	
	public void run() {
		for (int i = 0; i < 20; i++) {
			x = r.nextInt(300);
			y = r.nextInt(300);
			try {
				Thread.sleep(500);
				repaint();
			} catch (InterruptedException e) {}
		}//--for
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(c);
		g.fillOval(x, y, 10, 10);
	}
	
	@Override
	public void update(Graphics g) {
		g.clipRect(x, y, 10, 10);
		paint(g);
	}
	
	public static void main(String[] args) {
		RunnableFrameEx2 r1 = 
				new RunnableFrameEx2(Color.RED);
		RunnableFrameEx2 r2 = 
				new RunnableFrameEx2(Color.BLUE);
		Thread t1 = new Thread(r1);
		Thread t2 = new Thread(r2);
		t1.start();
		t2.start();
	}
}



