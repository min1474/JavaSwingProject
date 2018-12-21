package service;

import java.awt.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;

public class ServiceServerCenter extends JFrame implements ActionListener {

	// 서버측 소켓 생성
	ServerSocket serverSocket = null;
	Socket socket = null;

	List list = new List();
	HashMap clients;
	JTextField portTextField;
	JButton serverStartButton = new JButton("서버 시작");
	JButton serverCloseButton = new JButton("서버 종료");

	public ServiceServerCenter() {

		clients = new HashMap();
		Collections.synchronizedMap(clients);// 동기화 처리

		JLabel noticeLabel = new JLabel("[고객채팅 서버 구동방법]");
		noticeLabel.setBounds(12, 10, 153, 15);
		getContentPane().add(noticeLabel);
		JLabel noticeLabel2 = new JLabel("1. 포트 7000 입력 후  서버 시작 버튼 눌러 서버를 구동시킨다.");
		getContentPane().add(noticeLabel2);
		noticeLabel2.setBounds(22, 35, 366, 15);
		JLabel noticeLabel3 = new JLabel("2. 관리자 채팅 시작을 눌러 고객과의 채팅을 준비한다.");
		noticeLabel3.setBounds(22, 55, 354, 15);
		getContentPane().add(noticeLabel3);
		JLabel noticeLabel5 = new JLabel("3. 현재 창은 절대!! 끄지 말고 화면 구석에 배치해서 켜 놓는다.");
		noticeLabel5.setBounds(22, 75, 354, 15);
		getContentPane().add(noticeLabel5);
		JLabel noticeLabel6 = new JLabel("4. 영업이 끝나면 서버 종료를 눌러서 연결을 끊다.");
		noticeLabel6.setBounds(22, 95, 281, 15);
		getContentPane().add(noticeLabel6);

		JLabel portLabel = new JLabel("Port");
		portLabel.setHorizontalAlignment(SwingConstants.CENTER);
		portLabel.setFont(new Font("굴림", Font.BOLD, 20));
		portLabel.setBounds(14, 124, 57, 24);
		getContentPane().add(portLabel);

		portTextField = new JTextField();
		portTextField.setBounds(69, 124, 57, 24);
		getContentPane().add(portTextField);
		portTextField.setColumns(10);

		serverStartButton.setForeground(Color.WHITE);
		serverStartButton.setBackground(Color.GRAY);
		serverStartButton.setBounds(126, 124, 97, 23);
		getContentPane().add(serverStartButton);
		serverStartButton.addActionListener(this);
		
		JButton startCahtButton = new JButton("관리자 채팅 접속");
		startCahtButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServiceAdminFrame adminChat = new ServiceAdminFrame();
			}
		});
		startCahtButton.setForeground(Color.WHITE);
		startCahtButton.setBackground(Color.GRAY);
		startCahtButton.setBounds(225, 124, 140, 23);
		getContentPane().add(startCahtButton);

		serverCloseButton.setForeground(Color.WHITE);
		serverCloseButton.setBackground(Color.GRAY);
		serverCloseButton.setBounds(377, 124, 97, 23);
		getContentPane().add(serverCloseButton);
		serverCloseButton.addActionListener(this);

		list.setSize(464, 310);
		list.setLocation(12, 154);
		getContentPane().add(list);

		getContentPane().setLayout(null);
		setVisible(true);
		setSize(500, 513);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if (obj == serverStartButton) {
			int portNum = Integer.parseInt(portTextField.getText());
			start(portNum);
		} else if (obj == serverCloseButton) {
			System.exit(0);
		}

	}

	public void start(int port) {

		try {
			serverSocket = new ServerSocket(port);
			list.add("서버 설정이 완료되었습니다. 채팅 시작으로 고객과 대화를 준비하세요");
			Thread t1 = new StartThread();
			t1.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // start()

	// 클라이언트가 데이터를 입력하면 모든 클라이언트에게 데이터 전달
	void sendToAll(String msg) {
		Iterator it = clients.keySet().iterator();

		while (it.hasNext()) {
			try {
				DataOutputStream out = (DataOutputStream) clients.get(it.next());
				out.writeUTF(msg);
			} catch (IOException e) {
			}
		} // while
	} // sendToAll

	// ServerReceiver thread 호출하는 클래스
	class StartThread extends Thread {
		public void run() {
			while (true) {
				try {
					socket = serverSocket.accept();
				} catch (IOException e) {
					e.printStackTrace();
				}
				list.add("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "접속 하였습니다");
				ServerReceiver thread = new ServerReceiver(socket);
				thread.start();
			}
		}
	}

	class ServerReceiver extends Thread {
		Socket socket;
		DataInputStream in;
		DataOutputStream out;

		ServerReceiver(Socket socket) {
			this.socket = socket;
			try {
				in = new DataInputStream(socket.getInputStream());
				out = new DataOutputStream(socket.getOutputStream());
			} catch (IOException e) {
			}
		}

		// 쓰레드는 클라이언트가 추가될 때 마다 생긴다
		public void run() {
			System.out.println(Thread.currentThread());
			String name = "";
			try {
				name = in.readUTF();
				sendToAll("#" + name + "접속");

				clients.put(name, out);
				list.add("현재 서버접속자 수는 " + clients.size() + "명 입니다.");
				while (in != null) {
					sendToAll(in.readUTF());
				}
			} catch (IOException e) {
				// ignore
			} finally {
				sendToAll("#" + name + "Client out...");
				clients.remove(name);
				list.add("[" + socket.getInetAddress() + ":" + socket.getPort() + "]" + "에서 접속을 종료하였습니다.");
				list.add("현재 서버접속자 수는 " + clients.size() + "입니다.");
				list.add("Now Connect People " + clients.size());
			} // try
		} // run
	} // ReceiverThread
	
	public static void main(String[] args) {
		new ServiceServerCenter();
	}

}
