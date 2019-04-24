package com.gui;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.control.Game;

@SuppressWarnings("serial")
public class TitleScreen extends Canvas{

	public static Rectangle titleframe = new Rectangle (0, 0, Game.WIDTH, Game.HEIGHT);
	private BufferedImage image;
	
	
	public void render (Graphics g)  {
		try{
			image = ImageIO.read(getClass().getResourceAsStream("title_screen.png")); 

		} catch(IOException e){
			e.printStackTrace();
		}
		g.drawImage(image,0,0,null);
	}		
	//https://i.pinimg.com/236x/16/2c/a2/162ca2c3f90a3311175d6448f52d18b8.jpg

}
