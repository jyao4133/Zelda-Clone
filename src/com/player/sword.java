package com.player;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.Timer;

import com.control.Game;
import com.control.IDs;

public class sword extends Object {

    private Handler handler;

    private Game game;
    private Player1 player;

    int currentDirection;

    private long lastAttackTime, attackCooldown = 800;
    private long attacktime = attackCooldown;
    public int currentSecond = 0;


    //private SpriteAnimation animation;
    //private BufferedImage[] weapon = new BufferedImage [4];
    
    private BufferedImage [] up, down, left, right;
    private Animation ani_up, ani_down, ani_left, ani_right;
    
    public sword(int xpos, int ypos, IDs id, Handler handler, SpriteSheet ss, int direction, Game game) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        currentDirection = direction;
        this.game = game;
      /*  weapon[0] = ss.grabImage(1, 8, 75, 75);//right
        weapon[1] = ss.grabImage(2, 8, 75, 75);//left
        weapon[2] = ss.grabImage(3, 8, 75, 75);//up
        weapon[3] = ss.grabImage(4, 8, 75, 75);//down*/
         
        
        start();
        Xspeed = 4;
        Yspeed = 4;
        
        up = new BufferedImage [3];
		down = new BufferedImage [3];
		left = new BufferedImage [3];
		right = new BufferedImage [3];
		
		/////////////ANIMATIONS/////////////
		up[0] = ss.grabImage(5, 4, 75,75);
		up[1] = ss.grabImage(6, 4, 75,75);
		up[2] = ss.grabImage(7, 4, 75,75);
		
		down[0] = ss.grabImage(5, 3, 75,75);
		down[1] = ss.grabImage(6, 3, 75,75);
		down[2] = ss.grabImage(7, 3, 75,75);
		
		left[0] = ss.grabImage(5, 2, 75,75);
		left[1] = ss.grabImage(6, 2, 75,75);
		left[2] = ss.grabImage(7, 2, 75,75);
		
		right[0] = ss.grabImage(5, 1, 75,75);
		right[1] = ss.grabImage(6, 1, 75,75);
		right[2] = ss.grabImage(7, 1, 75,75);
		///////////////////////////////////////
		
		/*increasing the timer reduces the speed of the animation and vice versa*/
		ani_up = new Animation (40, up);
		ani_down = new Animation (40, down);
		ani_left = new Animation (40, left);
		ani_right = new Animation (40, right);		

    }

    public Rectangle getBounds() {

        if (game.meleeupgrade == true) {
            if (currentDirection == 1 && player.prevDirection == "up") {   //up
                return new Rectangle(xpos - 20, ypos - 48, 50, 90);
            } else if (currentDirection == 2 && player.prevDirection == "down") {//down
                return new Rectangle(xpos - 20, ypos + 30, 50, 100);
            } else if (currentDirection == 3 && player.prevDirection == "left") {//left
                return new Rectangle(xpos - 110, ypos, 90, 50);
            } else if (currentDirection == 4 && player.prevDirection == "right") {//right
                return new Rectangle(xpos + 25, ypos, 90, 50);
            } else if (currentDirection == 0 && player.prevDirection == "up") {
                System.out.println("aposgjn");
                return new Rectangle(xpos - 25, ypos - 88, 50, 90);
            } else if (currentDirection == 0 && player.prevDirection == "down") {
                return new Rectangle(xpos - 20, ypos + 30, 50, 100);
            } else if (currentDirection == 0 && player.prevDirection == "left") {
                return new Rectangle(xpos - 110, ypos, 90, 50);
            } else if (currentDirection == 0 && player.prevDirection == "right") {
                return new Rectangle(xpos + 25, ypos, 90, 50);
            }
        }

          	if (currentDirection == 1&& player.prevDirection == "up"){   //up
                return new Rectangle(xpos - 20 , ypos - 48, 50, 50);
            }else if(currentDirection == 2&& player.prevDirection == "down"){//down
                return new Rectangle(xpos - 20 , ypos + 30  , 50, 60);
            }else if(currentDirection == 3&& player.prevDirection == "left"){//left
                return new Rectangle(xpos - 80, ypos, 50, 50);
            }else if(currentDirection == 4 && player.prevDirection == "right"){//right
                return new Rectangle( xpos + 20 , ypos , 60, 50);
            }else if(currentDirection == 0 && player.prevDirection == "up"){
                return new Rectangle( xpos - 15, ypos - 48, 50, 50);
            }else if(currentDirection == 0 && player.prevDirection == "down"){
                return new Rectangle(xpos - 20 , ypos + 30  , 50, 60);
            }else if(currentDirection == 0 && player.prevDirection == "left"){
                return new Rectangle(xpos - 80, ypos, 50, 50);
            }else if(currentDirection == 0 && player.prevDirection == "right"){
                return new Rectangle( xpos + 20 , ypos , 60, 50);
            }else
                return new Rectangle(xpos - 20 , ypos - 48, 50, 50);
    }



    public void tick() {
        attacktime += System.currentTimeMillis() - lastAttackTime;
        lastAttackTime = System.currentTimeMillis();
    	ani_up.tick();
    	ani_down.tick();
    	ani_left.tick();
    	ani_right.tick();
        if(attacktime < attackCooldown)
        //System.out.println(attacktime);
        if(currentDirection == 1){
            ypos -= Yspeed ;
        }else if(currentDirection == 2){
            ypos += Yspeed;
        }else if(currentDirection == 3){
            xpos -= Xspeed;
        }else if(currentDirection == 4){
            xpos += Xspeed;
        }
    }

    public void render(Graphics g) {

        g.setColor(Color.yellow);
        if (currentDirection == 1){        //up
        	g.drawImage(ani_up.getCurrentFrame(), xpos - 20 , ypos - 48, null);

            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;

            }
        }else if (currentDirection == 2){       //down
        	g.drawImage(ani_down.getCurrentFrame(), xpos - 16 , ypos + 24 , null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 3){        //left
        	g.drawImage(ani_left.getCurrentFrame(), xpos - 80, ypos - 20, null);

            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 4){        //right
        	g.drawImage(ani_right.getCurrentFrame(), xpos + 20 , ypos - 10, null);

            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 0 && player.prevDirection == "up"){
        	g.drawImage(ani_up.getCurrentFrame(), xpos - 20 , ypos - 48, null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 0 && player.prevDirection == "down"){
        	g.drawImage(ani_down.getCurrentFrame(), xpos - 16 , ypos + 24 , null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 0 && player.prevDirection == "left"){
        	g.drawImage(ani_left.getCurrentFrame(), xpos - 80, ypos - 20, null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else if (currentDirection == 0 && player.prevDirection == "right"){
        	g.drawImage(ani_right.getCurrentFrame(), xpos + 20 , ypos - 10, null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }else{
        	g.drawImage(ani_up.getCurrentFrame(), xpos - 20, ypos - 48 , null);
            if (currentSecond > 10) {
                handler.removeObject(this);
                currentSecond = 0;
            }
        }


    }

    public void start(){
        Timer timer = new Timer(7, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                currentSecond++;
            }
        });
        timer.start();
    }
}

