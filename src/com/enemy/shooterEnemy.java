package com.enemy;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.swing.Timer;

import com.control.Audio;
import com.control.Game;
import com.control.IDs;
import com.control.States;
import com.player.Animation;
import com.player.Handler;
import com.player.Object;
import com.player.SpriteSheet;
import com.player.arrowPickup;
import com.player.coinPickup;
import com.player.heartPickup;

public class shooterEnemy extends Object {
    Game game;
    private int currentSecond = 0;
    private Handler handler;
    private int Direction = 1;
    Random r = new Random();
    Random p = new Random();
    int rngGen = 0;
    private BufferedImage [] fireball;
    private Animation animation;
    private Audio enemy_hit, enemy_fire;
    public shooterEnemy(int xpos, int ypos, IDs id, Handler handler, Game game, SpriteSheet ss ) {
        super(xpos, ypos, id, ss);
        this.handler = handler;
        this.game = game;
        start();
        fireball = new BufferedImage [4];
        fireball[0] = ss.grabImage(4, 8, 75, 75);
        fireball[1] = ss.grabImage(5, 8, 75, 75);
        fireball[2] = ss.grabImage(6, 8, 75, 75);
        fireball[3] = ss.grabImage(7, 8, 75, 75);
        animation = new Animation (200, fireball);
        ////////////SOUND EFFECTS///////////////
        enemy_hit = new Audio ("enemy_hit.wav");
        enemy_fire = new Audio ("shooting_enemy.wav");
        ///////////////////////////////////////
    }

    public Rectangle getBounds() {
        return new Rectangle(xpos, ypos, 36, 36);
    }

    public void tick() {
    	animation.tick();
        if (currentSecond > 30){
            if (Direction == 1) {            //right
            	enemy_fire.play();
                currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 36, ypos + 14, IDs.enemyArrow, handler, ss, 1, false));
                Direction = r.nextInt(4) + 1;
            }else if (Direction == 2) {            //up
            	enemy_fire.play();
            	currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 14, ypos +36 , IDs.enemyArrow, handler, ss, 2, false));
                Direction = r.nextInt(4) + 1;
                System.out.println("this is:" +Direction);
            }else if (Direction == 3) {            //left
            	enemy_fire.play();
            	currentSecond = 0;
                handler.addObject(new enemyArrow(xpos , ypos + 14, IDs.enemyArrow, handler, ss, 3, false));
                Direction = r.nextInt(4) + 1;
            }else if (Direction == 4) {            //down
            	enemy_fire.play();
            	currentSecond = 0;
                handler.addObject(new enemyArrow(xpos + 14, ypos , IDs.enemyArrow, handler, ss, 4, false));
                Direction = r.nextInt(4) + 1;
            }
        }
        for (int i = 0; i < handler.object.size(); i++) {
            Object tempObject = handler.object.get(i);
            if (tempObject.getId() == IDs.sword || tempObject.getId() == IDs.Arrow) {
                if (getBounds().intersects((tempObject.getBounds()))) {
                	enemy_hit.play();
                    if(tempObject.getId()== IDs.Arrow) {
                        handler.removeObject(tempObject);}
                    handler.removeObject(this);
                    rngGen = p.nextInt(10);
                    if (rngGen < 2) {
                        handler.addObject(new heartPickup(xpos+18, ypos +18, IDs.heartPickup, ss));}
                    else if (rngGen > 8){
                        handler.addObject(new arrowPickup(xpos + 18, ypos + 18, IDs.Pickup, ss));
                    }else if(rngGen > 2 && rngGen < 8){
                        handler.addObject(new coinPickup(xpos + 18, ypos+18,IDs.coinPickup, ss));
                    }
                    if (Game.state == States.level2){
                    }
                    if (Game.state == States.level3){
                        game.shootersStage3--;}
                }
            }
        }
    }

    public void render(Graphics g) {
    	g.drawImage(animation.getCurrentFrame(), xpos - 15, ypos - 20, null);
    }

    public void start(){
        Timer timer = new Timer(10, new ActionListener(){
            public void actionPerformed( ActionEvent e ) {
                currentSecond++;
            }
        });
        timer.start();
    }
}
