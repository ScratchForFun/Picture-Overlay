package net.vaagen.test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Magnus on 29.01.2016.
 */
public class Frame {

    public static final int WIDTH = 550, HEIGHT = 397;

    private JFrame frame;
    public static boolean hovering = false;

    public Frame() {
        frame = new JFrame("Test project");
        frame.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
        ((JComponent)frame.getContentPane()).setOpaque(false);
        frame.setUndecorated(true);

        frame.pack();
        frame.add(new Screen());
        frame.setBackground(new Color(1.0f,1.0f,1.0f,0.0f));
        frame.setAlwaysOnTop(true);

        Dimension scrnSize = Toolkit.getDefaultToolkit().getScreenSize();
        Rectangle winSize = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();

        int taskBarHeight = scrnSize.height - winSize.height;

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        frame.setLocation((int)toolkit.getScreenSize().getWidth() - WIDTH, (int)toolkit.getScreenSize().getHeight() - HEIGHT - taskBarHeight);
        frame.setVisible(true);

        frame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                hovering = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                hovering = false;
            }
        });
    }

}
