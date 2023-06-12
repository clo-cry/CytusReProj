package CytusRhythm.alpha.obj.obj_ss;

import javax.swing.*;
import java.awt.*;

public class EditButton extends JButton {
    public EditButton(){
        setText("MAP EDITOR");
        setFocusable(false);
        setContentAreaFilled(false);
        setForeground(Color.GRAY);
        setBounds(390,360,120,80);
        addActionListener(e -> {
            System.out.println("A quick brown fox jumps over the lazy dog.");
        });
    }
}
