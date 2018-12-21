package home;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import adminpage.AdminFrame;
import adminpage.AdminLogin;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class HomePanel1 extends JPanel {

	private HomeFrame hframe;
	private JLabel foodImageLable;

	
	public HomePanel1(HomeFrame homeFrame) {

		hframe = homeFrame;

		JButton menuBarButton = new JButton("");
		menuBarButton.setIcon(new ImageIcon("./img/home/menubarbutton.png"));
		menuBarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				hframe.changePanel();
			}
		});

		menuBarButton.setToolTipText("category");
		menuBarButton.setForeground(Color.WHITE);
		menuBarButton.setBackground(Color.WHITE);
		menuBarButton.setBounds(965, 10, 40, 38);
		add(menuBarButton);
		menuBarButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		menuBarButton.setContentAreaFilled(true);
		menuBarButton.setFocusPainted(false);
		menuBarButton.setOpaque(true);

		JButton signupButton = new JButton("");
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp();
			}

		});
		signupButton.setToolTipText("Sign up");
		signupButton.setIcon(new ImageIcon("./img/home/homesignupbutton.png"));

		signupButton.setOpaque(true);
		signupButton.setForeground(Color.WHITE);
		signupButton.setFocusPainted(false);
		signupButton.setContentAreaFilled(true);
		signupButton.setBorderPainted(false);
		signupButton.setBackground(Color.WHITE);
		signupButton.setBounds(913, 10, 40, 38);
		add(signupButton);

		JButton adminButton = new JButton("");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				new AdminLogin();

			}
		});

		adminButton.setIcon(new ImageIcon("./img/admin/admin.png"));
		adminButton.setToolTipText("admin mode");
		adminButton.setOpaque(true);
		adminButton.setForeground(Color.WHITE);
		adminButton.setFocusPainted(false);
		adminButton.setContentAreaFilled(true);
		adminButton.setBorderPainted(false);
		adminButton.setBackground(Color.WHITE);
		adminButton.setBounds(995, 451, 22, 20);
		add(adminButton);

		foodImageLable = new JLabel("");
		foodImageLable.setIcon(new ImageIcon("./img/home/dessert.png"));
		foodImageLable.setBounds(25, 30, 335, 425);
		add(foodImageLable);
		
		JLabel qrCodeLabel = new JLabel("\"Click\"");
		qrCodeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		qrCodeLabel.setBounds(755, 405, 51, 15);
		add(qrCodeLabel);
		
	
		
		JButton qrCodeButton = new JButton("");
		qrCodeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new QRcodeFrame();
			}
		});
		qrCodeButton.setIcon(new ImageIcon("./img/home/QRCODE.png"));
		qrCodeButton.setBounds(755, 421, 51, 50);
		add(qrCodeButton);

		JLabel copyrightLable = new JLabel("");
		copyrightLable.setHorizontalAlignment(SwingConstants.CENTER);
		copyrightLable.setIcon(new ImageIcon("./img/home/copyright.png"));
		copyrightLable.setBounds(401, 456, 350, 15);
		add(copyrightLable);

		JLabel homeImageLabel = new JLabel("");
		homeImageLabel.setIcon(new ImageIcon("./img/home/Homelabel.png"));
		homeImageLabel.setBounds(401, 120, 420, 258);
		add(homeImageLabel);

		JLabel homeFrameLabel = new JLabel("");
		homeFrameLabel.setBackground(Color.WHITE);
		homeFrameLabel.setIcon(new ImageIcon("./img/home/homeframe.png"));
		homeFrameLabel.setBounds(0, 0, 1029, 481);
		add(homeFrameLabel);

		setBackground(Color.WHITE);
		setLayout(null);
		setSize(1029, 481);
		setVisible(true);
		
		(new homeImageThread()).start();
	}
		

		class homeImageThread extends Thread {

			public void run() {

				
				String[] imgs = {"./img/home/baverage.png","./img/home/tea.png","./img/home/icecream.png","./img/home/salad.png",
						"./img/home/maindish01.png","./img/home/maindish02.png","./img/home/maindish03.png","./img/home/maindish04.png",
						"./img/home/maindish05.png"
						};

				while(true) {
				for (int i = 0; i < imgs.length; i++) {

					try {
						Thread.sleep(1200);
						ImageIcon icon = new ImageIcon(imgs[i]);
						foodImageLable.setIcon(icon);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				}
			}
		}
		    
}
	
	

