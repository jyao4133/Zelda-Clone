package com.control;

import java.awt.*;


public class Options extends Canvas  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Rectangle back = new Rectangle(800,50,150,80);
	


	public void render (Graphics g)  {

		Graphics2D g2d = (Graphics2D) g;
		Font font1 = new Font("Comic Sans MS", Font.PLAIN, 50);
		g.setFont(font1);
		g.setColor(Color.BLACK);
		g.drawString("back", back.x+20, back.y+55);
		g2d.draw(back);
		//You can delete the above code. I was just using it to test the error.
		
		
	}
}
