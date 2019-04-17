package com.enemy;

import java.awt.*;
import java.util.Random;

import com.control.IDs;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

public class enemyArrow extends Object {
    private Handler handler;
    Random r = new Random();

    public enemyArrow(int xpos, int ypos, IDs id, Handler handler,SpriteSheet ss, int Direction, Boolean randomDir ) {
        super(xpos, ypos, id, ss);
        this.handler = handler;



        if (Direction == 1){
            if (randomDir){
                Xspeed = 6;
                Yspeed = - 6 + r.nextInt(12);
            }
            else {
                Xspeed = 6;
                Yspeed = 0;
            }
        }

        else if (Direction == 2){
            if (randomDir){
                Xspeed = - 6 + r.nextInt(12);
                Yspeed = 6;
            }
            else {
                Xspeed = 0;
                Yspeed = 6;
            }
        }

        else if (Direction == 4){
            if (randomDir){
                Xspeed = - 6 + r.nextInt(12);
                Yspeed = -6;
            }
            else {
                Xspeed = 0;
                Yspeed = -6;
            }
        }

        else if (Direction == 3){
            if (randomDir){
                Xspeed = -6;
                Yspeed = - 6 + r.nextInt(12);
            }
            else {
                Xspeed = -6;
                Yspeed = 0;
            }
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