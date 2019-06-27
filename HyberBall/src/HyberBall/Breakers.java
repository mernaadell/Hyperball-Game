package HyberBall;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Merna
 */
public class Breakers {
    public int map[][];
    public int width;
    public int height;
    public Breakers(int row,int col)
    {
        map=new int[row][col];
        for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
                map[i][j]=1;
            }
        }
        width=540/col;
        height=150/row;
    }
    public void draw (Graphics2D g)
    {
         for(int i=0;i<map.length;i++)
        {
            for(int j=0;j<map[0].length;j++)
            {
                if(map[i][j]>0){
                    g.setColor( Color.lightGray);
                    g.fillOval(j*width+80, i*height+50, width, height);
                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawOval(j*width+80, i*height+50, width, height);
                    
                
                }
                
            }
        
        }}
         public void setbreakes(int value ,int row ,int col)
         {
             map[row][col]=value;
         }
    
}
