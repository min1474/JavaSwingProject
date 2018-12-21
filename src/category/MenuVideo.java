package category;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import com.teamdev.jxbrowser.chromium.Browser;
import com.teamdev.jxbrowser.chromium.swing.BrowserView;

public class MenuVideo extends JFrame {
	
	Browser browser = new Browser();
	BrowserView view = new BrowserView(browser);
	
	public void past1() {
		
		 
	
		add(view, BorderLayout.CENTER);
		setSize(700, 520);
		setVisible(true);
		setResizable(false);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		 
		browser.loadURL("https://www.youtube.com/watch?v=mSVGf4Ac9ro");
				
	}
	
	public void past2() {
		

		add(view, BorderLayout.CENTER);
		setSize(700, 520);
		setVisible(true);
		setResizable(false);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		 
		browser.loadURL("https://www.youtube.com/watch?v=y5g4cxbSvUU");
				
	}
	
	public void salad() {
		
		add(view, BorderLayout.CENTER);
		setSize(700, 520);
		setVisible(true);
		setResizable(false);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		 
		browser.loadURL("https://www.youtube.com/watch?v=9G2OImU-G78");
				
	}
	
	public void steak() {
		
		add(view, BorderLayout.CENTER);
		setSize(700, 520);
		setVisible(true);

		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		 
		browser.loadURL("https://www.youtube.com/watch?v=4LedZRQhLQc");
				
	}

}
