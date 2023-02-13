package ch06;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class MyFrame2 extends MFrame{
	
	Random r;
	
	public MyFrame2() {
		super(500,500,Color.white, false);
		r = new Random(); //랜덤객체
	}
	
	public void paint(Graphics g) {
		if(r==null)
			return;
		for(int i = 0; i<10000; i++) {
			g.setColor(rColor());
			int x = r.nextInt(500);
			int y = r.nextInt(500);
			int w = r.nextInt(10)+5;
			int h = r.nextInt(10)+5;
			g.fillRect(x, y, w, h);
			try {
				Thread.sleep(10);
			}catch (Exception e) {}	
		}
			
		
	}
	
	public Color rColor() {
		int rr , gg , bb ;
		rr = r.nextInt(255);
		gg = r.nextInt(255);
		bb = r.nextInt(255);
		return new Color(rr, gg, bb);
	}

	public static void main(String[] args) {
		 new MyFrame2();
	}	
	
}