package net.vaagen.test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by Magnus on 29.01.2016.
 */
public class Screen extends JPanel implements Runnable {

    private static Image image;
    private Thread thread;

    private float transparency;

    private float maxTransparency = 1F;
    private float minTransparency = 0.7F;
    private float deltaTransparency = 0.01F;

    public Screen() {
        thread = new Thread(this);
        thread.start();
    }

    public void paintComponent(Graphics g) {
        //g.setColor(new Color(1.0f,1.0f,1.0f,0.5f));
        //g.clearRect(0, 0, 800, 600);
        //g.fillRect(0, 0, 800, 600);

        g.drawImage(image, 0, 0, Frame.WIDTH, Frame.HEIGHT, null);
    }

    static {
        try {
            image = ImageIO.read(new File("res/trump.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load() {

    }

    private void tick() {
        if (Frame.hovering) {
            if (transparency > minTransparency) {
                transparency -= deltaTransparency;
            } else
                transparency = minTransparency;
        } else {
            if (transparency < maxTransparency) {
                transparency += deltaTransparency;
            } else
                transparency = maxTransparency;
        }
    }

    public void run() {
        load();

        repaint();

        while (true) {
            //repaint();

            tick();

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
