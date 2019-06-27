package HyberBall;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import static javafx.scene.text.Font.font;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Merna
 */
public class Gameplay extends JPanel implements KeyListener,ActionListener{
  private boolean play=false;
  private int score =0;
  private int totalBricks =21;
  private Timer timer;
  private int delay =7;
  private int playerx=320;
  private int ballposx=120;
  private int ballposy=350;
  private int ballxdir=-1;
  private int ballydir=-2;
  private Breakers map;
  public Gameplay()
  {   map=new Breakers(3,5);
      addKeyListener(this);
      setFocusable(true);
      setFocusTraversalKeysEnabled(false);
      timer =new Timer(delay,this);
      timer.start();
  }
  public void paint(Graphics g)
  {
      //background
      g.setColor(Color.black);
      g.fillRect(1, 1, 692, 592);
      map.draw((Graphics2D)g);
      //border
      g.setColor(Color.gray);
      g.fillRect(0, 0, 3, 592);
      g.fillRect(0, 0, 692, 3);
      g.fillRect(691, 0, 3, 592);
      //score
       g.setColor(Color.white);
      g.setFont(new Font("serif",Font.BOLD,25));
      g.drawString(""+score,590, 30);
      //paddle
      g.setColor(Color.PINK);
      g.fillRect(playerx,550, 100, 8);
      //theball
      g.setColor(Color.yellow);
      g.fillOval(ballposx,ballposy, 20, 20);
      
         if (totalBricks<=0||score>=75){
       play=false;
      ballxdir=0;
      ballydir=0;
      g.setColor(Color.red);
      g.setFont(new Font("serif",Font.BOLD,30));
      g.drawString("Game Over",190, 300);
      g.setFont(new Font("serif",Font.BOLD,20));
      g.drawString("Press Enter to Restart",230, 350);
      
      }
         else if (ballposy>570){
       play=false;
      ballxdir=0;
      ballydir=0;
      g.setColor(Color.red);
      g.setFont(new Font("serif",Font.BOLD,30));
      g.drawString("Game Over",190, 300);
      g.setFont(new Font("serif",Font.BOLD,20));
      g.drawString("Press Enter to Restart",230, 350);
     
      
      
      } 
   
      g.dispose();  
}    
    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
         if(play)
        {
            if(new Rectangle(ballposx,ballposy,20,20).intersects(new Rectangle(playerx,550,100,5)))
                {
                    ballydir=-ballydir;
                }
            out:  for(int i=0;i<map.map.length;i++)
            {
            for(int j=0;j<map.map[0].length;j++)
                {
                  if(map.map[i][j]>0)
                  {
                      int brickx=j*map.width+80;
                      int bricky=i*map.width+50;
                      int width=map.width;
                      int height=map.height;
                      //create rectangle around
                      Rectangle rect=new Rectangle(brickx,bricky,width,height);
                       Rectangle ballrect=new Rectangle(ballposx,ballposy,20,20);
                       Rectangle brick=rect;
                       if(ballrect.intersects(brick))
                       {
                           map.setbreakes(0, i, j);
                           totalBricks--;
                           score+=5;
                           if(ballposx+19<=rect.x||ballposx+1>=rect.x+rect.width)
                           {
                           ballxdir=-ballxdir;
                           }
                           else
                           {
                               ballydir=-ballydir;
                           }
                           break out;
                               }
                      
                  }

                }
            }
            ballposx+=ballxdir;
            ballposy+=ballydir;
            if(ballposx<0)
                ballxdir=-ballxdir;
             if(ballposy<0)
                ballydir=-ballydir;
              if(ballposx>670)
                ballxdir=-ballxdir;
            
        }
        repaint();
                
    }
     @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(e.getKeyCode()==KeyEvent.VK_RIGHT)
        {
            if(playerx>=600){
                playerx=600;
            }
            else
            {
                moveRight();
            }      
        }
         if(e.getKeyCode()==KeyEvent.VK_LEFT)
        {
            if(playerx<10){
                playerx=10;
            }
            else
            {
                moveLeft();
            }
        }
         if(e.getKeyCode()==KeyEvent.VK_ENTER)
         {
             if(!play)
             {
                 play=true;
                 ballposx=120;
                 ballposy=350;
                 ballxdir=-1;
                 ballydir=-2;
                 playerx=310;
                 score=0;
                 totalBricks=21;
                 map=new Breakers(3,5);
                 repaint();
            
             }
         }
    }
    public void moveRight(){
        play=true;
        playerx+=30;
    }
     public void moveLeft(){
         play=true;
         playerx-=30;
    }
    
    }
  //run all game  
    //key detect arrow key
    

