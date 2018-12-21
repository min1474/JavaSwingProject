package home;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import dao.MemberDAO;
import dto.MemberDTO;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {

	private JTextField idField;
	private JTextField nameField;
	private JTextField emailField;
	private JTextField telField;
	private JTextField passwordField;
	private JTextField passwordCheck;

	public SignUp() {

		JLabel signUpHead = new JLabel("");
		signUpHead.setIcon(new ImageIcon("./img/home/signupform2.png"));
		signUpHead.setForeground(Color.WHITE);
		signUpHead.setBounds(0, 0, 374, 376);
		getContentPane().add(signUpHead);

		JButton signupButton = new JButton("");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				
				MemberDTO dto = new MemberDTO();;
				MemberDAO dao = new MemberDAO();
				
				if(passwordField.getText().equals(passwordCheck.getText())) {
					
					dto.setId(idField.getText()); // 입력된 아이디를 가져와 dto에 저장
					dto.setName(nameField.getText());
					dto.setEmail(emailField.getText());
					dto.setTel(telField.getText());
					dto.setPw(passwordField.getText());// 입력된 비밀번호를 가져와 dto에 저장
					
					dao.signUp(dto);
					dispose();
				
				}else {
					JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
				}		
			}
		});
		
		signupButton.setForeground(Color.WHITE);
		signupButton.setIcon(new ImageIcon("./img/home/signupbutton.png"));
		signupButton.setBounds(22, 386, 329, 41);
		getContentPane().add(signupButton);

		idField = new JTextField();
		idField.setBackground(Color.WHITE);
		idField.setForeground(Color.GRAY);
		idField.setText("아이디를 입력하세요");
		idField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				idField.setText("");

			}
		});
		idField.setBounds(57, 76, 287, 21);
		getContentPane().add(idField);
		idField.setColumns(10);
		idField.setBorder(null);// 입력창 태두리삭제

		nameField = new JTextField("이름을 입력하세요");
		nameField.setForeground(Color.GRAY);
		nameField.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				nameField.setText("");

			}
		});
		nameField.setBounds(57, 118, 294, 27);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		nameField.setBorder(null);// 입력창 태두리삭제

		emailField = new JTextField("이메일을 입력하세요");
		emailField.setForeground(Color.GRAY);
		emailField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailField.setText("");

			}

		});
		emailField.setColumns(10);
		emailField.setBounds(57, 175, 287, 27);
		getContentPane().add(emailField);
		emailField.setBorder(null);// 입력창 태두리삭제

		telField = new JTextField("-빼고 입력하세요");
		telField.setForeground(Color.GRAY);
		telField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				telField.setText("");
			}

		});

		telField.setColumns(10);
		telField.setBounds(57, 223, 287, 27);
		getContentPane().add(telField);
		telField.setBorder(null);// 입력창 태두리삭제

		passwordField = new JPasswordField("비밀번호를 입력하세요");
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(57, 271, 294, 27);
		getContentPane().add(passwordField);
		passwordField.setBorder(null);// 입력창 태두리삭제
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");
			}
		});

		passwordCheck = new JPasswordField("같은 비밀번호를 입력하세요");
		passwordCheck.setForeground(Color.GRAY);
		passwordCheck.setBounds(57, 329, 294, 27);
		getContentPane().add(passwordCheck);
		passwordCheck.setBorder(null);// 입력창 태두리삭제
		passwordCheck.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordCheck.setText("");
			}
		});

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		setLocation(900, 200);
		setSize(390, 500);
		setVisible(true);

	}
}
