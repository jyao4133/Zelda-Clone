package com.control;


import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.enemy.*;
import com.gui.*;
import com.level.*;
import com.player.*;

import javax.swing.*;

public class Game extends Canvas implements Runnable {

    private static final long serialVersionUID = 125890125890L;
    ArrayList<String> scoreList = new ArrayList<>();

    public static int WIDTH = 1024, HEIGHT = 990;
    public int arrowsRemaining = 10;
    public int player1Health = 4;
    public int goldAmount = 0;
    public int bossHealth = 20;

    public int enemiesStage1 = 4;

    public int birdsStage2 = 3;
    public int shootersStage2 = 1;

    public int shootersStage3 = 1;
    public int clampsStage3 = 4;

    public int timeNum;
    public int playerScore;

    public String nextLevel;
    public String prevLevel;
    public String playerName;


    public boolean removeBool, keyObtained, keyspawned, shopKeeperCollision, rangedupgrade, meleeupgrade = false;

    public boolean firstLoad = true;
    private boolean save, titleShown,loadKey = true;
    private boolean level1Visted, level2Visted = false;


    private volatile boolean running = false;
    private Thread thread;

    private Handler handler;
    public BufferedImage background, background2,background3, bossLevel, basement, tutorialscreen;

    public static SpriteSheet ss;
    private BufferedImage spritesheet;
    
    private TitleScreen titlescreen;
    private Options options;
    private Pause pause;
    private pauseOptions pauseoptions;
    private highScores showScore;
    private deathScreen death;
    private level2 Level2;
    private level3 Level3;
    private bossStage bosstage;
    private InRead read;
    private OutWrite write;
    private highscoreSort scoreSort;
    private shopState shopstate;
    private Tutorial tutorial;

    public Window window;
    public Player1 player;
    private static Game game;

    private Hearts heart1, heart2, heart3, heart4;

    private timer Timer;

    ImageRender loader = new ImageRender();

    private Audio main_music;
    
    //to create the title screen we will use the states in the code
    public static States state = com.control.States.TitleScreen;
    public static States tempstate;
       
    
    
    public Game(){
        window = new Window (WIDTH, HEIGHT, "Pre-Title", this);
        handler = new Handler();
		titlescreen = new TitleScreen();
		options = new Options();
		pause = new Pause();
		pauseoptions = new pauseOptions();
		Level2 = new level2();
        Level3 = new level3();
        bosstage = new bossStage();
        death = new deathScreen();
        shopstate = new shopState();
        tutorial = new Tutorial();
        
        playerName = JOptionPane.showInputDialog(null, "Enter your name", "Elizabeth");
        if (playerName == null){
            playerName = "Elizabeth";
        }

        if (playerName.isEmpty()){
            playerName = "Elizabeth";
        }
        
        heart1 = new Hearts();
		heart2 = new Hearts();
        heart3 = new Hearts();
        heart4 = new Hearts();
        
        write = new OutWrite();
        read = new InRead();
        scoreSort = new highscoreSort();

     	main_music = new Audio ("Main_music.wav");
    	main_music.play();
    	
        Timer = new timer();
        Timer.start();

        this.requestFocusInWindow();
        if (loadKey == true) {
            this.addKeyListener(new KeyHandler(handler, ss, this));
            loadKey = false;
        }
        background = loader.loadImage("test_level.png");
        background2 = loader.loadImage("test_level_2.png");
        background3 = loader.loadImage("test_level_3.png");
        bossLevel = loader.loadImage("bosslevel.png");
        basement = loader.loadImage("basement.png");
        spritesheet = loader.loadImage("spritesheet.png");
        ss = new SpriteSheet (spritesheet);
		
        this.addMouseListener(new MouseHandler(handler, this, ss));
        
        loadLevel(background);
        loadLevel(background2);
        loadLevel(background3);
        showScore = new highScores(scoreList);
    }



	public synchronized void start(){

        thread = new Thread(this); //"this" refers to our Game class
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.interrupt();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public void run(){
    	Toolkit toolkit = Toolkit.getDefaultToolkit();
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        int updates = 0;
        while(running){
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >=1){
                tick();
                updates++;
                delta--;
            }
            render();
            frames++;
            if(System.currentTimeMillis() - timer > 1000){
                timer += 1000;
                System.out.println("FPS: "+ frames);
                updates = 0;
                frames = 0;
            }
            toolkit.sync(); //used to sync the objects rendered on the screen with the tick methods
        }
        stop();
    }
   
    private void tick(){
        if (state == States.level1 || state == States.level2 || state == States.level3 || state == States.bosslevel) {
            handler.tick();
            Timer.tick();
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
        if (state == States.level1) {
            keyspawned = false;
            nextLevel = "level2";
            g.setColor(Color.red);
        	g.fillRect(0, 0, WIDTH, HEIGHT);
        	g.setColor(Color.black);
        	g.fillRect(0, 0, WIDTH, 170);  	
        	g.drawImage(basement, 0, 170, null);
            handler.render(g);
            Timer.render(g, game);
            for (int i = 0; i < 2; i++) {
            	heart2.drawHeart(g, 295, 50, 30, 30, player1Health, 2);                
            	heart1.drawHeart(g, 225, 50, 30, 30, player1Health, 1);
            	heart3.drawHeart(g, 190, 50, 30 ,30, player1Health, 3);
            	heart4.drawHeart(g, 260, 50, 30, 30, player1Health, 4);
            }
            g.dispose();
        	bufferstrat.show();
        }else if (state == States.TitleScreen) {
            titleShown = true;
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
        	pause.render(g);
        	g.dispose();
            bufferstrat.show();
        }else if(state == States.deathscreen){
            g.setColor(Color.black);
            g.fillRect(0,0,WIDTH,HEIGHT);
            death.render(g);
            g.dispose();
            bufferstrat.show();
        }else if (state == States.highscores){
            if(titleShown == true) {
                scoreList.clear();
                scoreList = read.read(scoreList);
                scoreList = scoreSort.listSort(scoreList);
                System.out.println(scoreList);
                titleShown = false;
            }
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            showScore.render(g);
            g.dispose();
            bufferstrat.show();
        }else if(state == States.Load){ //Reset state
            scoreList.clear();
            Timer.currentSecond = 0;
            Timer.currentMinute = 0;
            player1Health = 4;
            arrowsRemaining = 10;
            bossHealth = 20;
            enemiesStage1 = 4;
            birdsStage2 = 3;
            shootersStage2 = 1;
            shootersStage3 = 1;
            clampsStage3 = 4;
            goldAmount = 0;
            removeBool = true;
            firstLoad = true;
            save = true;
            titleShown = true;
            keyspawned = false;
            keyObtained = false;
            level1Visted = false;
            level2Visted = false;
            meleeupgrade = false;
            rangedupgrade = false;
            loadLevel(background);
            state = States.level1;
        }else if(state == States.pauseOptions){
            pauseoptions.render(g);
            g.dispose();
            bufferstrat.show();
        } else if (state == States.level2) {
            keyspawned = false;
            prevLevel = "game";
            nextLevel = "level3";
            Level2.render(g);
            handler.render(g);
            if (firstLoad == true){
                loadLevel(background2);
                this.addKeyListener(new KeyHandler(handler, ss,this));
                firstLoad = false;
            }
            Timer.render(g, game);
            for (int i = 0; i < 3; i++) {
            	heart2.drawHeart(g, 295, 50, 30, 30, player1Health, 2);                
            	heart1.drawHeart(g, 225, 50, 30, 30, player1Health, 1);
            	heart3.drawHeart(g, 190, 50, 30 ,30, player1Health, 3);
            	heart4.drawHeart(g, 260, 50, 30, 30, player1Health, 4);
            }
            g.dispose();
            bufferstrat.show();
        }else if (state == States.level3){
            prevLevel = "level2";
            nextLevel = "bosslevel";
            Level3.render(g);
            handler.render(g);
            if (firstLoad == true){
                loadLevel(background3);
                this.addKeyListener(new KeyHandler(handler, ss, this));
                firstLoad = false;
            }
            Timer.render(g, game);
            for (int i = 0; i < 3; i++) {
            	heart2.drawHeart(g, 295, 50, 30, 30, player1Health, 2);                
            	heart1.drawHeart(g, 225, 50, 30, 30, player1Health, 1);
            	heart3.drawHeart(g, 190, 50, 30 ,30, player1Health, 3);
            	heart4.drawHeart(g, 260, 50, 30, 30, player1Health, 4);
            }
            if (clampsStage3 == 0 && shootersStage3 == 0){
                if (keyspawned == false && keyObtained == false) {
                    handler.addObject(new doorKey(800, 800, IDs.doorkey, ss));
                    keyspawned = true;
                }
            }
            g.dispose();
            bufferstrat.show();
        }else if (state == States.shop){
            shopstate.render(g);
            Timer.render(g, game);
            for (int i = 0; i < 2; i++) {
                heart2.drawHeart(g, 295, 50, 30, 30, player1Health, 2);                
                heart1.drawHeart(g, 225, 50, 30, 30, player1Health, 1);
                heart3.drawHeart(g, 190, 50, 30 ,30, player1Health, 3);
                heart4.drawHeart(g, 260, 50, 30, 30, player1Health, 4);
            }
            g.dispose();
            bufferstrat.show();
        }else if (state == States.bosslevel){
            prevLevel = "game";
            nextLevel = "level2";
            bosstage.render(g);
            handler.render(g);
            Timer.render(g,game);
            if (firstLoad == true){
                loadLevel(bossLevel);
                this.addKeyListener(new KeyHandler(handler, ss, this));
                firstLoad = false;
            }
            for (int i = 0; i < 3; i++) {
            	heart2.drawHeart(g, 295, 50, 30, 30, player1Health, 2);                
            	heart1.drawHeart(g, 225, 50, 30, 30, player1Health, 1);
            	heart3.drawHeart(g, 190, 50, 30 ,30, player1Health, 3);
            	heart4.drawHeart(g, 260, 50, 30, 30, player1Health, 4);
            }
            g.dispose();
            bufferstrat.show();
        }else if (state == States.tutorial) {
        	tutorial.render(g);
        	g.dispose();
            bufferstrat.show();
        }
        if(player1Health == 0 || bossHealth == 0){
            if (save == true){
                System.out.println("got here");
                playerScore = goldAmount * 5 + arrowsRemaining * 3 + player1Health * 3;
                write.Write(playerName, playerScore);
                save = false;
                scoreList = read.read(scoreList);
                scoreList = scoreSort.listSort(scoreList);
            }
        }
        g.dispose();
    	bufferstrat.show();
    }

    public void loadLevel(BufferedImage image){
        int w = image.getWidth();
        int h = image.getHeight();

        handler.removeall();

        for (int xx = 0; xx < w; xx++){
            for(int yy = 0; yy < h; yy++){
                int pixel = image.getRGB(xx, yy);
                int red = (pixel >> 16) & 0xff;
                int green = (pixel >> 8) & 0xff;
                int blue = (pixel) & 0xff;
                if (red == 255 && blue == 0 && green == 216){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block, ss));
                }
                if ((red & blue) == 255 && red == 0){
                    handler.addObject(new Block(xx*32, yy*32, IDs.Block, ss));
                }
                if (green == 255 && blue == 0 && red == 0){
                    System.out.println("This is the Y pos: "+ yy*32);
                    System.out.println("This is the X pos: "+ xx*32);
                }
                if (green == 255 && blue == 255 && red == 0){
                    handler.addObject(new arrowPickup(xx*32, yy*32, IDs.Pickup, ss));
                }
                if (green == 255 && blue == 255 && red == 255){
                    handler.addObject(new Stairs(xx*32, yy*32, IDs.Stairs, ss));
                }
                if (green == 0 && blue == 0 && red == 200){
                    handler.addObject(new backStairs(xx*32, yy*32, IDs.backStairs, ss));
                }
            }
        }
        if (Game.state == States.level2){
            level1Visted = true;
            if (level2Visted == false){
            	handler.addObject(new Player1(224, 750, IDs.player, handler, this, ss));
            }
            else{
                handler.addObject(new Player1(842, 360, IDs.player, handler, this, ss));
            }
            handler.addObject(new Enemy(500, 400, IDs.enemy,  handler, this, 500, 300, 1, ss));
        }
        if (Game.state == States.Load || Game.state == States.level1){
                level2Visted = false;
                if (enemiesStage1 > 0) {
                    handler.addObject(new Enemy(350, 350, IDs.enemy, handler, this, 350, 350, 1, ss));
                }
                if (enemiesStage1 > 1) {
                    handler.addObject(new Enemy(200, 500, IDs.enemy, handler, this, 200, 500, 1, ss));
                }
                if (enemiesStage1 > 2) {
                    handler.addObject(new Enemy(256, 640, IDs.enemy, handler, this, 256, 640, 1, ss));
                }
                if (enemiesStage1 > 3) {
                    handler.addObject(new Enemy(350, 500, IDs.enemy, handler, this, 350, 500, 1, ss));
                }
               handler.addObject(new Ghost(800, 500, IDs.followingEnemy, handler, this, ss));

                if (level1Visted ==true){
                    handler.addObject(new Player1(545, 360, IDs.player, handler, this, ss));
                }
                else{
                    handler.addObject(new Player1(740, 800, IDs.player, handler, this, ss));
                }
        }
        if (Game.state == States.bosslevel){
            handler.addObject(new Player1(138, 741, IDs.player, handler, this, ss));
            handler.addObject(new boss(600, 400, IDs.boss, handler, this, 500, 300, 1, ss));

        }
        if (Game.state == States.level3){
            level2Visted = true;
            handler.addObject(new Player1(103, 779, IDs.player, handler, this, ss));
            if (clampsStage3 > 0) {
                handler.addObject(new clampEnemyright(100, 605, IDs.clampright, handler, this, ss));
            }
            if (clampsStage3 > 1) {
                handler.addObject(new clampEnemyleft(700, 620, IDs.clampleft, handler, this, ss));
            }
            if (clampsStage3 > 2) {
                handler.addObject(new clampEnemyright(100, 370, IDs.clampright, handler, this, ss));
            }
            if (clampsStage3 > 3) {
                handler.addObject(new clampEnemyleft(700, 370, IDs.clampleft, handler, this, ss));
            }
            if (shootersStage3 > 0) {
                handler.addObject(new shooterEnemy(480, 500, IDs.shooterEnemy, handler, this, ss));
            }
            handler.addObject(new shopKeeper(855, 800,IDs.shopkeeper , ss));
        }

    }

    public static int edge(int var, int min, int max){
        if(var >= max){
            return var = max;
        }else if(var <= min){
            return var = min;
        } else
            return var; 
    }

    public static void main(String args[]){
        game = new Game();
    }

    public States getGameState() {
    	return state;
    }
    
    public void setGameState(States gamestate) {
        state = gamestate;
    }

}