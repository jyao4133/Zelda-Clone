package com.control;

import java.awt.*;
import java.util.LinkedList;

public class Handler {


    LinkedList<Object> object = new LinkedList<Object>();
    
    private boolean up = false;
    private boolean down = false;
    private boolean left = false;
    private boolean right = false;
    
    public void tick(){

        for (int i = 0; i < object.size(); i++){
            Object tempObject = object.get(i);
            tempObject.tick();
        }

    }

    public void render(Graphics g){

        for (int i = 0; i < object.size(); i++){
            Object tempObject = object.get(i);
            tempObject.render(g);
        }
    }

    public void addObject(Object object){
        this.object.add(object);
    }

    public void removeObject(Object object){
        this.object.remove(object);
    }

    public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

    
}
