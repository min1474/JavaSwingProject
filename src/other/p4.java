package other;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class p4 extends JPanel{
    private JLabel lblNewLabel;
    private JButton btnNewButton;
    private Frame2 F;
     
    public p4(Frame2 frame2) {
    	
    	F = frame2;
    	
        setBackground(Color.LIGHT_GRAY);
        setSize(500, 500);
        setLayout(null);
         
         
        lblNewLabel = new JLabel("Panel 4");
        lblNewLabel.setBounds(12, 10, 59, 15);
        add(lblNewLabel);
         
        btnNewButton = new JButton("Change 2로");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	F.getCardLayout().show(F.getContentPane(), "2");

            }

        });
        btnNewButton.setBounds(12, 35, 113, 23);
        add(btnNewButton);
        
        JButton button = new JButton("3\uB85C");
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		F.getCardLayout().show(F.getContentPane(), "3");
        	}
        });
        button.setBounds(12, 68, 113, 23);
        add(button);
        
        JButton button_1 = new JButton("4\uB85C");
        button_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		F.getCardLayout().show(F.getContentPane(), "4");
        	}
        });
        button_1.setBounds(12, 101, 113, 23);
        add(button_1);
        
        JButton button_2 = new JButton("5\uB85C");
        button_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		F.getCardLayout().show(F.getContentPane(), "5");
        	}
        });
        button_2.setBounds(12, 134, 113, 23);
        add(button_2);
        
        JButton button_3 = new JButton("1로\uB85C");
        button_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		F.getCardLayout().show(F.getContentPane(), "1");
        	}
        });
        button_3.setBounds(12, 167, 113, 23);
        add(button_3);
 
        setVisible(true);

    }
}
