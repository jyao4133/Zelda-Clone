package com.control;

import java.awt.*;
import javax.swing.JFrame;

/*This is used to create the JFrame of the game.*/
public class Window extends Canvas {

    private static final long serialVersionUID = 285728758278L;

    public Window(int width, int height, String title, Game game){

        JFrame frame = new JFrame(title);


        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();

    }
}

