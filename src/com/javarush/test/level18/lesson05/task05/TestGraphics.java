package com.javarush.test.level18.lesson05.task05;

import javax.swing.*;
import java.awt.*;

/**
 * Created by hasbala on 29.11.2015.
 */
public class TestGraphics extends JPanel
{
    public TestGraphics() throws HeadlessException
    {
    }

    public void paint(Graphics g){

        g.setColor(new Color(0x00AD19));
        g.fillRect(0, 0, 640, 480);
        g.setColor(new Color(0x000000));
        g.drawLine(20, 20, 300, 20);
    }

    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setResizable(false);
        f.setSize(640, 480);
        f.setLocationRelativeTo(null);
        f.add(new TestGraphics());
        f.setVisible(true);
    }
}
