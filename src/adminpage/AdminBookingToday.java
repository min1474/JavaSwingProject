package adminpage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.AdminDAO;
import dao.BookingDAO;
import dto.AdminDTO;
import dto.BookingDTO;
import home.Login;
import service.ServiceServerCenter;

import java.awt.Font;

public class AdminBookingToday extends JPanel {
	
	private AdminFrame frame;
	private JTable table1;
	private JTable table2;
	private JTable table3;
	private JTable table4;
	private JScrollPane todayBbookingListScrolllPane;

	String[] col = {"아이디", "이름","연락처","몇명","몇시" };
	DefaultTableModel model1 = new DefaultTableModel(col, 0) { public boolean isCellEditable(int row, int column) {return false;}};
	DefaultTableModel model2 = new DefaultTableModel(col, 0) { public boolean isCellEditable(int row, int column) {return false;}};	
	DefaultTableModel model3 = new DefaultTableModel(col, 0) { public boolean isCellEditable(int row, int column) {return false;}};	
	DefaultTableModel model4 = new DefaultTableModel(col, 0) { public boolean isCellEditable(int row, int column) {return false;}};	
															 	// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.
	BookingDAO dao = new BookingDAO();
	BookingDTO	dto = new BookingDTO();
	
	AdminDAO daoA = new AdminDAO();
	AdminDTO dtoA = daoA.login(AdminLogin.tosAdminID);
	
		
	//가져올 정보 조건 : 테이블번호, 아이디, 이름 , 전화번호, 몇명 인지, 몇시인지  를 가져와라 년 월 일 을 기준으로
	/// select tablenum, id, name, tel, person, hour from booking where year = ? and month = ? and day= ?;
	
	public AdminBookingToday(AdminFrame adminFrame) {
		
		setBackground(Color.WHITE);
		
		frame = adminFrame;
		
		setSize(990, 720);
		setLayout(null);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		
		table1 = new JTable(model1);
		table1.setBounds(128, 82, 122, 95);
		add(table1);
		todayBbookingListScrolllPane = new JScrollPane(table1);
		todayBbookingListScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		todayBbookingListScrolllPane.setLocation(44, 156);
		todayBbookingListScrolllPane.setSize(299, 100);
		add(todayBbookingListScrolllPane);
		
		TableColumnModel tcm = table1.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		
		table1.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table1.getColumnModel().getColumn(0).setPreferredWidth(20);
		table1.getColumnModel().getColumn(0).setResizable(false);
		table1.getColumnModel().getColumn(1).setPreferredWidth(20);
		table1.getColumnModel().getColumn(1).setResizable(false);
		table1.getColumnModel().getColumn(2).setPreferredWidth(40);
		table1.getColumnModel().getColumn(2).setResizable(false);
		table1.getColumnModel().getColumn(3).setPreferredWidth(1);
		table1.getColumnModel().getColumn(3).setResizable(false);
		table1.getColumnModel().getColumn(4).setPreferredWidth(50);
		table1.getColumnModel().getColumn(4).setResizable(false);
		
		
		table2 = new JTable(model2);
		table2.setBounds(382, 82, 122, 95);
		add(table2);
		todayBbookingListScrolllPane = new JScrollPane(table2);
		todayBbookingListScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		todayBbookingListScrolllPane.setLocation(389, 156);
		todayBbookingListScrolllPane.setSize(299, 100);
		add(todayBbookingListScrolllPane);
		
		TableColumnModel tcm2 = table2.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm2.getColumn(0).setCellRenderer(dtcr);
		tcm2.getColumn(1).setCellRenderer(dtcr);
		tcm2.getColumn(2).setCellRenderer(dtcr);
		tcm2.getColumn(3).setCellRenderer(dtcr);
		tcm2.getColumn(4).setCellRenderer(dtcr);
		
		table2.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table2.getColumnModel().getColumn(0).setPreferredWidth(20);
		table2.getColumnModel().getColumn(0).setResizable(false);
		table2.getColumnModel().getColumn(1).setPreferredWidth(20);
		table2.getColumnModel().getColumn(1).setResizable(false);
		table2.getColumnModel().getColumn(2).setPreferredWidth(40);
		table2.getColumnModel().getColumn(2).setResizable(false);
		table2.getColumnModel().getColumn(3).setPreferredWidth(1);
		table2.getColumnModel().getColumn(3).setResizable(false);
		table2.getColumnModel().getColumn(4).setPreferredWidth(50);
		table2.getColumnModel().getColumn(4).setResizable(false);
		
		table3 = new JTable(model3);
		table3.setBounds(382, 275, 122, 95);
		add(table3);
		todayBbookingListScrolllPane = new JScrollPane(table3);
		todayBbookingListScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		todayBbookingListScrolllPane.setLocation(389, 432);
		todayBbookingListScrolllPane.setSize(299, 100);
		add(todayBbookingListScrolllPane);
		
		TableColumnModel tcm3 = table3.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm3.getColumn(0).setCellRenderer(dtcr);
		tcm3.getColumn(1).setCellRenderer(dtcr);
		tcm3.getColumn(2).setCellRenderer(dtcr);
		tcm3.getColumn(3).setCellRenderer(dtcr);
		tcm3.getColumn(4).setCellRenderer(dtcr);
		
		table3.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table3.getColumnModel().getColumn(0).setPreferredWidth(20);
		table3.getColumnModel().getColumn(0).setResizable(false);
		table3.getColumnModel().getColumn(1).setPreferredWidth(20);
		table3.getColumnModel().getColumn(1).setResizable(false);
		table3.getColumnModel().getColumn(2).setPreferredWidth(40);
		table3.getColumnModel().getColumn(2).setResizable(false);
		table3.getColumnModel().getColumn(3).setPreferredWidth(1);
		table3.getColumnModel().getColumn(3).setResizable(false);
		table3.getColumnModel().getColumn(4).setPreferredWidth(50);
		table3.getColumnModel().getColumn(4).setResizable(false);
		
		table4 = new JTable(model4);
		table4.setBounds(128, 275, 122, 95);
		add(table4);
		todayBbookingListScrolllPane = new JScrollPane(table4);
		todayBbookingListScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		todayBbookingListScrolllPane.setLocation(44, 432);
		todayBbookingListScrolllPane.setSize(299, 100);
		add(todayBbookingListScrolllPane);
		
		TableColumnModel tcm4 = table4.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm4.getColumn(0).setCellRenderer(dtcr);
		tcm4.getColumn(1).setCellRenderer(dtcr);
		tcm4.getColumn(2).setCellRenderer(dtcr);
		tcm4.getColumn(3).setCellRenderer(dtcr);
		tcm4.getColumn(4).setCellRenderer(dtcr);
		
		table4.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		table4.getColumnModel().getColumn(0).setPreferredWidth(20);
		table4.getColumnModel().getColumn(0).setResizable(false);
		table4.getColumnModel().getColumn(1).setPreferredWidth(20);
		table4.getColumnModel().getColumn(1).setResizable(false);
		table4.getColumnModel().getColumn(2).setPreferredWidth(40);
		table4.getColumnModel().getColumn(2).setResizable(false);
		table4.getColumnModel().getColumn(3).setPreferredWidth(1);
		table4.getColumnModel().getColumn(3).setResizable(false);
		table4.getColumnModel().getColumn(4).setPreferredWidth(50);
		table4.getColumnModel().getColumn(4).setResizable(false);
		
		
					
		JComboBox yearComboBox = new JComboBox();
		yearComboBox.setForeground(Color.GRAY);
		yearComboBox.setBackground(Color.WHITE);
		yearComboBox.setModel(new DefaultComboBoxModel(new String[] {"2018", "2019", "2020"}));
		
		
		
		yearComboBox.setBounds(344, 40, 56, 29);
		add(yearComboBox);
		
		JComboBox monthComboBox = new JComboBox();
		monthComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"}));
		monthComboBox.setForeground(Color.GRAY);
		monthComboBox.setBackground(Color.WHITE);
		monthComboBox.setBounds(426, 40, 38, 29);
		add(monthComboBox);
		
		JComboBox dateComboBox = new JComboBox();
		dateComboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		dateComboBox.setForeground(Color.GRAY);
		dateComboBox.setBackground(Color.WHITE);
		dateComboBox.setBounds(488, 40, 47, 29);
		add(dateComboBox);
		
		JLabel lblNewLabel = new JLabel("\u3161");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(397, 47, 33, 15);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u3161");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(460, 47, 33, 15);
		add(label);
		
		JButton todayTableButton = new JButton("");
		todayTableButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ArrayList<BookingDTO> list;
				BookingDAO daoB = new BookingDAO();

				dto.setYear((String)yearComboBox.getSelectedItem());
				dto.setMonth((String)monthComboBox.getSelectedItem());
				dto.setDay((String)dateComboBox.getSelectedItem());
				
				try {
					
					list = daoB.selectDateTable1(dto); //1번테이블 메소드
//					list = daoB.selectDateTable2(dto); //2번테이블 메소드
//					list = daoB.selectDateTable3(dto); //3번테이블 메소드
//					list = daoB.selectDateTable4(dto); //4번테이블 메소드
					
					int count = table1.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model1.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);

						model1.addRow(new Object[] {dto.getId(), dto.getName(),dto.getTel(),dto.getPerson(),dto.getHour() });
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					

					list = daoB.selectDateTable2(dto); //2번테이블 메소드

					
					int count = table2.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model2.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);

						model2.addRow(new Object[] {dto.getId(), dto.getName(),dto.getTel(),dto.getPerson(),dto.getHour() });
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					

					list = daoB.selectDateTable3(dto); //3번테이블 메소드

					int count = table3.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model3.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);

						model3.addRow(new Object[] {dto.getId(), dto.getName(),dto.getTel(),dto.getPerson(),dto.getHour() });
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
				try {
					

					list = daoB.selectDateTable4(dto); //4번테이블 메소드
					
					int count = table4.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model4.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);

						model4.addRow(new Object[] {dto.getId(), dto.getName(),dto.getTel(),dto.getPerson(),dto.getHour() });
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				
			}
		});
		
		todayTableButton.setIcon(new ImageIcon("./img/admin/tadaybookinglistbutton.png"));
		todayTableButton.setForeground(Color.WHITE);
		todayTableButton.setBackground(Color.WHITE);
		todayTableButton.setBounds(14, 13, 318, 58);
		add(todayTableButton);
		todayTableButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		todayTableButton.setContentAreaFilled(true);
		todayTableButton.setFocusPainted(false);
		todayTableButton.setOpaque(true);
		
// -----------------------각 패널에 동일하게 들어갈 버튼들.	--------------------------------------------------//
		
		
		JButton todayBooking = new JButton("");
		todayBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {				
				frame.getCardLayout().show(frame.getContentPane(), "todaybooking");
			}
		});
		todayBooking.setIcon(new ImageIcon("./img/admin/todaybookingbutton.png"));
		todayBooking.setOpaque(true);
		todayBooking.setFocusPainted(false);
		todayBooking.setContentAreaFilled(true);
		todayBooking.setBorderPainted(false);
		todayBooking.setBackground(Color.WHITE);
		todayBooking.setBounds(746, 318, 220, 62);
		add(todayBooking);
		
		
		
		JButton memberSearchButton = new JButton("");
		memberSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.getCardLayout().show(frame.getContentPane(), "adminMemberlist");
				
			}
		});

		memberSearchButton.setIcon(new ImageIcon("./img/admin/memberinfosearchbutton.png"));
		memberSearchButton.setBackground(Color.WHITE);
		memberSearchButton.setBounds(746, 396, 220, 62);
		add(memberSearchButton);
		memberSearchButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		memberSearchButton.setContentAreaFilled(true);
		memberSearchButton.setFocusPainted(false);
		memberSearchButton.setOpaque(true);
		
		JButton bookingListButton = new JButton("");
		bookingListButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getCardLayout().show(frame.getContentPane(), "bookingList");
			}
		});
		bookingListButton.setIcon(new ImageIcon("./img/admin/totalbookinlistbutton.png"));
		bookingListButton.setOpaque(true);
		bookingListButton.setFocusPainted(false);
		bookingListButton.setContentAreaFilled(true);
		bookingListButton.setBorderPainted(false);
		bookingListButton.setBackground(Color.WHITE);
		bookingListButton.setBounds(746, 474, 220, 62);
		add(bookingListButton);
		
		
		
		JButton serviceButton = new JButton("");
		serviceButton.setIcon(new ImageIcon("./img/admin/serviceCenter.png"));
		serviceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ServiceServerCenter server = new ServiceServerCenter();
			}
		});
		serviceButton.setOpaque(true);
		serviceButton.setFocusPainted(false);
		serviceButton.setContentAreaFilled(true);
		serviceButton.setBorderPainted(false);
		serviceButton.setBackground(Color.WHITE);
		serviceButton.setBounds(746, 550, 220, 62);
		add(serviceButton);
		
		
		JButton exitButton = new JButton("");
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		exitButton.setIcon(new ImageIcon("./img/admin/exitbutton.png"));
		exitButton.setOpaque(true);
		exitButton.setFocusPainted(false);
		exitButton.setContentAreaFilled(true);
		exitButton.setBorderPainted(false);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBounds(746, 626, 220, 62);
		add(exitButton);
		
		JLabel todayTableLable = new JLabel("");
		todayTableLable.setIcon(new ImageIcon("./img/admin/todaytable.png"));
		todayTableLable.setBounds(38, 104, 659, 593);
		add(todayTableLable);
		
		JLabel admininnerframe = new JLabel("");
		admininnerframe.setIcon(new ImageIcon("./img/admin/admininnerframe.png"));
		admininnerframe.setBounds(15, 71, 708, 632);
		add(admininnerframe);
		
		JLabel adminoutframe = new JLabel("");
		adminoutframe.setIcon(new ImageIcon("./img/admin/adminframe.png"));
		adminoutframe.setBackground(Color.WHITE);
		adminoutframe.setBounds(0, 0, 990, 720);
		add(adminoutframe);
		
		JLabel adminIcon = new JLabel("");
		adminIcon.setIcon(new ImageIcon("./img/admin/adminIcon.png"));
		adminIcon.setBounds(754, 40, 200, 136);
		add(adminIcon);
		
		JLabel tosIDLable = new JLabel(dtoA.getId());
		tosIDLable.setFont(new Font("굴림", Font.PLAIN, 20));
		tosIDLable.setHorizontalAlignment(SwingConstants.RIGHT);
		tosIDLable.setBounds(764, 186, 89, 23);
		add(tosIDLable);
		
		JLabel label_1 = new JLabel("관리자님이");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setBounds(865, 186, 89, 23);
		add(label_1);
		
		JLabel label_2 = new JLabel("로그인중입니다");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setBounds(764, 209, 190, 23);
		add(label_2);
		
// -----------------------각 패널에 동일하게 들어갈 버튼들.	--------------------------------------------------//		
		

		setVisible(true);
	}
}
