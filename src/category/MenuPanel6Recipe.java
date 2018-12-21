package category;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MenuPanel6Recipe extends JPanel {
	
	private MenuFrame mFrame;
	MenuVideo video = new MenuVideo();
	
	public MenuPanel6Recipe(MenuFrame manuFrame) {
		
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
		baverageButton.setIcon(new ImageIcon("./img/menu/baverage2.png"));
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
		
		JButton yuotubeButton1 = new JButton("");
		yuotubeButton1.setBackground(Color.WHITE);
		yuotubeButton1.setIcon(new ImageIcon("./img/menu/youtubebutton.png"));
		yuotubeButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				video.past1();					
			}
			
		});
		yuotubeButton1.setBounds(629, 212, 37, 25);
		add(yuotubeButton1);
		yuotubeButton1.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		yuotubeButton1.setContentAreaFilled(true);
		yuotubeButton1.setFocusPainted(false);
		
		JButton yuotubeButton2 = new JButton("");
		yuotubeButton2.setBackground(Color.WHITE);
		yuotubeButton2.setIcon(new ImageIcon("./img/menu/youtubebutton.png"));
		yuotubeButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				video.past2();					
			}
			
		});
		yuotubeButton2.setFocusPainted(false);
		yuotubeButton2.setContentAreaFilled(true);
		yuotubeButton2.setBorderPainted(false);
		yuotubeButton2.setBounds(629, 346, 37, 25);
		add(yuotubeButton2);
		
		JButton yuotubeButton3 = new JButton("");
		yuotubeButton3.setBackground(Color.WHITE);
		yuotubeButton3.setIcon(new ImageIcon("./img/menu/youtubebutton.png"));
		yuotubeButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				video.salad();					
			}
			
		});
		yuotubeButton3.setFocusPainted(false);
		yuotubeButton3.setContentAreaFilled(true);
		yuotubeButton3.setBorderPainted(false);
		yuotubeButton3.setBounds(629, 478, 37, 25);
		add(yuotubeButton3);
		
		JButton yuotubeButton4 = new JButton("");
		yuotubeButton4.setBackground(Color.WHITE);
		yuotubeButton4.setIcon(new ImageIcon("./img/menu/youtubebutton.png"));
		yuotubeButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				video.steak();					
			}
			
		});
		yuotubeButton4.setFocusPainted(false);
		yuotubeButton4.setContentAreaFilled(true);
		yuotubeButton4.setBorderPainted(false);
		yuotubeButton4.setBounds(629, 608, 37, 25);
		add(yuotubeButton4);
		
		
		JButton recipeButton = new JButton("");
		recipeButton.setIcon(new ImageIcon("./img/menu/Recipe2.png"));
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
		
		
		JLabel menuFrameLable = new JLabel("");
		menuFrameLable.setHorizontalAlignment(SwingConstants.CENTER);
		menuFrameLable.setIcon(new ImageIcon("./img/menu/recipeframe.png"));
		menuFrameLable.setBounds(133, 107, 550, 550);
		add(menuFrameLable);

		setVisible(true);
		
	}

}
