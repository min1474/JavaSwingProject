package adminpage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;

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
import service.ServiceServerCenter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminTotalBooking extends JPanel {

	private AdminFrame frame;
	private JTable totalReviewTable;
	private JScrollPane totalReviewScrolllPane;

	String[] col = { "테이블", "아이디", "이름", "연락처", "몇명", "년", "월", "일", "몇시" };

	DefaultTableModel model = new DefaultTableModel(col, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.

	AdminDAO daoA = new AdminDAO();
	AdminDTO dtoA = daoA.login(AdminLogin.tosAdminID);

	public AdminTotalBooking(AdminFrame adminFrame) {
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		setBackground(Color.WHITE);

		frame = adminFrame;

		setSize(990, 720);
		setLayout(null);

		totalReviewTable = new JTable(model);
		totalReviewTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		totalReviewTable.setBounds(45, 86, 439, 282);
		add(totalReviewTable);

		totalReviewScrolllPane = new JScrollPane(totalReviewTable);
		totalReviewScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		totalReviewScrolllPane.setLocation(18, 84);
		totalReviewScrolllPane.setSize(696, 529);
		add(totalReviewScrolllPane);
		
		TableColumnModel tcm = totalReviewTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(5).setCellRenderer(dtcr);
		tcm.getColumn(6).setCellRenderer(dtcr);
		tcm.getColumn(7).setCellRenderer(dtcr);
		tcm.getColumn(8).setCellRenderer(dtcr);
		
		totalReviewTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		
		totalReviewTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		totalReviewTable.getColumnModel().getColumn(0).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(1).setPreferredWidth(30);
		totalReviewTable.getColumnModel().getColumn(1).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(2).setPreferredWidth(30);
		totalReviewTable.getColumnModel().getColumn(2).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		totalReviewTable.getColumnModel().getColumn(3).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(4).setPreferredWidth(5);
		totalReviewTable.getColumnModel().getColumn(4).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(5).setPreferredWidth(5);
		totalReviewTable.getColumnModel().getColumn(5).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(6).setPreferredWidth(5);
		totalReviewTable.getColumnModel().getColumn(6).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(7).setPreferredWidth(5);
		totalReviewTable.getColumnModel().getColumn(7).setResizable(false);
		totalReviewTable.getColumnModel().getColumn(8).setPreferredWidth(50);
		totalReviewTable.getColumnModel().getColumn(8).setResizable(false);

		JButton totalSearchButton = new JButton("");
		totalSearchButton.setIcon(new ImageIcon("./img/admin/totalbookingsearch.png"));
		totalSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				BookingDAO dao = new BookingDAO();
				ArrayList<BookingDTO> list;
				try {
					list = dao.selectAll();

					int count = totalReviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);
						model.addRow(new Object[] { dto.getTableNum(), dto.getId(), dto.getName(), dto.getTel(),
								dto.getPerson(), dto.getYear(), dto.getMonth(), dto.getDay(), dto.getHour() });

					}
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		totalSearchButton.setBackground(Color.WHITE);
		totalSearchButton.setBounds(539, 630, 162, 62);
		add(totalSearchButton);
		totalSearchButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		totalSearchButton.setContentAreaFilled(true);
		totalSearchButton.setFocusPainted(false);
		totalSearchButton.setOpaque(true);

		// -----------------------각 패널에 동일하게 들어갈 버튼들.
		// --------------------------------------------------//

		JButton todayBooking = new JButton("");
		todayBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getCardLayout().show(frame.getContentPane(), "todaybooking");
			}
		});

		JButton printTotalButton = new JButton("");
		printTotalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminPrintBookingAll printAll = new AdminPrintBookingAll();
			}
		});
		printTotalButton
				.setIcon(new ImageIcon("./img/admin/printtotal.png"));
		printTotalButton.setOpaque(true);
		printTotalButton.setFocusPainted(false);
		printTotalButton.setContentAreaFilled(true);
		printTotalButton.setBorderPainted(false);
		printTotalButton.setBackground(Color.WHITE);
		printTotalButton.setBounds(365, 630, 162, 62);
		add(printTotalButton);

		JButton printSearchButton = new JButton("");
		printSearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AdminPrintBooking printSearch = new AdminPrintBooking();

			}
		});
		printSearchButton.setIcon(
				new ImageIcon("./img/admin/printsearch.png"));
		printSearchButton.setOpaque(true);
		printSearchButton.setFocusPainted(false);
		printSearchButton.setContentAreaFilled(true);
		printSearchButton.setBorderPainted(false);
		printSearchButton.setBackground(Color.WHITE);
		printSearchButton.setBounds(191, 630, 162, 62);
		add(printSearchButton);
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

		JLabel admininnerframe = new JLabel("");
		admininnerframe.setIcon(new ImageIcon("./img/admin/totalbookinlistframe.png"));
		admininnerframe.setBounds(12, 24, 708, 686);
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

	}
}
