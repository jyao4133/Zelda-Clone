package com.control;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
/*we are making 256 key codes which co relates with the boolean keycode 
 * when the key is pressed we push it to keypressed to make it true else false.
 * In isKeyPressed checks the boolean value at the keycode.*/


public class KeyInput extends KeyAdapter {
	
	private final static boolean[] keys = new boolean[256]; 
	
	public void keyPressed (KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	public static boolean isKeyPressed(int key) {
		return keys[key];
	}
		
}
