package CytusRhythm.alpha.utils;

import CytusRhythm.alpha.FallDown;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SelectionScreen extends JPanel{
    public boolean startPrepared = false;
    private Point initialClick;
    public SelectionScreen(){
        setLayout(null);
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
                int x = thisX + xMoved;
                if (x > 0){
                    x = 0;
                } else if (x< -4900) {
                    x = -4900;
                }
                setLocation(x, 0);
            }
        });

        JButton startBtn = new JButton("START"){
        };
        startBtn.setFocusable(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setForeground(Color.GRAY);
        startBtn.setBounds(140,360,120,80);
        startBtn.addActionListener(e -> {
            startPrepared = true;
        });
        add(startBtn);
    }

    @Override
    protected void paintComponent(Graphics g) {
        setSize(new Dimension(6500,900));
        super.paintComponent(g);
        Graphics2D graphics2D = (Graphics2D) g;
        setBackground(Color.BLACK);
//        graphics2D.drawRect(100,100,200,600);
        for (int i = 0; i < 24; i++) {
            graphics2D.setColor(Color.gray);
            graphics2D.drawRect(100 + i * 250, 120, 200, 600);
            graphics2D.setColor(Color.WHITE);
            graphics2D.drawString(Integer.toString(i), 110 + i * 250, 140);

        }
    }

}
