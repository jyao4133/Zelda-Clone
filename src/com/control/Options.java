package com.control;

import java.awt.*;


public class Options extends Canvas  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Rectangle test = new Rectangle(220,300,300,80);
	


	public void render (Graphics g)  {

		Graphics2D g2d = (Graphics2D) g;
		
		
		g2d.draw(test);
		
		
		
		
	}
}
