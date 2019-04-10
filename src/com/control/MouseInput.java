package com.control;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MouseInput extends MouseAdapter{
	
	int x = -1, y = -1;
	
	private static final boolean buttons [] = new boolean [10];
	private static final boolean lastbutton[] = new boolean [10];
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
		y = e.getY();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = true;
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		buttons[e.getButton()] = false;
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		super.mouseWheelMoved(e);
	}
	
	public static void update () {
		for (int i = 0; i < 10; i++) {
			lastbutton[i] = buttons[i];
		}
	}
	
	public static boolean isDown(int button) {
		return buttons[button];
	}
	
	public static boolean wasPressed(int button) {
		return isDown(button) && !lastbutton[button];
	}
	
	public static boolean wasReleased (int button) {
		return !isDown(button) && lastbutton[button];
	}


	
}
