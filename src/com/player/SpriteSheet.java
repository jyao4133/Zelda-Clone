package com.player;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage image; 
	
	public SpriteSheet (BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage (int col, int row, int width, int height) {


		return image.getSubimage((col*75)-75, (row*75) - 75, width, height);
	}	
	
}
