package com.control;
////Referenced algorithm to draw a heart from https://stackoverflow.com/questions/33402242/how-to-draw-heart-using-java-awt-libaray
import java.awt.*;
import java.math.*;
import java.util.*;

public class Hearts {

    public void drawHeart(Graphics g, int x, int y, int width, int height, int player1Health, int bound) {


        int[] triangleX = {
                x - 2 * width / 18 + 3,
                x + width + 2 * width / 18 - 1,
                (x - 2 * width / 18 + x + width + 2 * width / 18) / 2};
        int[] triangleY = {
                y + height - 2 * height / 3,
                y + height - 2 * height / 3,
                y + height};




        if (player1Health < bound){

            g.fillOval(
                    x - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);
            g.fillOval(
                    x + width / 2 - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);


            g.fillPolygon(triangleX, triangleY, triangleX.length);
            g.setColor(Color.white);
        }

        else{
            g.fillOval(
                    x - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);
            g.fillOval(
                    x + width / 2 - width / 12,
                    y,
                    width / 2 + width / 6,
                    height / 2);


            g.fillPolygon(triangleX, triangleY, triangleX.length);
            g.setColor(Color.red);
        }
    }
}
