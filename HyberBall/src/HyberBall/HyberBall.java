package HyberBall;

import javax.swing.JFrame;

/**
 *
 * @author Merna
 */
public class HyberBall {
    public static void main(String[] args) {
        JFrame obj=new JFrame();
        Gameplay gameplay=new Gameplay();
        obj.setBounds(10, 10, 700, 600);
        obj.setTitle("Breakout Ball");
        obj.setResizable(false);
        obj.setVisible(true);
        obj.add(gameplay);
        obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
       
    }
    
}
