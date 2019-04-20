package com.enemy;

import java.awt.*;
import com.control.*;
import com.player.*;
import com.player.Object;

import java.awt.image.BufferedImage;
import java.util.*;

public class Enemy extends Object{

    //First enemy
    /*
    This enemy is the first enemy the player will come across. It will have randomized
    movement and will remove 1 point of health when it collides with the player.
     */
    private Handler handler;
    
    private BufferedImage [] left, right;
    private Animation ani_left, ani_right;


    Game game;
    Random r = new Random();
    Random p = new Random();
    int score = 0;
    int chosen = 0;
    int rngGen = 0;
    int hp = 100;
    boolean hitX = true;
    boolean hitY = true;
    int maxSpeed = 2;

    public Enemy(int xpos, int ypos, IDs id, Handler handler, Game game, int xprev, int yprev, int initial, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.xprev = xprev;
        this.yprev = yprev;
        this.game = game;
        this.initial = initial;
        
        left = new BufferedImage [4];
		right = new BufferedImage [4];
		
		/////////////ANIMATIONS/////////////
        left[0] = ss.grabImage(1, 5, 60,60);
        left[1] = ss.grabImage(2, 5, 60,60);
        left[2] = ss.grabImage(3, 5, 60,60);
        left[3] = ss.grabImage(4, 5, 60,60);
        
        right[0] = ss.grabImage(1, 6, 60,60);
        right[1] = ss.grabImage(2, 6, 60,60);
        right[2] = ss.grabImage(3, 6, 60,60);
        right[3] = ss.grabImage(4, 6, 60,60);
		///////////////////////////////////////

        ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);
    	
    }

    public void tick() {

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
                    Xspeed = (r.nextInt(2*maxSpeed +1) - maxSpeed);
                    Yspeed = (r.nextInt(2*maxSpeed +1) - maxSpeed);
                }
            }
            if (tempObject.getId() == IDs.Arrow || tempObject.getId() == IDs.sword){
                if(getBounds().intersects((tempObject.getBounds()))){
                    if(tempObject.getId()== IDs.Arrow) {
                        handler.removeObject(tempObject);
                    }
                    handler.removeObject(this);
                    rngGen = p.nextInt(10);
                    if (rngGen < 2) {
                        handler.addObject(new heartPickup(xpos+20, ypos +20, IDs.heartPickup, ss));
                    }
                    else if (rngGen > 8){
                        handler.addObject(new arrowPickup(xpos + 20, ypos + 20, IDs.Pickup, ss));
                    }
                    else if(rngGen >= 2 && rngGen <= 8){
                        handler.addObject(new coinPickup(xpos + 20, ypos+20,IDs.coinPickup, ss));
                    }
                    if (Game.state == States.Game || Game.state == States.Load){
                        game.enemiesStage1--;
                    }
                }
            }

        /*    if (tempObject.getId() == IDs.sword){
                if(getBounds().intersects((tempObject.getBounds()))){

                    handler.removeObject(this);
                    rngGen = p.nextInt(10);
                    

                    if (rngGen < 2) {
                        handler.addObject(new heartPickup(xpos, ypos, IDs.heartPickup, ss));
                    }

                    else if (rngGen > 8){
                        handler.addObject(new arrowPickup(xpos, ypos, IDs.Pickup, ss));

                    }

                    if (Game.state == States.Game || Game.state == States.Load){
                        game.enemiesStage1--;
                    }
                }
            }*/
        }


    }


    public void render(Graphics g) {
    	//g.drawImage(bird, xpos, ypos, null);   	
    	
    	if (Xspeed < 0  ) {//left
        	g.drawImage(ani_left.getCurrentFrame(), xpos, ypos, null);
    	}
    	else if (Xspeed > 0) {//right
        	g.drawImage(ani_right.getCurrentFrame(), xpos, ypos, null);
    	}
    	else {
        	g.drawImage(left[0], xpos, ypos, null);
    	}
    	


    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos + 20,ypos + 18,40,40);
    }

    //collision with wall
    public Rectangle getXYBounds(){
        return new Rectangle (xpos , ypos , 50, 30);
    }


}
