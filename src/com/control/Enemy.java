package com.control;

import java.awt.*;
import java.util.*;

public class Enemy extends Object{

    //First enemy
    /*
    This enemy is the first enemy the player will come across. It will have randomized
    movement and will remove 1 point of health when it collides with the player.
     */

    private Handler handler;
    Random r = new Random();
    int chosen = 0;
    int hp = 100;
    boolean hitX = true;
    boolean hitY = true;
    int maxSpeed = 5;

    public Enemy(int xpos, int ypos, IDs id, Handler handler) {

        super(xpos, ypos, id);
        this.handler = handler;
    }

    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;

        chosen = r.nextInt(10);


        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);

            if (tempObject.getId() == IDs.Block) {

                if (getXYBounds().intersects((tempObject.getBounds()))) {

                        xpos += (Xspeed*2) * -1;
                        ypos += (Yspeed*2) * -1;
                        Xspeed *= -1;
                        Yspeed *= -1;
                }
                else if (chosen == 0){
                    Xspeed = (r.nextInt(2*maxSpeed) - maxSpeed);
                    Yspeed = (r.nextInt(2*maxSpeed) - maxSpeed);


//                    if (Xspeed == 4){
//                        Xspeed = 3;
//                    }
//
//                    if (Yspeed == 4){
//                        Yspeed = 3;
//                    }
//
                    if (Xspeed == -6){
                        Xspeed = -5;
                    }

                    if (Yspeed == -6){
                        Yspeed = -5;
                    }



                    System.out.println(Xspeed + "<------ X");
                    System.out.println(Yspeed + "<------ Y");


                }
            }

            if (tempObject.getId() == IDs.Arrow){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
                    handler.removeObject(this);

                }
            }
        }



    }


    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect(xpos, ypos, 16, 16);
    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos,ypos,16,16);
    }

    //collision with wall
    public Rectangle getXYBounds(){
        return new Rectangle (xpos - 16, ypos - 16, 32, 32);
    }


}
