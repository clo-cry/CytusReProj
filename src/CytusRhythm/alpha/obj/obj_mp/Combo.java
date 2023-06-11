package CytusRhythm.alpha.obj.obj_mp;

import javax.swing.*;
import java.awt.*;

public class Combo extends GameObj {
    public Combo(int x, int y, JPanel panel) {
        super(x, y, panel);
    }

    @Override
    public void drawSelf(Graphics2D graphics2D) {
        super.drawSelf(graphics2D);
        graphics2D.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        graphics2D.setFont(new Font("Impact", Font.PLAIN, 20));
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawString("COMBO", x, y);
    }

    @Override
    public void move(int outer_x, int outer_y) {

    }
}
