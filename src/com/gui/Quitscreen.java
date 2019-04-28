package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;

import com.control.Game;

public class Quitscreen {
public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
	
	private final Button[] quitmenu;
	private int yshift = 280;
	private int yspacing = 220;	
	
	public Quitscreen() {
		quitmenu = new Button[2];
		quitmenu[0] = new Button ("Yes", pauseframe.width, pauseframe.height + yshift + 0 * yspacing,
				new Font("Arial", Font.BOLD, 60), Color.gray);
		quitmenu[1] = new Button ("No", pauseframe.width, pauseframe.height + yshift + 1 * yspacing,
				new Font("Arial", Font.BOLD, 60), Color.gray);
	}
		
	
	public void render (Graphics g) {
		g.setColor(Color.white);
    	g.fillRect(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
    	Button.drawString(g, new Font("Arial", Font.BOLD, 70), Color.black, "Exit Game", pauseframe.width, pauseframe.height + 20);

    	for (int i = 0; i < quitmenu.length; i++) {
    		quitmenu[i].render(g);
    	}
	}
}
