package com.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyHandler extends KeyAdapter {
	
	//if we create a new handler it will make a new list but because we are transferring from the list  
	//therefore we don't have a new instance
	Handler handler;
	
	public KeyHandler (Handler handler) {
		this.handler = handler;
	}
	
	//for no lag with key occurances.
	public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		
	}
	
	public void keyReleased (KeyEvent e) {
		int key = e.getKeyCode();
	}
}
