package awt;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ChoiceEx2 extends MFrame 
implements ItemListener{
	
	String sair[] = {"대한항공","아시아나","에어부산","진에어"};
	String scity[] = {"서 울","대 전","대 구","부 산","제주도"};
	Choice air, city;
	
	public ChoiceEx2() {
		super(300, 300, new Color(100, 200, 100));
		air = new Choice();
		city = new Choice();
		for (int i = 0; i < sair.length; i++) {
			air.add(sair[i]);
		}
		for (int i = 0; i < scity.length; i++) {
			city.add(scity[i]);
		}
		add(air);
		add(city);
		air.addItemListener(this);
		city.addItemListener(this);
		add(new Label("  항공사와 도시를 선택하세요"));
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		repaint();//결과적으로 paint호출
	}
	
	@Override
	public void paint(Graphics g/*붓*/) {
		if(air==null||city==null)
			return;//메서드 중간 return은 이후에 코드의 무력화
		g.setColor(Color.BLUE);
		String str = "항공사 선택 : " + air.getSelectedItem();
		g.drawString(str, 30, 120);
		g.setColor(Color.RED);
		str = "도시 선택 : " + city.getSelectedItem();
		g.drawString(str, 30, 150);
	}
	
	public static void main(String[] args) {
		new ChoiceEx2();
	}

}
