package com.player;

import java.awt.*;

import com.control.IDs;

public class heartPickup extends Object{

    public heartPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,16,16);
    }


    public void tick() {

    }


    public void render(Graphics g) {

        g.setColor(Color.yellow);
        g.fillRect(xpos, ypos, 16, 16);

    }
}