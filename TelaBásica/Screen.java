import javax.swing.JFrame;

public class Screen{
    private JFrame pixel;

    /*Construtor para chamar o método, para que assim
    não precise chamar o método, assim que instânciar o objeto e depois chamar o método createScreen.
    Também posso criar a janela direto no construtor sem ter que
    */
   
    public Screen(){
        this.createScreen();
    }

    public void createScreen(){
        pixel=new JFrame("My first window in java");
        pixel.setSize(600,400);//Altura e largura
        pixel.setVisible(true);//Vísivel ficando verdadeira
        pixel.setResizable(false);//Posso mexer no tamanho? False=Não Sim=true
        pixel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//Terminar assim que eu fechar
    }

    public static void main(String[] args){
        Screen exampleOfAWindow= new Screen();//Criação da janela instânciando ela
    }
}