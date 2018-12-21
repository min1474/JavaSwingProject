package adminpage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.BookingDAO;
import dto.BookingDTO;
import other.MyJOptionPane;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class AdminPrintBooking extends JFrame{
	private JTextField name;
	private JTextField tel;
	private JButton printBookingButton;

	
	// 예약 정보 저장(출력)하는 메소드
	public void saveFile(BookingDTO dto_0) {		
		BookingDAO dao = new BookingDAO();
		BookingDTO dto = new BookingDTO();
		ArrayList<BookingDTO> list = dao.saveFile(dto_0); // 현재 메소드랑 DAO메소드랑 이름이 같이 때문에 헷갈리지 마시길...
		
		try {
			Writer w = new FileWriter("D:/" + dto_0.getName() + ".txt"); // 입력한 고객명으로 파일 이름 부여
			
			w.write("=====================\r\n");
			for (int i = 0; i < list.size(); i++) {
				dto = list.get(i);
				
				w.write("예약일시: " + dto.getYear() + "-" + dto.getMonth() + "-" + dto.getDay() + "\r\n");
				w.write("예약시간: " + dto.getHour() + "\r\n");
				w.write("이름: " + dto.getName() + "\r\n");
				w.write("연락처: " + dto.getTel() + "\r\n");
				w.write("인원: " + dto.getPerson() + "\r\n");
				w.write("테이블 번호: " + dto.getTableNum() + "\r\n");
				w.write("=====================\r\n");
			}
			
			w.flush();
			w.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, dto_0.getName() + "님의 예약증.txt 파일이 생성되었습니다.");
	}
	
	// 메인 생성자
	public AdminPrintBooking() {
		getContentPane().setBackground(Color.WHITE);
		setSize(322, 318);
		setTitle("예약증 출력");
		getContentPane().setLayout(null);
		
		name = new JTextField();
		name.setBounds(69, 42, 207, 21);
		getContentPane().add(name);
		name.setColumns(10);
		name.setBorder(null);
		
		tel = new JTextField();
		tel.setBounds(69, 92, 207, 21);
		getContentPane().add(tel);
		tel.setColumns(10);
		tel.setBorder(null);
		
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		yearComboBox.setBounds(69, 140, 66, 21);
		getContentPane().add(yearComboBox);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setBounds(155, 140, 52, 21);
		getContentPane().add(monthComboBox);
		
		JComboBox dayComboBox = new JComboBox();
		dayComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", 
																	"13", "14", "15", "16", "17", "18", "19", "20", "21", "22", 
																	"23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dayComboBox.setBounds(225, 140, 51, 21);
		getContentPane().add(dayComboBox);
		
		
		printBookingButton = new JButton(""); // "예약증 출력" 버튼
		printBookingButton.setBackground(Color.WHITE);
		printBookingButton.setIcon(new ImageIcon("./img/admin/printforbooking.png"));
		printBookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookingDTO dto_0 = new BookingDTO();
				dto_0.setName(name.getText());
				dto_0.setTel(tel.getText());
				dto_0.setYear((String)yearComboBox.getSelectedItem());
				dto_0.setMonth((String)monthComboBox.getSelectedItem());
				dto_0.setDay((String)dayComboBox.getSelectedItem());
				
				saveFile(dto_0);
			}
		});
		printBookingButton.setBounds(61, 202, 186, 53);
		getContentPane().add(printBookingButton);
		printBookingButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		printBookingButton.setContentAreaFilled(true);
		printBookingButton.setFocusPainted(false);
		printBookingButton.setOpaque(true);
		
		JLabel frameLable = new JLabel("");
		frameLable.setBackground(Color.WHITE);
		frameLable.setIcon(new ImageIcon("./img/admin/printsearchframe.png"));
		frameLable.setBounds(22, 22, 259, 170);
		getContentPane().add(frameLable);
		
		setAlwaysOnTop(true);
		setVisible(true);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙
	}
}
