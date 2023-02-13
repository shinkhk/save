package ch06;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class ThisEx3 extends MFrame 
implements ActionListener{
	
	Button btn;
	Random r;
	
	public ThisEx3() {
		super();
		//super(500, 350, Color.GREEN, true);
		r = new Random();
		btn = new Button("my Button");
		btn.setBackground(rColor());
		add(btn, "South");
		btn.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		//System.out.println("보이나요?");
		MDialog md = new MDialog(this, "보이나요");
		
	}
	
	public  Color rColor(){
		int rr, gg, bb;
		rr = r.nextInt(256);
		gg = r.nextInt(256);
		bb = r.nextInt(256);
		return new Color(rr, gg, bb);
	}
	
	class MDialog extends Dialog 
	implements ActionListener{
		
		Button mbtn;
		ThisEx3 f;
		
		public MDialog(ThisEx3 f, String title) {
			super(f, title, true);
			this.f = f;
			setLayout(new FlowLayout());
			setSize(150, 100);
			mbtn = new Button("Click!");
			mbtn.setBackground(rColor());
			mbtn.addActionListener(this);
			add(mbtn);
			setVisible(true);
		}
		
		
		@Override
		public void actionPerformed(ActionEvent e) {
			f.btn.setBackground(rColor());
			dispose();//자신의 창이 사라짐
		}
	}
	
	
	public static void main(String[] args) {
		new ThisEx3();
	}

}
