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
            // ��ȡԭʼͼ��
            File file = new File("img/neko.png");
            BufferedImage image = ImageIO.read(file);

            // ����ͼ��
            int x = 140;
            int y = 0;
            int width = 320;
            int height = 755;
            BufferedImage subImage = image.getSubimage(x, y, width, height);

            // ��ʾ���к��ͼ��
            JFrame frame = new JFrame();
            JLabel label = new JLabel(new ImageIcon(subImage));
            frame.getContentPane().add(label);
            frame.pack();
            frame.setVisible(true);

            System.out.println("������ɣ�");

        } catch (Exception e) {
            System.out.println("����ʧ�ܣ�" + e.getMessage());
        }
    }
}