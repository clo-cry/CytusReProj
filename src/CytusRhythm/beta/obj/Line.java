package CytusRhythm.beta.obj;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line extends GameObj implements ActionListener {
    private int state = 1;
    private Timer timer;
    public Line(int x, int y, JPanel panel) {
        super(x, y, panel);
        timer = new Timer(1,this);
        timer.start();
    }
    public int getY(){
        return y;
    }
    @Override
    public void drawSelf(Graphics2D graphics2D) {
        super.drawSelf(graphics2D);
        graphics2D.setPaint(Color.WHITE);
        graphics2D.drawLine(x,y,panel.getWidth(),y);
    }

    @Override
    public void move() {
        super.move();
        switch (state){
            case 1 -> {
                if (y < panel.getHeight()){
                    y+= 10;
                }else state = 2;
            }
            case 2 -> {
                if (y > 0){
                    y-= 10;
                }else state = 1;
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }
}
