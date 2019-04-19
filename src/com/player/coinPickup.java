package com.player;

import com.control.IDs;

import java.awt.*;

public class coinPickup extends Object {

    public coinPickup(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,20,20);
    }


    public void tick() {

    }


    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect(xpos, ypos, 20, 20);
    }

}
