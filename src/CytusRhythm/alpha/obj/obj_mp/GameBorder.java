package CytusRhythm.alpha.obj.obj_mp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameBorder extends GameObj implements Runnable, ActionListener {
    private boolean face;       // F -> left  T -> right
    private int w = 3, h = 6;
    Line line;
    Timer timer;
    Color color = new Color(255, 255, 255, 82);

    public GameBorder(int x, int y, JPanel panel, Line line, boolean face) {
        super(x, y, panel);
        this.face = face;
        this.line = line;
        timer = new Timer(30, this);
        timer.start();
    }

    @Override
    public void drawSelf(Graphics2D graphics2D) {
        super.drawSelf(graphics2D);
        graphics2D.setColor(Color.WHITE);

        for (int i = 0; i < 2000; i += 100) {
            graphics2D.setColor(color);
            graphics2D.fillRect(x + i, y, w, h);
        }
    }

    @Override
    public void move() {
        if (face) {
            x--;
            if (x < -100) x = 0;
        } else {
            x++;
            if (x > 100) x = 0;
        }
    }

    @Override
    public void move(int outer_x, int outer_y) {
        // empty
    }

    @Override
    public void run() {
        // pass
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (face) {
            if (line.getY() < y + 10) {
                color = Color.ORANGE;

            } else color = new Color(255, 255, 255, 82);
        } else {
            if (line.getY() > y - 10) {
                color = Color.ORANGE;

            } else color = new Color(255, 255, 255, 82);
        }
    }
}
