import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;
public class Game extends Canvas implements Runnable {
    public int ALTURA=600;
    public int LARGURA=400;
    public int ESCALA=1;
    public JFrame frame;

    private boolean isRunning=true;
    private  BufferedImage image;

    public Game(){
        this.setPreferredSize(new Dimension(ALTURA * ESCALA, LARGURA* ESCALA));
        image=new BufferedImage(ALTURA*ESCALA, LARGURA*ESCALA, BufferedImage.TYPE_INT_RGB);
        this.criarTela();
        
    }    
    public void criarTela(){
        frame = new JFrame("Jogo em java:");
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
        System.out.print("Aqui está o tick");
    }

    //Game loop
    //Renderizar
    public void render(){
        System.out.print("Aqui está o tick");
        BufferStrategy bs=this.getBufferStrategy();
        if (bs==null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g= image.getGraphics();
        
        g.setColor(Color.blue);
        g.fillRect(0, 0, 50, 50);

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
                Thread.sleep(1000/60);
            } catch (Exception e) {
            }
        }
    }
}
