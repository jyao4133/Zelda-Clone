package com.enemy;

import javax.swing.*;

import com.control.Game;
import com.control.IDs;
import com.control.States;
import com.player.*;
import com.player.Object;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class shooterEnemy extends Object {
    Game game;

    private String shootDirection;
    private int currentSecond = 0;
    private Handler handler;
    private int Direction = 1;
    Random r = new Random();
    Random p = new Random();
    int rngGen = 0;

    public shooterEnemy(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss ) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;
        start();

    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 36, 36);
    }

    public void tick() {

        if (currentSecond > 30){
            //right
            if (Direction == 1) {
                currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 36, ypos + 14, IDs.enemyArrow, handler, ss, 1, false));
                Direction = r.nextInt(4) + 1;

            }
            //up
            else if (Direction == 2) {
                currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 14, ypos +36 , IDs.enemyArrow, handler, ss, 2, false));
                Direction = r.nextInt(4) + 1;
                System.out.println("this is:" +Direction);


            }
            //left
            else if (Direction == 3) {
                currentSecond = 0;
                handler.addObject(new enemyArrow(xpos , ypos + 14, IDs.enemyArrow, handler, ss, 3, false));
                Direction = r.nextInt(4) + 1;


            }
            //down
            else if (Direction == 4) {
                currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 14, ypos , IDs.enemyArrow, handler, ss, 4, false));
                Direction = r.nextInt(4) + 1;

            }
        }

        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                    if(tempObject.getId()== IDs.Arrow) {
                        handler.removeObject(tempObject);
                    }
                    handler.removeObject(this);
                    rngGen = p.nextInt(10);
                    if (rngGen < 2) {
                        handler.addObject(new heartPickup(xpos+18, ypos +18, IDs.heartPickup, ss));
                    }
                    else if (rngGen > 8){
                        handler.addObject(new arrowPickup(xpos + 18, ypos + 18, IDs.Pickup, ss));
                    }
                    else if(rngGen > 2 && rngGen < 8){
                        handler.addObject(new coinPickup(xpos + 18, ypos+18,IDs.coinPickup, ss));
                    }
                    if (Game.state == States.level2){

                    }
                }
            }




        }
    }

    public void render(Graphics g) {
        g.setColor(Color.orange);
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
