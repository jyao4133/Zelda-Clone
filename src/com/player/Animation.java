package com.player;
//https://www.youtube.com/watch?v=uitt3vk-Xkk&list=PLah6faXAgguMnTBs3JnEJY0shAc18XYQZ&index=25
import java.awt.image.BufferedImage;
/*
Animation class which handles the animations in the game
 */
public class Animation {
	private int speed, index;
	private BufferedImage[] frames;
	private long lastTime, timer;
	
	public Animation (int speed, BufferedImage[] frames) {
		this.speed = speed;
		this.frames = frames;
		index = 0;
		lastTime = System.currentTimeMillis();
		timer = 0;
	}
	
	public void tick () {
		timer += System.currentTimeMillis() - lastTime;
		lastTime = System.currentTimeMillis();
		
		if (timer > speed) {
			index++;
			timer = 0;
			if (index >= frames.length) {
				index = 0;
			}
		}
	}
	
	public BufferedImage getCurrentFrame() {
		return frames[index];
	}
	
	
}
