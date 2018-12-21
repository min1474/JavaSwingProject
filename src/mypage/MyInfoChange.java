package mypage;

import java.awt.Frame;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import dao.MemberDAO;
import dto.MemberDTO;
import home.Login;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MyInfoChange extends JFrame {
	
	private JTextField changIdtextField;
	private JTextField changeNametextField;
	private JTextField changeEamiltextField;
	private JTextField changeNumtextField;
	private JTextField changePwtextField;
	private JTextField chagePwCHtextField;
	
	public MyInfoChange(MemberDTO dto) {
		getContentPane().setBackground(Color.WHITE);
		setBackground(Color.WHITE);
	
		
		setTitle("회원정보변경");
		getContentPane().setLayout(null);
		
		
		changIdtextField = new JTextField();
		changIdtextField.setText(dto.getId());// 인자값으로 넘겨받은 dto값 각 텍스트칸에 삽입시킴  
		changIdtextField.disable();//id텍스트 입력부분을 보여주기만하고 수정할 수 없도록 
		
		changIdtextField.setBackground(Color.WHITE);
		changIdtextField.setBounds(58, 10, 281, 22);
		getContentPane().add(changIdtextField);
		changIdtextField.setColumns(10);
		changIdtextField.setBorder(null);// 입력창 태두리삭제
		
		changeNametextField = new JTextField();
		changeNametextField.setText(dto.getName());
		changeNametextField.disable();
		
		changeNametextField.setBackground(new Color(255, 255, 255));
		changeNametextField.setColumns(10);
		changeNametextField.setBounds(58, 59, 294, 22);
		getContentPane().add(changeNametextField);
		changeNametextField.setBorder(null);// 입력창 태두리삭제
		
		
		changeEamiltextField = new JTextField();
		changeEamiltextField.setText(dto.getEmail());
		
		changeEamiltextField.setBackground(Color.WHITE);
		changeEamiltextField.setColumns(10);
		changeEamiltextField.setBounds(58, 117, 294, 22);
		getContentPane().add(changeEamiltextField);
		changeEamiltextField.setBorder(null);// 입력창 태두리삭제
		
		changeNumtextField = new JTextField();
		changeNumtextField.setText(dto.getTel());
		
		changeNumtextField.setBackground(Color.WHITE);
		changeNumtextField.setColumns(10);
		changeNumtextField.setBounds(58, 165, 294, 22);
		getContentPane().add(changeNumtextField);
		changeNumtextField.setBorder(null);// 입력창 태두리삭제
		
		changePwtextField = new JTextField("변경 하려면 비밀번호를 입력해야 합니다.");
		changePwtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				changePwtextField.setText("");
			}
		});

		changePwtextField.setBackground(Color.WHITE);
		changePwtextField.setColumns(10);
		changePwtextField.setBounds(58, 210, 294, 22);
		getContentPane().add(changePwtextField);
		changePwtextField.setBorder(null);// 입력창 태두리삭제
		
		chagePwCHtextField = new JTextField("입력한 비밀번호와 같아야 합니다.");
		chagePwCHtextField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				chagePwCHtextField.setText("");
			}
		});
		chagePwCHtextField.setBackground(Color.WHITE);
		chagePwCHtextField.setColumns(10);
		chagePwCHtextField.setBounds(58, 258, 294, 31);
		getContentPane().add(chagePwCHtextField);
		chagePwCHtextField.setBorder(null);// 입력창 태두리삭제
		
		
		
		JButton changeButton = new JButton("");
		changeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				MemberDAO dao = new MemberDAO();
				MemberDTO dto;
				dto = dao.login(Login.tosID);
				
				dto.setPw(changePwtextField.getText());// 입력된 비밀번호를 가져와 dto에 저장
				
				dto.setEmail(changeEamiltextField.getText());
				
				dto.setTel(changeNumtextField.getText());
				
				if (changePwtextField.getText().equals("") && chagePwCHtextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.");
				}else {
					if (changePwtextField.getText().equals(chagePwCHtextField.getText())) {
						
						dao.modifyInfo(dto);
						JOptionPane.showMessageDialog(null, "회원정보가 수정 되었습니다.");
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
					}
				}
			}
		});
		changeButton.setForeground(Color.WHITE);
		changeButton.setBackground(Color.WHITE);
		changeButton.setIcon(new ImageIcon("./img/mypage/changbutton.png"));
		changeButton.setBounds(46, 304, 125, 49);
		getContentPane().add(changeButton);
		changeButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		changeButton.setContentAreaFilled(true);
		changeButton.setFocusPainted(false);
		changeButton.setOpaque(true);
		
		
		JButton deleteButton = new JButton("");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				MemberDAO dao = new MemberDAO();
				MemberDTO dto;
				dto = dao.login(Login.tosID);
				
				// id와 이름은 변경이 불가능
				

				if (changePwtextField.getText().equals("") && chagePwCHtextField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "패스워드를 입력하세요.");
				} else {
					if (changePwtextField.getText().equals(dto.getPw())
							&& changePwtextField.getText().equals(chagePwCHtextField.getText())) {
						
						dao.delete(dto);
						JOptionPane.showMessageDialog(null, "회원탈퇴!");
						dispose();
					} else {
						JOptionPane.showMessageDialog(null, "패스워드가 일치하지 않습니다.");
					}
				}

			}
		});
		
		deleteButton.setIcon(new ImageIcon("./img/mypage/deletebutton.png"));
		deleteButton.setOpaque(true);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setContentAreaFilled(true);
		deleteButton.setBorderPainted(false);
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setBounds(196, 304, 125, 49);
		getContentPane().add(deleteButton);
		
		
		JLabel memberFormLable = new JLabel("");
		memberFormLable.setBackground(Color.WHITE);
		
		memberFormLable.setIcon(new ImageIcon("./img/mypage/memberchange.png"));
		memberFormLable.setBounds(0, 0, 365, 304);
		getContentPane().add(memberFormLable);
		
		setLocation(870, 342);
		setSize(380, 402);
		setVisible(true);
		
	}


}
