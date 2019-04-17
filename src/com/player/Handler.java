package com.player;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;


public class Handler {



    public ArrayList<Object> object = new ArrayList<>();
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
    
    public void removeall(){
	    this.object.clear();
    }


    public void addObject(Object object){
        this.object.add(object);
    }

    public void removeObject(Object object){
        this.object.remove(object);
    }

    
}