package com.control;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Block extends Object {

    public Block(int xpos, int ypos, IDs id) {
        super(xpos, ypos, id);
    }

    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect(xpos, ypos, 34, 32);

    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,32,32);
    }

}
