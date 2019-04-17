package com.player;

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
    private SpriteAnimation animation;
    
    private BufferedImage[] player = new BufferedImage [16];
    private BufferedImage playerpos;
	public static String playerDirection;
	public static String prevDirection;

	private int hplossCD;

    int tx;
    int ty;

    
    public Player1(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        //Xspeed = 1;
        //Yspeed = 1;
		this.handler = handler;
		this.game = game;
		playerpos = player[0];
		animation = new SpriteAnimation(500, player);
		startCD();
		//down
		player[0] = ss.grabImage(1, 3, 75,75);
		player[1] = ss.grabImage(2, 3, 75,75);
		player[2] = ss.grabImage(3, 3, 75,75);
		player[3] = ss.grabImage(4, 3, 75,75);
		
		//right
		player[4] = ss.grabImage(1, 1, 75,75);
		player[5] = ss.grabImage(2, 1, 75,75);
		player[6] = ss.grabImage(3, 1, 75,75);
		player[7] = ss.grabImage(4, 1, 75,75);
		//left
		
		player[8] = ss.grabImage(1, 2, 75,75);
		player[9] = ss.grabImage(2, 2, 75,75);
		player[10] = ss.grabImage(3, 2, 75,75);
		player[11] = ss.grabImage(4, 2, 75,75);
		//up
		player[12] = ss.grabImage(1, 4, 75,75);
		player[13] = ss.grabImage(2, 4, 75,75);
		player[14] = ss.grabImage(3, 4, 75,75);
		player[15] = ss.grabImage(4, 4, 75,75);
		
		
		playerpos = player[0];
		

		
		for (int i = 0; i < player.length; i++) {
			animation = new SpriteAnimation(500, player[i]);
	        animation.runAnimation();
		}


		
    }

    public void tick() {
        ypos += Yspeed;
        xpos += Xspeed;
        collision();
	}

    public void render(Graphics g) {

    	if (Xspeed < 0 ) {//left
    		for (int i = 8; i < 12; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //left 8 to 11
        		playerpos = player[i];
				playerDirection = "left";

    		}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);

    	}
    	if (Xspeed > 0) {//right
    		for (int i = 4; i < 8; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //right 4 to 7
        		playerpos = player[i];
				playerDirection = "right";


			}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	
    	if (Yspeed < 0) {//up
    		for (int i = 12; i < 16; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //up 12 to 15
        		playerpos = player[i];
				playerDirection = "up";


			}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	if (Yspeed > 0) {//down
    		for (int i = 0; i < 4; i++) {
    			g.drawImage(player[i], xpos, ypos, null); //down 0 to 3
        		playerpos = player[i];
				playerDirection = "down";



			}
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}    	 
    	if(Xspeed == 0 && Yspeed == 0) {
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


            if (tempObject.getId() == IDs.enemy){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
                    if (game.player1Health > 0){
                        game.player1Health--;
                    }
                    if (Game.state == States.Game || Game.state == States.Load){
                    	game.enemiesStage1--;
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



        }
        
        if (game.player1Health < 0) {
        	Game.state = States.Pause;
        	game.player1Health = 4;
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
