package com.control;

import java.awt.*;


public class Options  {
	
	public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);
	private int currentSelection;

	private final Button[] optionmenu;
	private int yshift = 100;
	private int yspacing = 300;
	
	
	public Options() {
		optionmenu = new Button [4];
		Font font = new Font("Arial", Font.BOLD, 60);
		optionmenu[0] = new Button ("Sound", optionsframe.width / 4, optionsframe.height / 4 + yshift + 0 * yspacing, font, Color.black );
		optionmenu[1] = new Button ("Controls", optionsframe.width / 4, optionsframe.height / 4+ yshift + 1 * yspacing, font, Color.black );
		optionmenu[2] = new Button ("Credits", optionsframe.width / 4, optionsframe.height / 4 + yshift + 2 * yspacing, font, Color.black );
		optionmenu[3] = new Button ("Back", optionsframe.width / 4, optionsframe.height / 4 + yshift + 3 * yspacing, font, Color.black );
	}
	

	public void render (Graphics g)  {

	
		
		for (int i = 0; i < optionmenu.length; i++) {
    		if (i == currentSelection) {
    			optionmenu[i].setSelected(true);
    		}
    		else {
    			optionmenu[i].setSelected(false);
    		}
    		optionmenu[i].render(g);
    	}
	}
}
