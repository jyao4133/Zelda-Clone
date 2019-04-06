package com.control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class MouseHandler implements MouseListener {
	
	public void mouseClicked(MouseEvent e) {
		
	}
	
	public void mouseEntered(MouseEvent e) {
	
	}

	public void mouseExited(MouseEvent e) {
		
	}

	public void mousePressed(MouseEvent e) {
		
		int x = e.getX();
		int y = e.getY();
		if (Game.state == States.TitleScreen) {
		//To start the game in single player
			if (x >= 220 && x <= 520 && y >= 300 && y <= 380) {
				Game.state = States.Game;
				System.out.println("Single Player");
			}
		
		//To start the game in multiplayer
			if (x >= 220 && y <= 520 && y >= 400 && y <= 480) {
				System.out.println("Multi Player");

			}

		//To exit the game
			if (x >= 220 && x <= 520 && y >= 500 && y <= 580) {
				System.out.println("Option");

			}
		
		
		//To exit the game
			if (x >= 220 && x <= 520 && y >= 600 && y <= 680) {
				System.exit(1);
			}
		}
	}
 
	public void mouseReleased(MouseEvent e) {
		
	}

}
