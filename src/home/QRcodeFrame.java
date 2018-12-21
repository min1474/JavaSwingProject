package home;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class QRcodeFrame extends JFrame {
	
	public QRcodeFrame() {
		
		getContentPane().setLayout(null);
		
		JLabel qrCodeFrame = new JLabel("");
		qrCodeFrame.setIcon(new ImageIcon("./img/home/QRCODEBIG.jpg"));
		qrCodeFrame.setBounds(35, 10, 215, 215);
		getContentPane().add(qrCodeFrame);
		
		JLabel label = new JLabel("네이버 앱 QR코드로 확인해주세요");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(45, 235, 196, 15);
		getContentPane().add(label);
		setVisible(true);
		setSize(300, 300);
		
		Dimension frameSize = this.getSize(); // 프레임 사이즈
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
		this.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
		
	}

	public static void main(String[] args) {
		
		new QRcodeFrame();
	}

}
