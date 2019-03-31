package com.control;


import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 125890125890L;

    public static int WIDTH = 640, HEIGHT = WIDTH/12 * 9;

    private Thread thread;
    private boolean running = false;

    private Handler handler;


    public Game(){
        new Window (WIDTH, HEIGHT, "Pre-Title", this);
        handler = new Handler();
        handler.addObject(new Player1(100, 100, IDs.player));

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

    public void run(){
        //initialise the game loop

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
        }
        stop();
    }

    private void tick(){
        handler.tick();
    }

    private void render() {
        //Create a buffer strategy and number of buffers. We don't want an astronomically high FPS
        BufferStrategy bufferstrat = this.getBufferStrategy();

        if (bufferstrat == null){

            this.createBufferStrategy(3);
            return;

        }

        Graphics g = bufferstrat.getDrawGraphics();

        g.setColor(Color.red);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        handler.render(g);
        g.dispose();
        bufferstrat.show();

    }

    public static void main(String args[]){
        new Game();
    }



}