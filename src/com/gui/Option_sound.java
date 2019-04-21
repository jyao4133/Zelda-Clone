package com.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class Option_sound {
	
	Game game;
    private BufferedImage sound;
    ImageRender loader = new ImageRender();
    
	public Option_sound() {
    	sound = loader.loadImage("sound.png");
	}
	
	public void render(Graphics g) {
    	g.drawImage(sound, 500, 190, null);
	}
}
