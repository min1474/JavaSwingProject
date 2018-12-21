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

public class AdminMemberform extends JFrame {

	public JTextField nameField;
	public JTextField emailField;
	public JTextField telField;
	public JTextField idField;
	private JTextField pwtextField;
	private JTextField codeField;
	private JTextField adminField;
	private JButton adminDeleteButton;
	
	MyJOptionPane my = new MyJOptionPane();//joption 에러를 대체하기 위해 클래스를 만들어 객체 호출

	public AdminMemberform(AdminDTO dto) {

		idField = new JTextField();
		idField.setText(dto.getId()); // AdminMemberList 에서 "검색" 버튼을 눌렀을 경우에 넘어오는
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

		nameField = new JTextField("");
		nameField.setText(dto.getName()); // AdminMemberList 에서 "검색" 버튼을 눌렀을 경우에 넘어오는
											// dto의 정보를 받아서 set시킴

		nameField.setForeground(Color.DARK_GRAY);
		nameField.setBounds(68, 157, 287, 27);
		getContentPane().add(nameField);
		nameField.setColumns(10);
		nameField.setBorder(null);// 입력창 태두리삭제
		nameField.disable();

		emailField = new JTextField("");
		emailField.setText(dto.getEmail()); // AdminMemberList 에서 "검색" 버튼을 눌렀을 경우에 넘어오는
											// dto의 정보를 받아서 set시킴

		emailField.setForeground(Color.DARK_GRAY);
		emailField.setColumns(10);
		emailField.setBounds(68, 200, 287, 27);
		getContentPane().add(emailField);
		emailField.setBorder(null);// 입력창 태두리삭제

		telField = new JTextField("");
		telField.setText(dto.getTel()); // AdminMemberList 에서 "검색" 버튼을 눌렀을 경우에 넘어오는
										// dto의 정보를 받아서 set시킴

		telField.setForeground(Color.DARK_GRAY);
		telField.setColumns(10);
		telField.setBounds(68, 244, 287, 27);
		getContentPane().add(telField);
		telField.setBorder(null);

		codeField = new JTextField((String) null);
		codeField.setText(dto.getCode());
		codeField.setForeground(Color.DARK_GRAY);
		codeField.setColumns(10);
		codeField.setBorder(null);
		codeField.setBounds(68, 290, 287, 27);
		getContentPane().add(codeField);
		codeField.disable();

		adminField = new JTextField((String) null);
		adminField.setText(dto.getAdmin());
		adminField.setForeground(Color.DARK_GRAY);
		adminField.setColumns(10);
		adminField.setBorder(null);
		adminField.setBounds(68, 333, 287, 27);
		getContentPane().add(adminField);
		adminField.disable();

		JButton adminChangeButton = new JButton("");
		adminChangeButton.setBackground(Color.WHITE);
		adminChangeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				
				AdminDTO dto = new AdminDTO();

				dto.setId(idField.getText()); // 입력된 아이디를 가져와 dto에 저장
				dto.setPw(pwtextField.getText());// 입력된 비밀번호를 가져와 dto에 저장
				dto.setEmail(emailField.getText()); 
				dto.setTel(telField.getText()); 


				try {
					AdminDAO dao = new AdminDAO();

					dao.update(dto);
					//여기서도  joption때문에 에러
					
					my.showMessageDialog("수정이 완료되었습니다.");
					
					dispose();
				} catch (Exception e2) {

				}
			}

		});

		adminChangeButton.setForeground(Color.WHITE);
		adminChangeButton.setIcon(new ImageIcon("./img/admin/adminchange.png"));
		adminChangeButton.setBounds(10, 403, 168, 48);
		getContentPane().add(adminChangeButton);
		adminChangeButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		adminChangeButton.setContentAreaFilled(true);
		adminChangeButton.setFocusPainted(false);

		adminDeleteButton = new JButton("");
		adminDeleteButton.setIcon(new ImageIcon("./img/admin/admindelete.png"));

		adminDeleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				AdminDTO dto = new AdminDTO();

				dto.setId(idField.getText()); // 입력된 아이디를 가져와 dto에 저장
				dto.setPw(pwtextField.getText());// 입력된 비밀번호를 가져와 dto에 저장
				dto.setName(nameField.getText());
				dto.setEmail(emailField.getText());
				dto.setTel(telField.getText());
				dto.setCode(codeField.getText());
				dto.setAdmin(adminField.getText());

				try {
					AdminDAO dao = new AdminDAO();

					dao.deleteAdminMember(dto);
					//여기서도  joption때문에 에러
					
					my.showMessageDialog("삭제가 완료되었습니다.");
					dispose();
					
				} catch (Exception e2) {

				}
			}
		});

		adminDeleteButton.setForeground(Color.WHITE);
		adminDeleteButton.setFocusPainted(false);
		adminDeleteButton.setContentAreaFilled(true);
		adminDeleteButton.setBorderPainted(false);
		adminDeleteButton.setBackground(Color.WHITE);
		adminDeleteButton.setBounds(190, 403, 173, 48);
		getContentPane().add(adminDeleteButton);

		JLabel adminMemberForm = new JLabel("");
		adminMemberForm.setIcon(new ImageIcon("./img/admin/adminmemberform.png"));
		adminMemberForm.setForeground(Color.WHITE);
		adminMemberForm.setBounds(0, 0, 374, 393);
		getContentPane().add(adminMemberForm);

		setAlwaysOnTop(true);
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		setLocation(900, 200);
		setSize(390, 500);
		setVisible(true);
	}

}
