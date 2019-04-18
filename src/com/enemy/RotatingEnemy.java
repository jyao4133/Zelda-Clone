package com.enemy;

import java.awt.*;
import com.control.*;
import com.player.Animation;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteAnimation;
import com.player.SpriteSheet;
import com.player.arrowPickup;
import com.player.heartPickup;

import java.awt.image.BufferedImage;
import java.util.*;

public class RotatingEnemy extends Object{

    //First enemy
    /*
    This enemy is the first enemy the player will come across. It will have randomized
    movement and will remove 1 point of health when it collides with the player.
     */
    private Handler handler;
    Game game;
    int angle;
    
    public RotatingEnemy(int xpos, int ypos, IDs id, Handler handler, Game game, int initial, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;
        
        this.initial = initial;

    	
    }

    public void tick() {
  
    
    }

    public void render(Graphics g) {
    	//g.drawImage(bird, xpos, ypos, null);   	
    	g.setColor(Color.black);
        g.fillRect(xpos,ypos,25,25);


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
