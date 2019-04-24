package com.control;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;
/*The timer class keeps a track of the game to determine that the game is playable for 5:00 minutes.
 * It works from the inbuilt timer class of java.*/
public class timer {
    Game game;

    public int currentSecond = 0;
    public int currentMinute = 0;
    @SuppressWarnings("unused")
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
                if (Game.state != States.Pause && Game.state != States.tutorial) {
                    currentSecond++;
                }
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
        Font text = new Font ("Comic Sans MS", Font.BOLD, 30);
        g.setFont(text);
        g.setColor(Color.white);

        if (currentSecond <= 10) {
            g.drawString("0" + currentMinute + ":" + "0" + secondsString, 190, 120);
        }else {
            g.drawString("0" + currentMinute + ":" + secondsString, 190, 120);
        }

        g.drawString("Time: ", 100, 120);
        g.drawString("Health: ", 72, 80);

        g.drawString("Arrows left:" + ammoString,552, 120);
        g.drawString("Coins:" + coinsString, 646, 80);
    }

}
