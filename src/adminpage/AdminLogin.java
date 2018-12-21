package adminpage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.MemberDAO;
import dao.AdminDAO;
import dto.MemberDTO;
import dto.AdminDTO;
import mypage.MyPageFrame;

public class AdminLogin extends JFrame {
	
	private JTextField adminIdField;
	private JTextField adminPasswordField;
	public static String tosAdminID = "";

	public AdminLogin() {

		getContentPane().setBackground(Color.WHITE);
		getContentPane().setForeground(Color.WHITE);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		JButton adminLoginButton = new JButton("");
		adminLoginButton.setIcon(new ImageIcon("./img/admin/adminloginbutton.png"));
		adminLoginButton.setBackground(Color.WHITE);
		adminLoginButton.setForeground(Color.WHITE);
		adminLoginButton.setBounds(47, 154, 107, 38);
		getContentPane().add(adminLoginButton);
		adminLoginButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		adminLoginButton.setContentAreaFilled(true);
		adminLoginButton.setFocusPainted(false);
		adminLoginButton.setOpaque(true);
		adminLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkLogin();
			}
		});

		JButton adminFindButton = new JButton("Forget Password?");
		adminFindButton.setForeground(Color.GRAY);
		adminFindButton.setBackground(Color.WHITE);
		adminFindButton.setBounds(31, 233, 142, 14);
		getContentPane().add(adminFindButton);
		adminFindButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		adminFindButton.setContentAreaFilled(true);
		adminFindButton.setFocusPainted(false);
		adminFindButton.setOpaque(true);
		adminFindButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				FindAdminPassword findadmin = new FindAdminPassword();
			}
		});

		adminIdField = new JTextField("이메일을 입력하세요");
		adminIdField.setForeground(Color.GRAY);
		adminIdField.setBounds(264, 154, 297, 31);
		getContentPane().add(adminIdField);
		adminIdField.setColumns(10);
		adminIdField.setBorder(null);// 입력창 태두리삭제
		adminIdField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				adminIdField.setText("");
			}

		});

		adminPasswordField = new JPasswordField("");
		adminPasswordField.setBounds(264, 233, 297, 31);
		getContentPane().add(adminPasswordField);
		adminPasswordField.setBorder(null);// 입력창 태두리삭제
		
				JLabel adminLoginform = new JLabel("");
				adminLoginform.setFont(new Font("Adobe Song Std L", Font.PLAIN, 12));
				adminLoginform.setBackground(Color.WHITE);
				adminLoginform.setForeground(Color.WHITE);
				adminLoginform.setIcon(new ImageIcon("./img/admin/adminlogin.png"));
				adminLoginform.setBounds(0, 0, 629, 306);
				getContentPane().add(adminLoginform);
		setLocation(900, 200);
		setSize(635, 335);
		setResizable(false);// 프레임 창의 사이즈를 고정
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙

	}
	
	public void checkLogin() {
		
		AdminDAO dao = new AdminDAO();
		AdminDTO dto = dao.login(adminIdField.getText());
		
		if(dto != null) {
			if(adminIdField.getText().equals(dto.getId()) && adminPasswordField.getText().equals(dto.getPw())) {
				JOptionPane.showMessageDialog(null, "관리자 로그인이 성공하였습니다.");
				tosAdminID = dto.getId();
				dispose();
				new AdminFrame();
			}else if(adminIdField.getText().equals(dto.getId()) && adminPasswordField.getText() != dto.getPw()) {
				JOptionPane.showMessageDialog(null, "패스워드가 틀렸습니다.");
			}
		}else {
			JOptionPane.showMessageDialog(null, "아이디가 존재하지 않습니다.");
		}
		
	}

}
