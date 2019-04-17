package com.level;

import java.awt.*;
import java.awt.image.BufferedImage;

import com.control.Game;

public class level2 {

    Game game;


    private void tick() {
    }


    public void render(Graphics g){
        g.setColor(Color.red);
        g.fillRect(0, 150, 1040, 990);

        //Health Bar area
        g.setColor(Color.black);
        g.fillRect(0, 0,1040, 170);

    }


}

