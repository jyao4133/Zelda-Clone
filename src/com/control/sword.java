package com.control;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.*;
import java.util.Calendar;

public class sword extends Object {

    private Handler handler;
    int currentDirection;
    private long lastAttackTime, attackCooldown = 800;
    private long attacktime = attackCooldown;
    public int currentSecond = 0;

    public sword(int xpos, int ypos, IDs id, Handler handler, SpriteSheet ss, int direction) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        currentDirection = direction;
        start();

        Xspeed = 4;
        Yspeed = 4;
    }

    public Rectangle getBounds() {

            if (currentDirection == 1){
                return new Rectangle(xpos - 32, ypos - 48, 50, 50);

            }
            else if(currentDirection == 2){

                return new Rectangle(xpos - 32, ypos + 24, 50, 50);

            }
            else if(currentDirection == 3){
                return new Rectangle(xpos - 64, ypos - 24, 50, 50);

            }
            else if(currentDirection == 4){
                return new Rectangle(xpos + 24, ypos - 18, 50, 50);

            }
            else if(currentDirection == 0){
                return new Rectangle(xpos - 32, ypos + 24, 50, 50);


            }
            else{
                return new Rectangle(xpos - 32, ypos + 24, 50, 50);

            }


    }



    public void tick() {
        attacktime += System.currentTimeMillis() - lastAttackTime;
        lastAttackTime = System.currentTimeMillis();
        if(attacktime < attackCooldown)

        System.out.println(attacktime);

        if(currentDirection == 1){
            ypos -= Yspeed ;

        }

        else if(currentDirection == 2){
            ypos += Yspeed;

        }

        else if(currentDirection == 3){
            xpos -= Xspeed;

        }

        else if(currentDirection == 4){
            xpos += Xspeed;

        }

    }

    public void render(Graphics g) {

        g.setColor(Color.yellow);
        //up
        if (currentDirection == 1){
            g.fillRect(xpos - 32, ypos - 48, 45, 45);
            if (currentSecond == 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }

        }
        //down
        else if (currentDirection == 2){
            g.fillRect(xpos -32, ypos +24 , 45, 45);
            if (currentSecond == 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }

        }
        //left
        else if (currentDirection == 3){
            g.fillRect(xpos-64, ypos - 24, 45, 45);
            if (currentSecond == 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }
        //right
        else if (currentDirection == 4){
            g.fillRect(xpos + 24, ypos  - 18, 45, 45);
            if (currentSecond == 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }

        }

        else if (currentDirection == 0){
            g.fillRect(xpos -32, ypos +24 , 45, 45);
            if (currentSecond == 20) {
                handler.removeObject(this);
                currentSecond = 0;
            }

        }



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

