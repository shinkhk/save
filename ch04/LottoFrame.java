package ch04;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Arrays;
import java.util.Random;


public class LottoFrame extends Frame 
implements ActionListener{
	
	Button btn;
	int lotto[] = new int[6];
	
	public LottoFrame() {
		setSize(400, 200);
		setBackground(Color.gray);
		setVisible(true);
		btn = new Button("Lotto Click");
		btn.addActionListener(this);
		add(btn,BorderLayout.SOUTH);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		new LottoFrame();
	}

	public void paint(Graphics g){
		g.setColor(Color.white);
		Font f = new Font("궁서체",Font.BOLD,25);
		g.setFont(f);
		if(lotto[0]==0){
			g.drawString("로또 버튼을 클릭하세요.", 50, 100);
			return;
		}
		for (int i = 0, x =50; i < lotto.length; i++, x+=50) {
			g.drawString(lotto[i]+"", x , 100);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		lotto = getLotto();
		repaint();
	}

	public int[] getLotto(){
		int lotto[] = new int[6];
		//배열 밑에 항상 for문 있다.
		//중복로직 추가
		boolean isNumThere = false;
		for (int i = 0; i < lotto.length; i++) {
			isNumThere = false;
			lotto[i] = (int)(Math.random()*45)+1;
			for (int j = 0; j < i; j++) {
				if(lotto[i]==lotto[j]) {
					isNumThere = true;
				}
			}
			if(isNumThere)
				i--;
		}
		Arrays.sort(lotto);//올럼차순 정렬
		return lotto;
	}
}
