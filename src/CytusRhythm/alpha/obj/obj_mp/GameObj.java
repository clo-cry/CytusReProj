package CytusRhythm.alpha.obj.obj_mp;

import javax.swing.*;
import java.awt.*;

public abstract class GameObj {
    public int x,y;
    public JPanel panel;

    public GameObj(int x, int y, JPanel panel) {
        this.x = x;
        this.y = y;
        this.panel = panel;
    }

    public void drawSelf(Graphics2D graphics2D){

    }

    public void move(){

    }

    public abstract void move(int outer_x, int outer_y);
}
