package CytusRhythm.alpha.obj.obj_ss;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class C_paff extends SwingWorker {
    private BufferedImage bi;
    private Image im;
    BufferedImage subImage;
    BufferedImage image;
    public void drawSelf(Graphics2D graphics2D) {
        File file = new File("paff_r.png");
        try {
            ImageIO.write(image,"png",file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        graphics2D.drawImage(image, 100, 178, null);
    }

    @Override
    protected Object doInBackground() throws Exception {
        int x = 105;
        int y = 0;
        int width = 290;
        int height = 685;

        try {
            bi = ImageIO.read(new File("img/paff.png"));
            subImage = bi.getSubimage(x, y, width, height);

            im = subImage.getScaledInstance(230, -1, Image.SCALE_SMOOTH);

            // 创建BufferedImage对象
            image = new BufferedImage(im.getWidth(null), im.getHeight(null), BufferedImage.TYPE_INT_ARGB);

            // 获取Graphics2D对象
            Graphics2D g2d = image.createGraphics();

            // 创建圆角矩形路径
            int cornerRadius = 20;
            RoundRectangle2D.Float path = new RoundRectangle2D.Float(0, 0, im.getWidth(null), im.getHeight(null), cornerRadius, cornerRadius);

            // 将路径设置为裁剪区域
            g2d.setClip(path);

            // 开启抗锯齿
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 绘制圆角矩形
            g2d.drawImage(im, 0, 0, null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return image;
    }

    @Override
    protected void done() {
        super.done();
    }
}
