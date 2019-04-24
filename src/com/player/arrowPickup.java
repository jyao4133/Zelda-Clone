package com.player;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.IDs;
/*
Pickup object for adding arrows to the player's arsenal
 */

public class arrowPickup extends Object{
	private BufferedImage [] boomerang;
	private Animation animation;
    public arrowPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        boomerang = new BufferedImage [5];
		boomerang[0] = ss.grabImage(5, 6, 75,75);
		boomerang[1] = ss.grabImage(6, 6, 75,75);
		boomerang[2] = ss.grabImage(7, 6, 75,75);
		boomerang[3] = ss.grabImage(5, 5, 75, 75);
		boomerang[4] = ss.grabImage(6, 5, 75, 75);
		animation = new Animation (200, boomerang);
    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,20,20);
    }
    public void tick() {
    	animation.tick();
    }
    public void render(Graphics g) {
       g.drawImage(animation.getCurrentFrame(), xpos - 20, ypos - 40, null);
    }
}
