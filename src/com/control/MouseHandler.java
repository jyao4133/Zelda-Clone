package com.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.gui.Pause;
import com.player.Arrow;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

public class MouseHandler extends MouseAdapter  {

	
	private Handler handler;
	private Game game;
	private SpriteSheet ss;
	public Pause pausemenu;
	private static int x = -1, y = -1;
    
 	
     public MouseHandler (Handler handler, Game game, SpriteSheet ss){
         this.handler = handler;
         this.game = game;
         this.ss = ss;

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
			if (x >= 150 && x <= 450 && y >= 300 && y <= 380) {//To start the game in single player
				Game.state = States.tutorial;
			}	
			if (x >= 150 && x <= 450 && y >= 400 && y <= 480) {//display highscores
				Game.state = States.highscores;
			}
			if (x >= 150 && x <= 450 && y >= 500 && y <= 580) {	//Option Menu for the game
				Game.state = States.Options;
			}
			if (x >= 150 && x <= 450 && y >= 600 && y <= 680) {//To exit the game
				System.exit(0);
			}
		}else if (Game.state == States.Options || Game.state == States.Controls ||
				Game.state == States.Credits) {
			if (x>= 100 && x <= 400 && y >= 190 && y <= 300) {
				Game.state = States.Sound;
			}
			if (x>= 100 && x <= 400 && y >= 370 && y <=480) {
				Game.state = States.Controls;
			}
			if (x>= 100 && x <= 400 && y >= 550 && y <= 660) {
				Game.state = States.Credits;
			}
			if (x>= 100 && x <= 400 && y >= 730 && y <= 840) {
				Game.state = States.TitleScreen;
			}
			
		}else if (Game.state == States.Sound) {
			if (x >= 550 && x <= 700 && y >= 590 && y <= 670) {
				game.soundplay = false;

			}
			if (x >= 750 && x <= 900 && y >= 590 && y <= 670) {
				game.soundplay = true;

			}
			if (x>= 100 && x <= 400 && y >= 370 && y <=480) {
				Game.state = States.Controls;
			}
			if (x>= 100 && x <= 400 && y >= 550 && y <= 660) {
				Game.state = States.Credits;
			}
			if (x>= 100 && x <= 400 && y >= 730 && y <= 840) {
				Game.state = States.TitleScreen;
			}
		}
		else if (Game.state == States.level1 || Game.state == States.level2 || Game.state == States.bosslevel || Game.state == States.level3) {
			 for (int i = 0; i < handler.object.size(); i++){
                 Object tempObject= handler.object.get(i);
                 if(tempObject.getId() == IDs.player){
					if (e.getButton() == MouseEvent.BUTTON3) {
						if (game.arrowsRemaining > 0) {
							handler.addObject(new Arrow(tempObject.getXpos() + 24, tempObject.getYpos() + 24, IDs.Arrow, handler, x, y, ss));
							if (game.rangedupgrade == true){
								handler.addObject(new Arrow(tempObject.getXpos() + 32, tempObject.getYpos() + 32, IDs.Arrow, handler, x, y, ss));
							}
							game.arrowsRemaining--;
						}
					}
                 }
			 }
		}else if (Game.state == States.Pause) {
			if (x >= 390 && x <= 630 && y >= 410 && y <= 460) {
				Game.state = Game.tempstate;
			}
			if (x >= 390 && x <= 630 && y >= 480 && y <= 530) {
				Game.state = States.pauseOptions;
			}
			if (x >= 390 && x <= 630 && y >= 570 && y <= 620) {
				Game.state = States.TitleScreen;

			}
		}else if (Game.state == States.pauseOptions) {
			if (x >= 390 && x <= 630 && y >= 620 && y <= 650) {
				Game.state = States.Pause;
			}
		}else if (Game.state == States.highscores){
			if (x>= 360 && x <= 660 && y >= 790 && y <= 870) {
				Game.state = States.TitleScreen;

			}
		}else if (Game.state == States.deathscreen){
			if (x>= 350 && x <= 680 && y >= 480 && y <= 550) {
				Game.state = States.TitleScreen;
			}

		}else if (Game.state == States.shop){

			if (x >= 725 && x <= 975 && y >= 345 && y <= 415){
				Game.state = Game.tempstate;
			}
			if (x >= 80 && x <= 335 && y >= 425 && y <= 495){
				if (game.goldAmount > 0 && game.player1Health < 4){
					game.goldAmount --;
					game.player1Health++;
				}
			}
			if (x >= 80 && x <= 335 && y >= 535 && y <= 605){
				if (game.goldAmount > 0){
					game.goldAmount --;
					game.arrowsRemaining += 10;
				}
			}
			if (x >= 80 && x <= 335 && y >= 645 && y <= 815){
				if (game.goldAmount >= 3){
					game.goldAmount -= 3;
					game.rangedupgrade = true;
				}
			}
			if (x >= 80 && x <= 335 && y >= 750 && y <= 825){
				if (game.goldAmount >= 3){
					game.goldAmount -= 3;
					game.meleeupgrade = true;
				}
			}
		}
	}
 
	public void mouseReleased(MouseEvent e) {
		
	}
	
	public static int getX() {
		return x;
	}
	public static int getY() {
		return y;
	}

}
