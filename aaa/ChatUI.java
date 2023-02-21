package aaa;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatUI extends JFrame {
    private JTextField textField;
    private JTextArea textArea;
    private JList<String> userList;

    public ChatUI() {
        super("채팅");

        textField = new JTextField(30);
        textArea = new JTextArea(10, 30);
        userList = new JList<String>(new String[]{"유저1", "유저2", "유저3"});

        JScrollPane scrollPane = new JScrollPane(textArea);
        JScrollPane userListScrollPane = new JScrollPane(userList);
        textArea.setEditable(false);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(new Dimension(700, 50));
        bottomPanel.setLayout(new BorderLayout());
        bottomPanel.add(textField, BorderLayout.CENTER);
        JButton sendButton = new JButton("전송");
        bottomPanel.add(sendButton, BorderLayout.EAST);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        buttonPanel.setPreferredSize(new Dimension(150, 50));
        JButton exitButton = new JButton("나가기");
        buttonPanel.add(exitButton, BorderLayout.CENTER);

        userListScrollPane.setPreferredSize(new Dimension(150, 500));
        userListScrollPane.setMaximumSize(new Dimension(150, Integer.MAX_VALUE));
        sendButton.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));

        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        userPanel.setPreferredSize(new Dimension(150, 100));
        userPanel.add(userListScrollPane, BorderLayout.CENTER);
        userPanel.add(buttonPanel, BorderLayout.SOUTH);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        add(userPanel, BorderLayout.EAST);

        setPreferredSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);

        textField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });

        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
    }

    private void sendMessage() {
        String message = textField.getText();
        if (message.trim().length() > 0) {
            textArea.append("나: " + message + "\n");
            textField.setText("");
        }
    }

    public static void main(String[] args) {
        new ChatUI();
    }
}