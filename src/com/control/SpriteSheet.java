package com.control;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage image; 
	
	public SpriteSheet (BufferedImage image) {
		this.image = image;
	}
	
	public BufferedImage grabImage (int col, int row, int width, int height) {
		return image.getSubimage((col*48)-48, (row*48) - 48, width, height);
	}
	
	
}
