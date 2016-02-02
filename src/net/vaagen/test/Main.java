package net.vaagen.test;

import javax.swing.*;

/**
 * Created by Magnus on 29.01.2016.
 */
public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Frame();
            }
        });
    }

}
