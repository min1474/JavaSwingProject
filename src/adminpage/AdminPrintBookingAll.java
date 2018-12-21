package adminpage;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.BookingDAO;
import dto.BookingDTO;
import other.MyJOptionPane;

public class AdminPrintBookingAll {
	
	// 전체 예약 정보 저장(출력)하는 메소드 
	public void saveFileAll() {		
		BookingDAO dao = new BookingDAO();
		BookingDTO dto = new BookingDTO();
		ArrayList<BookingDTO> list = dao.saveFileAll(); // 현재 메소드가 DAO메소드랑 이름 같기 때문에 헷갈리지 마시길...
		
		final String FILE_NAME = "전체 예약 정보"; // 저장할 파일 이름
		try {
			Writer w = new FileWriter("D:/" + FILE_NAME + ".txt");
			
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
		MyJOptionPane my = new MyJOptionPane();
		my.showMessageDialog(FILE_NAME +".txt 파일이 생성되었습니다.");
//	JOptionPane.showMessageDialog(null, FILE_NAME + ".txt 파일이 생성되었습니다.");
	}
	
	// 메인 생성자
	public AdminPrintBookingAll() {
		saveFileAll();
	}
	

}
