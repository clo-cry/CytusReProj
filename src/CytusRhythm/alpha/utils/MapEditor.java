package CytusRhythm.alpha.utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MapEditor extends JPanel {
    public boolean startPrepared = false;
    public boolean editPrepared = false;
    private Point initialClick;
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;
    public MapEditor() {
        setLayout(new BorderLayout());

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
//        setSize(1600,900);
        setBackground(Color.BLACK);
        Graphics2D graphics2D = (Graphics2D) g;

        graphics2D.setFont(new Font("Impact",Font.PLAIN,15));

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
        graphics2D.setColor(Color.YELLOW);
        graphics2D.drawString("FPS: " + framePerSecond + "  " + "Thread Sleep: " + sleepTime + "ms ", 15,15);
        repaint();
    }
}
