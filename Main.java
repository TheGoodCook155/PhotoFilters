package com.filter;


import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;

import static java.awt.image.BufferedImage.TYPE_INT_RGB;

public class Main {

    public static BufferedImage image;

    public static void main(String[] args) throws IOException {

        image = ImageIO.read(new File("cat.png"));
//        grayScale();
//         darker();
        invert();


        ImageIO.write(image, "PNG", new File("output.png"));


    }

    private static void grayScale() {

        int redNew = 0;
        int greenNew = 0;
        int blueNew = 0;
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color old = new Color(image.getRGB(x, y));

                int redOld = old.getRed();
                int greenOld = old.getBlue();
                int blueOld = old.getBlue();

                redNew = (int) (redOld * 0.299);
                greenNew = (int) (greenOld * 0.587);
                blueNew = (int) (blueOld * 0.114);


                Color newColor = new Color(redNew + greenNew + blueNew, redNew + greenNew + blueNew, redNew + greenNew + blueNew);
                image.setRGB(x, y, newColor.getRGB());


            }
        }

    }




    public static void darker() {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color old = new Color(image.getRGB(x, y));
                Color newColor = new Color(old.getRed() / 3, old.getGreen() / 3, old.getBlue() / 3);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }



    public static void invert() {
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                Color old = new Color(image.getRGB(x, y));
                int redOld = old.getRed();
                int greenOld = old.getBlue();
                int blueOld = old.getBlue();

//0,0,0 = 255,255,255
                //1,2,0 = 254,253,00
                int redNew = 255 - redOld;
                int greenNew = 255 - greenOld;
                int blueNew = 255 - blueOld;


                Color newColor = new Color(redNew, greenNew, blueNew);
                image.setRGB(x, y, newColor.getRGB());
            }
        }
    }





}
