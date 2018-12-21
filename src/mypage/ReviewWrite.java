package mypage;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dao.ReviewDAO;
import dao.MemberDAO;
import dto.ReviewDTO;
import home.Login;
import dto.MemberDTO;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewWrite extends JPanel {

	JTextField idInfoField;
	JTextField idTextField;
	JTextField titleTextField;
	private MyPageFrame frame;

	MemberDAO dao = new MemberDAO();
	MemberDTO dto = dao.login(Login.tosID);

	public ReviewWrite(MyPageFrame myPageFrame) {

		frame = myPageFrame;

		setBackground(Color.WHITE);
		setLayout(null);

		JLabel reviewHead = new JLabel("");
		reviewHead.setIcon(new ImageIcon("./img/mypage/reviewhead.png"));
		reviewHead.setBounds(279, 19, 477, 60);
		add(reviewHead);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setForeground(Color.GRAY);
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 17));
		idLabel.setBounds(269, 89, 70, 31);
		add(idLabel);

		idTextField = new JTextField(dto.getId());
		idTextField.setText(dto.getId());

		idTextField.disable();
		idTextField.setBounds(339, 88, 417, 31);
		add(idTextField);
		idTextField.setColumns(10);

		JLabel scoreLabel = new JLabel("평점");
		scoreLabel.setForeground(Color.GRAY);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		scoreLabel.setBounds(269, 129, 70, 31);
		add(scoreLabel);

		JComboBox scoreComboBox = new JComboBox();
		scoreComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		scoreComboBox.setBounds(338, 129, 120, 31);
		add(scoreComboBox);

		JLabel titleLabel = new JLabel("제목");
		titleLabel.setForeground(Color.GRAY);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		titleLabel.setBounds(269, 170, 70, 31);
		add(titleLabel);

		titleTextField = new JTextField();
		titleTextField.setColumns(10);
		titleTextField.setBounds(338, 170, 417, 31);
		add(titleTextField);

		JLabel contentLabel = new JLabel("내용");
		contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentLabel.setForeground(Color.GRAY);
		contentLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		contentLabel.setBounds(269, 211, 70, 31);
		add(contentLabel);

		JTextArea contentTextArea = new JTextArea();

		Border border = BorderFactory.createLineBorder(Color.GRAY); // JTextArea 틀 색 삽입하기.
		contentTextArea
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		contentTextArea.setWrapStyleWord(true);
		contentTextArea.setForeground(Color.DARK_GRAY);
		contentTextArea.setBackground(Color.WHITE);
		contentTextArea.setLineWrap(true);
		contentTextArea.setBounds(338, 211, 417, 184);
		add(contentTextArea);

		JButton saveButton = new JButton("");
		saveButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				ReviewDTO dto = new ReviewDTO();
				ReviewDAO dao = new ReviewDAO();

				dto.setId(idTextField.getText()); // 입력된 아이디를 가져와 dto에 저장
				dto.setTitle(titleTextField.getText());
				dto.setGrade((String) scoreComboBox.getSelectedItem());
				dto.setContent(contentTextArea.getText());

				dao.insert(dto);
				JOptionPane.showMessageDialog(null, "저장되었습니다.");
				titleTextField.setText("");
				contentTextArea.setText("");
			}

		});
		saveButton.setBackground(Color.WHITE);
		saveButton.setIcon(new ImageIcon("./img/mypage/savebutton.png"));
		saveButton.setForeground(Color.WHITE);
		saveButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		saveButton.setBounds(337, 403, 194, 44);
		add(saveButton);
		saveButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		saveButton.setContentAreaFilled(true);
		saveButton.setFocusPainted(false);

		JButton resetButton = new JButton("");
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				titleTextField.setText("");
				contentTextArea.setText("");

			}
		});

		resetButton.setIcon(new ImageIcon("./img/mypage/resetbutton.png"));
		resetButton.setBackground(Color.WHITE);
		resetButton.setForeground(Color.WHITE);
		resetButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 20));
		resetButton.setBounds(561, 403, 194, 44);
		add(resetButton);
		resetButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		resetButton.setContentAreaFilled(true);
		resetButton.setFocusPainted(false);

		JLabel reviewFormFrame = new JLabel("");
		reviewFormFrame.setIcon(new ImageIcon("./img/mypage/reviewformframe.png"));
		reviewFormFrame.setBounds(269, 10, 500, 456);
		add(reviewFormFrame);

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
//-----------------각 패널매다 공통으로 삽입되어야할 UI부분---------------------------------------------------

		setSize(800, 476);
		setVisible(true);

	}

}
