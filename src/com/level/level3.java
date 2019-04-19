package com.level;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class level3 {

    Game game;
    private BufferedImage bedroom;
    ImageRender loader = new ImageRender();

    public level3 () {
    	bedroom = loader.loadImage("Bedroom1.png");
    }
    private void tick() {
    }


    public void render(Graphics g){
      //  g.setColor(Color.red);
      // g.fillRect(0, 150, 1040, 990);
        //Health Bar area
        g.setColor(Color.black);
        g.fillRect(0, 0,1040, 170);
        
    	g.drawImage(bedroom, 0, 170, null);


    }


}

