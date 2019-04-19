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
    public Stairs(int xpos, int ypos, IDs id, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
    }
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,60,60);
    }
    public void tick() {
    }
    public void render(Graphics g) {
    }
}
