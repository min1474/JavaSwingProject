package other;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Toolkit;

public class MyJOptionPane implements ActionListener{
   
   private static JFrame f;
   
   public static void showMessageDialog(String str) {
      f = new JFrame();
      f.setSize(400, 150);
      f.setTitle("알림창");
      f.getContentPane().setLayout(null);
      
      JLabel message = new JLabel(str);
      message.setFont(new Font("굴림", Font.BOLD, 14));
      message.setHorizontalAlignment(SwingConstants.CENTER);
      message.setBounds(12, 21, 360, 34);
      f.getContentPane().add(message);
      
      JButton confirm = new JButton("확인");
      confirm.setFont(new Font("굴림", Font.BOLD, 12));
      confirm.setBounds(158, 67, 66, 34);
      f.getContentPane().add(confirm);
      
      f.getContentPane().add(message);
      f.getContentPane().add(confirm);
      
      MyJOptionPane my = new MyJOptionPane();
      confirm.addActionListener(my);
      
      f.setVisible(true);
      
	Dimension frameSize = f.getSize(); // 프레임 사이즈
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); // 모니터 사이즈
	f.setLocation((screenSize.width - frameSize.width)/2, (screenSize.height - frameSize.height)/2); // 화면 중앙
   }
   
   public static void main(String[] args) {
      showMessageDialog("적을 내용");
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      f.dispose();
   }
   
}