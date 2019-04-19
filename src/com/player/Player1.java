package com.player;
//https://opengameart.org/content/one-more-lpc-alternate-character
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.IDs;
import com.control.States;

import javax.swing.*;

public class Player1 extends Object {
//player controller class following MVC
	Handler handler;
    Game game;
    
	private BufferedImage [] up, down, left, right;
    private BufferedImage playerpos;
    private Animation ani_up, ani_down, ani_left, ani_right;
    
	public static String playerDirection;
	public static String prevDirection;
	
	private int hplossCD;

    int tx;
    int ty;
    
    public Player1(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
 
		this.handler = handler;
		this.game = game;
		startCD();
		
		up = new BufferedImage [4];
		down = new BufferedImage [4];
		left = new BufferedImage [4];
		right = new BufferedImage [4];
		
		/////////////ANIMATIONS/////////////
		up[0] = ss.grabImage(1, 4, 75,75);
		up[1] = ss.grabImage(2, 4, 75,75);
		up[2] = ss.grabImage(3, 4, 75,75);
		up[3] = ss.grabImage(4, 4, 75,75);
		
		down[0] = ss.grabImage(1, 3, 75,75);
		down[1] = ss.grabImage(2, 3, 75,75);
		down[2] = ss.grabImage(3, 3, 75,75);
		down[3] = ss.grabImage(4, 3, 75,75);
		
		left[0] = ss.grabImage(1, 2, 75,75);
		left[1] = ss.grabImage(2, 2, 75,75);
		left[2] = ss.grabImage(3, 2, 75,75);
		left[3] = ss.grabImage(4, 2, 75,75);
		
		right[0] = ss.grabImage(1, 1, 75,75);
		right[1] = ss.grabImage(2, 1, 75,75);
		right[2] = ss.grabImage(3, 1, 75,75);
		right[3] = ss.grabImage(4, 1, 75,75);
		///////////////////////////////////////
		
		/*increasing the timer reduces the speed of the animation and vice versa*/
		ani_up = new Animation (200, up);
		ani_down = new Animation (200, down);
		ani_left = new Animation (200, left);
		ani_right = new Animation (200, right);		
		playerpos = up[0];

    }

    public void tick() {
    	
    	ani_up.tick();
    	ani_down.tick();
    	ani_left.tick();
    	ani_right.tick();
    	
        ypos += Yspeed;
        xpos += Xspeed;
        collision();
	}

    public void render(Graphics g) {

    	if (Yspeed < 0) {//up
        	g.drawImage(ani_up.getCurrentFrame(), xpos, ypos, null);
        	playerpos = up[0];
			playerDirection = "up";
		}else if (Yspeed > 0) {//down
        	g.drawImage(ani_down.getCurrentFrame(), xpos, ypos, null);
        	playerpos = down[0];
        	playerDirection = "down";
		}else if (Xspeed < 0 ) {//left
        	g.drawImage(ani_left.getCurrentFrame(), xpos, ypos, null);
        	playerpos = left[0];
			playerDirection = "left";
    	}else if (Xspeed > 0) {//right
        	g.drawImage(ani_right.getCurrentFrame(), xpos, ypos, null);
        	playerpos = right[0];
        	playerDirection = "right";
    	}
    	if (Xspeed == 0 && Yspeed == 0) {
    		g.drawImage(playerpos, xpos, ypos, null);
    	}
    	prevDirection = playerDirection;
		//g.setColor(Color.pink);
		//g.fillRect(xpos + 13 ,ypos + 10,50,60);

    }

    private void collision(){

        //Detection for when the player class collides with an object
        for (int i = 0; i < handler.object.size(); i++){
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.Block){
                if(getBounds().intersects(tempObject.getBounds())){
						xpos += Xspeed * -1;
						ypos += Yspeed * -1;
				}
            }

            //Pickup intersection
            if (tempObject.getId() == IDs.Pickup){
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    game.arrowsRemaining += 10;
                }
            }

			if (tempObject.getId() == IDs.heartPickup){
				if (getBounds().intersects(tempObject.getBounds())) {

					if(game.player1Health < 4) {
						handler.removeObject(tempObject);
						game.player1Health ++;
					}
				}
			}


            if (tempObject.getId() == IDs.enemy || tempObject.getId() == IDs.followingEnemy || tempObject.getId() == IDs.clampleft
					|| tempObject.getId() == IDs.clampright || tempObject.getId() == IDs.shooterEnemy){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
                    if (game.player1Health > 0){
                        game.player1Health--;
                    }
                    if (Game.state == States.Game || Game.state == States.Load){
                    	if (tempObject.getId() == IDs.enemy) {
							game.enemiesStage1--;
						}
					}
                }
            }

			if (tempObject.getId() == IDs.enemyArrow){
				if (getBounds().intersects((tempObject.getBounds()))) {
					handler.removeObject(tempObject);
					game.player1Health --;
				}
			}

			//invincibility period for the player
			if (tempObject.getId() == IDs.boss){
				if (getBounds().intersects((tempObject.getBounds()))){

					if(hplossCD > 100) {
						game.player1Health--;
						hplossCD = 0;
					}
				}
			}

            if (tempObject.getId() == IDs.Stairs){
            	if(getBounds().intersects((tempObject.getBounds()))){

            		if (game.nextLevel == "level2") {
						Game.state = States.level2;
						game.loadLevel(game.background2);
					}

            		else if (game.nextLevel == "level3"){
            			Game.state = States.level3;
            			game.loadLevel(game.background3);
					}

            		else if (game.nextLevel == "bosslevel"){
            			Game.state = States.bosslevel;
            			game.loadLevel(game.bossLevel);
					}


				}
			}

            if (tempObject.getId() == IDs.backStairs){
				if(getBounds().intersects((tempObject.getBounds()))){

					if (game.prevLevel == "level2") {
						Game.state = States.level2;
						game.loadLevel(game.background2);
					}

					else {
						Game.state = States.Game;
						game.loadLevel(game.background);
					}
				}
			}

            if (tempObject.getId() == IDs.coinPickup){
            	if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObject(tempObject);
					game.goldAmount++;
				}
			}



        }
        
        if (game.player1Health == 0) {
        	Game.state = States.deathscreen;
        }
    }




	public Rectangle getBounds() {

		return new Rectangle (xpos + 13 ,ypos + 10,50,60);
	}

	public void startCD(){
		javax.swing.Timer timer = new Timer(10, new ActionListener(){
			public void actionPerformed( ActionEvent e ) {
				hplossCD++;
			}
		});
		timer.start();
	}

}
