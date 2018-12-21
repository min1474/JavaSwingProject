package home;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.SwingConstants;

import dao.MemberDAO;
import dto.MemberDTO;
import mypage.MyPageFrame;


import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Login extends JFrame {
	private JTextField inputId;
	private JTextField inputPassword;
	public static String tosID = "";
	
	public Login() {
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		
		getContentPane().setLayout(null);
		
		JLabel eventImage = new JLabel("");
		eventImage.setForeground(Color.WHITE);
		eventImage.setIcon(new ImageIcon("./img/home/christmas02.gif"));
		eventImage.setHorizontalAlignment(SwingConstants.CENTER);
		eventImage.setBackground(Color.WHITE);
		eventImage.setBounds(12, 10, 270, 92);
		getContentPane().add(eventImage);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("./img/home/christmas01.png"));
		lblNewLabel.setBounds(12, 115, 270, 238);
		getContentPane().add(lblNewLabel);
		
		JLabel loginForm = new JLabel("");
		loginForm.setIcon(new ImageIcon("./img/home/login.png"));
		loginForm.setBounds(309, 161, 357, 154);
		getContentPane().add(loginForm);
		
		JLabel loginRestaurant = new JLabel("");
		loginRestaurant.setIcon(new ImageIcon("./img/home/loginrestarunt.png"));
		loginRestaurant.setBounds(346, 36, 198, 129);
		getContentPane().add(loginRestaurant);
		
		JButton loginCheckButton = new JButton("");
		loginCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});
		loginCheckButton.setIcon(new ImageIcon("./img/home/logincheckbutton.png"));
		loginCheckButton.setBackground(Color.WHITE);
		loginCheckButton.setForeground(Color.WHITE);
		loginCheckButton.setBounds(386, 315, 106, 38);
		getContentPane().add(loginCheckButton);
		loginCheckButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		loginCheckButton.setContentAreaFilled(true);
		loginCheckButton.setFocusPainted(false);
		loginCheckButton.setOpaque(true);
		
		JButton loginSignup = new JButton("");
		loginSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new SignUp();
			}
		});
		loginSignup.setIcon(new ImageIcon("./img/home/loginsignup.png"));
		loginSignup.setOpaque(true);
		loginSignup.setForeground(Color.WHITE);
		loginSignup.setFocusPainted(false);
		loginSignup.setContentAreaFilled(true);
		loginSignup.setBorderPainted(false);
		loginSignup.setBackground(Color.WHITE);
		loginSignup.setBounds(556, 10, 106, 38);
		getContentPane().add(loginSignup);
		
		inputId = new JTextField("아이디를 입력하세요");
		inputId.setForeground(Color.GRAY);
		inputId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				inputId.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				inputId.setForeground(Color.gray);		
			}
		});
		inputId.setBounds(357, 184, 295, 32);
		getContentPane().add(inputId);
		
		inputId.setColumns(10);
		inputId.setBorder(null);// 입력창 태두리삭제

		
		inputPassword = new JPasswordField("비밀번호를 입력하세요");
		inputPassword.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				inputPassword.setText("");
			}
		});

		inputPassword.setBounds(357, 262, 295, 32);
		getContentPane().add(inputPassword);
		inputPassword.setBorder(null);// 입력창 태두리삭제

		
		JButton findAccountButton = new JButton("Forget Passoword?");
		findAccountButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FindPassword find = new FindPassword();
				dispose();
			}
		});
		findAccountButton.setForeground(Color.LIGHT_GRAY);
		findAccountButton.setFocusPainted(false);
		findAccountButton.setContentAreaFilled(true);
		findAccountButton.setBorderPainted(false);
		findAccountButton.setBackground(Color.WHITE);
		findAccountButton.setBounds(504, 331, 148, 15);
		getContentPane().add(findAccountButton);
		


		setLocation(900, 200);
		setSize(700, 400);
		setResizable(false);// 프레임 창의 사이즈를 고정		
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	}
	
	public void checkLogin() {
		
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.login(inputId.getText());
		
		if(dto != null) {
			if(inputId.getText().equals(dto.getId()) && inputPassword.getText().equals(dto.getPw())) {
				JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
				tosID = dto.getId();
				dispose();
				new MyPageFrame();
			}else if(inputId.getText().equals(dto.getId()) && inputPassword.getText() != dto.getPw()) {
				JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
		}
		
	}
}
