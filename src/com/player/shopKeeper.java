package com.player;

import com.control.IDs;

import java.awt.*;
import java.awt.image.BufferedImage;
/*
A shop keeper object that the player can interact with
 */
public class shopKeeper extends Object {
	
	private BufferedImage [] keeper;
    private Animation animation;
    
    public shopKeeper(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        keeper = new BufferedImage [3];
        keeper[0] = ss.grabImage(1, 8, 75, 75);
        keeper[1] = ss.grabImage(2, 8, 75, 75);
        keeper[2] = ss.grabImage(3, 8, 75, 75);
        animation = new Animation (200, keeper);

    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,90,90);
    }
    public Rectangle getnpcBounds(){
        return new Rectangle (xpos + 45, ypos + 45, 45, 45);
    }

    public void tick() {
    	animation.tick();
    }

    public void render(Graphics g) {
    	g.drawImage(animation.getCurrentFrame(), xpos, ypos, null);
    }
}
