package other;

import java.awt.CardLayout;

import javax.swing.JFrame;

public class Frame2 extends JFrame{
	
    private CardLayout cards = new CardLayout();
     
    public Frame2() {
    	
        setSize(500, 500);
        getContentPane().setLayout(cards);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
         
        getContentPane().add("1",new P_One2(this));
        getContentPane().add("2",new P_Two2(this));
        getContentPane().add("3",new p3(this));
        getContentPane().add("4",new p4(this));
        getContentPane().add("5",new p5(this));
        
        

        setVisible(true);
    }
     
    public void changePanel() {
        cards.next(this.getContentPane());
        
        
    }
    

    public CardLayout getCardLayout() {
    	 return cards;
    	}

    
    public static void main(String[] args) {
		new Frame2();
	}
}
