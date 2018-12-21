package mypage;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import adminpage.AdminBookingToday;
import adminpage.AdminMemberList;
import adminpage.AdminTotalBooking;

import javax.swing.SwingConstants;

public class MyPageFrame extends JFrame {


	private JTable table;
	
	private CardLayout cards = new CardLayout();// CardLayout객체  통해 하나의 프레임에 각 패널들을 삽입 
	
	public MyPageFrame() {
		

	
		getContentPane().setBackground(Color.WHITE);
		setTitle("My page");
		setSize(800, 515);
		getContentPane().setLayout(null);
				
		
		getContentPane().setLayout(cards);//돌려 받은 리턴값을 레이아웃에 셋 시킴
		getContentPane().add("mybookinginfo", new MyBookingInfo(this));//최초실행시 보여질 화면, 그리고 따로 만들어진 각각의 패널들을 삽입
		getContentPane().add("review", new ReviewWrite(this)); 
		getContentPane().add("myPastReview", new MyPastReview(this));


		setVisible(true);
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	}
	
	
	
    public void changePanel() { // 클릭시  패널을 겹칠 수 있는 메소드
        cards.next(this.getContentPane());
    }
    
    public CardLayout getCardLayout() { // 각각의 버튼에 따른 패널을 불러올 수있게 하는 메소드
   	 return cards;
   	}

}
