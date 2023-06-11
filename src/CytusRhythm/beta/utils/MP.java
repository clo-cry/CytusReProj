package CytusRhythm.beta.utils;

import CytusRhythm.beta.obj.Line;
import CytusRhythm.beta.obj.Tap;

import javax.swing.*;
import java.awt.*;

public class MP extends JPanel{
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;
    Line line = new Line(0,0,this);
    Tap tap = new Tap(null,100);
    public MP() {
        setLayout(null);
        tap.setBounds(100,100,100,100);
        add(tap);
        Tap t2 = new Tap(null,100);
        t2.setBounds(300,300,100,100);
        add(t2);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(Color.DARK_GRAY);

        frameIndex++;
        if (frameIndex % 60 == 0) {
            double thisTime = System.currentTimeMillis();
            framePerSecond = (int) (1000 / ((thisTime - lastTime) / 60));
            lastTime = thisTime;
        }
        sleepTime = 0;
        while (System.currentTimeMillis() - lastDraw < frameInterval) {
            try {
                Thread.sleep(1);
                sleepTime++;
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
        lastDraw = System.currentTimeMillis();
        g2d.setColor(Color.YELLOW);
        g2d.drawString("FPS£º " + framePerSecond + "  " + "Thread Sleep£º" + sleepTime + "ms ", 5, 15);
        line.drawSelf(g2d);
        line.move();
        repaint();
    }
}
