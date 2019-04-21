package com.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class Option_credits {
	Game game;
    private BufferedImage credits;
    ImageRender loader = new ImageRender();
    
	public Option_credits() {
		credits = loader.loadImage("credit.png");
	}
	
	public void render(Graphics g) {
    	g.drawImage(credits, 500, 190, null);
	}
}
