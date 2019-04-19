package com.player;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.IDs;

public class heartPickup extends Object{
	private BufferedImage [] heart;
	private Animation animation;
	
    public heartPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        heart = new BufferedImage [5];
        heart[0] = ss.grabImage(5, 6, 75,75);
        heart[1] = ss.grabImage(6, 6, 75,75);
        heart[2] = ss.grabImage(7, 6, 75,75);
        heart[3] = ss.grabImage(5, 5, 75, 75);
        heart[4] = ss.grabImage(6, 5, 75, 75);

      	animation = new Animation (200, heart);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,20,20);
    }


    public void tick() {
    	animation.tick();
    }


    public void render(Graphics g) {

//        g.setColor(Color.yellow);
//        g.fillRect(xpos, ypos, 20, 20);
    	g.drawImage(animation.getCurrentFrame(), xpos - 20, ypos - 40, null);


    }
}