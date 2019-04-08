package com.control;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TitleScreen extends JPanel{
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public Rectangle singleplayer = new Rectangle(220,300,300,80);
	public Rectangle multiplayer = new Rectangle(220,400,300,80);
	public Rectangle options = new Rectangle(220,500,300,80);
	public Rectangle exit = new Rectangle(220,600,300,80);
	private BufferedImage image;
		
	//private ImageIcon title;
	//private JLabel background;
	
	 
	
	public void render (Graphics g)  {

		try{
			image = ImageIO.read(getClass().getResourceAsStream("title_screen.png"));

		} catch(IOException e){
			e.printStackTrace();
		}
		
		
		
		Graphics2D g2d = (Graphics2D) g;		
		g.drawImage(image,0,0,null);
		Font font1 = new Font("Comic Sans MS", Font.PLAIN, 80);
		g.setFont(font1);
		g.setColor(Color.black);
		g.drawString("Getting Teddy", 100, 200);

		Font font2 = new Font ("Comic Sans MS", Font.BOLD, 40);
		g.setFont(font2);
		g.drawString("Single Player", singleplayer.x + 22, singleplayer.y+50);
		g2d.draw(singleplayer);
		g.drawString("Multiplayer", multiplayer.x + 40, multiplayer.y+50);
		g2d.draw(multiplayer);
		g.drawString("Options", options.x + 75, options.y+50);
		g2d.draw(options);
		g.drawString("Exit", exit.x + 110, exit.y+50);
		g2d.draw(exit);
		
	}

}
