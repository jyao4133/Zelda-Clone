package com.control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {

	private boolean up = false;
	private boolean down = false;
	private boolean left = false;
	private boolean right = false;

	private Handler handler;

	public KeyHandler (Handler handler) {
		this.handler = handler;
	}
	
	//for no lag with key occurances we will use keypress and keyreleased functions

	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();





		for (int i = 0; i < handler.object.size(); i++) {
			Object tempObject = handler.object.get(i);
			if (tempObject.getId() == IDs.player) {

				if (key == KeyEvent.VK_W) {
					tempObject.setYspeed(-5);
					up = true;
				}
				if (key == KeyEvent.VK_A) {
					tempObject.setXspeed(-5);
					left = true;
				}
				if (key == KeyEvent.VK_S) {
					tempObject.setYspeed(5);
					down = true;
				}
				if (key == KeyEvent.VK_D) {
					tempObject.setXspeed(5);
					right = true;

				}


			}
		}

	}


	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
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
