package home;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import category.AboutUsFrame;
import category.Booking;
import category.MenuFrame;
import category.ReviewList;
import dao.MemberDAO;
import dto.MemberDTO;
import home.HomePanel1.homeImageThread;
import mypage.MyPageFrame;
import service.ServiceClientFrame;

import javax.swing.JLabel;

public class HomePanel2 extends JPanel {

	private HomeFrame hframe;
	private JLabel foodImageLable;

	public HomePanel2(HomeFrame homeFrame) {

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
		menuBarButton.setBounds(965, 10, 40, 39);
		add(menuBarButton);
		menuBarButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		menuBarButton.setContentAreaFilled(true);
		menuBarButton.setFocusPainted(false);
		menuBarButton.setOpaque(true);

		JButton signupButton = new JButton("");
		signupButton.setToolTipText("Sign up");
		signupButton.setIcon(new ImageIcon("./img/home/homesignupbutton.png"));
		signupButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp signUp = new SignUp(); 
			}
			
		});
		signupButton.setOpaque(true);
		signupButton.setForeground(Color.WHITE);
		signupButton.setFocusPainted(false);
		signupButton.setContentAreaFilled(true);
		signupButton.setBorderPainted(false);
		signupButton.setBackground(Color.WHITE);
		signupButton.setBounds(913, 10, 40, 38);
		add(signupButton);

		foodImageLable = new JLabel("");
		foodImageLable.setIcon(new ImageIcon("./img/home/dessert.png"));
		foodImageLable.setBounds(25, 30, 335, 425);
		add(foodImageLable);
		
		JLabel copyrightLable = new JLabel("");
		copyrightLable.setHorizontalAlignment(SwingConstants.CENTER);
		copyrightLable.setIcon(new ImageIcon("./img/home/copyright.png"));
		copyrightLable.setBounds(401, 456, 350, 15);
		add(copyrightLable);
		
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
		

		JLabel homeImageLabel = new JLabel("");
		homeImageLabel.setIcon(new ImageIcon("./img/home/Homelabel.png"));
		homeImageLabel.setBounds(401, 120, 411, 258);
		add(homeImageLabel);
		
		JButton bookingButton = new JButton("");
		bookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Booking booking = new Booking();
			}
		});
		bookingButton.setIcon(new ImageIcon("./img/home/bookingbutton.png"));
		bookingButton.setBackground(Color.WHITE);
		bookingButton.setBounds(824, 80, 173, 53);
		add(bookingButton);
		bookingButton.setBorderPainted(false);// 버튼 이미지 태두리와 배경 삭제
		bookingButton.setContentAreaFilled(true);
		bookingButton.setFocusPainted(false);
		
		JButton menuButton = new JButton("");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuFrame manuFrame = new MenuFrame();
			
			}
		});
		menuButton.setIcon(new ImageIcon("./img/home/menubutton.png"));
		menuButton.setFocusPainted(false);
		menuButton.setContentAreaFilled(true);
		menuButton.setBorderPainted(false);
		menuButton.setBackground(Color.WHITE);
		menuButton.setBounds(824, 142, 173, 53);
		add(menuButton);
		
		JButton aboutButton = new JButton("");
		aboutButton.setIcon(new ImageIcon("./img/home/abouusbutton.png"));
		aboutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AboutUsFrame aboutUs = new AboutUsFrame();
			}
			
		});
		aboutButton.setFocusPainted(false);
		aboutButton.setContentAreaFilled(true);
		aboutButton.setBorderPainted(false);
		aboutButton.setBackground(Color.WHITE);
		aboutButton.setBounds(824, 203, 173, 53);
		add(aboutButton);
		
		JButton serviceButton = new JButton("");
		serviceButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ServiceClientFrame service = new ServiceClientFrame();
			}
		});
		serviceButton.setIcon(new ImageIcon("./img/home/servicebutton.png"));
		serviceButton.setFocusPainted(false);
		serviceButton.setContentAreaFilled(true);
		serviceButton.setBorderPainted(false);
		serviceButton.setBackground(Color.WHITE);
		serviceButton.setBounds(824, 386, 173, 53);
		add(serviceButton);
		
		JButton reviewButton = new JButton("");
		reviewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReviewList reviewList = new ReviewList();
			
			}
		});
		reviewButton.setIcon(new ImageIcon("./img/home/reviewbuttton.png"));
		reviewButton.setFocusPainted(false);
		reviewButton.setContentAreaFilled(true);
		reviewButton.setBorderPainted(false);
		reviewButton.setBackground(Color.WHITE);
		reviewButton.setBounds(824, 264, 173, 53);
		add(reviewButton);
		
		JButton mypageButton = new JButton("");
		mypageButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login login = new Login();
			}
		});
		mypageButton.setIcon(new ImageIcon("./img/home/mypagebutton.png"));
		mypageButton.setFocusPainted(false);
		mypageButton.setContentAreaFilled(true);
		mypageButton.setBorderPainted(false);
		mypageButton.setBackground(Color.WHITE);
		mypageButton.setBounds(824, 325, 173, 53);
		add(mypageButton);

		JLabel cetegoruframe = new JLabel("");
		cetegoruframe.setIcon(new ImageIcon("./img/home/categoryframe.png"));
		cetegoruframe.setBounds(815, 70, 190, 382);
		add(cetegoruframe);

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
