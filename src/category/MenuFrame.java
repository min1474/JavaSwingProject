package category;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import home.HomeFrame;
import home.HomePanel1;
import home.HomePanel2;
import javax.swing.JLabel;

public class MenuFrame extends JFrame {

	private CardLayout cards = new CardLayout();// CardLayout객체 통해 하나의 프레임에 각 패널들을 삽입

	public MenuFrame() {

		getContentPane().setLayout(cards);

		getContentPane().add("steak", new MenuPanel1Steak(this)); //최초실행시 보여질 화면, 그리고 따로 만들어진 각각의 패널들을 삽입
		getContentPane().add("pasta", new MenuPanel2Pasta(this)); 
		getContentPane().add("hamberger", new MenuPanel3Hamberger(this)); 
		getContentPane().add("pizza", new MenuPanel4PizzaSalad(this)); 
		getContentPane().add("baverage", new MenuPanel5Baverage(this)); 
		getContentPane().add("recipe", new MenuPanel6Recipe(this)); 

		setBackground(Color.WHITE);
		setSize(707, 707);
		setVisible(true);

		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙
	}

    public void changePanel() { // 클릭시  패널을 겹칠 수 있는 메소드
        cards.next(this.getContentPane());
    }
    
    public CardLayout getCardLayout() { // 각각의 버튼에 따른 패널을 불러올 수있게 하는 메소드
   	 return cards;
   	}

}
