package com.gui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class Option_control {
	Game game;
    private BufferedImage control;
    ImageRender loader = new ImageRender();
    
	public Option_control() {
    	control = loader.loadImage("controls.png");
	}
	
	public void render(Graphics g) {
    	g.drawImage(control, 500, 190, null);
	}
}
