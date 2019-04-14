package com.control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	private int currentDirection = 0; // 1 for up, 2 for down, 3 for left, 4 for right


	private Handler handler;
	private Game game;
	private SpriteSheet ss;

	public KeyHandler (Handler handler) {
		this.handler = handler;
		this.game = game;
		this.ss = ss;
	}
	
	//for no lag with key occurances we will use keypress and keyreleased functions

	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();

		if (Game.state == States.Game || Game.state == States.level2) {
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
						Game.state = States.Pause;
						System.out.println("Game is Paused");

					}

					//Melee attack logic
					if (key == KeyEvent.VK_SPACE){
						System.out.println("pressed");
						System.out.println(up);

						if(up == true && left == false && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, currentDirection));
						}
						else if(down == true && left == false && right == false && up == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, currentDirection));
						}
						else if(up == false && left == false && right == true && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, currentDirection));
						}
						else if(up == false && left == true && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, currentDirection));
						}
						else if(up == false && left == false && right == false && down == false){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, 0));
						}

						else if((up == true && left == true && right == false && down == false) || (up == true && left == false && right == true && down == false)){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, 1));
						}

						else if((up == false && left == true && right == false && down == true) || (up == false && left == false && right == true && down == true)){
							handler.addObject(new sword (tempObject.getXpos()+35, tempObject.getYpos() + 24, IDs.sword, handler, ss, 2));
						}
					}

				}
			}
		}
	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(Game.state == States.Game) {
		for (int i = 0; i < handler.object.size(); i++) {
			Object tempObject = handler.object.get(i);
			if (tempObject.getId() == IDs.player) {

				if (key == KeyEvent.VK_W){
					up = false;
					if (down == true){
						tempObject.setYspeed(5);
					}
					else {
						tempObject.setYspeed(0);
					}
				}
				if (key == KeyEvent.VK_A) {
					left = false;
					if (right == true){
						tempObject.setXspeed(5);
					}
					else{
						tempObject.setXspeed(0);
					}
				}
				if (key == KeyEvent.VK_S) {

					down = false;
					if (up == true){
						tempObject.setYspeed(-5);
					}
					else{
						tempObject.setYspeed(0);
					}
				}
				if (key == KeyEvent.VK_D) {
					right = false;
					if (left == true){
						tempObject.setXspeed(-5);
					}
					else{
						tempObject.setXspeed(0);
					}
				}

			}
		}
		}
		else if (Game.state == States.level2){
			for (int i = 0; i < handler.object.size(); i++) {
				Object tempObject = handler.object.get(i);
				if (tempObject.getId() == IDs.player) {

					if (key == KeyEvent.VK_W){
						up = false;
						if (down == true){
							tempObject.setYspeed(5);
						}
						else {
							tempObject.setYspeed(0);
						}
					}
					if (key == KeyEvent.VK_A) {
						left = false;
						if (right == true){
							tempObject.setXspeed(5);
						}
						else{
							tempObject.setXspeed(0);
						}
					}
					if (key == KeyEvent.VK_S) {

						down = false;
						if (up == true){
							tempObject.setYspeed(-5);
						}
						else{
							tempObject.setYspeed(0);
						}
					}
					if (key == KeyEvent.VK_D) {
						right = false;
						if (left == true){
							tempObject.setXspeed(-5);
						}
						else{
							tempObject.setXspeed(0);
						}
					}


				}
			}
		}

	}
}
