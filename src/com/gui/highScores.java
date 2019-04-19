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


public class highScores {
    ArrayList<String> scoreList = new ArrayList<>();


    public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);
    public Rectangle textframe = new Rectangle (500, 190, 450, 650);
    private BufferedImage image;


    public final Button[] optionmenu;


    private int yshift = 100;
    private int yspacing = 370;
    private int scoreCount = 0;


    public highScores(ArrayList sortedScores) {
        optionmenu = new Button [1];
        Font font = new Font("Arial", Font.BOLD, 50);
        optionmenu[0] = new Button ("Back", (optionsframe.width / 4) - 10, (optionsframe.height / 4 + yshift + 3 * yspacing)- 10, font, Color.white );


        scoreList = sortedScores;


    }


    public void render (Graphics g)  {




        g.setColor(Color.WHITE);
        g.fillRect(Game.WIDTH, Game.HEIGHT , Game.WIDTH, Game.HEIGHT);

        g.setColor(Color.white);
        if (scoreList.size() > 0){
            int j = 0;
            int Xlab = 200;
            int Ylab = 50;
            if (scoreList.size() == 1){
                g.drawString(scoreList.get(0), Xlab, Ylab);

            }
            else {
                for (int i = scoreList.size() - 1; i > 0; i--) {
                    if (j < 5) {
                        g.drawString(scoreList.get(i), Xlab, Ylab);
                    }
                    j++;

                    Ylab += 100;

                }
            }

        }
        optionmenu[0].render(g);
    }


}
