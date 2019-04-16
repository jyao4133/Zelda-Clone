package com.control;

import java.awt.*;

public class enemyArrow extends Object {
    private Handler handler;


    public enemyArrow(int xpos, int ypos, IDs id, Handler handler,SpriteSheet ss, int Direction ) {
        super(xpos, ypos, id, ss);
        this.handler = handler;



        if (Direction == 1){
            Xspeed = 6;
            Yspeed = 0;
        }

        else if (Direction == 2){
            Xspeed = 0;
            Yspeed = 6;

        }

        else if (Direction == 4){
            Xspeed = 0;
            Yspeed = -6;
        }

        else if (Direction == 3){
            Xspeed = -6;
            Yspeed = 0;
        }



        System.out.println(Xspeed);
        System.out.println(Yspeed);
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