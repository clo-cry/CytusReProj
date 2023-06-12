package CytusRhythm.alpha.obj.obj_ss;

import CytusRhythm.alpha.utils.SelectionScreen;

import javax.swing.*;
import java.awt.*;

public class StartButton extends JButton {
    public StartButton(SelectionScreen selectionScreen){
        setText("START");
        setFocusable(false);
        setContentAreaFilled(false);
        setForeground(Color.GRAY);
        setBounds(140,360,120,80);
        addActionListener(e -> {
            selectionScreen.startPrepared = true;
        });
    }
}
