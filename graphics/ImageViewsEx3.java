package graphics;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ImageViewsEx3 extends JFrame 
implements ActionListener{
	
	Image img;
	JButton btn[] = new JButton[6];
	String str[] = {"정상그림","일부그림","축소그림","좌우뒤집기"
			,"상하뒤집기","전부뒤집기"};
	int idx;
	String name;
	
	static final int SHOW_NORM = 0;//정상그림
	static final int SHOW_PART = 1;//일부그림
	static final int SHOW_SCALE = 2;//축소그림
	static final int SHOW_HORIZONTAL = 3;//좌우뒤집기
	static final int SHOW_VERTICAL = 4;//상하뒤집기
	static final int SHOW_ALL = 5;//전부뒤집기
	
	public ImageViewsEx3(String name) {
		setSize(600,400);
		this.name = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel p = new JPanel();
		for (int i = 0; i < btn.length; i++) {
			p.add(btn[i]=new JButton(str[i]));
			btn[i].addActionListener(this);
		}
		img = Toolkit.getDefaultToolkit().
				getImage("graphics/"+name);
		add(p, BorderLayout.SOUTH);
		setResizable(false);
		setVisible(true);
		idx = SHOW_NORM;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		setTitle(name + " - " + str[idx]);
		int iw = img.getWidth(this);
		int ih = img.getHeight(this);
		switch (idx) {
		case SHOW_NORM:
			g.drawImage(img, 0, 0, iw, ih, /*컨테이너 좌표*/
					0, 0, iw, ih /*이미지좌표*/, this);
			break;
		case SHOW_PART:
			g.drawImage(img, 100, 100, 300, 300, /*컨테이너 좌표*/
					220, 20, 420, 220 /*이미지좌표*/, this);
			break;
		case SHOW_SCALE:
			g.drawImage(img, 0, 0, iw/2, ih/2, /*컨테이너 좌표*/
					0, 0, iw, ih /*이미지좌표*/, this);
			break;
		case SHOW_HORIZONTAL:
			g.drawImage(img, iw, 0, 0, ih, /*컨테이너 좌표*/
					0, 0, iw, ih /*이미지좌표*/, this);
			break;
		case SHOW_VERTICAL:
			g.drawImage(img, 0, ih, iw, 0, /*컨테이너 좌표*/
					0, 0, iw, ih /*이미지좌표*/, this);
			break;
		case SHOW_ALL:
			g.drawImage(img, iw, ih, 0, 0, /*컨테이너 좌표*/
					0, 0, iw, ih /*이미지좌표*/, this);
			break;
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		for (int i = 0; i < btn.length; i++) {
			if(obj==btn[i]) {
				idx = i;
				break;
			}
		}
		repaint();
	}
	
	public static void main(String[] args) {
		new ImageViewsEx3("aaa.png");
	}
}







