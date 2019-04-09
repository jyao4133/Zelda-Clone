package com.control;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;

public class Handler {


    ArrayList<Object> object = new ArrayList<>();
    private Rectangle button;


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

	
	public void Button (int x, int y, int width, int height) {
		button = new Rectangle(x,y,width,height);
	}
	
    
}
