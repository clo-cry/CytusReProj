package alpha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SoftSim extends JFrame {
    int width = 1600, height = 900;
    int mouse_x,mouse_y;

    public void launch() {
        setPreferredSize(new Dimension(width, height));
        setUndecorated(true);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setOpacity(0.5f);
        setLocationRelativeTo(null);
//        setExtendedState(MAXIMIZED_BOTH);
//        setAlwaysOnTop(true);
        setVisible(true);

        JLabel label = new JLabel("Hello Kitty");   // do not show with LayoutManager is null
        getContentPane().add(label, BorderLayout.CENTER);

        getContentPane().setBackground(Color.CYAN);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                mouse_x = e.getX();
                mouse_y = e.getY();
            }
        });

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
                setLocation(e.getXOnScreen()-mouse_x,e.getYOnScreen()-mouse_y);
            }
        });
    }

    public static void main(String[] args) {
        new SoftSim().launch();
    }
}
