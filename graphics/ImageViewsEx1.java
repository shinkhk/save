package graphics;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

public class ImageViewsEx1 extends MFrame{
	
	Image img;
	
	public ImageViewsEx1() {
		super(500,  350);
		img = Toolkit.getDefaultToolkit().
				getImage("graphics/aaa.jpg");
	}
	
	@Override
	public void paint(Graphics g) {
		g.drawImage(img, 0, 0, this);
	}
	
	public static void main(String[] args) {
		new ImageViewsEx1();
	}
}





