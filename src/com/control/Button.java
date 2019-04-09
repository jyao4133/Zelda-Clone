package com.control;

import java.awt.*;

public class Button extends Rectangle{
	
	private Font font, selectedFont;
	private Color color, selectedColor;
	private boolean selected;
	private String text;
	private int textX, textY;
	
	public Button(String text, int textX, int textY,Font font,  Font selectedFont, Color color, Color selectedColor) {
		this.text = text;
		this.textX = textX;
		this.textY = textY;
		this.font = font;
		this.selectedFont = selectedFont;
		this.color = color;
		this.selectedColor = selectedColor;
	}


	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public void render (Graphics g ) {
		if(selected) {
			Fonts.drawString(g, selectedFont, selectedColor, text, textX, textY);
		}else {
			Fonts.drawString(g, font, color, text, textX, textY);
		}
		
	}
	
}
