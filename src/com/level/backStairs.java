package com.level;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.IDs;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

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
        return new Rectangle (xpos, ypos, 60, 100);
    }


    public void tick() {

    }

    public void render(Graphics g) {
       // g.setColor(Color.magenta);
       // g.fillRect(xpos, ypos - 40, 75, 75);
		//g.drawImage(backstairs, xpos, ypos-40, null);

    }
}
