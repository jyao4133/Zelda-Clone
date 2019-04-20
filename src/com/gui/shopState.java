package com.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.control.Game;
import com.control.States;


public class shopState {



    public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);
    public Rectangle textframe = new Rectangle (500, 190, 450, 650);
    private BufferedImage image;





    private int yshift = 100;
    private int yspacing = 370;
    private int scoreCount = 0;


    public shopState() {

    }


    public void render (Graphics g)  {
        g.setColor(Color.black);
        g.fillRect(0,300, 1030,550);

        try{
            image = ImageIO.read(getClass().getResourceAsStream("shopMenu.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(image,0,0,null);




    }


}
