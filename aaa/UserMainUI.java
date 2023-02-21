package aaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.PublicKey;


public class UserMainUI extends JFrame {
	
	private JLabel RemainTime;
	private JLabel notification;
	private JLabel ManagerPhone;
	private JLabel ManagerNumber;
	private JLabel ManagerEmail;
	private JLabel picture;
	private JLabel quest;
	private JButton addpay;
	private JButton exit;
	private JList list;
	DefaultListModel model = new DefaultListModel();
	
	

	private JButton answerButton;//댭변버튼
	private JButton questButton;//질문버튼

	ImageIcon img=new ImageIcon("./Button_Image/addpay.jpg");
	ImageIcon imgexit=new ImageIcon("./Button_Image/exit.jpg");
	
	
	
	public UserMainUI() {
        setTitle("UserMain");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(true);
		this.setVisible(true);
		
		this.setSize(1100,700);
		this.setLocationRelativeTo(null);
		
		JPanel panel1 = new JPanel();
        UserMainUIPanel(panel1);
        
        panel1.setBounds(0,0,700,700);
        getContentPane().add(panel1);
        
		JPanel panel2 = new JPanel();
		QuestionPanel(panel2);
        
        panel2.setBounds(800,0,300,700);
        getContentPane().add(panel2);
        

        setVisible(true);
        
        
        
	}
	
	public void UserMainUIPanel(JPanel panel)
	{
		panel.setLayout(null);
		
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		JLabel remaintime=new JLabel("남은 시간:");
		remaintime.setBounds(400,0,100,50);
		remaintime.setFont(font);
		panel.add(remaintime);
		
		//관리자 전화번호 뜨게하기
		
		JLabel ManagerPhone = new JLabel("관리자 연락처:");
		ManagerPhone.setBounds(400, 20, 300, 50);
		ManagerPhone.setFont(font);
		panel.add(ManagerPhone);
		
		
		//관리자이메일 뜨게하기

		JLabel managerEmail=new JLabel("관리자이메일:");
		managerEmail.setBounds(400,40,300,50);
		managerEmail.setFont(font);
		panel.add(managerEmail);
		
		picture = new JLabel();
        picture.setIcon(new ImageIcon("./Button_Image/book.jpg"));
        picture.setBounds(0, 100, 700,365);
        panel.add(picture);
        
        JButton addpay=new JButton(img);
        addpay.setBounds(0,465,350,200);
        panel.add(addpay);
        
        JButton exit=new JButton(imgexit);
        exit.setBounds(350,465,350,200);
        panel.add(exit);
        
        
        
        panel.setBackground(Color.pink);
        
        //추가결제 기능
        addpay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {

				
			}
		});
        
        //퇴실 기능
        exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
        
		
	}
	
	public void QuestionPanel(JPanel panel)
	{
		panel.setLayout(null);
		Font font=new Font("맑은 고딕", Font.PLAIN, 17);
		
		//질문리스트들
		JList questList=new JList();
		questList.setFont(font);	
		questList.setModel(model);
		model.addElement("질문1");
		model.addElement("질문2");
		questList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);	
		questList.setBounds(730, 100, 320, 500);
		panel.add(questList);
		
		
		JLabel quest=new JLabel("질문");
		quest.setBounds(880,50,100,50);
		quest.setBackground(Color.cyan);
		quest.setFont(font);
		panel.add(quest);
		
		
		JButton questButton=new JButton("질문하기");
		questButton.setBounds(700,615,192,50);
		questButton.setBackground(Color.yellow);
		questButton.setFont(font);
		panel.add(questButton);
		
		JButton answerButton=new JButton("답변하기");
		answerButton.setBounds(892,615,192,50);
		answerButton.setBackground(Color.yellow);
		answerButton.setFont(font);
		panel.add(answerButton);
		panel.setBackground(new Color(204,204,204));
		
		
		//질문하기버튼
		questButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//창넘어가기
				model.addElement("질문추가");
			}
		});
		
		
       
	}
	public static void main(String[] args) {
		new UserMainUI();
	}



}
