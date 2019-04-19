package com.control;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.player.Object;
import com.player.SpriteSheet;


public class Block extends Object {

    public Block(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }

    public void tick() {

    }

    public void render(Graphics g) {
    //	g.setColor(Color.yellow);
     // g.fillRect(xpos, ypos, 30, 30);

    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,32,32);
    }

}
