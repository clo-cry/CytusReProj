package CytusRhythm.alpha.utils;

import CytusRhythm.alpha.FallDown;
import CytusRhythm.alpha.obj.obj_ss.CharacterCard;
import CytusRhythm.alpha.obj.obj_ss.EditButton;
import CytusRhythm.alpha.obj.obj_ss.StartButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectionScreen extends JPanel{
    public boolean startPrepared = false;
    private Point initialClick;
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;
    private int x,y;
    CharacterCard characterCard = new CharacterCard();
    public SelectionScreen(){
        setLayout(null);
        setDoubleBuffered(true);
        addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent e) {
                initialClick = e.getPoint();
                getComponentAt(initialClick);
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            public void mouseDragged(MouseEvent e) {
                int thisX = getLocation().x;
                int xMoved = e.getX() - initialClick.x;
                x = thisX + xMoved;
                if (x > 0){
                    x = 0;
                } else if (x< -4900) {
                    x = -4900;
                }
                setLocation(x, 0);
            }
        });
        add(new StartButton(this));
        add(new EditButton());
    }

    @Override
    protected void paintComponent(Graphics g) {
        setSize(new Dimension(6500,900));
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        setBackground(Color.BLACK);
//        graphics2D.drawRect(100,100,200,600);
        characterCard.drawSelf(graphics2D);
        for (int i = 0; i < 24; i++) {
            graphics2D.setColor(Color.gray);
            graphics2D.drawRect(100 + i * 250, 120, 200, 600);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(Integer.toString(i), 110 + i * 250, 140);     // gap 250

        }

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
        graphics2D.drawString("FPS£º " + framePerSecond + "  " + "Thread Sleep£º" + sleepTime + "ms ", 5-x,15);
        repaint();
    }

}
