import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;
public class Bola{
    private int xPosition=400;
    private int yPosition=300;

    private double dx, dy;
    private int angle;
    private int speed=2;

   

    public Bola(){
        
        angle=new Random().nextInt(120-45)+45;//Circulo trigonoétrico
        dx=Math.cos(angle);
        dy=Math.sin(angle);
    }

    public void tick(){
        Rectangle player = new Rectangle(Game.player.xPosition-Game.player.xPosition/2, Game.player.yPosition);
        Rectangle enemy=new Rectangle(Game.enemy.xPositionEnemy, Game.enemy.yPositionEnemy);
        Rectangle boll = new Rectangle(this.xPosition, this.yPosition, 30, 30);   
        if(boll.intersects(player)){
            System.out.println("player intersection");
        }else if(boll.intersects(enemy)){
            System.out.println("enemy intersection");
        }

        xPosition+=speed*dx;
        yPosition+=speed*dy;
    }

    public void render(Graphics g){
        g.setColor(Color.white);
        g.fillOval(xPosition, yPosition, 32, 32);
    }
}