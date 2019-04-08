package com.control;

import java.awt.*;

public class Arrow extends Object {

    private Handler handler;


    public Arrow(int xpos, int ypos, IDs id, Handler handler, int x, int y) {
        super(xpos, ypos, id);
        this.handler = handler;

        Xspeed = (x - xpos) / 10;
        Yspeed = (y - ypos) / 10;
    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 8, 8);
    }


    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.Block) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                    handler.removeObject(this);
                }
            }
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillOval(xpos,ypos,8,8);
    }
}
