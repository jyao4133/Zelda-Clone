package com.enemy;

import javax.swing.*;

import com.control.Game;
import com.control.IDs;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class clampEnemyleft extends Object {

    private String shootDirection;
    private int currentSecond = 0;
    private Handler handler;


    public clampEnemyleft(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.id = id;
        Xspeed = -4;

    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 36, 36);
    }

    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                }
            }

            if (tempObject.getId() == IDs.clampright) {
                if (this.getBounds().intersects(tempObject.getBounds())) {
                    Xspeed = 4;

                }
            }

            if (tempObject.getId() == IDs.Block) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    xpos += Xspeed * -1;
                    ypos += Yspeed * -1;
                    if (Xspeed == -4) {
                        Xspeed = 4;
                    }

                    else if (Xspeed == 4){
                        Xspeed = -4;
                    }
                }
            }
        }


    }




    public void render(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(xpos, ypos, 36, 36);
    }

    public void start(){
        Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {

                currentSecond++;
            }
        });
        timer.start();
    }
}
