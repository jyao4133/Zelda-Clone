package com.control;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Story {
	Game game;
	private BufferedImage story_screen;
    ImageRender loader = new ImageRender();

	public Story() {
		story_screen = loader.loadImage("story.png");
	}

	public void render(Graphics g){
		g.drawImage(story_screen, 0, 0, null);
	}
}
