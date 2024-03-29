package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;


import com.control.Game;
/*
Displays the pause menu when p is pressed while in game

 */
public class Pause {
	
	public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
	
	private int currentSelection;
	private final Button[] pausemenu;
	private int yshift = 250;
	private int yspacing = 150;
	
	
	public Pause() {
		pausemenu = new Button[3];
		pausemenu[0] = new Button ("Resume", pauseframe.width, pauseframe.height + yshift + 0 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.gray);
		pausemenu[1] = new Button ("Help", pauseframe.width, pauseframe.height + yshift + 1 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.gray);
		pausemenu[2] = new Button ("Return to Main", pauseframe.width, pauseframe.height + yshift + 2 * yspacing,
				new Font("Arial", Font.BOLD, 50), Color.gray);
	}
		
	
	public void render (Graphics g) {
		g.setColor(Color.white);
    	g.fillRect(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
    	    	    	Button.drawString(g, new Font("Arial", Font.BOLD, 80), Color.black, "Pause", pauseframe.width, pauseframe.height);

    	for (int i = 0; i < pausemenu.length; i++) {
    		pausemenu[i].render(g);
    	}
	}
	
}
