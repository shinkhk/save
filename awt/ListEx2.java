package awt;

import java.awt.Button;
import java.awt.Label;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class ListEx2 extends MFrame implements ItemListener, ActionListener {

	List list1, list2;
	Label label1, label2;
	String team1[] = { "A", "B", "C", "D", "E" };
	String team2[] = {};
	Button btn1, btn2;
	
	
	public ListEx2() {
		list1 = new List(3, false);
		for (int i = 0; i < team1.length; i++) {
			list1.add(team1[i]);
		}

		list2 = new List(4, true);

		add(list1);
		add(list2);
		add(label1 = new Label("team1:                               "));
		add(label2 = new Label("team2:                               "));
		list1.addItemListener(this);
		list2.addItemListener(this);

		validate();
	}

	public void actionPerformed(ActionEvent e) {
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		String str1 = list1.getSelectedItem();
		label1.setText("team1:" + str1);
		str1 = "";
		String str2[] = list2.getSelectedItems();
		for (int i = 0; i < str2.length; i++) {
			str1 += str2[i] + "";
		}
		label2.setText("team2:" + str1);
	}

	public static void main(String[] args) {
		new ListEx2();
	}

}
