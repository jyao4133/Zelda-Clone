package com.gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import com.control.Game;
import com.control.ImageRender;

public class pauseOptions {

    public static Rectangle pauseframe = new Rectangle(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
    private BufferedImage image;
    ImageRender loader = new ImageRender();
    private int currentSelection;
    private final Button[] pausemenu;
    private int yshift = 250;
    private int yspacing = 200;

    public pauseOptions() {
    	image = loader.loadImage("help_controls.png");
        pausemenu = new Button[1];
        pausemenu[0] = new Button ("Back", pauseframe.width, pauseframe.height + yshift + 2 * yspacing,
                new Font("Arial", Font.BOLD, 50), Color.black);

    }


    public void render (Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(Game.WIDTH/4, Game.HEIGHT/4 , Game.WIDTH/2, Game.HEIGHT/2);
        Button.drawString(g, new Font("Arial", Font.BOLD, 80), Color.orange, "Options", pauseframe.width, pauseframe.height);
        g.drawImage(image, 260, 270	, null);
        for (int i = 0; i < pausemenu.length; i++) {
            if (i == currentSelection) {
                pausemenu[i].setSelected(true);
            }
            else {
                pausemenu[i].setSelected(false);
            }
            pausemenu[i].render(g);
        }
    }
}
