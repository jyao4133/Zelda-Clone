package com.enemy;
//https://www.deviantart.com/zeka10000/art/WonderBolts-sprites-680138765
import javax.swing.*;

import com.control.Game;
import com.control.IDs;
import com.player.Animation;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

public class clampEnemyright extends Object {

    private String shootDirection;
    private int currentSecond = 0;
    private Handler handler;
    private BufferedImage [] left, right;
    private Animation ani_left, ani_right;

    public clampEnemyright(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.id = id;
        Xspeed = 4;
        
        left = new BufferedImage [3];
		right = new BufferedImage [3];
		
        left[0] = ss.grabImage(5, 11, 75,75);
		left[1] = ss.grabImage(6, 11, 75,75);
		left[2] = ss.grabImage(7, 11, 75,75);
		
		right[0] = ss.grabImage(5, 12, 75,75);
		right[1] = ss.grabImage(6, 12, 75,75);
		right[2] = ss.grabImage(7, 12, 75,75);
		
		ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);		
    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 75, 75);
    }

    public void tick() {
        ypos += Yspeed;
        xpos += Xspeed;
        ani_left.tick();
    	ani_right.tick();
    	
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects(tempObject.getBounds())) {
                    if(tempObject.getId()== IDs.Arrow) {
                        handler.removeObject(tempObject);
                    }
                    handler.removeObject(this);
                }
            } if (tempObject.getId() == IDs.clampleft) {
                if (this.getBounds().intersects(tempObject.getBounds())) {
                    Xspeed = -4;

                }
            } if (tempObject.getId() == IDs.Block) {
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
    	// g.setColor(Color.black);
        // g.fillRect(xpos, ypos, 75, 75);
     	if (Xspeed < 0  ) {//left
         	g.drawImage(ani_left.getCurrentFrame(), xpos, ypos, null);
     	}
     	else if (Xspeed > 0) {//right
         	g.drawImage(ani_right.getCurrentFrame(), xpos, ypos, null);
     	}
     	else {
         	g.drawImage(left[0], xpos, ypos, null);
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
