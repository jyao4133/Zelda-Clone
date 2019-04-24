package com.control;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.player.Object;
import com.player.SpriteSheet;
/*
Every block that the player runs into will be a "Block" object created by this class
This class creates a block with the ID block.
 */

public class Block extends Object {

    public Block(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }

    public void tick() {

    }

    public void render(Graphics g) {
   // 	g.setColor(Color.yellow);
  //  	g.fillRect(xpos, ypos, 30, 30);

    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,32,32);
    }

}
