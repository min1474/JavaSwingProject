package adminpage;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.AdminDAO;
import dto.MemberDTO;
import other.MyJOptionPane;
import dto.AdminDTO;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminMemberSearch extends JFrame {

	public JTextField nameField;
	public JTextField emailField;
	public JTextField telField;
	public JTextField idField;
	private JComboBox secretCodeComboBox;
	private JComboBox adminComboBox;
	private JTextField pwtextField;
	
	MyJOptionPane my = new MyJOptionPane();//joption 에러를 대체하기 위해 클래스를 만들어 객체 호출

	public AdminMemberSearch(MemberDTO dto, String id, String name, String email, String tel,
			MouseAdapter mouseAdapter) {

		idField = new JTextField();
		idField.setText(dto.getId()); // AdminMemberList 에서 테이블에서 한명의 회원울 눌렀을 경우에 넘어오는
										// dto의 정보를 받아서 set시킴

		idField.setBackground(Color.WHITE);
		idField.setForeground(Color.DARK_GRAY);
		idField.setBounds(68, 77, 287, 21);
		getContentPane().add(idField);
		idField.setColumns(10);
		idField.setBorder(null);// 입력창 태두리삭제
		idField.disable();

		pwtextField = new JPasswordField();
		pwtextField.setForeground(Color.DARK_GRAY);
		pwtextField.setText(dto.getPw());
		pwtextField.setBounds(68, 120, 287, 21);
		getContentPane().add(pwtextField);
		pwtextField.setColumns(10);
		pwtextField.setBorder(null);// 입력창 태두리삭제
		pwtextField.disable();

		nameField = new JTextField("");
		nameField.setText(dto.getName()); // AdminMemberList 에서 테이블에서 한명의 회원울 눌렀을 경우에 넘어오는
											// dto의 정보를 받아서 set시킴

		nameField.setForeground(Color.DARK_GRAY);
		nameField.setBounds(68, 157, 287, 27);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		nameField.setBorder(null);// 입력창 태두리삭제
		nameField.disable();

		emailField = new JTextField("");
		emailField.setText(dto.getEmail()); // AdminMemberList 에서 테이블에서 한명의 회원울 눌렀을 경우에 넘어오는
											// dto의 정보를 받아서 set시킴

		emailField.setForeground(Color.DARK_GRAY);
		emailField.setColumns(10);
		emailField.setBounds(68, 200, 287, 27);
		getContentPane().add(emailField);
		emailField.setBorder(null);// 입력창 태두리삭제

		telField = new JTextField("");
		telField.setText(dto.getTel()); // AdminMemberList 에서 테이블에서 한명의 회원울 눌렀을 경우에 넘어오는
										// dto의 정보를 받아서 set시킴

		telField.setForeground(Color.DARK_GRAY);
		telField.setColumns(10);
		telField.setBounds(68, 244, 287, 27);
		getContentPane().add(telField);
		telField.setBorder(null);

		secretCodeComboBox = new JComboBox();
		secretCodeComboBox.setModel(new DefaultComboBoxModel(new String[] { "A1B2C3", "null" }));
		secretCodeComboBox.setForeground(Color.GRAY);
		secretCodeComboBox.setBackground(Color.WHITE);
		secretCodeComboBox.setBounds(249, 292, 106, 21);
		getContentPane().add(secretCodeComboBox);

		adminComboBox = new JComboBox();
		adminComboBox.setForeground(Color.GRAY);
		adminComboBox.setBackground(Color.WHITE);
		adminComboBox.setModel(new DefaultComboBoxModel(new String[] { "administrator" }));
		adminComboBox.setBounds(249, 336, 106, 21);
		getContentPane().add(adminComboBox);

		JButton changeButton = new JButton("");
		changeButton.setBackground(Color.WHITE);
		changeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				AdminDTO dto = new AdminDTO();
				;

				dto.setId(idField.getText()); // 입력된 아이디를 가져와 dto에 저장

				dto.setPw(pwtextField.getText());// 입력된 비밀번호를 가져와 dto에 저장

				dto.setName(nameField.getText());

				dto.setEmail(emailField.getText());

				dto.setTel(telField.getText());

				dto.setCode((String) secretCodeComboBox.getSelectedItem());

				dto.setAdmin((String) adminComboBox.getSelectedItem());

				try {
					AdminDAO dao = new AdminDAO();
					dao.insert(dto);
					dao.delete(dto);
					
					my.showMessageDialog("수정이 완료되었습니다.");
					dispose();

				} catch (Exception e2) {

				}
			}
		});

		changeButton.setForeground(Color.WHITE);
		changeButton.setIcon(new ImageIcon("./img/admin/memberchange.png"));
		changeButton.setBounds(12, 403, 168, 48);
		getContentPane().add(changeButton);
		changeButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		changeButton.setContentAreaFilled(true);
		changeButton.setFocusPainted(false);

		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JButton deleteButton = new JButton("");
		deleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AdminDTO dto = new AdminDTO();
				
				dto.setId(idField.getText()); // 입력된 아이디를 가져와 dto에 저장
				dto.setPw(pwtextField.getText());// 입력된 비밀번호를 가져와 dto에 저장
				dto.setName(nameField.getText());
				dto.setEmail(emailField.getText());
				dto.setTel(telField.getText());

				try {
					AdminDAO dao = new AdminDAO();
					dao.delete(dto);
					
					my.showMessageDialog("탈퇴가 완료되었습니다.");
					dispose();


				} catch (Exception e2) {

				}

			}
		});
		deleteButton.setIcon(new ImageIcon("./img/admin/memberdelete.png"));
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFocusPainted(false);
		deleteButton.setContentAreaFilled(true);
		deleteButton.setBorderPainted(false);
		deleteButton.setBackground(Color.WHITE);
		deleteButton.setBounds(192, 403, 168, 48);
		getContentPane().add(deleteButton);
		// 지금 메소드의 텍스트필드에 dto정보를 삽입시킬려면 메소드에서 dto 인자를 받아서 처리헤야 한다

		JLabel adminMemberForm = new JLabel("");
		adminMemberForm.setIcon(new ImageIcon("./img/admin/adminmemberform.png"));
		adminMemberForm.setForeground(Color.WHITE);
		adminMemberForm.setBounds(0, 0, 374, 393);
		getContentPane().add(adminMemberForm);

		setLocation(900, 200);
		setSize(390, 500);
		setVisible(true);

	}
}
