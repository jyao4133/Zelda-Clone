package com.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.control.Audio;
import com.control.IDs;

public class doorKey extends Object {
	private BufferedImage [] key;
	private Animation animation;
	private Audio doorkey;	
    public doorKey(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        key = new BufferedImage [2];
        key[0] = ss.grabImage(1,7, 75,75);
        key[1] = ss.grabImage(2, 7, 75,75);
		animation = new Animation (200, key);
		doorkey = new Audio ("key_drop.wav");
		doorkey.play();
    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,20,30);
    }
    public void tick() {
    	animation.tick();
    }
    public void render(Graphics g) {
        g.drawImage(animation.getCurrentFrame(), xpos - 25, ypos - 30, null);
    }

}
