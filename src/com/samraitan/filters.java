package com.samraitan;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class filters {
public static BufferedImage image;

    public static void main(String[] args) throws IOException {

        File file = new File("/Users/samraitan/Documents/intellj/mickyMouse.png");
        if (file.exists()) {

            BufferedImage image = ImageIO.read(file);
            BufferedImage imageReverse = ImageIO.read(file);

            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    int pixel = image.getRGB(x, y);

                    Color color = new Color(pixel);

                    imageReverse.setRGB(image.getWidth() - x -1, y,color.getRGB());

                   // int red = color.getRed();
                   // int green = color.getGreen();
                   // int blue = color.getBlue();



                    Color newColor = blackAndWhite(color);
                    image.setRGB(x, y, newColor.getRGB());
                }
            }
            File newFile = new File("/Users/samraitan/Documents/intellj/mickyMouse29.png");
            //ImageIO.write(image, "png", newFile);
          ImageIO.write(imageReverse ,"png" ,newFile);

        }
    }
    public static Color reverseImgColor (Color color) {

        int red = color.getRed();
            red = 255-red;

        int green = color.getGreen();
            green = 255-green;

        int blue = color.getBlue();
            blue = 255-blue;

        Color newColor = new Color(red, green, blue);
        return newColor;
    }
    public static Color blackAndWhite (Color color) {
        int red = color.getRed();
        red = (color.getRed() + color.getGreen() + color.getBlue())/3  ;

        int green = color.getGreen();
        green = (color.getRed() + color.getGreen() + color.getBlue())/3;

        int blue = color.getBlue();
        blue = (color.getRed() + color.getGreen() + color.getBlue())/3;

        Color blackWhite = new Color(red, green, blue);
        return blackWhite;
    }

}