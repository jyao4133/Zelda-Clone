package com.control;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
/*This class is used to load an image on the canvas*/

public class ImageRender {
        private BufferedImage image;
        public BufferedImage loadImage (String path){
            try {
                image = ImageIO.read(getClass().getResource(path));
            }catch (IOException e){
                e.printStackTrace();
            }
            return image;
        }
}
