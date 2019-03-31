//High level wrapper for ALL objects in the game

package com.control;

import java.awt.*;

public abstract class Object {

    protected int xpos, ypos; //Only allow objects that inherit this class use xposition and yposition
    protected IDs id;
    protected int Xspeed, Yspeed;




    public Object(int xpos, int ypos, IDs id){
        //Constructor for our variables
        this.xpos = xpos;
        this.ypos = ypos;
        this.id = id;

    }


    public int getXpos() {
        return xpos;
    }

    public void setXpos(int xpos) {
        this.xpos = xpos;
    }

    public int getYpos() {
        return ypos;
    }

    public void setYpos(int ypos) {
        this.ypos = ypos;
    }

    public IDs getId() {
        return id;
    }

    public void setId(IDs id) {
        this.id = id;
    }

    public int getXspeed() {
        return Xspeed;
    }

    public void setXspeed(int xspeed) {
        this.Xspeed = xspeed;
    }

    public int getYspeed() {
        return Yspeed;
    }

    public void setYspeed(int yspeed) {
        this.Yspeed = yspeed;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
