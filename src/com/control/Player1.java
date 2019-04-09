package com.control;

import java.awt.*;

public class Player1 extends Object {
//player controller class following MVC
	Handler handler;
    public Player1(int xpos, int ypos, IDs id, Handler handler) {
        super(xpos, ypos, id);
        //Xspeed = 1;
        //Yspeed = 1;
		this.handler = handler;

    }

    public void tick() {

        ypos += Yspeed;
        xpos += Xspeed;
        collision();

    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(xpos, ypos, 32, 32);

    }

    private void collision(){
        for (int i = 0; i < handler.object.size(); i++){
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    xpos += Xspeed * -1;
                    ypos += Yspeed * -1;

                    System.out.println("this is temp object: " + tempObject.xpos);
                    System.out.println("this is player: " + xpos);
                }
            }
        }
    }




	public Rectangle getBounds() {
		return new Rectangle (xpos,ypos,32,32);
	}

}
