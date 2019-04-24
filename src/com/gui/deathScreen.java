package com.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;


public class deathScreen {
	Game game;
    private BufferedImage deathscreen;
    ImageRender loader = new ImageRender();
    public deathScreen() {
       deathscreen = loader.loadImage("deathscreen.png");
    }


    public void render (Graphics g)  {
    	g.drawImage(deathscreen, 0, 0, null);
    	
    }

}
