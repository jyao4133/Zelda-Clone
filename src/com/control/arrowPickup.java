package com.control;

import java.awt.*;

public class arrowPickup extends Object{

    public arrowPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,16,16);
    }


    public void tick() {

    }


    public void render(Graphics g) {
        g.setColor(Color.cyan);
        g.fillRect(xpos, ypos, 16, 16);
    }
}
