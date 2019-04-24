package com.level;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;
/*
The second stage of the game.
 */
public class level2 {

    Game game;
    private BufferedImage kitchen;
    ImageRender loader = new ImageRender();
    
    public level2 () {
    	kitchen = loader.loadImage("Kitchen.png");
    }

    public void render(Graphics g){
    	g.drawImage(kitchen, 0, 170, null);
        g.setColor(Color.black);
        g.fillRect(0, 0,1040, 170);
    }
}

