package adminpage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

import dao.AdminDAO;

import dto.AdminDTO;


import javax.swing.JButton;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FindAdminPassword extends JFrame{
	private JTextField idFindtextField;
	private JTextField nameFindtextField;
	private JTextField numberFindtextField;
	private JTextField codeFindtextField;
	
	
	public FindAdminPassword() {
		
		getContentPane().setLayout(null);
		
		idFindtextField = new JTextField();
		idFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				
				idFindtextField.setText("");
			}
		});
		idFindtextField.setForeground(Color.LIGHT_GRAY);
		idFindtextField.setText("가입시 입력했던 ID를 입력하세요");
		idFindtextField.setBounds(56, 90, 290, 39);
		getContentPane().add(idFindtextField);
		idFindtextField.setColumns(10);
		idFindtextField.setBorder(null);//입력창 테두리 삭제
		
		nameFindtextField = new JTextField();
		nameFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				nameFindtextField.setText("");
			}
		});
		nameFindtextField.setForeground(Color.LIGHT_GRAY);
		nameFindtextField.setText("가입시 입력했던 이름을 입력하세요");
		nameFindtextField.setColumns(10);
		nameFindtextField.setBounds(56, 141, 290, 38);
		getContentPane().add(nameFindtextField);
		nameFindtextField.setBorder(null);//입력창 테두리 삭제
		
		numberFindtextField = new JTextField();
		numberFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				numberFindtextField.setText("");
			}
		});
		numberFindtextField.setForeground(Color.LIGHT_GRAY);
		numberFindtextField.setText("가입시 입력했던 번호를 -없이 입력하세요");
		numberFindtextField.setColumns(10);
		numberFindtextField.setBounds(56, 191, 290, 42);
		getContentPane().add(numberFindtextField);
		numberFindtextField.setBorder(null);//입력창 테두리 삭제
		
		codeFindtextField = new JTextField();
		codeFindtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				codeFindtextField.setText("");
			}
		});
		codeFindtextField.setForeground(Color.LIGHT_GRAY);
		codeFindtextField.setText("관리자 시크릿 코드를 입력하세요");
		codeFindtextField.setColumns(10);
		codeFindtextField.setBounds(56, 243, 290, 42);
		getContentPane().add(codeFindtextField);
		codeFindtextField.setBorder(null);//입력창 테두리 삭제
		
		JButton showPasswordButton = new JButton("");
		showPasswordButton.setIcon(new ImageIcon("./img/admin/ShowPassword.png"));
		showPasswordButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				  
				AdminDAO dao = new AdminDAO();
				
				String id = idFindtextField.getText();
				String name = nameFindtextField.getText();
				String tel = numberFindtextField.getText();
				String code = codeFindtextField.getText();
				
				try {
					AdminDTO dto = dao.findPw(id, name, tel, code);
					JOptionPane.showMessageDialog(null,"비밀번호는 : "+dto.getPw()+"입니다." );
				} catch (Exception e) {
				
					e.printStackTrace();
				}
			
			}
		});
		showPasswordButton.setForeground(Color.WHITE);
		showPasswordButton.setBackground(Color.WHITE);
		showPasswordButton.setBounds(23, 297, 143, 42);
		getContentPane().add(showPasswordButton);
		showPasswordButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		showPasswordButton.setContentAreaFilled(true);
		showPasswordButton.setFocusPainted(false);
		showPasswordButton.setOpaque(true);
		
		JButton loginNowButton = new JButton("");
		loginNowButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				AdminLogin adminLogin = new AdminLogin();
			}
		});
		loginNowButton.setIcon(new ImageIcon("./img/admin/Loginnow.png"));
		loginNowButton.setOpaque(true);
		loginNowButton.setForeground(Color.WHITE);
		loginNowButton.setFocusPainted(false);
		loginNowButton.setContentAreaFilled(true);
		loginNowButton.setBorderPainted(false);
		loginNowButton.setBackground(Color.WHITE);
		loginNowButton.setBounds(203, 297, 143, 42);
		getContentPane().add(loginNowButton);
		
		
		JLabel findPasswordForm = new JLabel("");
		findPasswordForm.setIcon(new ImageIcon("./img/admin/adminfindform.png"));
		findPasswordForm.setBounds(0, 0, 362, 365);
		getContentPane().add(findPasswordForm);
		setTitle("비밀번호찾기");
		setSize(374, 404);
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
//		this.setLocation((screenSize.width - frameSize.width), (screenSize.height - screenSize.height)); // 화면 우측 상단
	}
	

}
