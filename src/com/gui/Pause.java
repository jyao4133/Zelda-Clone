package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.control.Game;

public class Pause {
	
	public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
	
	private int currentSelection;
	private final Button[] pausemenu;
	private int yshift = 250;
	private int yspacing = 150;
	
	
	
	public Pause() {
		pausemenu = new Button[3];
		pausemenu[0] = new Button ("Resume", pauseframe.width, pauseframe.height + yshift + 0 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.black);
		pausemenu[1] = new Button ("Help", pauseframe.width, pauseframe.height + yshift + 1 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.black);
		pausemenu[2] = new Button ("Exit", pauseframe.width, pauseframe.height + yshift + 2 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.black);
	}
		
	
	public void render (Graphics g) {
		
		g.setColor(Color.WHITE);
    	g.fillRect(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
    	    	    	Button.drawString(g, new Font("Arial", Font.BOLD, 80), Color.orange, "Pause", pauseframe.width, pauseframe.height);

    	for (int i = 0; i < pausemenu.length; i++) {
    		if (i == currentSelection) {
    			pausemenu[i].setSelected(true);
    		}
    		else {
    			pausemenu[i].setSelected(false);
    		}
    		pausemenu[i].render(g);
    	}
    	
	}


	
}
