package com.player;

import com.control.IDs;

import java.awt.*;
import java.awt.image.BufferedImage;
/*
Pickup object to add a coin to the player's inventory
 */
public class coinPickup extends Object {
	private BufferedImage [] coin;
	private Animation animation;
    public coinPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        coin = new BufferedImage [6];
        coin[0] = ss.grabImage(8, 9, 75,75);
        coin[1] = ss.grabImage(9, 9, 75,75);
        coin[2] = ss.grabImage(10, 9, 75,75);
        coin[3] = ss.grabImage(10, 10, 75, 75);
        coin[4] = ss.grabImage(9, 10, 75, 75);
        coin[5] = ss.grabImage(8, 10, 75, 75);
 		animation = new Animation (200, coin);
    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,20,20);
    }
    public void tick() {
    	animation.tick();
    }
    public void render(Graphics g) {
    	g.drawImage(animation.getCurrentFrame(), xpos - 25, ypos - 35, null);
    }
}
