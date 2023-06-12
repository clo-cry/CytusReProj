package test;

import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class RoundImage {

    public static void main(String[] args) {

        try {
            // ��ȡԭʼͼ��
            File file = new File("img/oyama.png");
            BufferedImage image = ImageIO.read(file);

            // ����BufferedImage����
            BufferedImage roundedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

            // ��ȡGraphics2D����
            Graphics2D g2d = roundedImage.createGraphics();

            // ����Բ�Ǿ���·��
            int cornerRadius = 50;
            RoundRectangle2D.Float path = new RoundRectangle2D.Float(0, 0, image.getWidth(), image.getHeight(), cornerRadius, cornerRadius);

            // ��·������Ϊ�ü�����
            g2d.setClip(path);

            // ���������
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // ����Բ�Ǿ���
            g2d.drawImage(image, 0, 0, null);

            // �ͷ�Graphics2D����
            g2d.dispose();

            // ����Բ�Ǿ���ͼ��
            File outputfile = new File("rounded_image.png");
            ImageIO.write(roundedImage, "png", outputfile);

            System.out.println("ת����ɣ�");

        } catch (Exception e) {
            System.out.println("ת��ʧ�ܣ�" + e.getMessage());
        }
    }
}