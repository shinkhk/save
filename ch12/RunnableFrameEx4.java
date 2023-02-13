package ch12;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Random;

public class RunnableFrameEx4 extends MFrame 
implements Runnable{

	public static Color rColor(){
		Random rd = new Random();
		int r,g,b;
		r = rd.nextInt(256);
		g = rd.nextInt(256);
		b = rd.nextInt(256);
		return new Color(r,g,b);
	}
	
	
	Random r = new Random();
	int x, y;
	Color c;
	
	public RunnableFrameEx4(Color c) {
		super(200,200);
		
		this.c = c;
	}
	
	public void run() {
		for (int i = 0; i < 30; i++) {
			x = r.nextInt(200);
			y = r.nextInt(200);
			try {
				Thread.sleep(500);
				repaint();
			} catch (Exception e) {
				
			}
		}
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
	
		RunnableFrameEx4[] rb = new RunnableFrameEx4[9];
		Thread[] tr = new Thread[9];
		int x = 100;
		int y = 100;
		
		for (int i = 0; i < rb.length; i++) {
			rb[i] = new RunnableFrameEx4(rColor());
		}
		
		for (int i = 0; i < tr.length; i++) {
			tr[i] = new Thread(rb[i]);
		}
		
		for (int i = 0; i < rb.length; i++) {
			rb[i].setLocation(x, y);
			System.out.println(x +" " +y);

			if(x == 460) {
				y = y + 180;
				x = 100;
			}else {
				x = x + 180;
			}
		}
		
		for (int i = 0; i < tr.length; i++) {
			tr[i].start();
		}
		
//		RunnableFrameEx4 r1 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r2 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r3 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r4 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r5 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r6 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r7 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r8 = new RunnableFrameEx4(rColor());
//		RunnableFrameEx4 r9 = new RunnableFrameEx4(rColor());
//		Thread t1 = new Thread(r1);
//		Thread t2 = new Thread(r2);
//		Thread t3 = new Thread(r3);
//		Thread t4 = new Thread(r4);
//		Thread t5 = new Thread(r5);
//		Thread t6 = new Thread(r6);
//		Thread t7 = new Thread(r7);
//		Thread t8 = new Thread(r8);
//		Thread t9 = new Thread(r9);
//		r1.setLocation(100, 100);
//		r2.setLocation(280, 100);
//		r3.setLocation(460, 100);
//		r4.setLocation(100, 280);
//		r5.setLocation(280, 280);
//		r6.setLocation(460, 280);
//		r7.setLocation(100, 460);
//		r8.setLocation(280, 460);
//		r9.setLocation(460, 460);
//		t1.start();
//		t2.start();
//		t3.start();
//		t4.start();
//		t5.start();
//		t6.start();
//		t7.start();
//		t8.start();
//		t9.start();
		
		
		
		
		

	}

}
