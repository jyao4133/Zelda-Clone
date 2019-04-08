package com.control;

import java.awt.*;

public class Enemy extends Object{


    public Enemy(int xpos, int ypos, IDs id) {
        super(xpos, ypos, id);
    }

    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;


    }


    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(xpos, ypos, 16, 16);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,16,16);
    }

}
