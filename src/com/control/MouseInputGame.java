package com.control;
import java.awt.event.*;

public class MouseInputGame extends MouseAdapter{
        private Handler handler;

        public MouseInputGame (Handler handler){
            this.handler = handler;
        }

        public void mousePressed (MouseEvent e){

                int x = e.getX();
                int y = e.getY();

                for (int i = 0; i < handler.object.size(); i++){
                        Object tempObject= handler.object.get(i);
                        if(tempObject.getId() == IDs.player){

                                handler.addObject(new Arrow(tempObject.getXpos() + 12, tempObject.getYpos() + 22, IDs.Arrow, handler, x, y));
                        }
                }






        }

}
