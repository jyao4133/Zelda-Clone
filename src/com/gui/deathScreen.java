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

import static java.awt.Color.white;


public class deathScreen {

    public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);

    private BufferedImage image;


    public final Button[] titleButton;


    private int yshift = 100;
    private int yspacing = 370;


    public deathScreen() {
        titleButton = new Button [1];
        Font font = new Font("Arial", Font.BOLD, 50);
       titleButton[0] = new Button ("Return to title", (optionsframe.width / 2), (optionsframe.height / 2 + yspacing ) + 50, font, Color.white );
    }


    public void render (Graphics g)  {

        Font text = new Font ("Comic Sans MS", Font.BOLD, 40);

        g.setColor(Color.WHITE);
        g.setFont(text);

        g.drawString("Oh dear, you weren't able to find me...", 120,400);
        titleButton[0].render(g);


        try{
            image = ImageIO.read(getClass().getResourceAsStream("sadd_bear.png"));

        } catch(IOException e){
            e.printStackTrace();
        }
        g.drawImage(image,400,100,null);
    }


}
