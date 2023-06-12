package CytusRhythm.alpha.obj.obj_ss;

import CytusRhythm.alpha.utils.SelectionScreen;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartButton extends JButton {
    LineBorder cyanBorder = new LineBorder(Color.CYAN,2);
    Border whiteBorder = BorderFactory.createLineBorder(Color.WHITE,2);
    public StartButton(SelectionScreen selectionScreen){
        setBorder(whiteBorder);
        setText("P L A Y");
        setFocusable(false);
        setContentAreaFilled(false);
        setForeground(Color.WHITE);
        setFont(new Font(null, Font.PLAIN,20));
        setBounds(145,400,140,50);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBorder(cyanBorder);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBorder(whiteBorder);
            }
        });
        addActionListener(e -> {
            selectionScreen.startPrepared = true;
        });
    }
}
