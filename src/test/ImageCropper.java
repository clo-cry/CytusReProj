package test;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImageCropper {

    public static void main(String[] args) {

        try {
            // ¶ÁÈ¡Ô­Ê¼Í¼Ïñ
            File file = new File("img/neko.png");
            BufferedImage image = ImageIO.read(file);

            // ²ÃÇÐÍ¼Ïñ
            int x = 140;
            int y = 0;
            int width = 320;
            int height = 755;
            BufferedImage subImage = image.getSubimage(x, y, width, height);

            // ÏÔÊ¾²ÃÇÐºóµÄÍ¼Ïñ
            JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(subImage));
            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);

            System.out.println("²ÃÇÐÍê³É£¡");

        } catch (Exception e) {
            System.out.println("²ÃÇÐÊ§°Ü£º" + e.getMessage());
        }
    }
}