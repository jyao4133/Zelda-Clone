package com.control;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
	
	public Rectangle singleplayer = new Rectangle(220,300,300,80);
	public Rectangle multiplayer = new Rectangle(220,400,300,80);
	public Rectangle options = new Rectangle(220,500,300,80);
	public Rectangle exit = new Rectangle(220,600,300,80);
	private Handler handler;

     public MouseHandler (Handler handler){
         this.handler = handler;
     }
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
			if (x >= 220 && x <= 520 && y >= 400 && y <= 480) {
				System.out.println("Multi Player");

			}
		//Option Menu for the game
			if (x >= 220 && x <= 520 && y >= 500 && y <= 580) {
				Game.state = States.Options;
				System.out.println("Option");

			}
		//To exit the game
			if (x >= 220 && x <= 520 && y >= 600 && y <= 680) {
				System.exit(1);
			}
		}else if (Game.state == States.Options) {
			if (x>= 800 && x <= 950 && y >= 50 && y <= 130) {
				Game.state = States.TitleScreen;

			}
		}else if (Game.state == States.Game) {
			 for (int i = 0; i < handler.object.size(); i++){
                 Object tempObject= handler.object.get(i);
                 if(tempObject.getId() == IDs.player){

                         handler.addObject(new Arrow(tempObject.getXpos() + 12, tempObject.getYpos() + 22, IDs.Arrow, handler, x, y));
                 }
         }
		}
	}
 
	public void mouseReleased(MouseEvent e) {
		
	}

}
