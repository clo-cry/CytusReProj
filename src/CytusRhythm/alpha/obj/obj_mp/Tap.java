package CytusRhythm.alpha.obj.obj_mp;

import CytusRhythm.alpha.utils.MP;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Tap extends GameObj {
    private int radius_1 = 1;
    private int radius_2;
    private int add_x1;
    private int radius_3;
    private int add_x2;
    private Shape shape;
    public boolean alive;
    public Line line;
    public boolean prepared;
    public Color[] colors = {new Color(62, 229, 174),new Color(183, 238, 211, 255),Color.WHITE};
    public Tap(int x, int y, MP panel, Line line ){
        super(x, y, panel);
        this.line = line;
        alive = true;

    }
    public Tap(int x, int y, MP panel, Line line,boolean type ){
        super(x, y, panel);
        this.line = line;
        alive = true;
        if (type){
            colors[0] = new Color(60, 177, 217);
            colors[1] = new Color(147, 224, 246);
        }
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public boolean getAlive(){
        return alive;
    }
    public void setAlive(boolean alive){
        this.alive = alive;
    }
    public void updateRadius() {
        radius_2 = radius_1 - radius_1 / 10;
        add_x1 = (radius_1 - radius_2) / 2;
        radius_3 = radius_1 - radius_1 / 2 + 10;
        add_x2 = (radius_1 - radius_3) / 2;
    }

    public void updateLocation() {
        x -= 1;
        y -= 1;
    }

    @Override
    public void drawSelf(Graphics2D graphics2D) {
        super.drawSelf(graphics2D);
        if (alive) {
            updateRadius();
            graphics2D.setPaint(Color.WHITE);
//        graphics2D.fillOval(x, y, radius_1, radius_1);
            shape = new Ellipse2D.Float(x, y, radius_1, radius_1);
            graphics2D.fill(shape);
            graphics2D.setPaint(colors[0]);
            graphics2D.fillOval(x + add_x1, y + add_x1, radius_2, radius_2);
//            graphics2D.setPaint(Color.WHITE);
            graphics2D.setColor(colors[1]);
            graphics2D.fillOval(x + add_x2, y + add_x2, radius_3, radius_3);
        }else {
            graphics2D.setPaint(Color.BLACK);
            graphics2D.fill(shape.getBounds());
        }
    }

    @Override
    public void move(int outer_x, int outer_y) {
        super.move();
        if (alive) {
            if (radius_1 < 100) {
                radius_1 += 2;
                updateLocation();
            }
            if (shape.contains(outer_x, outer_y)) {
                if (shape.contains(outer_x, line.getY())){
                    prepared = true;
                }else prepared = false;
            }else prepared = false;
        }

    }
}
