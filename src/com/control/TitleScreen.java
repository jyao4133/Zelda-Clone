package com.control;

import java.awt.*;

public class TitleScreen {
	
	public Rectangle singleplayer = new Rectangle(220,300,300,80);
	public Rectangle multiplayer = new Rectangle(220,400,300,80);
	public Rectangle options = new Rectangle(220,500,300,80);
	public Rectangle exit = new Rectangle(220,600,300,80);

	public void render (Graphics g) {
		
		Graphics2D g2d = (Graphics2D) g;
		
		
		Font font1 = new Font("Comic Sans MS", Font.PLAIN, 80);
		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Getting Teddy", 100, 200);
		
		Font font2 = new Font ("Comic Sans MS", Font.BOLD, 40);
		g.setFont(font2);
		g.drawString("Single Player", singleplayer.x + 22, singleplayer.y+50);
		g2d.draw(singleplayer);
		g.drawString("Double Player", multiplayer.x + 20, multiplayer.y+50);
		g2d.draw(multiplayer);
		g.drawString("Options", options.x + 75, options.y+50);
		g2d.draw(options);
		g.drawString("QUIT", exit.x + 90, exit.y+50);
		g2d.draw(exit);
		
	}
}
