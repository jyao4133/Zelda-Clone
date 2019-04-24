package com.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.control.Audio;
import com.control.Game;
import com.control.IDs;
import com.player.Animation;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;
//https://www.deviantart.com/andrea87sky/art/Entity-303-Minecraft-RPG-Maker-XP-s-Sprite-704456071
public class Ghost extends Object{

    //Second enemy
    /*
    This enemy follows the player when the player comes near it. It is a ghost enemy so the 
    interaction with the objects in the canvas is transparent to it. 
     */
	private Handler handler;

    Game game;

    private BufferedImage [] up, down, left, right;
    private BufferedImage ghostpos;
    private Animation ani_up, ani_down, ani_left, ani_right;
    private Audio enemy_hit;
    int speed = 1;
    

    
    public Ghost(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;     
        up = new BufferedImage [4];
		down = new BufferedImage [4];
		left = new BufferedImage [4];
		right = new BufferedImage [4];
		/////////////ANIMATIONS/////////////
		down[0] = ss.grabImage(1, 9, 75,75);
		down[1] = ss.grabImage(2, 9, 75,75);
		down[2] = ss.grabImage(3, 9, 75,75);
		down[3] = ss.grabImage(4, 9, 75,75);
		
		left[0] = ss.grabImage(1, 10, 75,75);
		left[1] = ss.grabImage(2, 10, 75,75);
		left[2] = ss.grabImage(3, 10, 75,75);
		left[3] = ss.grabImage(4, 10, 75,75);
		
		right[0] = ss.grabImage(1, 11, 75,75);
		right[1] = ss.grabImage(2, 11, 75,75);
		right[2] = ss.grabImage(3, 11, 75,75);
		right[3] = ss.grabImage(4, 11, 75,75);
		
		up[0] = ss.grabImage(1, 12, 75,75);
		up[1] = ss.grabImage(2, 12, 75,75);
		up[2] = ss.grabImage(3, 12, 75,75);
		up[3] = ss.grabImage(4, 12, 75,75);
		///////////////////////////////////////
		ani_up = new Animation (200, up);
		ani_down = new Animation (200, down);
		ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);		
		ghostpos = up[0];
		
		////////////SOUND EFFECTS///////////////
		enemy_hit = new Audio ("enemy_hit.wav");
		///////////////////////////////////////
    }
    
    public void tick() {
        xpos += Xspeed;
    	ypos += Yspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object player = handler.object.get(i);
            if (player.getId() == IDs.player) {

                if (xpos == player.getXpos()){
                    Xspeed = 0;
                }

            	else if (xpos < player.getXpos()) {//right
                    Xspeed = speed;
                 	ani_right.tick();
                 }
            	else if (xpos > player.getXpos()) {//left
            	    Xspeed = -speed;
                 	ani_left.tick();

            	 }

                if (ypos == player.getYpos()){
                    Yspeed = 0;
                }
                else if (ypos < player.getYpos()) {//down
                    Yspeed = speed;
                 	ani_down.tick();

            	 }
                else if (ypos > player.getYpos() + 5) {//up
                    Yspeed = -speed;    	
                    ani_up.tick();

            	 }
            }
        }
    	
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                	enemy_hit.play();
					if(tempObject.getId()== IDs.Arrow) {
						handler.removeObject(tempObject);
					}
                    handler.removeObject(this);
                }
            }
        }   	
   }


    public void render(Graphics g) {
       
    	if (Xspeed < 0 ) {//left
    		g.drawImage(ani_left.getCurrentFrame(), xpos, ypos, null);
        	ghostpos = left[0];
    	}else if (Xspeed > 0) {//right
    		g.drawImage(ani_right.getCurrentFrame(), xpos, ypos, null);
        	ghostpos = right[0];
    	}else if (Yspeed < 0) {//up
    		g.drawImage(ani_up.getCurrentFrame(), xpos, ypos, null);
        	ghostpos = up[0];
    	}else if (Yspeed > 0) {//down
    		g.drawImage(ani_down.getCurrentFrame(), xpos, ypos, null);
        	ghostpos = down[0];
    	}    	 
    	if(Xspeed == 0 && Yspeed == 0) {
    		g.drawImage(ghostpos, xpos, ypos, null);
		}

       //g.setColor(Color.pink);
      // g.fillRect(xpos + 20 , ypos + 30, 40, 40);
    }

    //collision with arrow
    public Rectangle getBounds() {
        return new Rectangle (xpos + 20 ,ypos + 20  ,40 , 40);
    }

    //collision with wall
    public Rectangle getXYBounds(){
        return new Rectangle (xpos - 16, ypos - 16, 32, 32);
    }
}
