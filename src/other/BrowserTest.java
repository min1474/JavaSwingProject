package other;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

import javax.swing.*;
import java.awt.*;

public class BrowserTest {

	public static void main(String[] args) {
		
		
		Browser browser = new Browser();
		BrowserView view = new BrowserView(browser);
		 
		JFrame frame = new JFrame();
		frame.add(view, BorderLayout.CENTER);
		frame.setSize(700, 500);
		frame.setVisible(true);
		 
		browser.loadURL("https://youtu.be/5vy9HeL8mOc");
		browser.loadURL("https://www.google.co.kr/maps/place/KG%EC%95%84%EC%9D%B4%ED%8B%B0%EB%B1%85%ED%81%AC"
				+ "+%EA%B5%AC%EB%A1%9C/@37.4768165,126.8833359,17z"
				+ "/data=!3m1!4b1!4m5!3m4!1s0x357c9e24f27e6df1"
				+ ":0x7ec6e4fa34b63d54!8m2!3d37.4768123!4d126.8855246?hl=ko");
		
		
		}
}
