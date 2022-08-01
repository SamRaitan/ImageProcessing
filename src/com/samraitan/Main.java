package com.samraitan;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
	File image = new File("/Users/samraitan/Desktop/intellj/pikachu.png");
        try {
            if(image.exists()) {
                System.out.println("ok");
                BufferedImage bufferedImage = ImageIO.read(image);
                bufferedImage.setRGB(20,20,Color.RED.getRGB());
                int width = bufferedImage.getWidth();
                int height = bufferedImage.getHeight();
                int onePixel = bufferedImage.getRGB(1,1);
                Color previous = null;
                Color backgroundColor = new Color(onePixel);

                for (int x = 0; x < width; x++) {
                    for (int y = 0; y < height; y+=2) {
                        bufferedImage.setRGB(x,y,Color.RED.getRGB());
                        Color currentColor = new Color(bufferedImage.getRGB(x,y));
                         if (isSimilarColor(currentColor,backgroundColor)){
                        //if (previous != null && !isSimilarColor(currentColor,previous)) {
                            bufferedImage.setRGB(x,y,Color.red.getRGB());
                        }
                        // previous = currentColor;
                    }
                }

                // File output = new File("/Users/samraitan/Desktop/pikachu1.png");
                File output = new File("/Users/samraitan/Desktop/intellj/pikachu1.png");
                ImageIO.write(bufferedImage, "png", output);
                }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean isSimilarColor (Color c1 ,Color c2) {
        boolean similar = false;
        int redDiff = Math.abs(c1.getRed() - c2.getRed());
        int greenDiff = Math.abs(c1.getGreen() - c2.getGreen());
        int blueDiff = Math.abs(c1.getBlue() - c2.getBlue());
        if (redDiff + greenDiff + blueDiff < 10){
            similar = true;
        }
        return similar;
    }
}
