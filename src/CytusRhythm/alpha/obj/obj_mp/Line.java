package CytusRhythm.alpha.obj.obj_mp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Line extends GameObj implements ActionListener {
    private int state = 1;
    private Timer timer;
    private Color color = Color.WHITE;

    public Line(int x, int y, JPanel panel) {
        super(x, y, panel);
        timer = new Timer(1, this);
        timer.start();
    }

    public int getY() {
        return y;
    }

    @Override
    public void drawSelf(Graphics2D graphics2D) {
        super.drawSelf(graphics2D);
        graphics2D.setPaint(color);
        graphics2D.drawLine(x, y, panel.getWidth(), y);
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void move() {
        super.move();
        switch (state) {
            case 1 : {
                if (y < 750) {
                    if (color.equals(Color.white)) {
                        y += 6;
                    } else if (color.equals(Color.GREEN)) {
                        y += 4;
                    } else y += 10;

                } else state = 2;
            }break;
            case 2 : {
                if (y > 120) {
                    if (color.equals(Color.white)) {
                        y -= 6;
                    } else if (color.equals(Color.GREEN)) {
                        y -= 4;
                    }else y -= 10;
                } else state = 1;
            }break;
        }
    }

    @Override
    public void move(int outer_x, int outer_y) {

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        move();
    }
}
