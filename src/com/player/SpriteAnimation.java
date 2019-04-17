package com.player;

import java.awt.Graphics;
import java.awt.image.BufferedImage;


public class SpriteAnimation {
	
	private int speed;
	private int frames;
	private int index = 0;
	private int count = 0;
	
	private BufferedImage[] images;	
	private BufferedImage currentImage;

	public SpriteAnimation(int speed, BufferedImage...sprites) {
		this.speed = speed;
		images = new BufferedImage[sprites.length];
		
		for(int i=0;i<sprites.length;i++){
			images[i] = sprites[i];
		}
		frames = sprites.length;
	}
	
	
	public void runAnimation(){
		index++;
		if(index > speed){
			index = 0;
			nextFrame();
		}	
	}
	
	public void nextFrame(){
		for(int i=0;i<frames;i++){
			// Which frame do we have currently on
			if(count == i) {
				currentImage = images[i];
		
			}
		}
		count++;
		if(count > frames)
			count = 0;
	}
	
	public void drawAnimation(Graphics g, double x, double y, int offset){
		g.drawImage(currentImage, (int)x - offset, (int)y, null);
	}
	
	public void setCount(int count){
		this.count = count;
	}
	public int getCount(){
		return count;
	}
	public int getSpeed(){
		return speed;
	}
	public void setSpeed(int speed){
		this.speed = speed;
	}
	
	
	
	
}