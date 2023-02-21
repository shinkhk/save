package awt;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.TextField;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FristScreen extends JFrame {
		
		JLabel la1, la2;
		TextField tf1, tf2;
		JButton btn1,btn2;
		ImageIcon fristimage;

	public FristScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		fristimage = new ImageIcon("awt/main.jpg");
		
		JPanel panel = new JPanel() {
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(fristimage.getImage(), 0, 0, null);
				setOpaque(false);
			}
		};
		
		panel.setLayout(null);
		panel.setBounds(0, 0, 1200, 600);
		panel.setBackground(Color.LIGHT_GRAY);	
		add(panel);

		
		panel.add(la1 = new JLabel("ID"));
		panel.add(tf1 = new TextField("",10));
		panel.add(la2 =new JLabel("��й�ȣ"));
		panel.add(tf2 = new TextField("",10));

		//#1 ����) ��,�ؽ�Ʈ ��ġ ����
		la1.setBounds(300,500,20,30);
		tf1.setBounds(330,500, 90,30);
		la2.setBounds(430, 500, 60, 30);
		tf2.setBounds(490, 500, 90, 30);		

		btn1 = new JButton("�α���"); 
		btn2= new JButton("���θ����"); 
		// ����) ��ư ��ġ,ũ�� ����
		btn1.setBounds(630, 500, 100, 30);
		btn2.setBounds(780, 500, 100, 30);			
		panel.add(btn1);
		panel.add(btn2);		
		
		setSize(1200, 600);
		setVisible(true);
		//setResizable(false);
		validate();
	}
	
	
	public static void main(String[] args) {
		new FristScreen();
	}
}
