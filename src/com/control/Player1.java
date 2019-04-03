package com.control;

import java.awt.*;

public class Player1 extends Object {
//player controller class following MVC
	Handler handler;
    public Player1(int xpos, int ypos, IDs id, Handler handler) {
        super(xpos, ypos, id);
        //Xspeed = 1;
        //Yspeed = 1;
		this.handler = handler;

    }

    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;

    }

    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(xpos, ypos, 32, 32);

    }
    
	public Rectangle getBounds() {
		return new Rectangle (xpos,ypos,32,32);
	}

}
