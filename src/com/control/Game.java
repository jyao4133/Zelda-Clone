package com.control;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.awt.image.*;
import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 125890125890L;

    public static int WIDTH = 1040, HEIGHT = 990;
    public int arrowsRemaining = 10;
    public int player1Health = 4;

    private Thread thread = null;
    private boolean running = false;

    private Handler handler;
    private BufferedImage background;

    private TitleScreen titlescreen;
    private Options options;
    private Pause pause;
    
    public Player1 player;
    public Enemy enemy;

    private Hearts heart1;
    private Hearts heart2;
    private Hearts heart3;
    private Hearts heart4;

    //to create the title screen we will use the states in the code
    public static States state = com.control.States.TitleScreen;

       
    
    
    public Game(){
        new Window (WIDTH, HEIGHT, "Pre-Title", this);
        handler = new Handler();
		titlescreen = new TitleScreen();
		options = new Options();
		pause = new Pause();

		heart2 = new Hearts();
        heart1 = new Hearts();
        heart3 = new Hearts();
        heart4 = new Hearts();
        //handler.addObject(new Enemy(50,50, IDs.enemy));
		
        //handler.addObject(new Player1(100, 100, IDs.player));
        this.requestFocusInWindow();
		this.addKeyListener(new KeyHandler(handler));
		this.addMouseListener(new MouseHandler(handler, this));
		//this.addMouseListener(new MouseInputGame(handler));
		ImageRender loader = new ImageRender();
        background = loader.loadImage("test_level.png");
        loadLevel(background);
        
        
    }
    

    public synchronized void start(){
        thread = new Thread(this); //"this" refers to our Game class
        thread.start();
        running = true;
    }

    public synchronized void stop() {
    	
        try {
            thread.join(); //stops thread
            running = false;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public void run()
    {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                updates++;
                delta--;
            }
            
            render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                //System.out.println("FPS: "+ frames);
                updates = 0;
                frames = 0;
            }
            toolkit.sync(); //used to sync the objects rendered on the screen with the tick methods
        }
        stop();
    }

   
    private void tick(){
        if (state == States.Game) {
            handler.tick();
        }
    }

    private void render() {
        //Create a buffer strategy and number of buffers. We don't want an astronomically high FPS
        BufferStrategy bufferstrat = this.getBufferStrategy();
        
		
		if (bufferstrat == null){

            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bufferstrat.getDrawGraphics();

        
        
        if (state == States.Game) {
        	////////////////////////////////////JFrame colour
        	g.setColor(Color.red);
        	g.fillRect(0, 222, WIDTH, HEIGHT);

        	//Health Bar area
        	g.setColor(Color.black);
        	g.fillRect(0, 0, WIDTH, 230);

        	g.setColor(Color.blue);
        	g.fillRect(50, 50, 200, 50);

            handler.render(g);

            for (int i = 0; i < 3; i++) {

                heart2.drawHeart(g, 480, 50, 50, 50, player1Health, 2);
                heart1.drawHeart(g, 360, 50, 50, 50, player1Health, 1);
                heart3.drawHeart(g, 300, 50, 50 ,50, player1Health, 3);
                heart4.drawHeart(g, 420, 50, 50, 50, player1Health, 4);

            }
            g.dispose();
        	bufferstrat.show();

        }else if (state == States.TitleScreen) {
            //g.fillRect(0, 0, WIDTH, HEIGHT);
            titlescreen.render(g);
            g.dispose();
            bufferstrat.show();
            
        }else if (state == States.Options) {
        	g.setColor(Color.GREEN);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
            options.render(g);
            g.dispose();
            bufferstrat.show();
        }else if (state == States.Pause) {
        	//g.setColor(Color.WHITE);
        	//g.fillRect(WIDTH/4, HEIGHT/4 , WIDTH/2, HEIGHT/2);
        	pause.render(g);
        	g.dispose();
            bufferstrat.show();
        }
        
        
        g.dispose();
    	bufferstrat.show();

    }

    private void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        for (int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;

                if (red == 255){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block));
                }

                if (blue == 255 && green == 0 && red == 0){
                    handler.addObject(new Player1(xx*32,yy*32, IDs.player, handler, this));

                }

                if ((red & blue) == 255 && red == 0){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block));
                }

                if (green == 255 && blue == 0 && red == 0){
                    handler.addObject(new Enemy(xx*32, yy*32, IDs.enemy, handler, xx*32, yy*32, 1));
                }

                if (green == 255 && blue == 255 && red == 0){
                    handler.addObject(new arrowPickup(xx*32, yy*32, IDs.Pickup));
                }


            }
        }
    }

    public static int edge(int var, int min, int max){
        if(var >= max){
            return var = max;
        }
        else if(var <= min){
            return var = min;
        }
        else
            return var;

    }

//    public void drawHeart(Graphics g, int x, int y, int width, int height,int heartnum){
//
//        //Referenced algorithm to draw a heart from https://stackoverflow.com/questions/33402242/how-to-draw-heart-using-java-awt-libaray
//
//
//        int[] triangleX = {
//                x - 2*width/18 + 3,
//                x + width + 2*width/18 - 3,
//                (x - 2*width/18 + x + width + 2*width/18)/2};
//        int[] triangleY = {
//                y + height - 2*height/3,
//                y + height - 2*height/3,
//                y + height };
//
//        g.fillOval(
//                x - width/12,
//                y,
//                width/2 + width/6,
//                height/2);
//        g.fillOval(
//                x + width/2 - width/12,
//                y,
//                width/2 + width/6,
//                height/2);
//
//
//        g.fillPolygon(triangleX, triangleY, triangleX.length);
//        g.setColor(Color.orange);
//
//        if (arrowsRemaining < 5 && heartnum == 1){
//            g.fillOval(
//                    x - width/12,
//                    y,
//                    width/2 + width/6,
//                    height/2);
//            g.fillOval(
//                    x + width/2 - width/12,
//                    y,
//                    width/2 + width/6,
//                    height/2);
//            g.fillPolygon(triangleX, triangleY, triangleX.length );
//            g.setColor(Color.green);
//        }
//
//    }

    public static void main(String args[]){
        if (state == States.TitleScreen) {
            new Game();
        }  
    }

    public States getGameState() {
    	return state;
    }
    
    public void setGameState(States gamestate) {
    	Game.state = gamestate;
    }

}