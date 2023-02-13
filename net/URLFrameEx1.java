package net;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;



public class URLFrameEx1 extends MFrame implements ActionListener {

	TextArea ta;
	TextField tf;
	Button connect;
	Button save;
	URL url;

	public URLFrameEx1() {
		super(500, 500);
		setTitle("ViewHost");
		Panel p = new Panel();
		p.add(tf = new TextField("http://", 40));
		p.add(connect = new Button("connect"));
		p.add(save = new Button("save"));
		ta = new TextArea();
		add(p, BorderLayout.NORTH);
		add(ta);
		save.setEnabled(false);
		connect.addActionListener(this);
		save.addActionListener(this);
		tf.addActionListener(this);
		validate();
	}

	@Override 
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==tf||obj==connect) {
			String host = tf.getText().trim();
			try {
				url = new URL(host);
			} catch (Exception e2) {
				ta.append("해당되는 호스트가 없습니다");
			}
			ta.setText("");
			connectHost(url);
			save.setEnabled(true);
		}else if(obj==save) {
			createFile(url.getHost(), ta.getText());
			save.setEnabled(false);
			tf.setText("http://");
			ta.setText("");
			ta.append("저장하였습니다");
			tf.requestFocus();
		}
	}
	
	//독립적인 기능은 최대한 세부적으로 구현
	public void connectHost(URL url) {
		try {
			BufferedReader br = new BufferedReader(
					new InputStreamReader(
							url.openStream(), "UTF-8"));
			String line = "";
			while(true) {
				line = br.readLine();
				if(line==null) break;
				ta.append(line+"\n");
			}
			br.close();
		} catch (Exception e) {
			ta.append("해당하는 호스트가 없습니다");
		}
	}
	
	public void createFile(String file, String content) {
		try {
			FileWriter fw = new FileWriter("net/"+file+".html");
			fw.write(content);
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		URLFrameEx1 ex = new URLFrameEx1();
	}
}












