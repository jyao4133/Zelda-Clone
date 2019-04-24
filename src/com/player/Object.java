//High level wrapper for ALL objects in the game

package com.player;

import java.awt.*;

import com.control.IDs;
/*
High level class which every object that the player can interact with in the game will extend
The class includes getter and setter methods so that we can change any parameter of any object
on the screen whenever an event occurs
 */
public abstract class Object {
	
    protected int xpos, ypos; //Only allow objects that inherit this class use xposition and yposition
    protected IDs id;
    protected int Xspeed, Yspeed, xprev, yprev, initial;
    protected String currentLevel;
    protected SpriteSheet ss;
    
    public Object(int xpos, int ypos, IDs id, SpriteSheet ss){
        //Constructor for our variables
        this.xpos = xpos;
        this.ypos = ypos;
        this.id = id;
        this.ss = ss;
        this.currentLevel = currentLevel;

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

    public int getshiftY() {return ypos + 45;}

    public int getshiftX() {return xpos + 45;}

    public IDs getId() {
        return id;
    }

    public abstract Rectangle getBounds();

    public String getLevel() {return currentLevel;}

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

    public void setXprev(int xprev) { this.xprev = xprev; }

    public int getXprev() {
        return xprev;
    }

    public void setYprev(int yprev) { this.yprev = yprev; }

    public int getYprev() { return yprev; }

    public void setInitial(int initial) { this.initial = initial; }

    public int getInitial() { return initial; }

    public abstract void tick();
    public abstract void render(Graphics g);
}
