package adminpage;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;

import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;

public class AdminFrame extends JFrame {
	

	
	private JTable table1;
	private JTable table2;
	private JTable table4;
	private JTable table_2;
	
	private CardLayout cards = new CardLayout();// CardLayout객체  통해 하나의 프레임에 각 패널들을 삽입 
	
	public AdminFrame() {
		
		setTitle("관리자 모드");
		setAutoRequestFocus(false);
//		setAlwaysOnTop(true);
		getContentPane().setForeground(Color.WHITE);
		getContentPane().setBackground(Color.DARK_GRAY);
		setBackground(Color.WHITE);
		
		
		
		setSize(1005, 760);
		
		
		getContentPane().setLayout(cards);
		getContentPane().add("todaybooking", new AdminBookingToday(this)); //최초실행시 보여질 화면, 그리고 따로 만들어진 각각의 패널들을 삽입
		getContentPane().add("adminMemberlist",new AdminMemberList(this));   
		getContentPane().add("bookingList",new AdminTotalBooking(this));   
				
		
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
    
	public static void main(String[] args) {
		AdminFrame adminFrame = new AdminFrame();
	}
}
