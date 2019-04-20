package com.player;

import com.control.IDs;

import java.awt.*;
import java.awt.image.BufferedImage;

public class shopKeeper extends Object {

    public shopKeeper(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);

    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,90,90);
    }
    public Rectangle getnpcBounds(){
        return new Rectangle (xpos + 45, ypos + 45, 45, 45);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.orange);
        g.fillRect(xpos,ypos,90,90);
    }

}
