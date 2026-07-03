import java.awt.Color;
import java.awt.Graphics;

public class Enemy{
    public  int xPositionEnemy=Game.LARGURA*Game.ESCALA/2;
    public  int yPositionEnemy=0;


    public Enemy(){
        
    }

    public void tick(){

    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(xPositionEnemy+64, yPositionEnemy, 64*2, 16*2);
    }
}