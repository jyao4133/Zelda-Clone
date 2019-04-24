package com.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class winscreen {
	Game game;
    private BufferedImage winscreen;
    ImageRender loader = new ImageRender();
    public winscreen() {
    	winscreen = loader.loadImage("winscreen.png");
    }


    public void render (Graphics g)  {
    	g.drawImage(winscreen, 0, 0, null);
    	
    }
}
