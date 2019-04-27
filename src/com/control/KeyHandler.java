package com.control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;
import com.player.sword;
/*In this class the implementation of KeyAdapter has been done. It takes the key inputs at different states to make the 
 * player walk along the map and also enable the melee attacks as well as interaction with the shop.
 * */
public class KeyHandler extends KeyAdapter {

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	private int currentDirection = 0; // 1 for up, 2 for down, 3 for left, 4 for right


	private Handler handler;
	private Game game;
	public KeyHandler (Handler handler, SpriteSheet ss, Game game) {

		this.handler = handler;
		this.game = game;
	}

	//for no lag with key occurances we will use keypress and keyreleased functions

	@SuppressWarnings("static-access")
	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		if (Game.state == States.tutorial) {
			if (key == KeyEvent.VK_ENTER) {
				Game.state = States.Load;
			}
			if (key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_BACK_SPACE) {
				Game.state = States.TitleScreen;
			}
		}
		if (Game.state == States.level1 || Game.state == States.level2 || Game.state == States.level3 || Game.state == States.bosslevel || Game.state == States.winscreen || Game.state == States.deathscreen) {
			for (int i = 0; i < handler.object.size(); i++) {
				Object tempObject = handler.object.get(i);
				if (tempObject.getId() == IDs.player) {
					if (key == KeyEvent.VK_W) {
						tempObject.setYspeed(-5);
						up = true;
						currentDirection = 1;
					}
					if (key == KeyEvent.VK_A) {
						tempObject.setXspeed(-5);
						left = true;
						currentDirection = 3;
					}
					if (key == KeyEvent.VK_S) {
						tempObject.setYspeed(5);
						down = true;
						currentDirection = 2;
					}
					if (key == KeyEvent.VK_D) {
						tempObject.setXspeed(5);
						right = true;
						currentDirection = 4;
					}
					if (key == KeyEvent.VK_P) {
						Game.tempstate = Game.state;
						Game.state = States.Pause;

					}
					if (key == KeyEvent.VK_B) {
						game.meleeupgrade = true;
						game.rangedupgrade = true;
						game.player1Health = 4;
						game.arrowsRemaining = 99;
						Game.state = States.bosslevel;
						game.loadLevel(game.bossLevel);

					}

					//Melee attack logic
					if (key == KeyEvent.VK_SPACE){
						if(up == true && left == false && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, game.ss, currentDirection, game));
							tempObject.setYspeed(0);
							tempObject.setXspeed(0);

						}else if(down == true && left == false && right == false && up == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, game.ss, currentDirection, game));
							tempObject.setYspeed(0);
							tempObject.setXspeed(0);
						}else if(up == false && left == false && right == true && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, game.ss, currentDirection, game));
							tempObject.setYspeed(0);
							tempObject.setXspeed(0);
						}else if(up == false && left == true && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, game.ss, currentDirection, game));
							tempObject.setYspeed(0);
							tempObject.setXspeed(0);
						}else if(up == false && left == false && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, game.ss, 0, game));
							tempObject.setYspeed(0);
							tempObject.setXspeed(0);
						}
					}
					if (key == KeyEvent.VK_F){
						if (game.shopKeeperCollision){
							Game.tempstate = Game.state;
							Game.state = States.shop;
						}
					}

				}
			}
		}
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Game.state == States.level1  ) {
		for (int i = 0; i < handler.object.size(); i++) {
			Object tempObject = handler.object.get(i);
			if (tempObject.getId() == IDs.player) {

				if (key == KeyEvent.VK_W){
					up = false;
					if (down == true){
						tempObject.setYspeed(5);
					}else {
						tempObject.setYspeed(0);
					}
				}
				if (key == KeyEvent.VK_A) {
					left = false;
					if (right == true){
						tempObject.setXspeed(5);
					}else{
						tempObject.setXspeed(0);
					}
				}
				if (key == KeyEvent.VK_S) {

					down = false;
					if (up == true){
						tempObject.setYspeed(-5);
					}else{
						tempObject.setYspeed(0);
					}
				}
				if (key == KeyEvent.VK_D) {
					right = false;
					if (left == true){
						tempObject.setXspeed(-5);
					}else{
						tempObject.setXspeed(0);
						}
					}


				}
			}
		}
		else if (Game.state == States.level2 || Game.state == States.bosslevel || Game.state == States.level3 || Game.state == States.winscreen || Game.state == States.deathscreen){
			for (int i = 0; i < handler.object.size(); i++) {
				Object tempObject = handler.object.get(i);
				if (tempObject.getId() == IDs.player) {
					if (key == KeyEvent.VK_W){
						up = false;
						if (down == true){
							tempObject.setYspeed(5);
						}else {
							tempObject.setYspeed(0);
						}
					}
					if (key == KeyEvent.VK_A) {
						left = false;
						if (right == true){
							tempObject.setXspeed(5);
						}else{
							tempObject.setXspeed(0);
						}
					}
					if (key == KeyEvent.VK_S) {
						down = false;
						if (up == true){
							tempObject.setYspeed(-5);
						}else{
							tempObject.setYspeed(0);
						}
					}
					if (key == KeyEvent.VK_D) {
						right = false;
						if (left == true){
							tempObject.setXspeed(-5);
						}else{
							tempObject.setXspeed(0);
						}
					}
				}
			}
		}

	}
}
