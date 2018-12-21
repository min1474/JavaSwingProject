package other;

import java.awt.BorderLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GoogleMain extends JFrame {
	private JTextField textField = new JTextField(30);
	private JButton button = new JButton();
	private JPanel panel = new JPanel();
	private GoogleAPI googleAPI = new GoogleAPI();
	private String location = "서울";
	private JLabel googleMap;
	
	
	public class Event implements MouseListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {
			setMap(textField.getText());
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
	
	
	public void setMap(String location) {
		
		googleAPI.downloadMAP(location);
		googleMap = new JLabel(googleAPI.getMap(location));
		googleAPI.fileDelete(location);
		add(BorderLayout.SOUTH, googleMap);
		pack();
		
	}
	
	public GoogleMain() {
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Google Map)");
		setVisible(true);
		
		panel.add(textField);
		panel.add(button);
		
		
		
		
		add(BorderLayout.NORTH,panel);
		pack();
		
	}


}
