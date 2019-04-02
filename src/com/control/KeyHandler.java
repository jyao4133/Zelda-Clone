package com.control;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
	

	Handler handler;
	
	public KeyHandler (Handler handler) {
		this.handler = handler;
	}
	
	//for no lag with key occurances we will use keypress and keyreleased functions
	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < handler.object.size(); i++) {
			Object tempobject = handler.object.get(i);
			if (tempobject.getId() == IDs.player) {
				if (key == KeyEvent.VK_UP) handler.setUp(true);
				if (key == KeyEvent.VK_DOWN) handler.setDown(true);
				if (key == KeyEvent.VK_LEFT) handler.setLeft(true);
				if (key == KeyEvent.VK_RIGHT) handler.setRight(true);
			}
		}
		
	}
	
}
