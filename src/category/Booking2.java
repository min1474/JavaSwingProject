package category;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;

import com.teamdev.jxbrowser.chromium.internal.EventQueue;

import dao.BookingDAO;
import dao.MemberDAO;
import dto.BookingDTO;
import dto.MemberDTO;
import mypage.MyPageFrame;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.ArrayList;
import javax.swing.SwingConstants;

public class Booking2 extends JFrame {
	private JTextField idTextField;
	private JTextField nameTextField;
	private JTextField telTextField;
	JComboBox tableBox;
	JComboBox yearComboBox;
	JComboBox monthComboBox;
	JComboBox dayComboBox;
	JComboBox timeComboBox;

	public Booking2(MemberDTO dto) {
		getContentPane().setBackground(Color.WHITE);

		getContentPane().setLayout(null);

		JLabel infoLabel1 = new JLabel("How many people?");
		infoLabel1.setForeground(Color.GRAY);
		infoLabel1.setBackground(Color.WHITE);
		infoLabel1.setBounds(367, 360, 117, 15);
		getContentPane().add(infoLabel1);

		JLabel infoLabel2 = new JLabel("which day?");
		infoLabel2.setForeground(Color.GRAY);
		infoLabel2.setBackground(Color.WHITE);
		infoLabel2.setBounds(591, 360, 71, 15);
		getContentPane().add(infoLabel2);

		JLabel infoLabel3 = new JLabel("what time?");
		infoLabel3.setForeground(Color.GRAY);
		infoLabel3.setBackground(Color.WHITE);
		infoLabel3.setBounds(764, 360, 71, 15);
		getContentPane().add(infoLabel3);

		JLabel infoLabel4 = new JLabel("select table");
		infoLabel4.setForeground(Color.GRAY);
		infoLabel4.setBackground(Color.WHITE);
		infoLabel4.setBounds(941, 360, 71, 15);
		getContentPane().add(infoLabel4);

		tableBox = new JComboBox();
		tableBox.setForeground(Color.DARK_GRAY);
		tableBox.setBackground(Color.WHITE);
		tableBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		tableBox.setBounds(898, 329, 114, 21);
		getContentPane().add(tableBox);

		idTextField = new JTextField("");
		idTextField.setText(dto.getId());
		idTextField.setForeground(Color.DARK_GRAY);
		idTextField.setBackground(Color.WHITE);
		idTextField.setBounds(437, 223, 123, 21);
		getContentPane().add(idTextField);
		idTextField.setColumns(10);
		idTextField.setBorder(null);// 입력창 태두리삭제
		idTextField.disable();

		nameTextField = new JTextField("");
		nameTextField.setText(dto.getName());
		nameTextField.setForeground(Color.DARK_GRAY);
		nameTextField.setBackground(Color.WHITE);
		nameTextField.setBounds(613, 223, 123, 21);
		getContentPane().add(nameTextField);
		nameTextField.setColumns(10);
		nameTextField.setBorder(null);// 입력창 태두리삭제

		telTextField = new JTextField("");
		telTextField.setText(dto.getTel());
		telTextField.setBackground(Color.WHITE);
		telTextField.setForeground(Color.DARK_GRAY);
		telTextField.setBounds(798, 223, 117, 21);
		getContentPane().add(telTextField);
		telTextField.setColumns(10);
		telTextField.setBorder(null);// 태두리삭제

		JComboBox peopleComboBox = new JComboBox();
		peopleComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8" }));
		peopleComboBox.setForeground(Color.DARK_GRAY);
		peopleComboBox.setBackground(Color.WHITE);
		peopleComboBox.setBounds(364, 329, 114, 21);
		getContentPane().add(peopleComboBox);

		yearComboBox = new JComboBox();
		yearComboBox.setForeground(Color.DARK_GRAY);
		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] { "2018", "2019", "2020" }));
		yearComboBox.setBounds(545, 300, 111, 21);
		getContentPane().add(yearComboBox);

		monthComboBox = new JComboBox();
		monthComboBox.setForeground(Color.DARK_GRAY);
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		monthComboBox.setBounds(543, 329, 42, 21);
		getContentPane().add(monthComboBox);

		dayComboBox = new JComboBox();
		dayComboBox.setForeground(Color.DARK_GRAY);
		dayComboBox.setBackground(Color.WHITE);
		dayComboBox.setModel(new DefaultComboBoxModel(
				new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
						"17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
		dayComboBox.setBounds(599, 329, 57, 21);
		getContentPane().add(dayComboBox);

		timeComboBox = new JComboBox();
		timeComboBox.setModel(new DefaultComboBoxModel(new String[] { "08:00 (AM)", "11:00 (Lunch)", "12:00 (Lunch)",
				"14:00 (PM)", "16:00 (PM)", "18:00 (Dinner)", "20:00 (Dinner)" }));
		timeComboBox.setForeground(Color.DARK_GRAY);
		timeComboBox.setBackground(Color.WHITE);
		timeComboBox.setBounds(715, 329, 117, 21);
		getContentPane().add(timeComboBox);

		JLabel label = new JLabel("  - ");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(581, 328, 18, 23);
		getContentPane().add(label);

		JButton bookingButton = new JButton("");
		bookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BookingDTO dto = new BookingDTO();
				BookingDAO dao = new BookingDAO();

				dto.setTableNum((String) tableBox.getSelectedItem());
				dto.setId(idTextField.getText()); // 입력된 아이디를 가져와 dto에 저장
				dto.setName(nameTextField.getText());
				dto.setTel(telTextField.getText());
				dto.setPerson((String) peopleComboBox.getSelectedItem());
				dto.setYear((String) yearComboBox.getSelectedItem());
				dto.setMonth((String) monthComboBox.getSelectedItem());
				dto.setDay((String) dayComboBox.getSelectedItem());
				dto.setHour((String) timeComboBox.getSelectedItem());

				try {

					BookingDTO dtoA = new BookingDTO();
					dtoA.setTableNum((String) tableBox.getSelectedItem());
					dtoA.setYear((String) yearComboBox.getSelectedItem());
					dtoA.setMonth((String) monthComboBox.getSelectedItem());
					dtoA.setDay((String) dayComboBox.getSelectedItem());
					dtoA.setHour((String) timeComboBox.getSelectedItem());

					BookingDTO dtoB = dao.selecDuplication(dtoA);
					if (nameTextField.getText().equals("") || telTextField.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "이름과 연락처를 적어주세요.");
					} else {
						if (tableBox.getSelectedItem().equals(dtoB.getTableNum())
								&& yearComboBox.getSelectedItem().equals(dtoB.getYear())
								&& monthComboBox.getSelectedItem().equals(dtoB.getMonth())
								&& dayComboBox.getSelectedItem().equals(dtoB.getDay())
								&& timeComboBox.getSelectedItem().equals(dtoB.getHour())) {
	
							JOptionPane.showMessageDialog(null, "해당 시간에는 테이블 예약이 꽉 찾습니다.");
						} else {
	
							dao.bookingInsert(dto);
							JOptionPane.showMessageDialog(null, "예약이 완료되었습니다.");
						}
					}

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		bookingButton.setIcon(new ImageIcon("./img/booking/bookingbutton.png"));
		bookingButton.setForeground(Color.WHITE);
		bookingButton.setBackground(Color.WHITE);
		bookingButton.setBounds(466, 395, 191, 51);
		getContentPane().add(bookingButton);
		bookingButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		bookingButton.setContentAreaFilled(true);
		bookingButton.setFocusPainted(false);

		JButton searchBookingButton = new JButton("");
		searchBookingButton.setIcon(new ImageIcon("./img/booking/searchforprint.png"));
		searchBookingButton.setBackground(Color.WHITE);

		searchBookingButton.setBounds(669, 395, 191, 51);
		getContentPane().add(searchBookingButton);

		JLabel bookingForm = new JLabel("");
		bookingForm.setBackground(Color.WHITE);
		bookingForm.setIcon(new ImageIcon("./img/booking/bookingformfinal.png"));
		bookingForm.setBounds(-16, 0, 1045, 476);
		getContentPane().add(bookingForm);
		setSize(1045, 515);
		setSize(1045, 515);

		setVisible(true);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

	}

}
