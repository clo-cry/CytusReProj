package CytusRhythm.beta;

import CytusRhythm.beta.utils.MP;

import javax.swing.*;
import java.awt.*;

public class FallDown extends JFrame {
    public int w = 1600, h = 900;

    public FallDown() {
        setSize(w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        MP mp = new MP();
        getContentPane().add(mp, BorderLayout.CENTER);
        setVisible(true);

    }

    public static void main(String[] args) {
        new FallDown();
    }


}
