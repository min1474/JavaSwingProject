package home;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class HomeFrame extends JFrame {
	
	private CardLayout cards = new CardLayout();// CardLayout객체  통해 하나의 프레임에 각 패널들을 삽입 
	
	public HomeFrame() {
		

		getContentPane().setLayout(cards);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		getContentPane().add(new HomePanel1(this)); //최초실행시 보여질 화면, 그리고 따로 만들어진 각각의 패널들을 삽입
		getContentPane().add(new HomePanel2(this)); 
  

		setBackground(Color.WHITE);
		setSize(1045, 520);
		setVisible(true);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
	}
	
    public void changePanel() { // 클릭시  패널을 겹칠 수 있는 메소드
    	cards.next(getContentPane());
    }
    
    public static void main(String[] args) {
    	
    	HomeFrame homeFrame = new HomeFrame();
    }
    	
		
}
