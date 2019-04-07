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
		Font font1 = new Font("Comic Sans MS", Font.PLAIN, 80);
		g.setFont(font1);
		g.setColor(Color.white);
		g.drawString("Getting Teddy", 100, 200);

		Font font2 = new Font ("Comic Sans MS", Font.BOLD, 40);
		g.setFont(font2);


		//You can delete the above code. I was just using it to test the error.
		
		
	}
}
