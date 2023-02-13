package member2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ZipcodeFrame extends Frame implements ActionListener{

	JLabel label;
	JButton searchBtn, selectBtn;
	List list;
	TextField tf;
	JPanel p1,p2;
	MemberMgr mgr;
	DialogBox err1, err2;
	MemberAWT2 awt;
	
	public ZipcodeFrame(MemberAWT2 awt) {
		this.awt = awt;
		setTitle("ZipcodeFrame");
		//setBounds(w,y,w,h) : awt���� ������ ���� ȣ���.
		setBounds(awt.getX()+awt.getWidth(),awt.getY(),300,500);
		mgr = new MemberMgr();
		p1=new JPanel();
		p1.setBackground(Color.LIGHT_GRAY);
		p1.add(label = new JLabel ("���θ�:",label.CENTER));
		p1.add(tf = new TextField("�������",15));
		p1.add(searchBtn = new JButton("�˻�"));
		tf.addActionListener(this);
		searchBtn.addActionListener(this); 
		//////////////////////////////////////
		list = new List();
		list.addActionListener(this);
		//////////////////////////////////////
		p2=new JPanel();
		p2.add(selectBtn = new JButton("����"));
		selectBtn.addActionListener(this);
		p2.setBackground(Color.LIGHT_GRAY);
		///////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}
		});
		add(p1,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
		tf.requestFocus();
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//��� Ŭ���� ��ü�� Object�� ���۷��� �� �� �ִ�.
		//Object obj1 = new String(); // ��ü �Һ��� ��Ģ
		Object obj = e.getSource();
		if(obj==searchBtn || obj==tf) {
			if(tf.getText().trim().length()==0) {
				if(err1==null) {
					err1 = new DialogBox(this, "�˸�", "�˻�� �Է��ϼ���.");
			}else {
				err1.setLocation(this.getX()+this.getWidth()/2-(err1.getWidth()/2),this.getY()+this.getHeight()/2-(err1.getHeight()/2));
				err1.setVisible(true);
				}
			} else { // �˻������ list�� �߰�
				list.removeAll(); // ���� �˻������ ����
				Vector<ZipcodeBean> vlist = mgr.getZipcodeList(tf.getText());
				if(vlist.isEmpty()) {
					if(err2==null) {
						err2 = new DialogBox(this, "�˸�", "�˻� ����� �����ϴ�.");
				}else {
					err2.setLocation(this.getX()+this.getWidth()/2-(err2.getWidth()/2),this.getY()+this.getHeight()/2-(err2.getHeight()/2));
					err2.setVisible(true);
					}
					tf.setText("");
				}else {
					for(int i=0; i<vlist.size();i++) {
						ZipcodeBean bean = vlist.get(i);
						String str = bean.getZipcode()+" ";
						str += bean.getArea1()+" ";
						str += bean.getArea2()+" ";
						str += bean.getArea3()+" ";
						list.add(str);
					}
				}
			}
		}else if(obj==list || obj==selectBtn) {
			String adds = list.getSelectedItem();
			awt.tf4.setText(adds);
			list.removeAll();
			dispose();
		}
	}

}









