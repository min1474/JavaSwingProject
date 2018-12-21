package category;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.javafx.BrowserView;

public class AboutUsFrame extends JFrame {
		
	private CardLayout cards = new CardLayout();// CardLayout객체 통해 하나의 프레임에 각 패널들을 삽입
	
	public AboutUsFrame() {

		getContentPane().setLayout(cards);

		getContentPane().add("aboutus", new AboutUsPanel1(this)); //최초실행시 보여질 화면, 그리고 따로 만들어진 각각의 패널들을 삽입
		getContentPane().add("location", new AboutUsPanel2(this)); 


		setBackground(Color.WHITE);
		setSize(815, 905);
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
    
    public static void main(String[] args) {
		AboutUsFrame name = new AboutUsFrame();
	}

}
