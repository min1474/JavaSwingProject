package category;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class AboutUsMapFrame extends JFrame {

	public AboutUsMapFrame() {

		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);
		
		add(view, BorderLayout.CENTER);
		setTitle("네이버지도");
		setSize(1000, 700);
		setVisible(true);

		browser.loadURL("https://map.naver.com/");
//		browser.loadURL("https://www.google.co.kr/maps/place/KG%EC%95%84%EC%9D%B4%ED%8B%B0%EB%B1%85%ED%81%AC"
//				+ "+%EA%B5%AC%EB%A1%9C/@37.4768165,126.8833359,17z" + "/data=!3m1!4b1!4m5!3m4!1s0x357c9e24f27e6df1"
//				+ ":0x7ec6e4fa34b63d54!8m2!3d37.4768123!4d126.8855246?hl=ko");
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2); // 화면 중앙

	}

}
