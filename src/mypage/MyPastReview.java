package mypage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import category.WatchReview;
import dao.MemberDAO;
import dao.ReviewDAO;
import dto.MemberDTO;
import dto.ReviewDTO;
import home.Login;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyPastReview extends JPanel{
	
	private MyPageFrame frame;
	JTable myReviewTable;
	private JScrollPane myReviewScrolllPane;
	String[] col = {"글번호","아이디","제목", "내용","평점"};
	DefaultTableModel model = new DefaultTableModel(col, 0) {public boolean isCellEditable(int row, int column) {return false;}};
																// 테이블에 데이터가 출력되면 클릭해서 정보를 수정 할수 없게 막는 메소드.
	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.login(Login.tosID);
	
	public MyPastReview(MyPageFrame myPageFrame) {
	
		frame = myPageFrame;
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		//-----------------각 패널매다 공통으로 삽입되어야할 UI부분---------------------------------------------------	
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
//-----------------각 패널매다 공통으로 삽입되어야할 UI부분---------------------------------------------------
		
		
		myReviewTable = new JTable(model);
		myReviewTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// mouseClicked 만 사용

				int r = myReviewTable.getSelectedRow(); // 선택한 row(행)의 정보를 r에 담음
				
				String num = (String) myReviewTable.getValueAt(r, 0);
				String id = (String) myReviewTable.getValueAt(r, 1); // 첫번째 column(열) 에 대한 id 정보를 담음
				String title = (String) myReviewTable.getValueAt(r, 2);// 두번째 column(열) 에 대한 title 정보를 담음
				String content = (String) myReviewTable.getValueAt(r, 3);// 세번째 column(열) 에 대한 content 정보를 담음
				String grade = (String) myReviewTable.getValueAt(r, 4);// 네번째 column(열) 에 대한 grade 정보를 담음

				WatchMyReview watchMyReview = new WatchMyReview(num, id, title, content, grade, null);
				
			}
		});
		myReviewTable.setBounds(285, 57, 471, 303);
		add(myReviewTable);
		myReviewScrolllPane = new JScrollPane(myReviewTable);
		myReviewScrolllPane.setViewportBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		myReviewScrolllPane.setLocation(285, 57);
		myReviewScrolllPane.setSize(471, 303);
		add(myReviewScrolllPane);
		
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer(); // 디폴트테이블셀렌더러를 생성
		dtcr.setHorizontalAlignment(SwingConstants.CENTER); // 렌더러의 가로정렬을 CENTER로
		TableColumnModel tcm = myReviewTable.getColumnModel(); // 정렬할 테이블의 컬럼모델을 가져옴
		// 특정 열에 지정
		tcm.getColumn(0).setCellRenderer(dtcr);
		tcm.getColumn(1).setCellRenderer(dtcr);
		tcm.getColumn(4).setCellRenderer(dtcr);
		
		myReviewTable.getTableHeader().setReorderingAllowed(false);
		// 테이블 컬럼의 이동을 방지한다. 이거 안쓰면 마우스로 드로그 앤 드롭으로 엉망진창이 될수 있다.
		myReviewTable.getColumnModel().getColumn(0).setPreferredWidth(2);
		myReviewTable.getColumnModel().getColumn(0).setResizable(false);
		myReviewTable.getColumnModel().getColumn(1).setPreferredWidth(2);
		myReviewTable.getColumnModel().getColumn(1).setResizable(false);
		myReviewTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		myReviewTable.getColumnModel().getColumn(2).setResizable(false);
		myReviewTable.getColumnModel().getColumn(3).setPreferredWidth(150);
		myReviewTable.getColumnModel().getColumn(3).setResizable(false);
		myReviewTable.getColumnModel().getColumn(4).setPreferredWidth(2);
		myReviewTable.getColumnModel().getColumn(4).setResizable(false);


		
		
		
		JLabel pastReviewSignLabel = new JLabel("[ \uB098\uC758 \uC9C0\uB09C \uB9AC\uBDF0 \uC791\uC131\uAE00 \uC785\uB2C8\uB2E4. ]");
		pastReviewSignLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pastReviewSignLabel.setForeground(Color.LIGHT_GRAY);
		pastReviewSignLabel.setBounds(417, 28, 192, 15);
		add(pastReviewSignLabel);
		
		
		
		JButton pastReviewOutPut = new JButton("");
		pastReviewOutPut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ArrayList<ReviewDTO> list;
				ReviewDAO daoR = new ReviewDAO();
				
				try {
					list = daoR.select(dto);
					
					int count = myReviewTable.getRowCount(); // 테이블에 값들이 중복출력되지 않게함
					for (int i = 0; i < count; i++) {      // 테이블에 값들이 중복출력되지 않게함
						model.removeRow(0);				   // 테이블에 값들이 중복출력되지 않게함
					}

						for (int i= 0; i < list.size(); i++) {
						ReviewDTO dto = list.get(i);
							
						model.addRow(new Object[] {
							dto.getNum(),dto.getId(),dto.getTitle(),dto.getContent(),dto.getGrade()																
						});
						System.out.println("성공");
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
		}

	});
		pastReviewOutPut.setIcon(new ImageIcon("./img/mypage/pastReviewOutPut.png"));
		pastReviewOutPut.setBackground(Color.WHITE);
		pastReviewOutPut.setBounds(627, 404, 124, 48);
		add(pastReviewOutPut);
		pastReviewOutPut.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		pastReviewOutPut.setContentAreaFilled(true);
		pastReviewOutPut.setFocusPainted(false);
		
		
		JLabel myPastReviewForm = new JLabel("");
		myPastReviewForm.setIcon(new ImageIcon("./img/mypage/reviewformframe.png"));
		myPastReviewForm.setBounds(269, 10, 500, 456);
		add(myPastReviewForm);
		

		setSize(800, 476);
		setVisible(true);
	
	}
}
