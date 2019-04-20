package com.enemy;
//https://www.deviantart.com/zeka10000/art/Discord-Sprites-for-RPG-Maker-MV-718234101
import java.awt.*;
import com.control.*;
import com.player.Animation;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteAnimation;
import com.player.SpriteSheet;
import com.player.arrowPickup;
import com.player.heartPickup;

import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.*;

public class boss extends Object{

    //First enemy
    /*
    This enemy is the first enemy the player will come across. It will have randomized
    movement and will remove 1 point of health when it collides with the player.
     */
    private Handler handler;
    Game game;
    Random r = new Random();
    int chosen = 0;
    private int hplossCD = 0;
    private int currentSecond = 0;
    private int currentShot = 0;
    int maxSpeed = 5;
    private int Direction = 1;
	int spacing = 60;

    
    private BufferedImage [] up, down, left, right;
    private BufferedImage bosspos;
    private Animation ani_up, ani_down, ani_left, ani_right;
    
    public boss(int xpos, int ypos, IDs id, Handler handler, Game game, int xprev, int yprev, int initial, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.xprev = xprev;
        this.yprev = yprev;
        this.game = game;
        this.initial = initial;
        start();
        startCD();

        up = new BufferedImage [3];
		down = new BufferedImage[3];
		left = new BufferedImage [3];
		right = new BufferedImage [3];
		/////////////ANIMATIONS/////////////
		up[0] = ss.bossImage(8, 4, 75,150);
		up[1] = ss.bossImage(9, 4, 75,150);
		up[2] = ss.bossImage(10, 4, 75,150);
		
		down[0] = ss.bossImage(8, 1, 75,150);
		down[1] = ss.bossImage(9, 1, 75,150);
		down[2] = ss.bossImage(10, 1, 75,150);
		
		left[0] = ss.bossImage(8, 2, 75,150);
		left[1] = ss.bossImage(9, 2, 75,150);
		left[2] = ss.bossImage(10, 2, 75,150);
		
		right[0] = ss.bossImage(8, 3, 75,150);
		right[1] = ss.bossImage(9, 3, 75,150);
		right[2] = ss.bossImage(10, 3, 75,150);
		///////////////////////////////////////
		ani_up = new Animation (200, up);
		ani_down = new Animation (200, down);
		ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);		
		bosspos = up[0];
        
        
    }

    public void tick() {
    	ani_up.tick();
    	ani_down.tick();
    	ani_left.tick();
    	ani_right.tick();

        if(initial == 1){
            initial = 0;
        }else{
            xprev = xpos;
            yprev = ypos;
        }

            ypos += Yspeed;
            xpos += Xspeed;


        if(currentShot > 50) {
            //right
            if (Direction == 1) {
                currentShot = 0;
                handler.addObject(new enemyArrow(xpos + 200, ypos + 115, IDs.enemyArrow, handler, ss, 1, true));
                Direction = r.nextInt(4) + 1;

            }
            //up
            else if (Direction == 2) {
                currentShot = 0;
                handler.addObject(new enemyArrow(xpos + 115, ypos + 200, IDs.enemyArrow, handler, ss, 2, true));
                Direction = r.nextInt(4) + 1;


            }
            //left
            else if (Direction == 3) {
                currentShot = 0;
                handler.addObject(new enemyArrow(xpos, ypos + 115, IDs.enemyArrow, handler, ss, 3, true));
                Direction = r.nextInt(4) + 1;


            }
            //down
            else if (Direction == 4) {
                currentShot = 0;
                handler.addObject(new enemyArrow(xpos + 115, ypos, IDs.enemyArrow, handler, ss, 4, true));
                Direction = r.nextInt(4) + 1;

            }
        }
        chosen = r.nextInt(10);


        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);

            if (tempObject.getId() == IDs.Block) {

                if (getBounds().intersects((tempObject.getBounds()))) {

                    xpos = xprev;
                    ypos = yprev;
                    Xspeed *= -1;
                    Yspeed *= -1;
                }
                else if (chosen == 0){
                        if (currentSecond > 40) {
                            Xspeed = (r.nextInt(2 * maxSpeed + 1) - maxSpeed);
                            Yspeed = (r.nextInt(2 * maxSpeed + 1) - maxSpeed);
                            currentSecond = 0;
                        }
                }
            }

            if (tempObject.getId() == IDs.Arrow ){
                if(getBounds().intersects((tempObject.getBounds()))){

                    if (game.bossHealth > 0){
                        handler.removeObject(tempObject);

                        game.bossHealth--;

                    }

                    if (game.bossHealth == 0) {
                        handler.removeObject(tempObject);
                        handler.removeObject(this);
                    }
                }
            }

            if (tempObject.getId() == IDs.sword){
                if(getBounds().intersects((tempObject.getBounds()))){
                    if (game.bossHealth > 0) {

                        handler.removeObject(tempObject);
                        if(hplossCD > 25) {
                            game.bossHealth--;
                            hplossCD = 0;
                        }

                    }
                    if (game.bossHealth == 0){
                        handler.removeObject(tempObject);
                        handler.removeObject(this);
                    }


                }
            }
        }


    }


    public void render(Graphics g) {
        //g.setColor(Color.pink);
        //g.fillRect(xpos + spacing,ypos,75,150);

        g.setColor(Color.green);
        g.fillRect(xpos, ypos - 40, game.bossHealth*10, 20);
        if (Yspeed < 0) {//up
    		g.drawImage(ani_up.getCurrentFrame(), xpos + spacing , ypos, null);
    		bosspos = up[0];
    	}else if (Yspeed > 0) {//down
    		g.drawImage(ani_down.getCurrentFrame(), xpos+ spacing, ypos, null);
    		bosspos = down[0];
    	}else if (Xspeed < 0 ) {//left
    		g.drawImage(ani_left.getCurrentFrame(), xpos+ spacing, ypos, null);
        	bosspos = left[0];
    	}else if (Xspeed > 0) {//right
    		g.drawImage(ani_right.getCurrentFrame(), xpos+ spacing, ypos, null);
    		bosspos = right[0];
    	}
    	if(Xspeed == 0 && Yspeed == 0) {
    		g.drawImage(bosspos, xpos, ypos, null);
		}



    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos + spacing, ypos, 75, 150);
    }

    public void start(){
        javax.swing.Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                currentShot++;
                currentSecond++;
            }
        });
        timer.start();
    }

    public void startCD(){
        javax.swing.Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                hplossCD++;
            }
        });
        timer.start();
    }

}
