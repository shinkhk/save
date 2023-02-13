package talk;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.ChatProtocol3;



public class TalkClient extends JFrame 
implements ActionListener, Runnable{
	
	JButton btn1, btn2;
	JTextField tf1, tf2;
	TextArea ta;
	JPanel  p1, p2;
	BufferedReader in;
	PrintWriter out;
	boolean flag = false;
	String id;
	public static final int PORT = 8001;
	
	public TalkClient(BufferedReader in, PrintWriter out, String id) {
		setSize(350, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Talk1.0" + " - " + id + "�� �ݰ����ϴ�.");
		this.in = in;
		this.out = out;
		this.id = id; 
		p1 = new JPanel();
		p1.setBackground(new Color(100,200,100));
		p1.add(btn1 = new JButton("save"));
		
		p2 = new JPanel();
		p2.setBackground(new Color(100,200,100));
		p2.add(new Label("CHAT ",Label.CENTER));
		p2.add(tf2 = new JTextField("",15));
		p2.add(btn2 = new JButton("SEND"));	
		
		tf2.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		
		add(p1,BorderLayout.NORTH);
		add(ta=new TextArea());
		add(p2,BorderLayout.SOUTH);
		
		new Thread(this).start();
		setVisible(true);
		validate();
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn1/*save*/) {
			String content = ta.getText();
			//1970��1��1�� ~������� 1/1000�� ������ ���
			long fileName = System.currentTimeMillis();
			try {
				FileWriter fw = new FileWriter("net/"+fileName+".txt");
				fw.write(content);
				fw.close();
				ta.setText("");
				new MDialog(this, "Save", "��ȭ������ �����Ͽ����ϴ�.");
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} 
		if(obj==tf2||obj==btn2/*send*/) {
			String str = tf2.getText().trim();
			if(filterMgr(str)) {
				new MDialog(this, "���", "�Է��Ͻ� ��¥�� �������Դϴ�.");
				return;
			}
			if(str.length()==0)
				return;//������ �������� �ʰ� �޼��� ���� ����
			sendMessage(ChatProtocol3.CHATALL+ChatProtocol3.MODE+str);;//���� ����
			tf2.setText("");
			tf2.requestFocus();
		}
	}//--actionPerformed
	
	@Override //������ ���� �޼����� ������ �����ϴ� ���
	public void run() {
		try {
			while(true) {
				String line = in.readLine();
				int idx = line.indexOf(ChatProtocol3.MODE);
				String cmd = line.substring(0, idx);
				String data = line.substring(idx+1);
					if(cmd.equals(ChatProtocol3.CHAT)||
							cmd.equals(ChatProtocol3.CHATALL)){
						ta.append(data+"\n");
					}
				tf2.requestFocus();
			}
		} catch (Exception e) {
			System.err.println("Error in run");
			e.printStackTrace();
		}
	}//--run
	
	public boolean filterMgr(String msg){
		boolean flag = false;//false�̸� ������ �ƴ�
		String str[] = {"�ٺ�","������","����","�ڹ�","java"};
		//msg : ���� ȣȣ ����
		StringTokenizer st = new StringTokenizer(msg);//�����ϸ� �����ڴ� ����
		String msgs[] = new String[st.countTokens()];
		for (int i = 0; i < msgs.length; i++) {
			msgs[i] = st.nextToken();
		}
		for (int i = 0; i < str.length; i++) {
			if(flag) break;//ù��° for�� ��������.
			for (int j = 0; j < msgs.length; j++) {
				if(str[i].equalsIgnoreCase(msgs[j])) {
					flag = true;
					break; //�ι�° for�� ��������.
				}//if
			}//for2
		}//for1
		return flag;
	}
	
	class MDialog extends Dialog implements ActionListener{
		
		Button ok;
		TalkClient ct3;
		
		public MDialog(TalkClient ct3,String title, String msg) {
			super(ct3, title, true);
			this.ct3 = ct3;
			 //////////////////////////////////////////////////////////////////////////////////////////
			   addWindowListener(new WindowAdapter() {
			    public void windowClosing(WindowEvent e) {
			     dispose();
			    }
			   });
			   /////////////////////////////////////////////////////////////////////////////////////////
			   setLayout(new GridLayout(2,1));
			   Label label = new Label(msg, Label.CENTER);
			   add(label);
			   add(ok = new Button("Ȯ��"));
			   ok.addActionListener(this);
			   layset();
			   setVisible(true);
			   validate();
		}
		
		public void layset() {
			int width = 200;
			int height = 100;
			setSize(width, height);
			setLocationRelativeTo(ct3);
			setVisible(true);
		}

		public void actionPerformed(ActionEvent e) {
			tf2.setText("");
			dispose();
		}
	}
	
	public void sendMessage(String msg) {
		out.println(msg);
	}
	
	
}



