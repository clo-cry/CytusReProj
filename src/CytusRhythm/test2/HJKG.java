package CytusRhythm.test2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class HJKG extends JFrame {
    List<Object> objectList = new ArrayList<>();//存储金块石块

    ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("bg.jpg")));
    Image bg = icon.getImage();

    Line line = new Line(this);

    {
        for (int i = 0; i < 5; i++) {
            objectList.add(new Gold());
        }
    }


    void launch() {
        this.setVisible(true);
        this.setSize(1126, 750);
        this.setLocationRelativeTo(null);
        this.setTitle("黄金矿工");

        setDefaultCloseOperation(EXIT_ON_CLOSE);//关闭窗口的方法


        //设置鼠标事件
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1) {
                    line.state = 1;
                }

            }
        });


        while (true) {
            repaint();

            try {
                Thread.sleep(30);//线延时
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    BufferedImage bufferedImage = new BufferedImage(1126, 750,BufferedImage.TYPE_INT_RGB);
    @Override
    public void paint(Graphics g) {
//        g.drawImage(bg, 0, 0, null);

        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.drawImage(bg, 0, 0, null);
        line.paintSelf(graphics2D);
        for (Object obj : objectList) {
            obj.paintSelf(graphics2D);
        }
        g.drawImage(bufferedImage,0,0,this);

    }

    public static void main(String[] args) {
        HJKG hjkg = new HJKG();
        hjkg.launch();

    }
}
