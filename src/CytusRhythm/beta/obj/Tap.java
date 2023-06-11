package CytusRhythm.beta.obj;

import CytusRhythm.alpha.obj.obj_mp.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class Tap extends JButton implements ActionListener {
    private int x,y;
    private final int radius;
    private int radius_2;
    private int add_x1;
    private int radius_3;
    private int add_x2;
    public boolean alive;
    public Line line;
    private Shape shape;
    private Timer timer;
    public Tap(String label, int radius){
        super(label);
        this.radius = radius;
        setContentAreaFilled(false);
        alive = true;
        timer = new Timer(10,this);

    }

    public void updateRadius() {
        radius_2 = radius - radius / 10;
        add_x1 = (radius - radius_2) / 2;
        radius_3 = radius - radius / 2 + 10;
        add_x2 = (radius - radius_3) / 2;
    }

    public void updateLocation() {
        x -= 1;
        y -= 1;
    }

    @Override
    public void setBounds(int x, int y, int width, int height){
        super.setBounds(x, y, width, height);
        shape = new RoundRectangle2D.Float(0, 0, width - 1, height - 1, radius, radius);
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        if(getModel().isArmed()){
            g2d.setColor(Color.CYAN);
            getParent().remove(this);
        } else {
            g2d.setColor(Color.WHITE);
        }
        g2d.fill(shape);

    }
    //
    @Override
    protected void paintBorder(Graphics g){
        g.setColor(getForeground());
//        g.drawRoundRect(0, 0, getSize().width - 1, getSize().height - 1, radius, radius);
        ((Graphics2D)g).draw(shape);
    }

    @Override
    public boolean contains(int x, int y){
        return shape != null && shape.contains(x, y);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}

