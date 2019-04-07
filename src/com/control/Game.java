package com.control;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.*;
import java.nio.Buffer;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 125890125890L;

    public static int WIDTH = 1024, HEIGHT = 990;

    private Thread thread;
    private boolean running = false;

    private Handler handler;
    private BufferedImage background;
    private TitleScreen titlescreen;
    //to create the title screen we will use the states in the code
    public static States state = com.control.States.TitleScreen;

       
    
    
    public Game(){
        new Window (WIDTH, HEIGHT, "Pre-Title", this);
        handler = new Handler();
		titlescreen = new TitleScreen();
        handler.addObject(new Player1(50,50, IDs.player, handler));

        handler.addObject(new Enemy(50,50, IDs.enemy));

        //handler.addObject(new Player1(100, 100, IDs.player));
        this.requestFocusInWindow();
		this.addKeyListener(new KeyHandler(handler));
		this.addMouseListener(new MouseHandler());
		//ImageRender loader = new ImageRender();
        //background = loader.loadImage("test_level.png");
        //loadLevel(background);
		
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
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1)
            {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }
            //toolkit.sync(); //used to sync the objects rendered on the screen with the tick methods
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
        	g.setColor(Color.cyan);
        	g.fillRect(0, 0, WIDTH, 222);

        	handler.render(g);
        	g.dispose();
        	bufferstrat.show();
        }else if (state == States.TitleScreen) {
            g.fillRect(0, 0, WIDTH, HEIGHT);

//            ImageRender loader = new ImageRender();
//            background = loader.loadImage("test_level2.png");
//            loadLevel(background);
            titlescreen.render(g);
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

                if (blue == 255){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block));

                }

                if ((red & blue) == 255){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block));
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

    public static void main(String args[]){
        new Game();
    }



}