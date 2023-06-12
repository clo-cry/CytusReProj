package CytusRhythm.alpha.utils;

import CytusRhythm.alpha.obj.obj_mp.Combo;
import CytusRhythm.alpha.obj.obj_mp.GameBorder;
import CytusRhythm.alpha.obj.obj_mp.Line;
import CytusRhythm.alpha.obj.obj_mp.Tap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MP extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    public static int frameIndex;
    public static int frameInterval = 16;
    public static int sleepTime;
    public static int framePerSecond;
    public static long lastDraw;
    public static double thisTime, lastTime;

    Line line = new Line(0, 0, this);
    Tap tap = new Tap(100, 300, this, line, true);

    // border position up: 120 bottom: 750
    GameBorder gbu = new GameBorder(0, 120, this, line, true);
    GameBorder gbd = new GameBorder(0, 750, this, line, false);

    Combo combo = new Combo(750,80,this);

    int o_x, o_y;
    long pastTime = System.currentTimeMillis();
    public ArrayList<Tap> arrayList = new ArrayList<>();

    public Tap[] taps = {
    };

    public MP() {
        setDoubleBuffered(true);
        for (int i = 0; i < 5; i++) {
            arrayList.add(new Tap(200 + i * 120, 200 + i * 120, this, line));
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        setBackground(Color.black);

        gbu.drawSelf(g2d);      // Game Border Up
        gbd.drawSelf(g2d);      // Game Border Down
        gbu.move();
        gbd.move();

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

        for (Tap value : arrayList) {
//            if ((System.currentTimeMillis() - pastTime) > 30 ) {
            value.drawSelf(g2d);
            value.move(o_x, o_y);
            pastTime = System.currentTimeMillis();
//            }
        }

        combo.drawSelf(g2d);
        tap.drawSelf(g2d);
        tap.move(o_x, o_y);
        line.drawSelf(g2d);
        repaint();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
//        if ((o_x > tap.getX() && o_x < (tap.getX() + 100))
//                && (o_y > tap.getY() && (o_y < tap.getY() + 100))
//                && (line.getY() > tap.getY() && line.getY() < (tap.getY() + 100))) {
//            tap.setAlive(false);
//        }
        if (tap.prepared) {
            tap.setAlive(false);
        }
        for (Tap tap1 : arrayList) {
            if (tap1.prepared) tap1.setAlive(false);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        o_x = e.getX();
        o_y = e.getY();
//            System.out.println(o_x+","+o_y);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_R) {
            line.setColor(Color.RED);
        }
        if (e.getKeyCode() == KeyEvent.VK_G) {
            line.setColor(Color.GREEN);
        }
        if (e.getKeyCode() == KeyEvent.VK_W) {
            line.setColor(Color.WHITE);
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            try {
                Robot robot = new Robot();
                robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            } catch (AWTException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
