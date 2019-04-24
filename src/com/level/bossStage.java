package com.level;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;
/*
The stage the boss stage spawns in. The state will be bossstage
 */
public class bossStage {

    Game game;
    private BufferedImage bossroom;
    ImageRender loader = new ImageRender();
    
    public bossStage () {
    	bossroom = loader.loadImage("Bossroom.png");
    	
    }

    public void render(Graphics g){
        //g.setColor(Color.red);
       // g.fillRect(0, 150, 1040, 990);
    	g.drawImage(bossroom, 0, 170, null);

        //Health Bar area
        g.setColor(Color.black);
        g.fillRect(0, 0,1040, 170);

    }


}
