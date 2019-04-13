package com.control;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.sun.glass.events.KeyEvent;

public class Player1 extends Object {
//player controller class following MVC
	Handler handler;
    Game game;
    SpriteAnimation animation;
    
    private BufferedImage[] player = new BufferedImage [16];
    
    
    
    public Player1(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss) {
        super(xpos, ypos, id, ss);
        //Xspeed = 1;
        //Yspeed = 1;
		this.handler = handler;
		this.game = game;
		
		//down
		player[0] = ss.grabImage(1, 3, 48,48);
		player[1] = ss.grabImage(2, 3, 48,48);
		player[2] = ss.grabImage(3, 3, 48,48);
		player[3] = ss.grabImage(4, 3, 48,48);
		
		//right
		player[4] = ss.grabImage(1, 1, 48,48);
		player[5] = ss.grabImage(2, 1, 48,48);
		player[6] = ss.grabImage(3, 1, 48,48);
		player[7] = ss.grabImage(4, 1, 48,48);
		//left
		
		player[8] = ss.grabImage(1, 2, 48,48);
		player[9] = ss.grabImage(2, 2, 48,48);
		player[10] = ss.grabImage(3, 2, 48,48);
		player[11] = ss.grabImage(4, 2, 48,48);
		//up
		player[12] = ss.grabImage(1, 4, 48,48);
		player[13] = ss.grabImage(2, 4, 48,48);
		player[14] = ss.grabImage(3, 4, 48,48);
		player[15] = ss.grabImage(4, 4, 48,48);
		

		

		
		for (int i = 0; i < player.length; i++) {
			animation = new SpriteAnimation(3, player[i]);
	        animation.runAnimation();
		}
		

    }

    public void tick() {
        ypos += Yspeed;
        xpos += Xspeed;
        collision();
    }

    public void render(Graphics g) {
       // g.setColor(Color.blue);
       // g.fillRect(xpos, ypos, 32, 32);
    	
    	//g.drawImage(girl, xpos, ypos, null);    	

    	
    	
    	//Graphics up = (Graphics) g;
    	//Graphics down = (Graphics) g;
    	//Graphics left = (Graphics) g;
    	//Graphics right = (Graphics) g;
    	
      	    	
    	if(Xspeed == 0 && Yspeed == 0) {
    		g.drawImage(player[0], xpos, ypos, null);
		}
    	if (Xspeed < 0) {
    		for (int i = 8; i < 12; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //left 8 to 11
    		}
             System.out.println("Left");
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);

    	}
    	if (Xspeed > 0) {
    		for (int i = 4; i < 8; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //right 4 to 7
    		}
            System.out.println("Right ");
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	
    	if (Yspeed < 0) {
    		for (int i = 12; i < 16; i++) {
        		g.drawImage(player[i], xpos, ypos, null); //up 12 to 15
    		}
            System.out.println("Up");
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	if (Yspeed > 0) {
    		for (int i = 0; i < 4; i++) {
    			g.drawImage(player[i], xpos, ypos, null); //down 0 to 3
    		}
            System.out.println("Down");
    	}else {
    		animation.drawAnimation(g, xpos, ypos, 2);
    	}
    	
    	  	 	 	
    	  	
    	  	
    }

    private void collision(){

        //Detection for when the player class collides with an object
        for (int i = 0; i < handler.object.size(); i++){
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    xpos += Xspeed * -1;
                    ypos += Yspeed * -1;

                  //  System.out.println("this is temp object: " + tempObject.xpos);
                  //  System.out.println("this is player: " + xpos);
                }
            }

            //Pickup intersection
            if (tempObject.getId() == IDs.Pickup){
                if (getBounds().intersects(tempObject.getBounds())) {
                    handler.removeObject(tempObject);
                    game.arrowsRemaining += 10;
                }
            }

            if (tempObject.getId() == IDs.enemy){
                if(getBounds().intersects((tempObject.getBounds()))){
                    handler.removeObject(tempObject);
                    if (game.player1Health > 0){
                        game.player1Health--;

                    }
                }
            }

            if (tempObject.getId() == IDs.Stairs){
            	if(getBounds().intersects((tempObject.getBounds()))){
					game.loadLevel(game.background2);

					Game.state = States.level2;
				}
			}

            if (tempObject.getId() == IDs.backStairs){
				if(getBounds().intersects((tempObject.getBounds()))){
					Game.state = States.Game;

					game.loadLevel(game.background);

				}
			}

        }
        
        if (game.player1Health < 0) {
        	Game.state = States.Pause;
        	game.player1Health = 4;
        }
    }




	public Rectangle getBounds() {
		return new Rectangle (xpos,ypos,32,32);
	}

}
