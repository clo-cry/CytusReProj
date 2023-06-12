package CytusRhythm.alpha.obj.obj_ss;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CharacterCard extends SwingWorker {
    private BufferedImage bi;
    private Image im;
    public void drawSelf(Graphics2D graphics2D){
        try {
            bi  = ImageIO.read(new File("img/wildcat_1.png"));
            im = bi.getScaledInstance(250,-1,Image.SCALE_SMOOTH);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(im, 560,250,null);
    }

    @Override
    protected Object doInBackground() throws Exception {
        return null;
    }
}
