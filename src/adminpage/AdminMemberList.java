package adminpage;

import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import dao.AdminDAO;
import dao.MemberDAO;

import dto.AdminDTO;
import dto.MemberDTO;
import other.MyJOptionPane;
import service.ServiceServerCenter;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class AdminMemberList extends JPanel {

	// AdminMemberList메소드 에 해당
	private AdminFrame frame;
	private JTable totalMemberListTable;
	private JTable totalAdminListTable;
	private JTextField memberSearchTextField;
	private JScrollPane totalMemberListScrolllPane;
	private JScrollPane totalAdminListScrolllPane;

	String[] col = { "회원번호", "아이디", "이름", "이메일", "연락처" };
	DefaultTableModel model = new DefaultTableModel(col, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.
	DefaultTableModel model2 = new DefaultTableModel(col, 0);

	// model = 일반회원 조회 모델, model2 = 관리자 조회 모델

	AdminDAO daoA = new AdminDAO();
	AdminDTO dtoA = daoA.login(AdminLogin.tosAdminID); // 관리자 로그인시 로그인 유지 객체

	public AdminMemberList(AdminFrame adminFrame) {
		setBackground(Color.WHITE);

		frame = adminFrame;

		setSize(990, 720);
		setLayout(null);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로

		totalMemberListTable = new JTable(model);
		totalMemberListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {

				int r = totalMemberListTable.getSelectedRow(); // 선택한 row(행)의 정보를 r에 담음
				String id = (String) totalMemberListTable.getValueAt(r, 1); // 첫번째 column(열) 에 대한 id 정보를 담음
				String name = (String) totalMemberListTable.getValueAt(r, 2);// 두번째 column(열) 에 대한 title 정보를 담음
				String email = (String) totalMemberListTable.getValueAt(r, 3);// 세번째 column(열) 에 대한 content 정보를 담음
				String tel = (String) totalMemberListTable.getValueAt(r, 4);// 네번째 column(열) 에 대한 grade 정보를 담음

				MemberDAO dao = new MemberDAO();
				MemberDTO dto = dao.select(id);

				AdminMemberSearch search = new AdminMemberSearch(dto, id, name, email, tel, null);

			}
		});
		totalMemberListTable.setFont(new Font("굴림", Font.PLAIN, 15));
		totalMemberListTable.setBackground(Color.WHITE);
		totalMemberListTable.setBounds(44, 87, 440, 281);
		add(totalMemberListTable);
		totalMemberListScrolllPane = new JScrollPane(totalMemberListTable);
		totalMemberListScrolllPane.setBackground(Color.WHITE);
		totalMemberListScrolllPane.setForeground(Color.BLUE);
		totalMemberListScrolllPane.setLocation(18, 84);
		totalMemberListScrolllPane.setSize(696, 529);
		add(totalMemberListScrolllPane);
		
		TableColumnModel tcm = totalMemberListTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		
		totalMemberListTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		totalMemberListTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		totalMemberListTable.getColumnModel().getColumn(0).setResizable(false);
		totalMemberListTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		totalMemberListTable.getColumnModel().getColumn(1).setResizable(false);
		totalMemberListTable.getColumnModel().getColumn(2).setPreferredWidth(20);
		totalMemberListTable.getColumnModel().getColumn(2).setResizable(false);
		totalMemberListTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		totalMemberListTable.getColumnModel().getColumn(3).setResizable(false);
		totalMemberListTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		totalMemberListTable.getColumnModel().getColumn(4).setResizable(false);

		totalAdminListTable = new JTable(model2);
		totalAdminListTable.setFont(new Font("굴림", Font.PLAIN, 15));
		totalAdminListTable.setBackground(Color.WHITE);
		totalAdminListTable.setBounds(44, 87, 440, 281);
		add(totalAdminListTable);
		totalAdminListScrolllPane = new JScrollPane(totalAdminListTable);
		totalAdminListScrolllPane.setBackground(Color.WHITE);
		totalAdminListScrolllPane.setForeground(Color.BLUE);
		totalAdminListScrolllPane.setLocation(18, 84);
		totalAdminListScrolllPane.setSize(696, 529);
		add(totalAdminListScrolllPane);
		
		TableColumnModel tcm2 = totalAdminListTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		
		totalAdminListTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		totalAdminListTable.getColumnModel().getColumn(0).setPreferredWidth(5);
		totalAdminListTable.getColumnModel().getColumn(0).setResizable(false);
		totalAdminListTable.getColumnModel().getColumn(1).setPreferredWidth(20);
		totalAdminListTable.getColumnModel().getColumn(1).setResizable(false);
		totalAdminListTable.getColumnModel().getColumn(2).setPreferredWidth(20);
		totalAdminListTable.getColumnModel().getColumn(2).setResizable(false);
		totalAdminListTable.getColumnModel().getColumn(3).setPreferredWidth(70);
		totalAdminListTable.getColumnModel().getColumn(3).setResizable(false);
		totalAdminListTable.getColumnModel().getColumn(4).setPreferredWidth(30);
		totalAdminListTable.getColumnModel().getColumn(4).setResizable(false);

		memberSearchTextField = new JTextField("");
		memberSearchTextField.setForeground(Color.GRAY);
		memberSearchTextField.setBounds(103, 675, 136, 23);
		add(memberSearchTextField);
		memberSearchTextField.setColumns(10);

		JComboBox memberBox = new JComboBox();
		memberBox.setModel(new DefaultComboBoxModel(new String[] { "일반회원", "관리자" }));
		memberBox.setBounds(20, 675, 83, 23);
		add(memberBox);

		JButton SearchButton = new JButton("\uAC80\uC0C9");
		SearchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (memberBox.getSelectedItem().equals("일반회원")) {

					MemberDAO dao = new MemberDAO();
					ArrayList<MemberDTO> list;
					try {

						list = dao.selectSomeId(memberSearchTextField.getText());

						int count = totalMemberListTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
						for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
							model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
						}

						for (int i = 0; i < list.size(); i++) {
							MemberDTO dto = list.get(i);
							model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getName(), dto.getEmail(),
									dto.getTel() });

						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else if (memberBox.getSelectedItem().equals("관리자")) {

					AdminDAO dao = new AdminDAO();
					AdminDTO dto = dao.select(memberSearchTextField.getText());

					AdminMemberform adminmember = new AdminMemberform(dto);

				}

			}
		});

		SearchButton.setBackground(Color.LIGHT_GRAY);
		SearchButton.setBounds(236, 675, 66, 23);
		add(SearchButton);

		JButton totalMember = new JButton("");
		totalMember.setIcon(new ImageIcon("./img/admin/membersearch.png"));
		totalMember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MemberDAO dao = new MemberDAO();
				ArrayList<MemberDTO> list;
				try {

					totalMemberListTable.setVisible(true);
					int count = totalMemberListTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {
						MemberDTO dto = list.get(i);
						model.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getName(), dto.getEmail(),
								dto.getTel() });
					}
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});
		totalMember.setBackground(Color.WHITE);
		totalMember.setBounds(524, 623, 162, 62);
		add(totalMember);
		totalMember.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		totalMember.setContentAreaFilled(true);
		totalMember.setFocusPainted(false);
		totalMember.setOpaque(true);

		JButton totaladminmember = new JButton("");
		totaladminmember.setBackground(Color.WHITE);
		totaladminmember.setIcon(new ImageIcon("./img/admin/adminmembersearch.png"));
		totaladminmember.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				totalMemberListTable.setVisible(false);

				AdminDAO dao = new AdminDAO();
				ArrayList<AdminDTO> list;
				try {
					int count = totalAdminListTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model2.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					list = dao.selectAll();
					for (int i = 0; i < list.size(); i++) {
						AdminDTO dto = list.get(i);
						model2.addRow(new Object[] { dto.getNum(), dto.getId(), dto.getName(), dto.getEmail(),
								dto.getTel() });
					}
					MyJOptionPane my = new MyJOptionPane();
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}
		});

		totaladminmember.setBounds(352, 623, 162, 62);
		add(totaladminmember);
		totaladminmember.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		totaladminmember.setContentAreaFilled(true);
		totaladminmember.setFocusPainted(false);
		totaladminmember.setOpaque(true);

		// -----------------------각 패널에 동일하게 들어갈 버튼들.
		// --------------------------------------------------//

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

		JLabel infoLable = new JLabel("[관리자 수정방법]");
		infoLable.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		infoLable.setBounds(28, 615, 274, 14);
		add(infoLable);

		JLabel infoLable2 = new JLabel("1. 관리자 전체검색 버튼 클릭 ");
		infoLable2.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		infoLable2.setBounds(28, 629, 274, 14);
		add(infoLable2);

		JLabel infoLable3 = new JLabel("2. 박스에서 관리자 선택 ");
		infoLable3.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		infoLable3.setBounds(28, 643, 274, 14);
		add(infoLable3);

		JLabel infoLable4 = new JLabel("3. 검색칸에서 해당 ID 입력 후 검색 ");
		infoLable4.setFont(new Font("맑은 고딕", Font.PLAIN, 10));
		infoLable4.setBounds(28, 658, 274, 14);
		add(infoLable4);

		JLabel admininnerframe = new JLabel("");
		admininnerframe.setIcon(new ImageIcon("./img/admin/totalmembersearchframe.png"));
		admininnerframe.setBounds(12, 24, 708, 686);
		add(admininnerframe);

		// -----------------------각 패널에 동일하게 들어갈 버튼들.
		// --------------------------------------------------//

	}
}
