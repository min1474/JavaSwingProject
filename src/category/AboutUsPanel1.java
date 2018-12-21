package category;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AboutUsPanel1 extends JPanel {
	
	private AboutUsFrame aFrame;
	private JButton aboutUsButton;

	
	public AboutUsPanel1(AboutUsFrame aboutUsFrame) {

		
		aFrame = aboutUsFrame;
		
		setLayout(null);
		setSize(800, 875);
		
		aboutUsButton = new JButton("");
		aboutUsButton.setBackground(new Color(0, 0, 0));
		aboutUsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aFrame.getCardLayout().show(aFrame.getContentPane(), "aboutus");
			}
		});
		aboutUsButton.setIcon(new ImageIcon("./img/aboutus/AbuoutUsbutton.png"));
		aboutUsButton.setBounds(10, 13, 165, 59);
		add(aboutUsButton);
		aboutUsButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		aboutUsButton.setContentAreaFilled(true);
		aboutUsButton.setFocusPainted(false);
		aboutUsButton.setOpaque(true);
		
		JButton LocationButton = new JButton("");
		LocationButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aFrame.getCardLayout().show(aFrame.getContentPane(), "location");
			}
		});
		LocationButton.setIcon(new ImageIcon("./img/aboutus/Locationbutton.png"));
		LocationButton.setOpaque(true);
		LocationButton.setFocusPainted(false);
		LocationButton.setContentAreaFilled(true);
		LocationButton.setBorderPainted(false);
		LocationButton.setBackground(Color.BLACK);
		LocationButton.setBounds(10, 78, 165, 59);
		add(LocationButton);
		
		JLabel aboutUsFrameLable = new JLabel("");
		aboutUsFrameLable.setIcon(new ImageIcon("./img/aboutus/aboutusframe.png"));
		aboutUsFrameLable.setBounds(0, 0, 800, 867);
		add(aboutUsFrameLable);
		

		setVisible(true);
		
	}
}
