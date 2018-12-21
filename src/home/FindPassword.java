package home;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dao.MemberDAO;
import dto.MemberDTO;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindPassword extends JFrame{
	private JTextField idFindtextField;
	private JTextField nameFindtextField;
	private JTextField emailFindtextField;
	private JTextField numberFindtextField;
	private JButton loginNowButton;
	
	public FindPassword() {
		
		getContentPane().setLayout(null);
		
		idFindtextField = new JTextField();
		idFindtextField.setForeground(Color.LIGHT_GRAY);
		idFindtextField.setText("가입시 입력했던 ID를 입력하세요");
		idFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				idFindtextField.setText("");
			}
		});
		idFindtextField.setBounds(56, 90, 290, 34);
		getContentPane().add(idFindtextField);
		idFindtextField.setColumns(10);
		idFindtextField.setBorder(null);//입력창 테두리 삭제
		
		nameFindtextField = new JTextField();
		nameFindtextField.setForeground(Color.LIGHT_GRAY);
		nameFindtextField.setText("가입시 입력했던 이름을 입력하세요");
		nameFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nameFindtextField.setText("");
			}
		});
		nameFindtextField.setColumns(10);
		nameFindtextField.setBounds(56, 141, 290, 34);
		getContentPane().add(nameFindtextField);
		nameFindtextField.setBorder(null);//입력창 테두리 삭제
		
		emailFindtextField = new JTextField();
		emailFindtextField.setForeground(Color.LIGHT_GRAY);
		emailFindtextField.setText("가입시 입력했던 email 입력하세요");
		emailFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				emailFindtextField.setText("");
			}
		});
		emailFindtextField.setColumns(10);
		emailFindtextField.setBounds(56, 191, 290, 42);
		getContentPane().add(emailFindtextField);
		emailFindtextField.setBorder(null);//입력창 테두리 삭제
		
		numberFindtextField = new JTextField();
		numberFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				numberFindtextField.setText("");
			}
		});
		numberFindtextField.setForeground(Color.LIGHT_GRAY);
		numberFindtextField.setText("가입시 입력했던 번호를 - 없이 입력하세요");
		numberFindtextField.setColumns(10);
		numberFindtextField.setBounds(56, 243, 290, 34);
		getContentPane().add(numberFindtextField);
		numberFindtextField.setBorder(null);//입력창 테두리 삭제
		
		JButton showPasswordButton = new JButton("");
		showPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
				MemberDAO dao = new MemberDAO();
				
				String id = idFindtextField.getText();
				String name = nameFindtextField.getText();
				String email = emailFindtextField.getText();
				String tel = numberFindtextField.getText();
				
				try {
					MemberDTO dto = dao.findPw(id, name, email, tel);
					JOptionPane.showMessageDialog(null,"비밀번호는 : "+dto.getPw()+"입니다." );
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			
			}
		});
		showPasswordButton.setIcon(new ImageIcon("./img/home/ShowPassword.png"));
		showPasswordButton.setForeground(Color.WHITE);
		showPasswordButton.setBackground(Color.WHITE);
		showPasswordButton.setBounds(23, 297, 143, 42);
		getContentPane().add(showPasswordButton);
		showPasswordButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		showPasswordButton.setContentAreaFilled(true);
		showPasswordButton.setFocusPainted(false);
		showPasswordButton.setOpaque(true);
		
		loginNowButton = new JButton("");
		loginNowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
				dispose();
			}
		});
		loginNowButton.setIcon(new ImageIcon("./img/home/Loginnow.png"));
		loginNowButton.setOpaque(true);
		loginNowButton.setForeground(Color.WHITE);
		loginNowButton.setFocusPainted(false);
		loginNowButton.setContentAreaFilled(true);
		loginNowButton.setBorderPainted(false);
		loginNowButton.setBackground(Color.WHITE);
		loginNowButton.setBounds(203, 297, 143, 42);
		getContentPane().add(loginNowButton);
		
		
		JLabel findPasswordForm = new JLabel("");
		findPasswordForm.setIcon(new ImageIcon("./img/home/findpasswordform.png"));
		findPasswordForm.setBounds(0, 0, 362, 365);
		getContentPane().add(findPasswordForm);
		setTitle("비밀번호찾기");
		setSize(374, 404);
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	}

}
