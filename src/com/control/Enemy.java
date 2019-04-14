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
    Game game;
    Random r = new Random();
    Random p = new Random();

    int chosen = 0;
    int rngGen = 0;
    int hp = 100;
    boolean hitX = true;
    boolean hitY = true;
    int maxSpeed = 4;

    public Enemy(int xpos, int ypos, IDs id, Handler handler, Game game, int xprev, int yprev, int initial, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.xprev = xprev;
        this.yprev = yprev;
        this.game = game;
        this.initial = initial;
    }

    public void tick() {

        if(initial == 1){
            initial = 0;
        }else{
            xprev = xpos;
            yprev = ypos;
        }

        ypos += Yspeed;
        xpos += Xspeed;

        chosen = r.nextInt(10);


        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);

            if (tempObject.getId() == IDs.Block) {

                if (getBounds().intersects((tempObject.getBounds()))) {

                        xpos = xprev;
                        ypos = yprev;
                        Xspeed *= -1;
                        Yspeed *= -1;
                }
                else if (chosen == 0){
                    Xspeed = (r.nextInt(2*maxSpeed +1) - maxSpeed);
                    Yspeed = (r.nextInt(2*maxSpeed +1) - maxSpeed);

                }
            }

            if (tempObject.getId() == IDs.Arrow){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                    rngGen = p.nextInt(10);

                    if (rngGen < 2) {
                        handler.addObject(new heartPickup(xpos, ypos, IDs.heartPickup, ss));
                    }

                    else if (rngGen > 8){
                        handler.addObject(new arrowPickup(xpos, ypos, IDs.Pickup, ss));

                    }

                    if (Game.state == States.Game || Game.state == States.Load){
                        game.enemiesStage1--;
                    }
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
