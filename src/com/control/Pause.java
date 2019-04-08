package com.control;

import java.awt.*;

public class Pause {


	public Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
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
		
		
		
				
		

	}
	
}
