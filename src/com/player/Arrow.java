package com.player;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.math.*;

import com.control.IDs;
/*
Boomerang that the player will fire with right click
The speed is dictated by a trigonometric formula
 */
public class Arrow extends Object {

    private Handler handler;
    private BufferedImage [] boomerang;
    private Animation animation;

    public Arrow(int xpos, int ypos, IDs id, Handler handler, int x, int y, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
		boomerang = new BufferedImage [3];
		boomerang[0] = ss.grabImage(5, 5, 75,75);
		boomerang[1] = ss.grabImage(6, 5, 75,75);
		boomerang[2] = ss.grabImage(7, 5, 75,75);
		animation = new Animation (100, boomerang);

        double distance = Math.sqrt(Math.pow((x - xpos),2) + Math.pow((y - ypos),2));
        double speed = 10;


        Xspeed = (int) ((x - xpos)*speed/distance);
        Yspeed = (int) ((y - ypos)*speed/distance);

    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 8, 8);
    }



    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;
        animation.tick();
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.Block) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                    handler.removeObject(this);
                }
            }
        }
    }

    public void render(Graphics g) {
    	g.drawImage(animation.getCurrentFrame(), xpos - 20, ypos - 40, null);

       // g.setColor(Color.yellow);
      //  g.fillOval(xpos,ypos,8,8);
    }
}
