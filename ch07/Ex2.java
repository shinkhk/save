package ch07;

import java.awt.Color;
import java.awt.Frame;


class MFrame2 extends Frame{
		public MFrame2() {
		}
		
		public MFrame2(Color c, int v, int h, boolean fiag) {
			setBackground(c);
			setSize(v,h);
			setVisible(fiag);
		}
	}

public class Ex2 {

	public static void main(String[] args) {
		MFrame2 m = new MFrame2();
		m.setBackground(Color.blue);
		m.setSize(300,300);
		m.setVisible(true);
		
		MFrame2 m2 = new MFrame2(Color.red,200,300,true);
		
	}

}
