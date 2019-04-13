package com.control;

import java.awt.*;

public class Stairs extends Object{

    Handler handler;
    Game game;


    public Stairs(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);

        this.handler = handler;
        this.game = game;
    }

    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,8,8);
    }


    public void tick() {

    }

    public void render(Graphics g) {
        g.setColor(Color.magenta);
        g.fillRect(xpos, ypos, 32, 32);
    }
}
