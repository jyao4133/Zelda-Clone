package com.control;

import java.awt.*;

public class Player1 extends Object {
//player controller class following MVC

    public Player1(int xpos, int ypos, IDs id) {
        super(xpos, ypos, id);
        Xspeed = 1;
        Yspeed = 1;
    }

    public void tick() {
        ypos += Yspeed;
        xpos += Xspeed;

    }

    public void render(Graphics g) {

        g.setColor(Color.white);
        g.fillRect(xpos, ypos, 32, 32);

    }

}
