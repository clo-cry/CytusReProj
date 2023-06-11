package test;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.color.ColorSpace;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;

public class DigitalImageProcess extends JFrame {
    private JPanel panel;
    private int w = 700, h = 700;
    private BufferedImage bi;

    public DigitalImageProcess() {
        panel = (JPanel) getContentPane();
        panel.setPreferredSize(new Dimension(w, h));
        pack();

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // 源码目录下的图片资源的导入方法，在同一package下
//        URL imageURL = getClass().getResource("oyama.png");
//        try {
//            BufferedImage bufferedImage = ImageIO.read(imageURL);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        try {
            bi = ImageIO.read(new File("img/oyama.png"));
//            bi = doColorGray(bi);
//            bi = doBinaryImage(bi);
//            bi = doBlur(bi);
            writeImageFIle(bi);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        panel.getGraphics().drawImage(bi, 0, 0, this);
    }

    public void writeImageFIle(BufferedImage bi) {
        File imageFile = new File("saved.png");
        try {
            ImageIO.write(bi, "png", imageFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public BufferedImage doColorGray(BufferedImage bi) {
        ColorConvertOp filterObj = new ColorConvertOp(ColorSpace.getInstance(ColorSpace.CS_GRAY), null);
        return filterObj.filter(bi, null);
    }

    public BufferedImage doBinaryImage(BufferedImage bi) {
        bi = doColorGray(bi);
        byte[] threshold = new byte[256];
        for (int i = 0; i < 256; i++) {
            threshold[i] = (i < 128) ? (byte) 0 : (byte) 255;
        }
        BufferedImageOp thresholdOp = new LookupOp(new ByteLookupTable(0, threshold), null);
        return thresholdOp.filter(bi, null);
    }

    public BufferedImage doBlur(BufferedImage bi) {

        if (bi.getType() == BufferedImage.TYPE_3BYTE_BGR) {
            bi = convertType(bi,BufferedImage.TYPE_INT_RGB);
        }
        float ninth = 1.0f/9.0f;
        float[] blurKernel = {
                ninth,ninth,ninth,
                ninth,ninth,ninth,
                ninth,ninth,ninth
        };
        BufferedImageOp blurFilter =
                new ConvolveOp(new Kernel(3,3,blurKernel));
        return blurFilter.filter(bi,null);
    }

    BufferedImage convertType(BufferedImage src, int type) {
        ColorConvertOp cco = new ColorConvertOp(null);
        BufferedImage dest = new BufferedImage(
                src.getWidth(), src.getHeight(), type);
        cco.filter(src, dest);
        return dest;
    }

    public static void main(String[] args) {
        new DigitalImageProcess();
    }
}
