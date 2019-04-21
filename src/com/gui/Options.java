package com.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.control.Game;
import com.control.ImageRender;
import com.control.States;


public class Options {
	public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);
	public Rectangle textframe = new Rectangle (500, 190, 450, 650);
	private BufferedImage image;

	public final Button[] optionmenu;
	private int yshift = 100;
	private int yspacing = 370;

	
	
	public Options() {
		optionmenu = new Button [4];
		Font font = new Font("Arial", Font.BOLD, 50);
		optionmenu[0] = new Button ("Sound", optionsframe.width / 4, optionsframe.height / 4 + yshift + 0 * yspacing, font, Color.black );
		optionmenu[1] = new Button ("Controls", optionsframe.width / 4, optionsframe.height / 4+ yshift + 1 * yspacing, font, Color.black );
		optionmenu[2] = new Button ("Credits", optionsframe.width / 4, optionsframe.height / 4 + yshift + 2 * yspacing, font, Color.black );
		optionmenu[3] = new Button ("Back", (optionsframe.width / 4) - 10, (optionsframe.height / 4 + yshift + 3 * yspacing)- 10, font, Color.black );
	}
	

	public void render (Graphics g)  {

		/////////////////////////////////////////////////////////////////////////////
		try{
			image = ImageIO.read(getClass().getResourceAsStream("OptionsMenu.png")); 

		} catch(IOException e){
			e.printStackTrace();
		}
		g.drawImage(image,0,0,null);
		/////////////////////////////////////////////////////////////////////////////
		for (int i = 0; i < optionmenu.length; i++) {
    		optionmenu[i].render(g);
    	}
		
		Font text = new Font ("Comic Sans MS", Font.BOLD, 70);
		g.setColor(Color.black);
		g.setFont(text);
		g.drawString("Options", 130, 100);
	}


}
