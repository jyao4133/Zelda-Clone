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


    
}
