package com.control;
/*This a utility for font*/
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;

public class Fonts {

	
	
	public static void drawString(Graphics g, Font f, Color c, String text, int framex, int framey) {
		FontMetrics fm = g.getFontMetrics(f);
		int spacing_y = 60;
		int x = (framex - fm.stringWidth(text) / 2); // horizontal centre
		int y = ((framey - fm.getHeight()) / 2) + fm.getAscent() + spacing_y; // vertical centre
		g.setColor(c);
		g.setFont(f);
		g.drawString(text, x, y);
	}

	/*public static void drawString(Graphics g, Font f, Color c, String text) {
		FontMetrics fm = g.getFontMetrics(f);
		int x = (Game.WIDTH - fm.stringWidth(text) / 2); // horizontal centre
		int y = ((Game.WIDTH - fm.getHeight()) / 2) + fm.getAscent(); // vertical centre
		drawString(g, f, c, text, x, y);
	}

	public static void drawString(Graphics g, Font f, Color c, String text, double x) {
		FontMetrics fm = g.getFontMetrics(f);
		int y = ((Game.WIDTH - fm.getHeight()) / 2) + fm.getAscent(); // vertical centre
		drawString(g, f, c, text, (int) x, y);
	}

	public static void drawString(Graphics g, Font f, Color c, String text, int y) {
		FontMetrics fm = g.getFontMetrics(f);
		int x = (Game.WIDTH - fm.stringWidth(text) / 2); // horizontal centre
		drawString(g, f, c, text, x, y);
	}*/

}
