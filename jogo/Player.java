import java.awt.Color;
import java.awt.Graphics;

public class Player{ 
    public int xPosition=300;
    public  int yPosition=570;
    

    public  boolean right=false;
    public  boolean left=false;
    
    private double speed=5;

    public Player(){
        
    }

    public void tick(){
        if(right==true){
            xPosition+=speed;
        }else if(left==true){
            xPosition-=speed;
        }
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(xPosition+64, yPosition,64*2, 16*2);    
    }
}