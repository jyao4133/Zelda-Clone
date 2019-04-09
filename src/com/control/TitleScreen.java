package com.control;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class TitleScreen extends Canvas{
	
	/**
	 * 
	 */
	
	public static Rectangle titleframe = new Rectangle (0, 0, Game.WIDTH, Game.HEIGHT);
	private BufferedImage image;

	/*private final Button [] mainscreen;
	private int currentSelection;

	
	private int yshift = -150;
	private int yspacing = 200;
	private int xshift = -600;
	public Rectangle singleplayer = new Rectangle(150,300,300,80);
	public Rectangle multiplayer = new Rectangle(150,400,300,80);
	public Rectangle options = new Rectangle(150,500,300,80);
	public Rectangle exit = new Rectangle(150,600,300,80);
	private BufferedImage image;*/
		
	//private ImageIcon title;
	//private JLabel background;
	//public Button(String text, int textX, int textY,Font font,  Font selectedFont, Color color, Color selectedColor)

	/*public TitleScreen() {
		mainscreen = new Button[4];
		mainscreen[0] = new Button ("Single Player", titleframe.width + xshift, titleframe.height + yshift + 0 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
		mainscreen[1] = new Button ("Multi Player", titleframe.width + xshift, titleframe.height + yshift + 1 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
		mainscreen[2] = new Button ("Options", titleframe.width + xshift, titleframe.height + yshift + 2 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
		mainscreen[3] = new Button ("Exit", titleframe.width + xshift, titleframe.height + yshift + 2 * yspacing, new Font("Arial", Font.PLAIN, 42),
				new Font("Arial", Font.BOLD, 50), Color.black, Color.red);
	}
	 */
	
	public void render (Graphics g)  {
		/////////////////////////////////////////////////////////////////////////////
		try{
			image = ImageIO.read(getClass().getResourceAsStream("title_screen.png")); 

		} catch(IOException e){
			e.printStackTrace();
		}
		g.drawImage(image,0,0,null);
		
		/////////////////////////////////////////////////////////////////////////////
		
		/*for (int i = 0; i < mainscreen.length; i++) {
			if (i == currentSelection) {
				mainscreen[i].setSelected(true);
    		}
    		else {
    			mainscreen[i].setSelected(false);
    		}
			mainscreen[i].render(g);
    	}*/
		}
		
		
		/*Graphics2D g2d = (Graphics2D) g;		
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
		g2d.draw(exit);*/
		
	//https://i.pinimg.com/236x/16/2c/a2/162ca2c3f90a3311175d6448f52d18b8.jpg

}
