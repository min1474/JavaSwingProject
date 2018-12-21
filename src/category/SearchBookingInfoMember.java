package category;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.Book;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.BookingDAO;
import dao.MemberDAO;
import dto.BookingDTO;
import dto.MemberDTO;
import home.Login;

import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SearchBookingInfoMember extends JFrame{
	
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.login(Login.tosID);
	
		// 매개변수 BookingDTO가 있는 생성자 
		public SearchBookingInfoMember(BookingDTO dtoB) {
			
			getContentPane().setBackground(Color.WHITE);
			setSize(323, 474);
			setTitle("예약 정보");
			getContentPane().setLayout(null);
			
			JLabel getLabel_name = new JLabel(dtoB.getName());
			getLabel_name.setBackground(Color.WHITE);
			getLabel_name.setHorizontalAlignment(SwingConstants.LEFT);
			getLabel_name.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
			getLabel_name.setBounds(47, 10, 117, 24);
			getContentPane().add(getLabel_name);
			
			JLabel lblNewLabel_1 = new JLabel("님의 예약 정보 입니다");
			lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
			lblNewLabel_1.setBounds(47, 35, 215, 15);
			getContentPane().add(lblNewLabel_1);
			
			
			JButton printBookingButton = new JButton("");
			printBookingButton.setBackground(Color.WHITE);
			printBookingButton.setIcon(new ImageIcon("./img/booking/printInfo.png"));
			printBookingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					saveFile(dtoB);
				}
			});
			printBookingButton.setBounds(22, 379, 124, 46);
			getContentPane().add(printBookingButton);
			printBookingButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
			printBookingButton.setContentAreaFilled(true);
			printBookingButton.setFocusPainted(false);
			
			JButton deleteBookingButton = new JButton("");
			deleteBookingButton.setBackground(Color.WHITE);
			deleteBookingButton.setIcon(new ImageIcon("./img/booking/cancelbooking.png"));
			deleteBookingButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					deleteBookingInfo(dtoB);				
				}
			});
			deleteBookingButton.setBounds(158, 379, 124, 46);
			getContentPane().add(deleteBookingButton);
			deleteBookingButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
			deleteBookingButton.setContentAreaFilled(true);
			deleteBookingButton.setFocusPainted(false);
			
			JLabel getLabel_id = new JLabel(dtoB.getId());
			getLabel_id.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_id.setBackground(Color.WHITE);
			getLabel_id.setBounds(60, 56, 215, 30);
			getContentPane().add(getLabel_id);
			
			JLabel getLabel_date = new JLabel(dtoB.getYear()+"-"+dtoB.getMonth()+"-"+dtoB.getDay());
			getLabel_date.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_date.setBackground(Color.WHITE);
			getLabel_date.setBounds(60, 182, 215, 30);
			getContentPane().add(getLabel_date);
			
			JLabel getLabel_tablenum = new JLabel(dtoB.getTableNum());
			getLabel_tablenum.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_tablenum.setBackground(Color.WHITE);
			getLabel_tablenum.setBounds(61, 266, 215, 30);
			getContentPane().add(getLabel_tablenum);
			
			JLabel getLabel_name2 = new JLabel(dtoB.getName());
			getLabel_name2.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_name2.setBackground(Color.WHITE);
			getLabel_name2.setBounds(60, 98, 215, 30);
			getContentPane().add(getLabel_name2);
			
			JLabel getLabel_tel = new JLabel(dtoB.getTel());
			getLabel_tel.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_tel.setBackground(Color.WHITE);
			getLabel_tel.setBounds(60, 141, 215, 30);
			getContentPane().add(getLabel_tel);
			
			JLabel getLabel_time = new JLabel(dtoB.getHour());
			getLabel_time.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_time.setBackground(Color.WHITE);
			getLabel_time.setBounds(60, 224, 215, 30);
			getContentPane().add(getLabel_time);
			
			JLabel getLabel_person = new JLabel(dtoB.getPerson());
			getLabel_person.setHorizontalAlignment(SwingConstants.CENTER);
			getLabel_person.setBackground(Color.WHITE);
			getLabel_person.setBounds(61, 308, 215, 30);
			getContentPane().add(getLabel_person);
			
			JLabel bookingFormLabel = new JLabel("");
			bookingFormLabel.setBackground(Color.WHITE);
			bookingFormLabel.setIcon(new ImageIcon("./img/booking/searchbookingform.png"));
			bookingFormLabel.setBounds(12, 56, 283, 312);
			getContentPane().add(bookingFormLabel);
			
			setVisible(true);
		}
		
		
		// 예약증 출력 버튼 클릭 시 사용될 메소드
		public void saveFile(BookingDTO dtoB) {		
			BookingDAO dao = new BookingDAO();
			BookingDTO dto = new BookingDTO();
			ArrayList<BookingDTO> list = dao.saveFileInBookingPageMember(dtoB);
			
			try {
				Writer w = new FileWriter("D:/" + dtoB.getName() + ".txt"); // 입력한 고객명으로 파일 이름 부여
				
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
			JOptionPane.showMessageDialog(null, dtoB.getName() + "님의 예약증.txt 파일이 생성되었습니다.");
		}
		
		// 예약 취소 버튼 클릭 시 사용될 메소드
		public void deleteBookingInfo(BookingDTO dtoB) {
			BookingDAO dao = new BookingDAO();
			dao.deleteInBookingInfoMember(dtoB);
			JOptionPane.showMessageDialog(null, "예약이 취소 되었습니다.");
		}
	
}
