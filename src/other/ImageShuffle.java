package other;


import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;

public class ImageShuffle extends JPanel {


	

	    private List<Icon> list = new ArrayList<Icon>();
	    private List<JLabel> labels = new ArrayList<JLabel>();
	    private Timer timer = new Timer(1000, new ActionListener() {

	        @Override
	        public void actionPerformed(ActionEvent e) {
	            update();
	        }
	    });

	    public ImageShuffle() {
	        this.setLayout(new GridLayout(1, 0));
	        list.add(UIManager.getIcon("OptionPane.errorIcon"));
	        list.add(UIManager.getIcon("OptionPane.informationIcon"));
	        list.add(UIManager.getIcon("OptionPane.warningIcon"));
	        list.add(UIManager.getIcon("OptionPane.questionIcon"));
	        for (Icon icon : list) {
	            JLabel label = new JLabel(icon);
	            labels.add(label);
	            this.add(label);
	        }
	        timer.start();
	    }

	    private void update() {
	        Collections.shuffle(list);
	        int index = 0;
	        for (JLabel label : labels) {
	            label.setIcon(list.get(index++));
	        }
	    }

	    private void display() {
	        JFrame f = new JFrame("ImageShuffle");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.add(this);
	        f.pack();
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	    }

	    public static void main(String[] args) {
	        EventQueue.invokeLater(new Runnable() {

	            @Override
	            public void run() {
	                new ImageShuffle().display();
	            }
	        });
	    }
	}


