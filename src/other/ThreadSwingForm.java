package other;

import java.awt.Graphics ; 
import java.awt.Color ; 
import javax.swing.JFrame ; 
import javax.swing.JLabel ; 

class ThreadSwingForm extends JFrame implements Runnable { 
	
    JFrame frame = new JFrame() ; 

    int x, y ; 

    ThreadSwingForm() { 
        this.x = 0 ; 
        this.y = 40 ; 

        setSize(300, 100) ; 
        setLocation(250, 300) ;         

        setVisible(true) ; 

        setDefaultCloseOperation(EXIT_ON_CLOSE) ; 
    } 

    public void paint(Graphics g) { 
        g.setColor(Color.WHITE) ; 
        g.fillRect(0, 0, 300, 100) ; 

        g.setColor(Color.BLACK) ; 
        g.drawString("'Click'", x, y) ; 
    } 

    public void run() {
   
        while (true) { 
            for (int i = 0 ; i < 1 ; i++) { 
                repaint() ; 
                try { 
                    Thread.sleep(100) ;// 글이 흐르는 속도(낮을수록 빠르고 높을수록 느리다)
                    x += 10 ; // 움직일때 x축으로 몇칸씩 움직이는지
                    if(x == 200) { //글자의 위치가 x축으로 500에 도달했다면 다시 x축을 0으로만들어서 반복되느 효과를 줌.
                    	x = 0;
                    
                    }
                    continue;
                } 
         
                catch (Exception e) { 
                    e.printStackTrace() ; 
                }
            }

        }

    }
 
    public static void main(String[] args)     { 
        ThreadSwingForm tsf = new ThreadSwingForm() ; 
        Thread thread = new Thread(tsf) ;         

        thread.start() ; 
    }  

} 