package com.control;

import java.awt.*;
import javax.swing.JFrame;


public class Window extends Canvas {

    private static final long serialVersionUID = 285728758278L;

    public Window(int width, int height, String title, Game game){

        JFrame frame = new JFrame(title);


        frame.setPreferredSize(new Dimension(width,height));
        frame.setMaximumSize(new Dimension(width,height));
        frame.setMinimumSize(new Dimension(width,height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);

        game.start();

    }
}

