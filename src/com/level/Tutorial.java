package com.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class Tutorial {

	Game game;
	private BufferedImage tutorial_screen;
    ImageRender loader = new ImageRender();

	public Tutorial() {
		tutorial_screen = loader.loadImage("tutorial_map.png");
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 1024, 990);
		g.drawImage(tutorial_screen, 0, 0, null);
	}
}
