package com.control;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class Enemy extends Object{

    //First enemy
    /*
    This enemy is the first enemy the player will come across. It will have randomized
    movement and will remove 1 point of health when it collides with the player.
     */
    SpriteAnimation animation;

    private Handler handler;
    private BufferedImage [] bird = new BufferedImage [8];

    Game game;
    Random r = new Random();
    Random p = new Random();

    int chosen = 0;
    int rngGen = 0;
    int hp = 100;
    boolean hitX = true;
    boolean hitY = true;
    int maxSpeed = 0;

    public Enemy(int xpos, int ypos, IDs id, Handler handler, Game game, int xprev, int yprev, int initial, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.xprev = xprev;
        this.yprev = yprev;
        this.game = game;
        this.initial = initial;

        //left
        bird[0] = ss.grabImage(1, 5, 75,75);
        bird[1] = ss.grabImage(2, 5, 75,75);
        bird[2] = ss.grabImage(3, 5, 75,75);
        bird[3] = ss.grabImage(4, 5, 75,75);
        //right
        bird[4] = ss.grabImage(1, 6, 75,75);
        bird[5] = ss.grabImage(2, 6, 75,75);
        bird[6] = ss.grabImage(3, 6, 75,75);
        bird[7] = ss.grabImage(4, 6, 75,75);

    	for (int i = 0; i < bird.length; i++) {
			animation = new SpriteAnimation(1, bird[i]);
	        animation.runAnimation();
		}
    }

    public void tick() {

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

            if (tempObject.getId() == IDs.Arrow ){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
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
            }

            if (tempObject.getId() == IDs.sword){
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
            }
        }



    }


    public void render(Graphics g) {
    	//g.drawImage(bird, xpos, ypos, null);   	
    	
    	if (Xspeed <= 0  ) {//left
    		for (int i = 0; i < 4; i++) {
    			g.drawImage(bird[i], xpos, ypos, null); //down 0 to 3
    		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	if (Xspeed >= 0) {//right
    		for (int i = 4; i < 8; i++) {
        		g.drawImage(bird[i], xpos, ypos, null); //right 4 to 7
    		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	

    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,50,30);
    }

    //collision with wall
    public Rectangle getXYBounds(){
        return new Rectangle (xpos , ypos , 50, 30);
    }


}
