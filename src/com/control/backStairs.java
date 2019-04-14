package com.control;

import java.awt.*;
import java.awt.image.BufferedImage;

public class backStairs extends Object{

    Handler handler;
    Game game;
    private BufferedImage backstairs;


    public backStairs(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);

       // this.handler = handler;
       // this.game = game;
        backstairs = ss.grabImage(1, 7, 75, 75);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,8,8);
    }


    public void tick() {

    }

    public void render(Graphics g) {
       // g.setColor(Color.magenta);
     //   g.fillRect(xpos, ypos, 32, 32);
		g.drawImage(backstairs, xpos, ypos-40, null);

    }
}
