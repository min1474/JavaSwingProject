package category;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import java.awt.*;

public class AboutUsPanel2 extends JPanel {

	private AboutUsFrame aFrame;
	private JButton aboutUsButton;

	public AboutUsPanel2(AboutUsFrame aboutUsFrame) {
		setBackground(Color.WHITE);

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
		LocationButton.setIcon(new ImageIcon("./img/aboutus/Locationbutton.png"));
		LocationButton.setOpaque(true);
		LocationButton.setFocusPainted(false);
		LocationButton.setContentAreaFilled(true);
		LocationButton.setBorderPainted(false);
		LocationButton.setBackground(Color.BLACK);
		LocationButton.setBounds(10, 78, 165, 59);
		add(LocationButton);

		JButton mapButton = new JButton("");
		mapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AboutUsMapFrame();
			}
		});
		mapButton.setIcon(new ImageIcon("./img/aboutus/mapButton.png"));
		mapButton.setBackground(Color.WHITE);
		mapButton.setBounds(12, 299, 500, 500);
		add(mapButton);
		mapButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		mapButton.setContentAreaFilled(true);
		mapButton.setFocusPainted(false);
		mapButton.setOpaque(true);

		JLabel aboutUsFrameLable = new JLabel("");
		aboutUsFrameLable.setIcon(new ImageIcon("./img/aboutus/locationframe.png"));
		aboutUsFrameLable.setBounds(0, 0, 800, 867);
		add(aboutUsFrameLable);

		setVisible(true);

	}

}
