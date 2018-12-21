package service;

import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import java.awt.Font;

public class ServiceClientFrame extends JFrame implements ActionListener, KeyListener {

	JButton callButton = new JButton("상담원호출");
	JTextField inputTextField;
	JTextField nameField;
	List list = new List();
	String name = "";

	// 소켓의 생성
	Socket socket;
	DataOutputStream out;

	public ServiceClientFrame() {
		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		JLabel nameLabel = new JLabel("이름");
		nameLabel.setFont(new Font("굴림", Font.BOLD, 15));
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setBounds(316, 109, 47, 22);
		getContentPane().add(nameLabel);

		nameField = new JTextField();
		nameField.setBounds(363, 110, 85, 22);
		getContentPane().add(nameField);
		nameField.setColumns(10);

		callButton.setForeground(Color.WHITE);
		callButton.setBackground(Color.GRAY);
		callButton.setBounds(449, 110, 100, 22);
		getContentPane().add(callButton);
		callButton.addActionListener(this);

		list.setSize(450, 341);
		list.setLocation(316, 141);
		getContentPane().add(list);

		inputTextField = new JTextField();
		inputTextField.setFont(new Font("굴림", Font.BOLD, 15));
		inputTextField.setBounds(316, 488, 387, 41);
		getContentPane().add(inputTextField);
		inputTextField.setColumns(10);
		inputTextField.addKeyListener(this);

		JButton enterButton = new JButton("입력");
		enterButton.setForeground(Color.WHITE);
		enterButton.setBackground(Color.GRAY);
		enterButton.setBounds(702, 488, 64, 40);
		getContentPane().add(enterButton);

		JLabel clientFormLabel = new JLabel("");
		clientFormLabel.setBackground(Color.WHITE);
		clientFormLabel.setIcon(new ImageIcon("./img/service/clientForm.png"));
		clientFormLabel.setBounds(12, 10, 764, 529);
		getContentPane().add(clientFormLabel);
		setVisible(true);
		setSize(799, 591);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				out.writeUTF("[" + name + "]" + inputTextField.getText());
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			inputTextField.setText("");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Object obj = e.getSource();
		if (obj == callButton) {
//			String uip = ipField.getText();
//			int uport = Integer.parseInt(portField.getText());
			String uip = "127.0.0.1";
			int uport = 7000;
			name = nameField.getText();
			init(name, uip, uport);
			list.add("상담원관 연결되었습니다. 대화를 시작해주세요^^");
		}

	}

	public void init(String name, String uip, int uport) {
		try {
			String serverIp = uip;
			// 소켓을 생성하여 연결을 요청한다.
			socket = new Socket(serverIp, uport);
			out = new DataOutputStream(socket.getOutputStream());
			System.out.println("상담원과 연결되었습니다.");
			// 접속자 이름전송
			out.writeUTF(name);

			// Thread sender = new Thread(new ClientSender(socket, uid));
			Thread receiver = new Thread(new ClientReceiver(socket));

			// sender.start();
			receiver.start();
		} catch (ConnectException ce) {
			ce.printStackTrace();
		} catch (Exception e) {
		}
	}

	class ClientReceiver extends Thread {
		Socket socket;
		DataInputStream in;

		ClientReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
			} catch (IOException e) {
			}
		}

		public void run() {
			while (in != null) {
				try {
					String re = in.readUTF();
					System.out.println(re);
					list.add(re);
				} catch (IOException e) {
				}
			}
		} // run
	}// end class ClientReceiver
	
	public static void main(String[] args) {
		
		new ServiceClientFrame();
	
	}

}
