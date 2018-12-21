package category;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel5Baverage extends JPanel {
	
	private MenuFrame mFrame;
	
	
	public MenuPanel5Baverage(MenuFrame manuFrame) {
		setBackground(Color.WHITE);
		
		mFrame = manuFrame;
		
		setLayout(null);
		setSize(690, 665);
		
		JButton steakButton = new JButton("");
		steakButton.setBackground(Color.WHITE);
		steakButton.setIcon(new ImageIcon("./img/menu/steak2.png"));
		steakButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mFrame.getCardLayout().show(mFrame.getContentPane(), "steak");
			}
		});
		steakButton.setBounds(15, 122, 122, 55);
		add(steakButton);
		steakButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		steakButton.setContentAreaFilled(true);
		steakButton.setFocusPainted(false);
		
		JButton pastButton = new JButton("");
		pastButton.setIcon(new ImageIcon("./img/menu/pastabutton2.png"));
		pastButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mFrame.getCardLayout().show(mFrame.getContentPane(), "pasta");
			}
		});
		pastButton.setFocusPainted(false);
		pastButton.setContentAreaFilled(true);
		pastButton.setBorderPainted(false);
		pastButton.setBackground(Color.WHITE);
		pastButton.setBounds(15, 186, 122, 55);
		add(pastButton);
		
		JButton hambergerButton = new JButton("");
		hambergerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mFrame.getCardLayout().show(mFrame.getContentPane(), "hamberger");
			}
		});
		hambergerButton.setIcon(new ImageIcon("./img/menu/hamberger2.png"));
		hambergerButton.setFocusPainted(false);
		hambergerButton.setContentAreaFilled(true);
		hambergerButton.setBorderPainted(false);
		hambergerButton.setBackground(Color.WHITE);
		hambergerButton.setBounds(15, 251, 122, 55);
		add(hambergerButton);
		
		JButton pizzaButton = new JButton("");
		pizzaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				mFrame.getCardLayout().show(mFrame.getContentPane(), "pizza");
			}
		});
		pizzaButton.setIcon(new ImageIcon("./img/menu/pizza&salad2.png"));
		pizzaButton.setFocusPainted(false);
		pizzaButton.setContentAreaFilled(true);
		pizzaButton.setBorderPainted(false);
		pizzaButton.setBackground(Color.WHITE);
		pizzaButton.setBounds(15, 316, 122, 104);
		add(pizzaButton);
		
		JButton baverageButton = new JButton("");
		baverageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mFrame.getCardLayout().show(mFrame.getContentPane(), "baverage");
				
			}
			
		});
		baverageButton.setIcon(new ImageIcon("./img/menu/baverage1.png"));
		baverageButton.setFocusPainted(false);
		baverageButton.setContentAreaFilled(true);
		baverageButton.setBorderPainted(false);
		baverageButton.setBackground(Color.WHITE);
		baverageButton.setBounds(15, 430, 122, 55);
		add(baverageButton);
		
		JLabel menuHead = new JLabel("");
		menuHead.setIcon(new ImageIcon("./img/menu/menuHead.png"));
		menuHead.setBounds(293, 10, 156, 87);
		add(menuHead);
		
		JLabel menuFrameLable = new JLabel("");
		menuFrameLable.setHorizontalAlignment(SwingConstants.CENTER);
		menuFrameLable.setIcon(new ImageIcon("./img/menu/baverageframe.png"));
		menuFrameLable.setBounds(133, 107, 550, 550);
		add(menuFrameLable);
		
		JButton recipeButton = new JButton("");
		recipeButton.setIcon(new ImageIcon("./img/menu/Recipe1.png"));
		recipeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mFrame.getCardLayout().show(mFrame.getContentPane(), "recipe");
				
			}
			
		});
		recipeButton.setFocusPainted(false);
		recipeButton.setContentAreaFilled(true);
		recipeButton.setBorderPainted(false);
		recipeButton.setBackground(Color.WHITE);
		recipeButton.setBounds(15, 495, 122, 55);
		add(recipeButton);
		
		

		setVisible(true);
		
	}


}
