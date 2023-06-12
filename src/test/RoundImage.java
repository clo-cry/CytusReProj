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
            // 读取原始图像
            File file = new File("img/oyama.png");
            BufferedImage image = ImageIO.read(file);

            // 创建BufferedImage对象
            BufferedImage roundedImage = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_ARGB);

            // 获取Graphics2D对象
            Graphics2D g2d = roundedImage.createGraphics();

            // 创建圆角矩形路径
            int cornerRadius = 50;
            RoundRectangle2D.Float path = new RoundRectangle2D.Float(0, 0, image.getWidth(), image.getHeight(), cornerRadius, cornerRadius);

            // 将路径设置为裁剪区域
            g2d.setClip(path);

            // 开启抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 绘制圆角矩形
            g2d.drawImage(image, 0, 0, null);

            // 释放Graphics2D对象
            g2d.dispose();

            // 保存圆角矩形图像
            File outputfile = new File("rounded_image.png");
            ImageIO.write(roundedImage, "png", outputfile);

            System.out.println("转换完成！");

        } catch (Exception e) {
            System.out.println("转换失败：" + e.getMessage());
        }
    }
}