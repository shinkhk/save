package awt;

import java.awt.Canvas;

public class CavasEx1 extends MFrame {

	Canvas c;
	
	public CavasEx1() {
		c= new Canvas();
		c.setSize(100,100);
		c.setBackground(MColor.rColor());
		add(c);
	}
	
	
	
	public static void main(String[] args) {
		new CavasEx1();
	}

}
