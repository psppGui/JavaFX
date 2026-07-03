import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class Game extends Canvas implements Runnable, KeyListener {
    public static int ALTURA=900;
    public static int LARGURA=600;
    public static int ESCALA=1;
    public JFrame frame;

    private boolean isRunning=true;
    private  BufferedImage image;
    
    //Instaciando player
    public static  Player player;
    public static Enemy enemy;
    public static Bola boll;
    

    public  int xPosition=LARGURA*ESCALA/2;
    public  int yPosition=570;
    

    public  int xPositionEnemy=LARGURA*ESCALA/2;
    public  int yPositionEnemy=0;
    

    public Game(){
        this.addKeyListener(this);
        this.setPreferredSize(new Dimension(ALTURA * ESCALA, LARGURA* ESCALA));
        image=new BufferedImage(ALTURA*ESCALA, LARGURA*ESCALA, BufferedImage.TYPE_INT_RGB);
        this.criarTela();

        player = new Player();
        enemy=new Enemy();
        boll=new Bola();



    }    
    public void criarTela(){
        frame = new JFrame("Ping pong:");
        frame.add(this);
        frame.pack(); //frame.setSize(ALTURA*ESCALA, LARGURA*ESCALA); jeito certo de criar a tela  <-----
        frame.setResizable(false);  //Para deixar um tamanho de tela fixo e não o capetinha ficar mexendo nela com o mouse:

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);//Para deixar nossa tela no meio da tela do computador table sei lá o que tu estiver vendo aí
        frame.setVisible(true);
    }

    public static void main(String[] args){
        Game primeiraTela = new Game();
        new Thread(primeiraTela).start();

    }

    //Game loop
    //Ticar atualizar
    public void tick(){
        player.tick();
        enemy.tick();
        boll.tick();
    }

    //Game loop
    //Renderizar
    public void render(){
        System.out.print("");
        BufferStrategy bs=this.getBufferStrategy();
        if (bs==null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g= image.getGraphics();
        
        g.setColor(Color.darkGray);
        g.fillRect(0,0,ALTURA*ESCALA, LARGURA*ESCALA);

        player.render(g);
        enemy.render(g);
        boll.render(g);

        g=bs.getDrawGraphics();
        g.drawImage(image, 0, 0, ALTURA*ESCALA, LARGURA*ESCALA, null);
        bs.show();
    }
    
    @Override
    public  void run(){
        while(isRunning){
            tick();
            render();
            try {
                Thread.sleep(1000/75);
            } catch (Exception e) {
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e){
        
    }

    @Override
    public void keyPressed(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            player.right=true;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            player.left=true;
        }

      /*if(e.getKeyCode()==KeyEvent.VK_UP){up=true;}else if(e.getKeyCode()==KeyEvent.VK_DOWN){down=true;}*/
    }
    @Override
    public void keyReleased(KeyEvent e){
        if (e.getKeyCode()==KeyEvent.VK_RIGHT) {
            player.right=false;
        }else if(e.getKeyCode()==KeyEvent.VK_LEFT){
            player.left=false;
        }
        /*if(e.getKeyCode()==KeyEvent.VK_UP){up=false;}else if(e.getKeyCode()==KeyEvent.VK_DOWN){down=false;}*/
    }
}
