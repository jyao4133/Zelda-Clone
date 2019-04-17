package com.enemy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

import com.control.Game;
import com.control.IDs;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteAnimation;
import com.player.SpriteSheet;
//https://www.deviantart.com/andrea87sky/art/Entity-303-Minecraft-RPG-Maker-XP-s-Sprite-704456071
public class Ghost extends Object{

    //Second enemy
    /*
    This enemy follows the player when the player comes near it. It is a ghost enemy so the 
    interaction with the objects in the canvas is transparent to it. 
     */
	private Handler handler;
    private SpriteAnimation animation;

    Game game;


    private BufferedImage[] ghost = new BufferedImage [16];
    private BufferedImage ghostpos;
    int speed = 1;
    

    
    public Ghost(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {

        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;     
        
        ghostpos = ghost[0];
		animation = new SpriteAnimation(500, ghost);
		
		//down
		ghost[0] = ss.grabImage(1, 9, 75,75);
		ghost[1] = ss.grabImage(2, 9, 75,75);
		ghost[2] = ss.grabImage(3, 9, 75,75);
		ghost[3] = ss.grabImage(4, 9, 75,75);
		
		//left
		ghost[4] = ss.grabImage(1, 10, 75,75);
		ghost[5] = ss.grabImage(2, 10, 75,75);
		ghost[6] = ss.grabImage(3, 10, 75,75);
		ghost[7] = ss.grabImage(4, 10, 75,75);
		
		//right
		ghost[8] = ss.grabImage(1, 11, 75,75);
		ghost[9] = ss.grabImage(2, 11, 75,75);
		ghost[10] = ss.grabImage(3, 11, 75,75);
		ghost[11] = ss.grabImage(4, 11, 75,75);
		
		//up
		ghost[12] = ss.grabImage(1, 12, 75,75);
		ghost[13] = ss.grabImage(2, 12, 75,75);
		ghost[14] = ss.grabImage(3, 12, 75,75);
		ghost[15] = ss.grabImage(4, 12, 75,75);
		
		
		ghostpos = ghost[0];
		

		
		for (int i = 0; i < ghost.length; i++) {
			animation = new SpriteAnimation(500, ghost[i]);
	        animation.runAnimation();
		}
        
        
    }
    
    
    
    public void tick() {  	   	
        xpos += Xspeed;
    	ypos += Yspeed;

        for (int i = 0; i < handler.object.size(); i++) {
            Object player = handler.object.get(i);
            if (player.getId() == IDs.player) {
            	 if (xpos < player.getXpos()) {
                     Xspeed = speed;
                 }
            	 if (xpos > player.getXpos()) {
                     Xspeed = -speed;
            	 }
            	 if (ypos < player.getYpos()) {
                     Yspeed = speed;
            	 }
            	 if (ypos > player.getYpos()) {
                     Yspeed = -speed;
            	 }
            }
        }

    	
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                    handler.removeObject(tempObject);
                    handler.removeObject(this);
                }
            }

        }
    	
   }


    public void render(Graphics g) {
       
    	if (Xspeed < 0 ) {//left
    		for (int i = 4; i < 8; i++) {
        		g.drawImage(ghost[i], xpos, ypos, null); //left 8 to 11
        		ghostpos = ghost[i];
    		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);

    	}
    	if (Xspeed > 0) {//right
    		for (int i = 8 ; i < 12; i++) {
        		g.drawImage(ghost[i], xpos, ypos, null); //right 4 to 7
        		ghostpos = ghost[i];
        		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	
    	if (Yspeed < 0) {//up
    		for (int i = 12; i < 16; i++) {
        		g.drawImage(ghost[i], xpos, ypos, null); //up 12 to 15
        		ghostpos = ghost[i];
    		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	if (Yspeed > 0) {//down
    		for (int i = 0; i < 4; i++) {
    			g.drawImage(ghost[i], xpos, ypos, null); //down 0 to 3
        		ghostpos = ghost[i];
			}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}    	 
    	if(Xspeed == 0 && Yspeed == 0) {
    		g.drawImage(ghostpos, xpos, ypos, null);
		}

       // g.setColor(Color.pink);
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
