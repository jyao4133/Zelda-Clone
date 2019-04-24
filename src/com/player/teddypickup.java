package com.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.control.IDs;

public class teddypickup extends Object{
	private BufferedImage [] teddy;
	private Animation animation;
	public teddypickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
		super(xpos, ypos, id, ss);
		teddy = new BufferedImage [4];
		teddy[0] = ss.grabImage(1, 13, 75,75);
		teddy[1] = ss.grabImage(2, 13, 75,75);
		teddy[2] = ss.grabImage(3, 13, 75,75);
		teddy[3] = ss.grabImage(4, 13, 75, 75);
		
      	animation = new Animation (200, teddy);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
        return new Rectangle (xpos,ypos,20,20);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
    	animation.tick();

	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
    	g.drawImage(animation.getCurrentFrame(), xpos - 30, ypos - 30, null);

	}

}
