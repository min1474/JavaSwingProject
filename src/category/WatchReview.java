package category;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import dao.MemberDAO;
import dao.ReviewDAO;
import dto.MemberDTO;
import dto.ReviewDTO;
import home.Login;

public class WatchReview extends JFrame {
	
	JTextField idInfoField;
	JTextField idTextField;
	JTextField titleTextField;
	
	
	public WatchReview(String id,String title,String content,String grade, MouseAdapter mouseAdapter) {
		getContentPane().setBackground(Color.WHITE);
						// 마우스 클릭시 해당 테이블의 로우에서 넘어오는 인자를 받아주기 위함
		
		
		
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		JLabel reviewHead = new JLabel("");
		reviewHead.setIcon(new ImageIcon("./img/mypage/reviewhead.png"));
		reviewHead.setBounds(17, 19, 477, 60);
		getContentPane().add(reviewHead);

		JLabel idLabel = new JLabel("아이디");
		idLabel.setForeground(Color.GRAY);
		idLabel.setHorizontalAlignment(SwingConstants.CENTER);
		idLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 17));
		idLabel.setBounds(7, 89, 70, 31);
		getContentPane().add(idLabel);

		idTextField = new JTextField();
		idTextField.setText(id);
		idTextField.disable();
		idTextField.setBounds(77, 88, 417, 31);
		getContentPane().add(idTextField);
		idTextField.setColumns(10);

		JLabel scoreLabel = new JLabel("평점");
		scoreLabel.setForeground(Color.GRAY);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		scoreLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		scoreLabel.setBounds(7, 129, 70, 31);
		getContentPane().add(scoreLabel);

		JComboBox scoreComboBox = new JComboBox();
		scoreComboBox.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5" }));
		scoreComboBox.setBounds(77, 129, 120, 31);
		getContentPane().add(scoreComboBox);
		scoreComboBox.disable();
		scoreComboBox.setSelectedItem(grade);

		JLabel titleLabel = new JLabel("제목");
		titleLabel.setForeground(Color.GRAY);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		titleLabel.setBounds(7, 170, 70, 31);
		getContentPane().add(titleLabel);

		titleTextField = new JTextField();
		titleTextField.setText(title);
		titleTextField.setColumns(10);
		titleTextField.setBounds(77, 170, 417, 31);
		titleTextField.disable();
		getContentPane().add(titleTextField);

		JLabel contentLabel = new JLabel("내용");
		contentLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentLabel.setForeground(Color.GRAY);
		contentLabel.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 18));
		contentLabel.setBounds(7, 211, 70, 31);
		getContentPane().add(contentLabel);
		

		JTextArea contentTextArea = new JTextArea();
		contentTextArea.setText(content);

		Border border = BorderFactory.createLineBorder(Color.GRAY); // JTextArea 틀 색 삽입하기.
		contentTextArea
				.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		contentTextArea.setWrapStyleWord(true);
		contentTextArea.setForeground(Color.DARK_GRAY);
		contentTextArea.setBackground(Color.WHITE);
		contentTextArea.setLineWrap(true);
		contentTextArea.setBounds(77, 211, 417, 184);
		getContentPane().add(contentTextArea);
		contentTextArea.disable();
		
		JButton closeButton = new JButton("");
		closeButton.setForeground(Color.WHITE);
		closeButton.setBackground(Color.WHITE);
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		closeButton.setIcon(new ImageIcon("./img/home/close.png"));
		closeButton.setBounds(197, 405, 151, 46);
		getContentPane().add(closeButton);
		closeButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		closeButton.setContentAreaFilled(true);
		closeButton.setFocusPainted(false);
		closeButton.setOpaque(true);


		JLabel reviewFormFrame = new JLabel("");
		reviewFormFrame.setBackground(Color.WHITE);
		reviewFormFrame.setIcon(new ImageIcon("./img/mypage/reviewformframe.png"));
		reviewFormFrame.setBounds(7, 8, 500, 456);
		getContentPane().add(reviewFormFrame);
		
		
		setSize(530, 510);
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	
	}
	
	public static void main(String[] args) {
		

	}
}
