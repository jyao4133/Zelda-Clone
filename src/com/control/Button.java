package com.control;

import java.awt.*;

public class Button extends Rectangle{
	
	private Font font, selectedFont;
	private Color color, selectedColor;
	private boolean selected;
	private String text;
	private int textX, textY;
	
	public Button(String text, int textX, int textY,Font font,  Color color) {
		this.text = text;
		this.textX = textX;
		this.textY = textY;
		this.font = font;
		//this.selectedFont = selectedFont;
		this.color = color;
		//this.selectedColor = selectedColor;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void render (Graphics g ) {
		//if(selected) {
		//	drawString(g, selectedFont, selectedColor, text, textX, textY);
		//}else {
			drawString(g, font, color, text, textX, textY);
		//}
		
	}
	
	public static void drawString(Graphics g, Font f, Color c, String text, int framex, int framey) {
		FontMetrics fm = g.getFontMetrics(f);
		int spacing_y = 60;
		int x = (framex - fm.stringWidth(text) / 2); // horizontal centre
		int y = ((framey - fm.getHeight()) / 2) + fm.getAscent() + spacing_y; // vertical centre
		g.setColor(c);
		g.setFont(f);
		g.drawString(text, x, y);
	}	
}