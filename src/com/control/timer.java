package com.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.util.Calendar;
import java.util.Date;

public class timer {
    Game game;

    public int currentSecond = 0;
    public int currentMinute = 0;
    private Calendar calendar;
    public String secondsString;
    public String minutesString;
    public String ammoString;
    public String coinsString;

    public void start(){
        reset();
        Timer timer = new Timer(1000, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                if( currentSecond == 60 ) {

                    currentMinute++;
                    reset();
                }
                secondsString = Integer.toString(currentSecond);

                currentSecond++;
            }
        });
        timer.start();

    }
    private void reset(){
        calendar = Calendar.getInstance();
        currentSecond = 0;
    }

    public void tick(){

    }

    public void render(Graphics g, Game game) {
        minutesString = Integer.toString(currentMinute);
        ammoString = Integer.toString(game.arrowsRemaining);
        coinsString = Integer.toString(game.goldAmount);
        g.setColor(Color.white);
        if (currentSecond <= 10) {
            g.drawString("0" + currentMinute + ":" + "0" + secondsString, 190, 120);

        } else {
            g.drawString("0" + currentMinute + ":" + secondsString, 190, 120);
        }

        g.setColor(Color.white);
        g.drawString("Arrows left:" + ammoString,390, 120);
        g.drawString("Coins:" + coinsString, 496, 80);
    }

}
