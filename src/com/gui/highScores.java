package com.gui;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import com.control.Game;
import com.control.ImageRender;
import com.control.States;
/*
Displays the high scores in the highscore state. Will display the top 5 scores in descending order
 */

public class highScores {
    ArrayList<String> scoreList = new ArrayList<>();

    public Rectangle optionsframe = new Rectangle(0,0,Game.WIDTH,Game.HEIGHT);
    public Rectangle textframe = new Rectangle (500, 190, 450, 650);
    private BufferedImage highscore;
    ImageRender loader = new ImageRender();


    public final Button[] optionmenu;


    @SuppressWarnings("unchecked")
	public highScores(ArrayList sortedScores) {
        optionmenu = new Button [1];
        scoreList = sortedScores;
        highscore = loader.loadImage("Highscores.png");

    }


    public void render (Graphics g)  {
    	g.drawImage(highscore, 0, 0, null);
        g.setColor(Color.black);

        Font text = new Font ("Comic Sans MS", Font.BOLD, 30);
        g.setFont(text);
        if (scoreList.size() > 0){
            int j = 0;
            int Xlab = 300;
            int Ylab = 250;
            if (scoreList.size() == 1){
                g.drawString(scoreList.get(0), Xlab, Ylab);

            }
            else {
                for (int i = scoreList.size() - 1; i > 0; i--) {
                    if (j < 5) {
                        g.drawString(scoreList.get(i), Xlab, Ylab);
                    }
                    j++;
                    Ylab += 50;
                }
            }

        }
    }


}
