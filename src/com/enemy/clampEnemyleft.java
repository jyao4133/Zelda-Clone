package com.enemy;
//https://www.deviantart.com/zeka10000/art/WonderBolts-sprites-680138765
import javax.swing.*;

import com.control.Audio;
import com.control.Game;
import com.control.IDs;
import com.control.States;
import com.player.*;
import com.player.Object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;
/*
Enemy that moves left into other objects. When colliding with another clamp enemy, it will bounce off
When colliding with a wall, it will bounce off.
 */
public class clampEnemyleft extends Object {

    Game game;
    private String shootDirection;
    private int currentSecond = 0;
    private Handler handler;
    private BufferedImage [] left, right;
    private Animation ani_left, ani_right;
    private Audio enemy_hit;
    private int rngGen = 0;
    Random p = new Random();

    public clampEnemyleft(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.id = id;
        Xspeed = -4;
        this.game = game;

        left = new BufferedImage [3];
		right = new BufferedImage [3];
		
        left[0] = ss.grabImage(5, 9, 75,75);
		left[1] = ss.grabImage(6, 9, 75,75);
		left[2] = ss.grabImage(7, 9, 75,75);
		
		right[0] = ss.grabImage(5, 10, 75,75);
		right[1] = ss.grabImage(6, 10, 75,75);
		right[2] = ss.grabImage(7, 10, 75,75);
		
		ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);	
		
		
		////////////SOUND EFFECTS///////////////
		enemy_hit = new Audio ("enemy_hit.wav");
		///////////////////////////////////////
    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 75, 75);
    }

    public void tick() {
    	ani_left.tick();
    	ani_right.tick();
    	
        ypos += Yspeed;
        xpos += Xspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects(tempObject.getBounds())) {
                	enemy_hit.play();
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
                    if (Game.state == States.level3){
                        if (game.clampsStage3 > 0) {
                            game.clampsStage3--;
                        }
                    }

                }
            }

            if (tempObject.getId() == IDs.clampright) {
                if (this.getBounds().intersects(tempObject.getBounds())) {
                    Xspeed = 4;

                }
            }

            if (tempObject.getId() == IDs.Block) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    xpos += Xspeed * -1;
                    ypos += Yspeed * -1;
                    if (Xspeed == -4) {
                        Xspeed = 4;
                    }

                    else if (Xspeed == 4){
                        Xspeed = -4;
                    }
                }
            }
        }


    }




    public void render(Graphics g) {

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

    public void start(){
        Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {

                currentSecond++;
            }
        });
        timer.start();
    }
}
