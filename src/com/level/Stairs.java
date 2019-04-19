package com.level;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.IDs;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

public class Stairs extends Object{

    Handler handler;
    Game game;
    private BufferedImage stairs;


    public Stairs(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);

       // this.handler = handler;
        //this.game = game;
        stairs = ss.grabImage(2, 7, 75, 75);
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,60,60);
    }


    public void tick() {

    }

    public void render(Graphics g) {
       // g.setColor(Color.magenta);
       // g.fillRect(xpos, ypos, 75, 75);
	//	g.drawImage(stairs, xpos, ypos-4, null);

    }
}
