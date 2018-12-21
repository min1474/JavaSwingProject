package mypage;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import category.Booking2;
import category.SearchBookingInfoMember;
import dao.BookingDAO;
import dao.MemberDAO;

import dto.BookingDTO;
import dto.MemberDTO;

import home.Login;

import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyBookingInfo extends JPanel {

	private MyPageFrame frame;
	private JTable myBookingListTable;
	private JScrollPane myBbookingListScrolllPane;

	String[] col = { "id","이름","연락처","년","월","일","시간","몇명","Tnum" };
	DefaultTableModel model = new DefaultTableModel(col, 0) {
		public boolean isCellEditable(int row, int column) {
			return false;
		}
	};
	// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.

	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.login(Login.tosID);


	public MyBookingInfo(MyPageFrame myPageFrame) {

		frame = myPageFrame;

		setBackground(Color.WHITE);
		setLayout(null);

		// -----------------각 패널매다 공통으로
		// 삽입되어야할UI부분---------------------------------------------------
		JLabel logoMypage = new JLabel("");
		logoMypage.setIcon(new ImageIcon("./img/mypage/logomypage.png"));
		logoMypage.setForeground(Color.WHITE);
		logoMypage.setBackground(Color.WHITE);
		logoMypage.setBounds(12, 10, 200, 74);
		add(logoMypage);

		JLabel tosIDLable = new JLabel(dto.getName());
		tosIDLable.setFont(new Font("굴림", Font.BOLD | Font.ITALIC, 15));
		tosIDLable.setHorizontalAlignment(SwingConstants.RIGHT);
		tosIDLable.setBounds(12, 94, 87, 22);
		add(tosIDLable);

		JLabel nimLable = new JLabel("\uB2D8\uC774");
		nimLable.setHorizontalAlignment(SwingConstants.CENTER);
		nimLable.setBounds(97, 94, 39, 22);
		add(nimLable);

		JLabel loginLable = new JLabel("\uB85C\uADF8\uC778 \uD558\uC168\uC2B5\uB2C8\uB2E4");
		loginLable.setBounds(12, 118, 124, 22);
		add(loginLable);

		JButton myBookingInfo = new JButton("");
		myBookingInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				frame.getCardLayout().show(frame.getContentPane(), "mybookinginfo");

			}

		});
		myBookingInfo.setIcon(new ImageIcon("./img/mypage/bookininfo.png"));
		myBookingInfo.setForeground(Color.WHITE);
		myBookingInfo.setFocusPainted(false);
		myBookingInfo.setContentAreaFilled(true);
		myBookingInfo.setBorderPainted(false);
		myBookingInfo.setBackground(Color.WHITE);
		myBookingInfo.setBounds(12, 172, 192, 48);
		add(myBookingInfo);

		JButton myReviewList = new JButton("");
		myReviewList.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.getCardLayout().show(frame.getContentPane(), "myPastReview");
			}
		});
		myReviewList.setIcon(new ImageIcon("./img/mypage/myreviewlist.png"));
		myReviewList.setForeground(Color.WHITE);
		myReviewList.setFocusPainted(false);
		myReviewList.setContentAreaFilled(true);
		myReviewList.setBorderPainted(false);
		myReviewList.setBackground(Color.WHITE);
		myReviewList.setBounds(12, 230, 192, 48);
		add(myReviewList);

		JButton reviewWrite = new JButton("");
		reviewWrite.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				frame.getCardLayout().show(frame.getContentPane(), "review");

			}
		});
		reviewWrite.setIcon(new ImageIcon("./img/mypage/review.png"));
		reviewWrite.setForeground(Color.WHITE);
		reviewWrite.setFocusPainted(false);
		reviewWrite.setContentAreaFilled(true);
		reviewWrite.setBorderPainted(false);
		reviewWrite.setBackground(Color.WHITE);
		reviewWrite.setBounds(12, 288, 192, 48);
		add(reviewWrite);

		JButton memberInfo = new JButton("");
		memberInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				MemberDAO dao = new MemberDAO();
				MemberDTO dto = dao.login(Login.tosID);
				MyInfoChange myInfo = new MyInfoChange(dto);
			}
		});

		memberInfo.setForeground(Color.WHITE);
		memberInfo.setBackground(Color.WHITE);
		memberInfo.setIcon(new ImageIcon("./img/mypage/memberinfo.png"));
		memberInfo.setBounds(12, 346, 192, 48);
		add(memberInfo);
		memberInfo.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		memberInfo.setContentAreaFilled(true);
		memberInfo.setFocusPainted(false);

		JButton closeButton = new JButton("");
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int quit = JOptionPane.showConfirmDialog(null, "로그아웃 하시겠습니까? 모든 세션이 종료됩니다.\n", "",
						JOptionPane.YES_NO_OPTION);

				if (quit == JOptionPane.YES_OPTION) {

					frame.dispose();
				} else {

				}
			}
		});
		closeButton.setIcon(new ImageIcon("./img/mypage/closemypage.png"));
		closeButton.setForeground(Color.WHITE);
		closeButton.setFocusPainted(false);
		closeButton.setContentAreaFilled(true);
		closeButton.setBorderPainted(false);
		closeButton.setBackground(Color.WHITE);
		closeButton.setBounds(12, 404, 192, 48);
		add(closeButton);

		// -----------------각 패널매다 공통으로
		// 삽입되어야할UI부분---------------------------------------------------

		JLabel bookingSignLabel = new JLabel("[ \uB098\uC758 \uC608\uC57D \uC815\uBCF4\uB4E4 \uC785\uB2C8\uB2E4. ]");
		bookingSignLabel.setHorizontalAlignment(SwingConstants.CENTER);
		bookingSignLabel.setForeground(Color.LIGHT_GRAY);
		bookingSignLabel.setBounds(430, 29, 156, 15);
		add(bookingSignLabel);

		myBookingListTable = new JTable(model);
		myBookingListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int r = myBookingListTable.getSelectedRow(); // 선택한 row(행)의 정보를 r에 담음
	
				BookingDTO dto = new BookingDTO();
				
				dto.setId((String) myBookingListTable.getValueAt(r, 0));
				dto.setName((String) myBookingListTable.getValueAt(r, 1)); // 첫번째 column(열) 에 대한 id 정보를 담음
				dto.setTel((String)myBookingListTable.getValueAt(r, 2));// 두번째 column(열) 에 대한 title 정보를 담음
				dto.setYear((String) myBookingListTable.getValueAt(r, 3));// 세번째 column(열) 에 대한 content 정보를 담음
				dto.setMonth((String) myBookingListTable.getValueAt(r, 4));// 네번째 column(열) 에 대한 grade 정보를 담음
				dto.setDay((String) myBookingListTable.getValueAt(r, 5));
				dto.setHour((String) myBookingListTable.getValueAt(r, 6));
				dto.setPerson((String) myBookingListTable.getValueAt(r, 7));
				dto.setTableNum((String) myBookingListTable.getValueAt(r, 8));

//				BookingDTO dtoB = dao.searchBookingMember(dto);
				
				SearchBookingInfoMember searchbookingmember = new SearchBookingInfoMember(dto);
				
				
			}
		});
		myBookingListTable.setBackground(Color.WHITE);
		myBookingListTable.setBounds(287, 56, 464, 320);
		add(myBookingListTable);

		myBbookingListScrolllPane = new JScrollPane(myBookingListTable);
		myBbookingListScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		myBbookingListScrolllPane.setLocation(287, 56);
		myBbookingListScrolllPane.setSize(464, 320);
		add(myBbookingListScrolllPane);
		
		// 테이블 내용 가운데 정렬하기
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = myBookingListTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(2).setCellRenderer(dtcr);
		tcm.getColumn(3).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		tcm.getColumn(5).setCellRenderer(dtcr);
		tcm.getColumn(6).setCellRenderer(dtcr);
		tcm.getColumn(7).setCellRenderer(dtcr);
		tcm.getColumn(8).setCellRenderer(dtcr);

		// 전체 열에 지정
		// for(int i = 0 ; i < tcm.getColumnCount() ; i++){
		// tcm.getColumn(i).setCellRenderer(dtcr);
		// 컬럼모델에서 컬럼의 갯수만큼 컬럼을 가져와 for문을 이용하여
		// 각각의 셀렌더러를 아까 생성한 dtcr에 set해줌
		// }

		myBookingListTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		myBookingListTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(0).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(1).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(1).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(2).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(2).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(3).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(3).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(4).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(4).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(5).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(5).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(6).setPreferredWidth(50);
		myBookingListTable.getColumnModel().getColumn(6).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(7).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(7).setResizable(false);
		myBookingListTable.getColumnModel().getColumn(8).setPreferredWidth(2);
		myBookingListTable.getColumnModel().getColumn(8).setResizable(false);


		JButton bookingOutPut = new JButton("");
		bookingOutPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				ArrayList<BookingDTO> list;
				BookingDAO daoB = new BookingDAO();

				try {

					list = daoB.select(dto);

					int count = myBookingListTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) { // 테이블에 값들이 중복출력되지 않게함
						model.removeRow(0); // 테이블에 값들이 중복출력되지 않게함
					}

					for (int i = 0; i < list.size(); i++) {
						BookingDTO dto = list.get(i);

						model.addRow(new Object[] {
								dto.getId(),dto.getName(), dto.getTel(),dto.getYear(), dto.getMonth(), dto.getDay(),
								dto.getHour(),dto.getPerson(),dto.getTableNum()});
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		bookingOutPut.setIcon(new ImageIcon("./img/mypage/mybookingoutput.png"));
		bookingOutPut.setBackground(Color.WHITE);
		bookingOutPut.setBounds(627, 404, 124, 48);
		add(bookingOutPut);
		bookingOutPut.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		bookingOutPut.setContentAreaFilled(true);
		bookingOutPut.setFocusPainted(false);

		JButton bookingbutton = new JButton("");
		bookingbutton.setIcon(new ImageIcon("./img/mypage/bookingbutton.png"));
		bookingbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Booking2 booking = new Booking2(dto);
			}
		});
		bookingbutton.setFocusPainted(false);
		bookingbutton.setContentAreaFilled(true);
		bookingbutton.setBorderPainted(false);
		bookingbutton.setBackground(Color.WHITE);
		bookingbutton.setBounds(287, 404, 124, 48);
		add(bookingbutton);

		JLabel myBookingForm = new JLabel("");
		myBookingForm.setIcon(new ImageIcon("./img/mypage/reviewformframe.png"));
		myBookingForm.setBounds(269, 10, 500, 456);
		add(myBookingForm);

		setSize(800, 476);
		setVisible(true);

	}
}
