package CytusRhythm.test2;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class Gold extends Object {
    boolean flag = false;

    Gold() {
        this.x = (int) (Math.random() * 700);
        this.y = (int) (Math.random() * 400 + 300);
        this.width = 53;
        this.height = 55;
        this.flag = false;
        ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("gold.gif")));
        this.img = icon.getImage();
    }

}
