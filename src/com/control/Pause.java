package com.control;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Pause {
	
	public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
	//private final String [] pausemenu = {"Resume", "Options", "Exit"};
	private int currentSelection;
	private final Button[] pausemenu;
	private int yshift = 250;
	private int yspacing = 150;
	
	
	
	//public Button(String text, int textX, int textY,Font font,  Font selectedFont, Color color, Color selectedColor)
	public Pause() {
		pausemenu = new Button[3];
		pausemenu[0] = new Button ("Resume", pauseframe.width, pauseframe.height + yshift + 0 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
		pausemenu[1] = new Button ("Options", pauseframe.width, pauseframe.height + yshift + 1 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
		pausemenu[2] = new Button ("Exit", pauseframe.width, pauseframe.height + yshift + 2 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
	}
		
	
	public void render (Graphics g) {
		g.setColor(Color.WHITE);
    	g.fillRect(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
    	    	    	Fonts.drawString(g, new Font("Arial", Font.BOLD, 80), Color.orange, "Pause", pauseframe.width, pauseframe.height);

    	for (int i = 0; i < pausemenu.length; i++) {
    		/*if (i == currentSelection) {
    	    	Fonts.drawString(g, new Font("Arial", Font.BOLD, 50), Color.red, pausemenu[i], pauseframe.width, pauseframe.height + yshift + i * yspacing);
    		}else {
    	    	Fonts.drawString(g, new Font("Arial", Font.PLAIN, 42), Color.black, pausemenu[i], pauseframe.width, pauseframe.height + yshift + i *yspacing);
    		}*/
    		if (i == currentSelection) {
    			pausemenu[i].setSelected(true);
    		}
    		else {
    			pausemenu[i].setSelected(false);
    		}
    		pausemenu[i].render(g);
    	}
    	
	}
	
	
	
	

	/*public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
	public Rectangle resume = new Rectangle(390, 390, 240, 50);
	public Rectangle options = new Rectangle(390,480,240,50);
	public Rectangle exit = new Rectangle(390,570,240,50);

	
	public void render(Graphics g) {
		
		Graphics2D pauseframeg = (Graphics2D) g;
		Font pausef = new Font ("Arial", Font.BOLD, 70);
		pauseframeg.setColor(Color.WHITE);
		pauseframeg.fill(pauseframe);
		g.setFont(pausef);
		g.setColor(Color.black);
		g.drawString("Paused", (pauseframe.width/4)+pauseframe.x, pauseframe.y + 80);
		
		Graphics2D buttong = (Graphics2D) g;
		Font buttonf = new Font ("Comic Sans MS", Font.BOLD, 40);
		g.setFont(buttonf);
		g.drawString("Resume", resume.x + 50, resume.y + 40 );
		buttong.draw(resume);
		
		g.drawString("Options", options.x + 50, options.y + 40 );
		buttong.draw(options);
		
		g.drawString("Exit", exit.x + 70, exit.y + 40 );
		buttong.draw(exit);

	}*/
	
}
