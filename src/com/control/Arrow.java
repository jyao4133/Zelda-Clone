package com.control;

import java.awt.*;
import java.math.*;

public class Arrow extends Object {

    private Handler handler;


    public Arrow(int xpos, int ypos, IDs id, Handler handler, int x, int y, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        this.handler = handler;


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
        g.setColor(Color.yellow);
        g.fillOval(xpos,ypos,8,8);
    }
}
