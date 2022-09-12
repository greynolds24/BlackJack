
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;

public class BlackJackMain implements Runnable, KeyListener {

    //global variables
    //Sets the width and height of the program window
    final int WIDTH = 5;
    final int HEIGHT = 5;

    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    public int getScore;
    public int score;
    public int shuffle;
    public int printDeck;
    public int dealer;
    public Player[] players;
    public int currentPlayer = 0;
    public Player dealers;
    public int topofdeck;
    ArrayList<Card> deck = new ArrayList<>();


    public static void main(String[] args) {
        BlackJackMain game = new BlackJackMain();

        new Thread(game).run();
    }


    public BlackJackMain() {
        setUpGraphics();
        canvas.addKeyListener(this);
       

        players = new Player[3];
        for (int i = 0; i < players.length; i++) {
            players[i] = new Player();
        }
        dealers = new Player();


        for (int suitname = 1; suitname < 5; suitname++) {
            for (int cardname = 1; cardname < 14; cardname++) {
                deck.add(new Card(suitname, cardname));
            }
        }


        shuffle();
        //deal
        for (int y = 0; y < 2; y++) {
            for (int w = 0; w < players.length; w++) {
                deal(players[w]);
            }
            deal(dealers);
        }
        printhands();
        players[0].checkScore();

    }


    public void run() {

        while(true){
            render();
            pause(100);
        }
    }
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }
    public void printhands() {
        for (int d = 0; d < players.length; d++) {
            System.out.println("player: " + (d + 1));
            players[d].printhand();

        }
    }
    public void shuffle() {
        for (int s = 0; s < 1000; s++) {
            int r = (int) (Math.random() * 52);
            Card x = deck.get(0);
            deck.set(0, deck.get(r));
            deck.set(r, x);
        }


    }
    public void deal(Player p) {

        p.hand.add(deck.get(0));
        deck.remove(0);


    }
    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            deck.get(i).printInfo();

        }
    }
    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        //

        //
        g.dispose();
        bufferStrategy.show();
    }
    public void setUpGraphics() {

        frame = new JFrame("Blackjack");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!
        frame.setLocationRelativeTo(null);

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        char key = e.getKeyChar();
        int keyCode = e.getKeyCode();
        System.out.println(key + "   " + keyCode);
        if (keyCode == 72){ // h
            System.out.println("player "+ (currentPlayer+1) + "'s turn");
            deal(players[currentPlayer]);
            players[currentPlayer].printhand();
        }
        if (keyCode==83){ // s
            currentPlayer++;
            System.out.println("new player");

        }
    }

}